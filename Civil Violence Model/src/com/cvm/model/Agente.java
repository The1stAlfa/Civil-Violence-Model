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
public class Agente {
    private double agravio;
    private Estado estado = Estado.INACTIVO;
    private static final double LIMITE = 0.1;
    private double perjuicio;
    private Posicion posicion;
    private double riesgoAversion;
    private int vision;
    
    public Agente() {
    }

    public Agente(double perjuicio, double riesgoAversion, int vision) {
        this.perjuicio = perjuicio;
        this.riesgoAversion = riesgoAversion;
        this.vision = vision;
    }

    public double getAgravio() {
        return agravio;
    }

    public Estado getEstado() {
        return estado;
    }

    public double getPerjuicio() {
        return perjuicio;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public double getRiesgoAversion() {
        return riesgoAversion;
    }

    public int getVision() {
        return vision;
    }

    public void setAgravio(double agravio) {
        this.agravio = agravio;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setPerjuicio(double perjuicio) {
        this.perjuicio = perjuicio;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public void setRiesgoAversion(double riesgoAversion) {
        this.riesgoAversion = riesgoAversion;
    }

    public void setVision(int vision) {
        this.vision = vision;
    }
}
