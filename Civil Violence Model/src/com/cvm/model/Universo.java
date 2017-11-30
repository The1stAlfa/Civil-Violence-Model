/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvm.model;

import com.cvm.util.Aleatorio;
import com.cvm.util.Validacion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ij_le
 */
public class Universo {
    private int columnas;    
    private int filas;
    private List<List<Actor>> matriz;
    private ArrayList<Agente> poblacion;
    private ArrayList<Policia> policias;

    public Universo() {
    }

    public Universo(int columnas, int filas){
        this.columnas = columnas;
        this.filas = filas;
    }
    
    public Universo(int columnas, int filas, ArrayList<Agente> poblacion, 
            ArrayList<Policia> policias) {
        this.columnas = columnas;
        this.filas = filas;
        this.poblacion = poblacion;
        this.policias = policias;
    }
    
    public void colocarAgentes(int columnas, int filas, 
            List<List<Actor>> matriz, ArrayList<Agente> poblacion){
        Posicion coordenada = new Posicion();
        
        for(int i=0; i<poblacion.size(); i++){
            do{
                coordenada = Aleatorio.posicionAleatoria(columnas, filas);
            }while(!Validacion.validarCoordenada(matriz, coordenada));
            poblacion.get(i).setPosicion(coordenada);
            matriz.get(coordenada.getFila()).set(
                    coordenada.getColumna(), poblacion.get(i));
        }
    }
    
    public void colocarPolicias(int columnas, int filas, 
            List<List<Actor>> matriz, ArrayList<Policia> policias){
        Posicion coordenada = new Posicion();
        
        for(int i=0; i<policias.size(); i++){
            do{
                coordenada = Aleatorio.posicionAleatoria(filas, columnas);
            }while(!Validacion.validarCoordenada(matriz, coordenada));
            policias.get(i).setPosicion(coordenada);
            matriz.get(coordenada.getFila()).set(
                    coordenada.getColumna(), policias.get(i));
        }
    }
    
    public int getColumnas() {
        return columnas;
    }

    public int getFilas() {
        return filas;
    }

    public List<List<Actor>> getMatriz() {
        return matriz;
    }

    public ArrayList<Agente> getPoblacion() {
        return poblacion;
    }

    public ArrayList<Policia> getPolicias() {
        return policias;
    }
    
    public void inicializarMatriz(int columnas, int filas){
        matriz = new ArrayList<List<Actor>>();
        for(int i=0; i<filas; i++){
            matriz.add(new ArrayList<Actor>());
            for(int j=0; j<columnas; j++){
                matriz.get(i).add(null);
            }
        }
    }
    
    public void imprimirMatriz(){
        
    }
    
    public ArrayList<Actor> obtenerActores(ArrayList<Agente> poblacion, 
            ArrayList<Policia> policias){
        ArrayList<Actor> actores = new ArrayList<>();
        actores.addAll(poblacion);
        actores.addAll(policias);
        
        return actores;
    }
    
    public Actor seleccionarActor(ArrayList<Actor> actores){
        int indice;
        do{
            indice = Aleatorio.enteroAleatorio(0, actores.size()-1);
            if(actores.get(indice).getCategoria().equals(Categoria.POLICIA))
                break;
        }while(Validacion.validarPrisionAgente((Agente) actores.get(indice)));
        
        return actores.get(indice);
    }
    
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public void setMatriz(List<List<Actor>> matriz) {
        this.matriz = matriz;
    }

    public void setPoblacion(ArrayList<Agente> poblacion) {
        this.poblacion = poblacion;
    }

    public void setPolicias(ArrayList<Policia> policias) {
        this.policias = policias;
    }  
    
    public int tamanioMatriz(){
        return this.filas * this.columnas;
    }
}
