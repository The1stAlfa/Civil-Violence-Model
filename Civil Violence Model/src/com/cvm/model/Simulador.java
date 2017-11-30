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
        Actor actor;
        this.turno += 1;
        System.out.println("Turno: "+ this.turno + "\n");
        System.out.println("** Agentes ** Densidad: " + this.densidadAgentes + 
                "Vision: " + this.visionAgentes + 
                "-Cantidad- Matriz: " +
                "Prision: " + "\n" +
                "** Policias ** Densidad:" + this.densidadPolicias + 
                "Vision: " + this.visionPolicias + 
                "-Cantidad- Matriz: " + " \n" + 
                "Legitimidad del Gobierno: " + this.legitimidad);
        do{
            actor = universo.seleccionarActor(universo.obtenerActores(
                    universo.getPoblacion(), universo.getPolicias()));
        }while(!actor.movimiento(universo.getColumnas(), universo.getFilas(), 
                universo.getMatriz()));
        if(actor.getCategoria().equals(Categoria.AGENTE)){
            
        }
        else{
            
        }
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
        int filas = tamanioUniverso[0];
        int columnas = tamanioUniverso[1];
        float tamanio = (float)(filas * columnas);
        
        universo = new Universo(columnas, filas, 
                obtenerAgentes(this.densidadAgentes, tamanio, 
                        this.visionAgentes), 
                obtenerPolicias(this.densidadPolicias, tamanio, 
                        this.visionPolicias));
        universo.inicializarMatriz(columnas, filas);
        universo.colocarAgentes(columnas-1, filas-1, universo.getMatriz(), 
                universo.getPoblacion());
        universo.colocarPolicias(columnas-1, filas-1, universo.getMatriz(), 
                universo.getPolicias());          
    }
    
    public ArrayList<Agente> obtenerAgentes(int densidad, float tamanio, 
            int vision){
        ArrayList<Agente> agentes = new ArrayList<>();
        int numeroDeAgentes = 
                (int)((float)tamanio * (float)densidad/100);
        for(int a=0; a<numeroDeAgentes; a++){
            agentes.add(new Agente(Math.random(), Math.random(), vision));
        }
        
        return agentes;
    }
    
    public ArrayList<Policia> obtenerPolicias(int densidad, float tamanio,
            int vision){
        ArrayList<Policia> policias = new ArrayList<>();
        int numeroDeAgentes = 
                (int)((float)tamanio * (float)densidad/100);
        for(int a=0; a<numeroDeAgentes; a++)
            policias.add(new Policia(vision));
        
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
