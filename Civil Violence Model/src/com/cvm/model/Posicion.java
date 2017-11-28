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
    private byte fila;
    private byte columna;
    
    Posicion(){      
    }

    public Posicion(byte fila, byte columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public byte getColumna() {
        return columna;
    }   
  
    public byte getFila() {
        return fila;
    }
    
    public void setColumn(byte columna) {
        this.columna = columna;
    }

    public void setFila(byte fila) {
        this.fila = fila;
    }

}
