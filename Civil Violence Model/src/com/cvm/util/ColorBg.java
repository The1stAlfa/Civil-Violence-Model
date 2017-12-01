/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvm.util;

/**
 *
 * @author ij_le
 */

/**
* Color ANSI para el fondo
*/
public enum ColorBg {
    BLACK ("\u001B[40m"),
    BLUE ("\u001B[44m"),
    CYAN ("\u001B[46m"),
    GREEN ("\u001B[42m"),
    MAGENTA ("\u001B[45m"),
    RED ("\u001B[41m"),
    WHITE ("\u001B[47m"),
    YELLOW ("\u001B[43m");

    private final String codigo;

    private ColorBg(String codigo) {
        this.codigo = codigo;
    }
    
    public String getCodigo(){
        return this.codigo;
    }
}