/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvm.model;

import java.util.List;
/**
 *
 * @author ij_le
 */
public class Agente extends Actor{
    private double agravio;
    private Estado estado = Estado.INACTIVO;
    private boolean estaEnPrision = false;
    private static final double LIMITE = 0.1;
    private double perjuicio;
    private double riesgoAversion;
    
    public Agente(){
        super(Categoria.AGENTE);
    }

    public Agente(boolean movimiento, double perjuicio, double riesgoAversion, int vision) {
        super(movimiento, Categoria.AGENTE, vision);
        this.perjuicio = perjuicio;
        this.riesgoAversion = riesgoAversion;
    }
    
    public void actuar(int columnas, int filas, double legitimidad, 
            List<List<Actor>> matriz){
        double riesgoNeto = calcularRiesgoNeto(columnas, filas, matriz);
        this.agravio = calcularAgravio(legitimidad);
        
        // REGLA DE AGENTE AGRAVIO - RIESGO NETO > LIMITE : ACTIVO
        if(agravio - riesgoNeto > LIMITE){
            if(this.estado.equals(Estado.INACTIVO))
                cambiarEstado();
        }
        else{
            if(this.estado.equals(Estado.ACTIVO))
                cambiarEstado();
        }
    }
    
    private double calcularAgravio(double legitimidad){
        return this.perjuicio * (1.0 - legitimidad);
    }
    
    private double calcularProbabilidadArresto(int columnas, int filas, 
            List<List<Actor>> matriz){
        double k = 2.3;
        double ratio = calcularRatioPoliciaAgente(columnas, filas, matriz);
        
        return 1.0 - Math.exp(-k * ratio);
    }
    
    private double calcularRatioPoliciaAgente(int columnas, int filas, 
            List<List<Actor>> matriz){
        double numeroAgentes = (double) inspeccionar(Categoria.AGENTE, columnas,
                filas, matriz, this.getPosicion()).size();
        double numeroPolicias = (double) inspeccionar(Categoria.POLICIA, columnas,
                filas, matriz, this.getPosicion()).size();
        
        return numeroPolicias / numeroAgentes;
    }
    
    private double calcularRiesgoNeto(int columnas, int filas, 
            List<List<Actor>> matriz){
        return this.riesgoAversion * calcularProbabilidadArresto(columnas, 
                filas, matriz);
    }
    
    public void cambiarEstado(){
        if(this.estado.equals(Estado.ACTIVO))
            this.estado = Estado.INACTIVO;
        else
            this.estado = Estado.ACTIVO;
    }
    
    public double getAgravio() {
        return agravio;
    }

    public Estado getEstado() {
        return estado;
    }
    
    public boolean getEstaEnPrision(){
        return this.estaEnPrision;
    }

    public double getPerjuicio() {
        return perjuicio;
    }

    public double getRiesgoAversion() {
        return riesgoAversion;
    }

    public void setAgravio(double agravio) {
        this.agravio = agravio;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    public void setEstaEnPrision(boolean estaEnPrision){
        this.estaEnPrision = estaEnPrision;
    }

    public void setPerjuicio(double perjuicio) {
        this.perjuicio = perjuicio;
    }

    public void setRiesgoAversion(double riesgoAversion) {
        this.riesgoAversion = riesgoAversion;
    }
}
