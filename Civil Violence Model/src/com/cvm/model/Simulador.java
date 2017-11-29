/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvm.model;

import java.util.ArrayList;

/**
 *
 * @author ij_le
 */
public class Simulador {
    private int densidadAgentes;
    private int densidadPolicias;
    protected double legitimidad;
    private int maxTurnosPrision;
    private int turnosSimulacion;
    protected Prision prision;
    private int[] tamanioUniverso;
    private int turno;    
    protected Universo universo;
    private int visionAgentes;
    private int visionPolicias;
        
    public Simulador(){
        
    }
    
    public Simulador(int densidadAgentes, int densidadPolicias, 
            double legitimidad, int maxTurnosPrision, int[] tamanioUniverso,
            int turnosSimulacion, int visionAgentes, int visionPolicias){
       
        this.densidadAgentes = densidadAgentes;
        this.densidadPolicias = densidadPolicias;
        this.legitimidad = legitimidad;
        this.maxTurnosPrision = maxTurnosPrision;
        this.tamanioUniverso = tamanioUniverso;
        this.turnosSimulacion = turnosSimulacion;
        this.visionAgentes = visionAgentes;
        this.visionPolicias = visionPolicias;
        inicializarUniverso();
    }

    public void ejecutarSimulacro(){
        System.out.println("");
    }
    public int getDensidadAgentes() {
        return densidadAgentes;
    }

    public int getDensidadPolicias() {
        return densidadPolicias;
    }

    public double getLegitimidad() {
        return legitimidad;
    }

    public int getMaxTurnosPrision() {
        return maxTurnosPrision;
    }

    public int getTurnosSimulacion() {
        return turnosSimulacion;
    }

    public Prision getPrision() {
        return prision;
    }

    public int[] getTamanioUniverso() {
        return tamanioUniverso;
    }

    public int getTurno() {
        return turno;
    }

    public Universo getUniverso() {
        return universo;
    }

    public int getVisionAgentes() {
        return visionAgentes;
    }

    public int getVisionPolicias() {
        return visionPolicias;
    }
    
    public void inicializarUniverso(){
        universo = new Universo(tamanioUniverso[0], tamanioUniverso[1], 
                obtenerAgentes(this.densidadAgentes), 
                obtenerPolicias(this.densidadPolicias));
        universo.colocarAgentes();
        universo.colocarPolicias();          
    }
    
    public ArrayList<Agente> obtenerAgentes(int densidad){
        ArrayList<Agente> agentes = new ArrayList<>();
        int numeroDeAgentes = 
                (int)((float)universo.tamanioMatriz() * (float)densidad/100);
        for(int a=0; a<numeroDeAgentes; a++){
            agentes.add(new Agente(Math.random(), Math.random(), 
                    this.visionAgentes));
        }
        
        return agentes;
    }
    
    public ArrayList<Policia> obtenerPolicias(int densidad){
        ArrayList<Policia> policias = new ArrayList<>();
        int numeroDeAgentes = 
                (int)((float)universo.tamanioMatriz() * (float)densidad/100);
        for(int a=0; a<numeroDeAgentes; a++)
            policias.add(new Policia(this.visionPolicias));
        
        return policias;
    }
    
    public void setDensidadAgentes(int densidadAgentes) {
        this.densidadAgentes = densidadAgentes;
    }

    public void setDensidadPolicias(int densidadPolicias) {
        this.densidadPolicias = densidadPolicias;
    }

    public void setLegitimidad(double legitimidad) {
        this.legitimidad = legitimidad;
    }

    public void setMaxTurnosPrision(int maxTurnosPrision) {
        this.maxTurnosPrision = maxTurnosPrision;
    }

    public void setTurnosSimulacion(int turnosSimulacion) {
        this.turnosSimulacion = turnosSimulacion;
    }

    public void setPrision(Prision prision) {
        this.prision = prision;
    }

    public void setTamanioUniverso(int[] tamanioUniverso) {
        this.tamanioUniverso = tamanioUniverso;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public void setUniverso(Universo universo) {
        this.universo = universo;
    }

    public void setVisionAgentes(int visionAgentes) {
        this.visionAgentes = visionAgentes;
    }

    public void setVisionPolicias(int visionPolicias) {
        this.visionPolicias = visionPolicias;
    }
    
    
    
}
