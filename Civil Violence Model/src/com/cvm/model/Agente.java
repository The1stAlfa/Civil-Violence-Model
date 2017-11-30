/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvm.model;

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

    public Agente(double perjuicio, double riesgoAversion, int vision) {
        super(Categoria.AGENTE, vision);
        this.perjuicio = perjuicio;
        this.riesgoAversion = riesgoAversion;
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
