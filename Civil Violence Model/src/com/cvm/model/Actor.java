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
public class Actor {
    private Categoria categoria;
    private Posicion posicion;
    
    public Actor(){
    }
    
    public Actor(Categoria  categoria){
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void movimiento(){
        
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
