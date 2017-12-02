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
public enum Color {
    BLACK ("\033[1;30m"),
    BLUE ("\033[1;34m"),
    CYAN ("\u001B[36m"),
    GREEN ("\u001B[32m"),
    MAGENTA ("\u001B[35m"),
    RED ("\033[1;31m"),
    RESET ("\033[0m"),    
    WHITE ("\u001B[37m"),
    YELLOW ("\u001B[33m");
    
    private final String codigo;
    
    private Color(String codigo){
        this.codigo = codigo;
    }
    
    public String getCodigo(){
        return this.codigo;
    }
}
