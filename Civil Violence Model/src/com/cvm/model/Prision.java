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
public class Prision {
    protected ArrayList<Prisionero> prisioneros;

    public Prision() {
        prisioneros = new ArrayList<Prisionero>();
    }
     
    public void actualizarTurnoEnPrision(){
        
    }

    public ArrayList<Prisionero> getPrisioneros() {
        return prisioneros;
    }
    
    public void liberarPrisioneros(){
        
    }

    public void setPrisioneros(ArrayList<Prisionero> prisioneros) {
        this.prisioneros = prisioneros;
    }
}
