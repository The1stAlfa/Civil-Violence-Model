/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvm.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ij_le
 */
public class Universo {
    private int columnas;    
    private int filas;
    private List<List<Actor>> matriz;
    private ArrayList<Agente> poblacion;
    private ArrayList<Policia> policias;

    public Universo() {
    }

    public Universo(int columnas, int filas, ArrayList<Agente> poblacion, 
            ArrayList<Policia> policias) {
        this.columnas = columnas;
        this.filas = filas;
        this.poblacion = poblacion;
        this.policias = policias;
    }

    public int getColumnas() {
        return columnas;
    }

    public int getFilas() {
        return filas;
    }

    public List<List<Actor>> getMatriz() {
        return matriz;
    }

    public ArrayList<Agente> getPoblacion() {
        return poblacion;
    }

    public ArrayList<Policia> getPolicias() {
        return policias;
    }
    
    public void imprimirMatriz(){
        
    }
    
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public void setMatriz(List<List<Actor>> matriz) {
        this.matriz = matriz;
    }

    public void setPoblacion(ArrayList<Agente> poblacion) {
        this.poblacion = poblacion;
    }

    public void setPolicias(ArrayList<Policia> policias) {
        this.policias = policias;
    }  
}
