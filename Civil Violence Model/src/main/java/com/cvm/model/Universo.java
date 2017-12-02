/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvm.model;

import com.cvm.util.Aleatorio;
import com.cvm.util.Color;
import com.cvm.util.Validacion;
import java.util.ArrayList;
import java.util.List;
import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi.Attribute;
import com.diogonunes.jcdp.color.api.Ansi.BColor;
import com.diogonunes.jcdp.color.api.Ansi.FColor;

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
    
    public int cantidadAgentes(Estado estado){
        int cantidad = 0;
        Agente agente;
        for(List<Actor> lista: matriz){
            for(Actor actor: lista){
                if(actor != null){
                    if(actor.getCategoria().equals(Categoria.AGENTE)){
                        if(estado != null){
                            agente = (Agente) actor;
                            if(agente.getEstado().equals(estado))
                                cantidad++;
                        }
                        else
                            cantidad++;
                    }
                }
            }
        }
        return cantidad;
    }
    
    public int cantidadPolicias(){
        return this.policias.size();
    }
    
    public void colocarAgentes(int columnas, int filas, 
            List<List<Actor>> matriz, ArrayList<Agente> poblacion){
        Posicion coordenada = new Posicion();
        
        for(int i=0; i<poblacion.size(); i++){
            do{
                coordenada = Aleatorio.posicionAleatoria(columnas, filas);
            }while(Validacion.validarCoordenada(matriz, coordenada) == 0);
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
                coordenada = Aleatorio.posicionAleatoria(columnas, filas);
            }while(Validacion.validarCoordenada(matriz, coordenada) == 0);
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
    
    /**
     *
     * @param columnas
     * @param filas
     */
    public void inicializarMatriz(int columnas, int filas){
        matriz = new ArrayList<List<Actor>>();
        for(int i=0; i<filas; i++){
            matriz.add(new ArrayList<Actor>());
            for(int j=0; j<columnas; j++){
                matriz.get(i).add(null);
            }
        }
    }
    
    // Muestra matriz usando colores para diferenciar a los agentes 
    // en la consola del NetBeans
    /*
    public void imprimirMatriz(int columnas, int filas){
        System.out.print("\t ");
        for(int i=0; i<columnas; i++)
            System.out.print("-");
        System.out.println("");
        for(int i=0; i<filas; i++){
            System.out.print("\t");
            for(int j=0; j<columnas; j++){
                if(j == 0)
                    System.out.print("|");
                Actor actor = matriz.get(i).get(j); 
                if(actor != null){ 
                    if(actor.getCategoria().equals(Categoria.AGENTE)){
                        Agente agente = (Agente)actor;
                        if(agente.getEstado().equals(Estado.ACTIVO))
                            System.out.print(Color.RED.getCodigo() + "0" 
                                    + Color.RESET.getCodigo());
                        else
                            System.out.print(Color.BLUE.getCodigo() + "0" 
                                    + Color.RESET.getCodigo());
                    }
                    else
                        System.out.print(Color.BLACK.getCodigo() + "0" 
                                + Color.RESET.getCodigo());
                }
                else
                    System.out.print(" ");
                if(j == columnas - 1)
                    System.out.print("|");
            }
            System.out.println("");
        }
        System.out.print("\t ");
        for(int i=0; i<columnas; i++)
            System.out.print("-");
        System.out.println("");
    }
    */

    /**
     *
     * @param columnas
     * @param filas
     */
    
    public void imprimirMatriz(int columnas, int filas){
        System.out.print("\t ");
        for(int i=0; i<columnas; i++)
            System.out.print("-");
        System.out.println("");
        for(int i=0; i<filas; i++){
            System.out.print("\t");
            for(int j=0; j<columnas; j++){
                if(j == 0)
                    System.out.print("|");
                Actor actor = matriz.get(i).get(j); 
                if(actor != null){ 
                    if(actor.getCategoria().equals(Categoria.AGENTE)){
                        Agente agente = (Agente)actor;
                        if(agente.getEstado().equals(Estado.ACTIVO))
                            System.out.print("@");
                        else
                            System.out.print(".");
                    }
                    else
                        System.out.print("P");
                }
                else
                    System.out.print(" ");
                if(j == columnas - 1)
                    System.out.print("|");
            }
            System.out.println("");
        }
        System.out.print("\t ");
        for(int i=0; i<columnas; i++)
            System.out.print("-");
        System.out.println("");
    }
    
    // Muestra matriz usando colores para diferenciar a los agentes 
    // para consolas Windows y Linux
    /*
    public void imprimirMatriz(int columnas, int filas){
        ColoredPrinter cp = new ColoredPrinter.Builder(1, false)
                        .foreground(FColor.WHITE).background(BColor.BLACK)   //setting format
                        .build();

        cp.print("\t ");
        for(int i=0; i<columnas; i++)
            cp.print("-");
        System.out.println("");
        for(int i=0; i<filas; i++){
            cp.print("\t");
            for(int j=0; j<columnas; j++){
                if(j == 0)
                    cp.print("|");
                Actor actor = matriz.get(i).get(j); 
                if(actor != null){ 
                    if(actor.getCategoria().equals(Categoria.AGENTE)){
                        Agente agente = (Agente)actor;
                        if(agente.getEstado().equals(Estado.ACTIVO))
                            cp.print("0", Attribute.NONE, FColor.RED, 
                                BColor.BLACK);
                        else
                            cp.print("0", Attribute.NONE, FColor.BLUE, 
                                BColor.BLACK);
                    }
                    else{
                        cp.clear();
                        System.out.print("0");
                    }
                }
                else{
                    cp.clear();
                    System.out.print(" ");
                }
                if(j == columnas - 1){
                    cp.clear();
                    System.out.println("|");
                }
            }
            cp.clear();
        }
        System.out.print("\t ");
        for(int i=0; i<columnas; i++)
            System.out.print("-");
        System.out.println("");
    }*/

    
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
