/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvm.model;

import com.cvm.sys.Cvm;
import com.cvm.util.Archivo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ij_le
 */
public class Simulador {
    private int densidadAgentes;
    private int densidadPolicias;
    protected double legitimidad;
    private int maxTurnosPrision;
    private boolean movimiento;
    private int turnosSimulacion;
    private static Prision prision;
    private int[] tamanioUniverso;
    private int turno;    
    protected Universo universo;
    private int visionAgentes;
    private int visionPolicias;
        
    public Simulador(){
        
    }
    
    public Simulador(int densidadAgentes, int densidadPolicias, 
            double legitimidad, boolean movimiento, int maxTurnosPrision, 
            int[] tamanioUniverso, int turnosSimulacion, int visionAgentes, 
            int visionPolicias){
       
        this.densidadAgentes = densidadAgentes;
        this.densidadPolicias = densidadPolicias;
        this.legitimidad = legitimidad;
        this.movimiento = movimiento;
        this.maxTurnosPrision = maxTurnosPrision;
        this.prision = new Prision();
        this.tamanioUniverso = tamanioUniverso;
        this.turnosSimulacion = turnosSimulacion;
        this.visionAgentes = visionAgentes;
        this.visionPolicias = visionPolicias;
        inicializarUniverso();
    }
    
    public int calcularNumeroAgentes(int densidad, float tamanio){
        return (int)((float)tamanio * (float)densidad/100);
    }
    
    public int calcularNumeroPolicias(int densidad, float tamanio){
        return (int)((float)tamanio * (float)densidad/100); 
    }
    
