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
    BLACK ("\u001B[30m"),
    BLUE ("\u001B[34m"),
    CYAN ("\u001B[36m"),
    GREEN ("\u001B[32m"),
    MAGENTA ("\u001B[35m"),
    RED ("\u001B[31m"),
    RESET ("\u001B[0m"),    
    WHITE ("\u001B[37m"),
    YELLOW ("\u001B[33m");
    
    private String codigo;
    
    private Color(String codigo){
        this.codigo = codigo;
    }
    
    public String getSecuencia(){
        return this.codigo;
    }
}
