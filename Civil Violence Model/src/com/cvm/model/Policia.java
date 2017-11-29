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
public class Policia extends Actor{
    private int vision;
    
    public Policia(){
        super(Categoria.POLICIA);
    }

    public Policia(int vision) {
        super(Categoria.POLICIA);
        this.vision = vision;
    }
    
    public void actuar(){
        
    }
    
    public void arrestarAgente(){
        
    }

    public int getVision() {
        return vision;
    }
    
    public void inspeccionarVecindario(){
        
    } 
}
