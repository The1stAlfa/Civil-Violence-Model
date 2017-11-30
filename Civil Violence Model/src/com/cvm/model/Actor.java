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
public class Actor {
    private Categoria categoria;
    private Posicion posicion;
    private int vision;
    
    public Actor(){
    }
    
    public Actor(Categoria categoria){
        this.categoria = categoria;
    }
    
    public Actor(Categoria  categoria, int vision){
        this.categoria = categoria;
        this.vision = vision;
    }

    public Actor(Categoria  categoria, Posicion posicion, int vision){
        this.categoria = categoria;
        this.posicion = posicion;
        this.vision = vision;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    
    public Posicion getPosicion(){
        return this.posicion;
    }

    public int getVision() {
        return vision;
    }
    
    public boolean movimiento(int columnas, int filas, List<List<Actor>> matriz){
        ArrayList<Posicion> espacios = 
                obtenerEspacios(columnas, filas, matriz, posicion);
        
        if(!espacios.isEmpty()){
            int indice = Aleatorio.enteroAleatorio(0, espacios.size()-1);
            
            return true;
        }
            
        return false;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public void setPosicion(Posicion posicion){
        this.posicion = posicion;
    }

    public void setVision(int vision) {
        this.vision = vision;
    }
    
    private ArrayList<Posicion> obtenerEspacios(int columnas, int filas, 
            List<List<Actor>> matriz, Posicion posicion){
        int posX = posicion.getFila();
        int posY = posicion.getColumna();
        ArrayList<Posicion> espacios = new ArrayList<>();
        
        if(posX == 0){
            if(posY == 0){
                inspeccionInferiorDerecha(espacios, matriz, posX, posY);
            }
            else if(posY == columnas - 1){
                inspeccionInferiorIzquierda(espacios, matriz, posX, posY);
            }
            else{
                inspeccionInferiorDerecha(espacios, matriz, posX, posY);
                inspeccionInferiorIzquierda(espacios, matriz, posX, posY);
            }
        }
        else if(posX == filas - 1){
            if(posY == 0){
                inspeccionSuperiorDerecha(espacios, matriz, posX, posY);
            }
            else if(posY == columnas - 1){
                inspeccionSuperiorIzquierda(espacios, matriz, posX, posY);
            }
            else{
                inspeccionSuperiorDerecha(espacios, matriz, posX, posY);
                inspeccionSuperiorIzquierda(espacios, matriz, posX, posY);
            }
        }
        else{
            if(posY == 0){
                inspeccionSuperiorDerecha(espacios, matriz, posX, posY);
                inspeccionInferiorDerecha(espacios, matriz, posX, posY);
            }
            else if(posY == columnas -1){
                inspeccionSuperiorIzquierda(espacios, matriz, posX, posY);
                inspeccionInferiorIzquierda(espacios, matriz, posX, posY);
            }
            else{
                inspeccionSuperiorDerecha(espacios, matriz, posX, posY);
                inspeccionSuperiorIzquierda(espacios, matriz, posX, posY);
                inspeccionInferiorDerecha(espacios, matriz, posX, posY);
                inspeccionInferiorIzquierda(espacios, matriz, posX, posY);
            }
        }
        return espacios;
    }
    
    private void inspeccionInferiorDerecha(ArrayList<Posicion> espacios, 
            List<List<Actor>> matriz, int posX, int posY){
        for(int i=posX; i<=posX+vision; i++){
            for(int j=posY; j<=posY+vision; j++){
                if(posX == i && posY == j)
                    continue;
                Posicion posicion = new Posicion(j, i);
                    if(Validacion.validarCoordenada(matriz, posicion)){
                        if(Validacion.validarPosicion(espacios, posicion))
                            espacios.add(posicion);
                    }
            }
        }
    }
    
    private void inspeccionInferiorIzquierda(ArrayList<Posicion> espacios, 
            List<List<Actor>> matriz, int posX, int posY){
        for(int i=posX; i<=posX+vision; i++){
            for(int j=posY; j>=posY-vision; j--){
                if(posX == i && posY == j)
                    continue;
                Posicion posicion = new Posicion(j, i);
                if(Validacion.validarCoordenada(matriz, posicion))
                    if(Validacion.validarPosicion(espacios, posicion))
                            espacios.add(posicion);
            }
        }
    }
    
    private void inspeccionSuperiorDerecha(ArrayList<Posicion> espacios, 
            List<List<Actor>> matriz, int posX, int posY){
        for(int i=posX; i>=posX-vision; i--){
            for(int j=posY; j<=posY+vision; j++){
                if(posX == i && posY == j)
                    continue;
                Posicion posicion = new Posicion(j, i);
                    if(Validacion.validarCoordenada(matriz, posicion))
                        if(Validacion.validarPosicion(espacios, posicion))
                            espacios.add(posicion);
            }
        }
    }
    
    private void inspeccionSuperiorIzquierda(ArrayList<Posicion> espacios, 
            List<List<Actor>> matriz, int posX, int posY){
        for(int i=posX; i>=posX-vision; i--){
            for(int j=posY; j>=posY-vision; j--){
                if(posX == i && posY == j)
                    continue;
                Posicion posicion = new Posicion(j, i);
                if(Validacion.validarCoordenada(matriz, posicion))
                    if(Validacion.validarPosicion(espacios, posicion))
                            espacios.add(posicion);
            }
        }
    }
}
