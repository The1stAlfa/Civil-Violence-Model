/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvm.util;

import com.cvm.model.Posicion;

/**
 *
 * @author ij_le
 */
public class Aleatorio {

    public Aleatorio() {
    }
    
    public static int enteroAleatorio(int max, int min){
        int range = (max - min) + 1;     
        return (int)(Math.random() * range) + min;
    }
    
    public static Posicion posicionAleatoria(int columnas, int filas){
        int posX = enteroAleatorio(filas, 0);
        int posY = enteroAleatorio(columnas, 0);
        
        return new Posicion(posY, posX);
    }
}
