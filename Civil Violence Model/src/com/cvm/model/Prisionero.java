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
public class Prisionero {
    private Agente agente;
    private int condena;
    private int turnosEnPrision = 0;

    public Prisionero() {
    }

    public Prisionero(Agente agente, int condena) {
        this.agente = agente;
        this.condena = condena;
    }
    
    public void aumentarTurnoEnPrision(){
        this.turnosEnPrision += 1;
    }

    public Agente getAgente() {
        return agente;
    }

    public int getCondena() {
        return condena;
    }

    public int getTurnosEnPrision() {
        return turnosEnPrision;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    public void setCondena(int condena) {
        this.condena = condena;
    }

    public void setTurnosEnPrision(int turnosEnPrision) {
        this.turnosEnPrision = turnosEnPrision;
    }
}
