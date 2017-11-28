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
public class Simulador {
    private int densidadAgentes;
    private int densidadPolicias;
    protected double legitimidad;
    private int maxTurnosPrision;
    private int maxTurnosSimulacion;
    protected Prision prision;
    private int[] tamanioUniverso;
    private int turno;    
    protected Universo universo;
    private int visionAgentes;
    private int visionPolicias;
        
    public Simulador(){
        
    }
    
    public Simulador(int densidadAgentes, int densidadPolicias, 
            double legitimidad, int maxTurnosPrision, int maxTurnosSimulacion,
            int[] tamanioUniverso, int visionAgentes, int visionPolicias ){
       
        this.densidadAgentes = densidadAgentes;
        this.densidadPolicias = densidadPolicias;
        this.legitimidad = legitimidad;
        this.maxTurnosPrision = maxTurnosPrision;
        this.maxTurnosSimulacion = maxTurnosSimulacion;
        this.tamanioUniverso = tamanioUniverso;
        this.visionAgentes = visionAgentes;
        this.visionPolicias = visionPolicias;  
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

    public int getMaxTurnosSimulacion() {
        return maxTurnosSimulacion;
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

    public void setMaxTurnosSimulacion(int maxTurnosSimulacion) {
        this.maxTurnosSimulacion = maxTurnosSimulacion;
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
