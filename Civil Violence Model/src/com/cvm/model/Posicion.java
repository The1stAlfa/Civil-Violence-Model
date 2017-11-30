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

public class Posicion {
    private int fila;
    private int columna;
    
    public Posicion(){      
    }

    public Posicion(int columna, int fila) {
        this.columna = columna;
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }   
  
    public int getFila() {
        return fila;
    }
    
    public void setColumn(int columna) {
        this.columna = columna;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

}