    public void ejecutarSimulacro(String ruta){
        Actor actor;
	Scanner consola = new Scanner(System.in);
        String data = new String();
	
	if(turno == 0){
            System.out.println("  Matriz UNIVERSO inicial\n");
            imprimirInformacion();
            universo.imprimirMatriz(tamanioUniverso[1], tamanioUniverso[0]);
            System.out.print("Presione Enter para continuar...");
            consola.nextLine();
            Cvm.limpiarPantalla();
            System.out.println("*** CIVIL VIOLENCE MODEL ***");
            System.out.println("          SIMULADOR        \n");
            data = "Turno;Agentes Activos;Agentes Inactivos;En Prision";
            try {
                Archivo.grabar(ruta, data);
            } catch (IOException ex) {
                Logger.getLogger(Simulador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.turno += 1;
        prision.actualizarTurnoEnPrision();
        prision.liberarPrisioneros(universo.getMatriz());
        do{
            actor = universo.seleccionarActor(universo.obtenerActores(
                    universo.getPoblacion(), universo.getPolicias()));
        }while(!actor.moverse(universo.getColumnas(), universo.getFilas(), 
                universo.getMatriz()));
        if(actor.getCategoria().equals(Categoria.AGENTE))
            ((Agente)actor).actuar(universo.getColumnas(), universo.getFilas(), 
                    legitimidad, universo.getMatriz());  
        else
            ((Policia)actor).actuar(universo.getColumnas(), universo.getFilas(),
                    universo.getMatriz(), maxTurnosPrision, prision);
        imprimirInformacion();
        universo.imprimirMatriz(tamanioUniverso[1], tamanioUniverso[0]);
        System.out.print("Presione Enter para continuar...");
        consola.nextLine();
        data = String.valueOf(turno) + ";" +
                String.valueOf(universo.cantidadAgentes(Estado.INACTIVO)) + ";"
                + String.valueOf(universo.cantidadAgentes(Estado.ACTIVO)) + ";"  
                + String.valueOf(prision.cantidadPrisioneros());
        try {
            Archivo.grabar(ruta, data);
        } catch (IOException ex) {
            Logger.getLogger(Simulador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getDensidadAgentes() {
        return densidadAgentes;
    }

    public int getDensidadPolicias() {
        return densidadPolicias;
    }

    public double getLegitimidad() {
        return legitimidad;
    }

    public int getMaxTurnosPrision() {
        return maxTurnosPrision;
    }

    public int getTurnosSimulacion() {
        return turnosSimulacion;
    }

    public Prision getPrision() {
        return prision;
    }

    public int[] getTamanioUniverso() {
        return tamanioUniverso;
    }

    public int getTurno() {
        return turno;
    }

    public Universo getUniverso() {
        return universo;
    }

    public int getVisionAgentes() {
        return visionAgentes;
    }

    public int getVisionPolicias() {
        return visionPolicias;
    }
    
    public void imprimirInformacion(){
        if(turno != 0)
            System.out.println("Turno: "+ this.turno);
        System.out.println("** Agentes  ** \n" + 
                "Densidad: " + this.densidadAgentes + 
                " Vision: " + this.visionAgentes + 
                "  -Cantidad- " + 
                    "Matriz: " + universo.cantidadAgentes(null) + 
                    " Activos: " + universo.cantidadAgentes(Estado.ACTIVO) + 
                    " Inactivos: " + universo.cantidadAgentes(Estado.INACTIVO) + 
                " Prision: " + prision.cantidadPrisioneros() + "\n" +
                        "-Simbolo- Activo: @ Inactivo: ." +
                "\n** Policias ** \n" + 
                "Densidad: " + this.densidadPolicias + 
                " Vision: " + this.visionPolicias + 
                "  -Cantidad- " + 
                        "Matriz: " + universo.cantidadPolicias() +" \n" + 
                "Legitimidad del Gobierno: " + this.legitimidad);
    }
    
    public void inicializarUniverso(){
        int filas = tamanioUniverso[0];
        int columnas = tamanioUniverso[1];
        float tamanio = (float)(filas * columnas);
        
        universo = new Universo(columnas, filas, 
                obtenerAgentes(this.densidadAgentes, this.movimiento, tamanio, 
                        this.visionAgentes), 
                obtenerPolicias(this.densidadPolicias, true, tamanio, 
                        this.visionPolicias));
        universo.inicializarMatriz(columnas, filas);
        universo.colocarAgentes(columnas-1, filas-1, universo.getMatriz(), 
                universo.getPoblacion());
        universo.colocarPolicias(columnas-1, filas-1, universo.getMatriz(), 
                universo.getPolicias());          
    }
    
    public ArrayList<Agente> obtenerAgentes(int densidad, boolean movimiento, 
            float tamanio, int vision){
        ArrayList<Agente> agentes = new ArrayList<>();
        int numeroDeAgentes = calcularNumeroAgentes(densidad, tamanio);
        
        for(int a=0; a<numeroDeAgentes; a++){
            agentes.add(new Agente(movimiento, Math.random(), 
                    Math.random(), vision));
        }
        return agentes;
    }
    
    /**
     *
     * @param densidad
     * @param movimiento
     * @param tamanio
     * @param vision
     * @return
     */
    public ArrayList<Policia> obtenerPolicias(int densidad, boolean movimiento, 
            float tamanio, int vision){
        ArrayList<Policia> policias = new ArrayList<>();
        int numeroDePolicias = calcularNumeroPolicias(densidad, tamanio);
                
        for(int a=0; a<numeroDePolicias; a++)
            policias.add(new Policia(movimiento, vision));
        
        return policias;
    }
    
    public void setDensidadAgentes(int densidadAgentes) {
        this.densidadAgentes = densidadAgentes;
    }

    public void setDensidadPolicias(int densidadPolicias) {
        this.densidadPolicias = densidadPolicias;
    }

    public void setLegitimidad(double legitimidad) {
        this.legitimidad = legitimidad;
    }

    public void setMaxTurnosPrision(int maxTurnosPrision) {
        this.maxTurnosPrision = maxTurnosPrision;
    }

    public void setTurnosSimulacion(int turnosSimulacion) {
        this.turnosSimulacion = turnosSimulacion;
    }

    public void setPrision(Prision prision) {
        this.prision = prision;
    }

    public void setTamanioUniverso(int[] tamanioUniverso) {
        this.tamanioUniverso = tamanioUniverso;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public void setUniverso(Universo universo) {
        this.universo = universo;
    }

    public void setVisionAgentes(int visionAgentes) {
        this.visionAgentes = visionAgentes;
    }

    public void setVisionPolicias(int visionPolicias) {
        this.visionPolicias = visionPolicias;
    }
}
