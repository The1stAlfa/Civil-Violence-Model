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
    private boolean movimiento;
    private Posicion posicion;
    private int vision;
    
    public Actor(){
    }
    
    public Actor(Categoria categoria){
        this.categoria = categoria;
    }
    
    public Actor(boolean movimiento, Categoria  categoria, int vision){
        this.movimiento = movimiento;
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

    public boolean isMovimiento() {
        return movimiento;
    }
    
    public Posicion getPosicion(){
        return this.posicion;
    }

    public int getVision() {
        return vision;
    }
    
    public boolean moverse(int columnas, int filas, List<List<Actor>> matriz){
        ArrayList<Posicion> espacios = 
                inspeccionar(null, columnas, filas, matriz, posicion);
        
        if(!espacios.isEmpty()){
            int indice = Aleatorio.enteroAleatorio(0, espacios.size()-1);
            Posicion nuevaPosicion = espacios.get(indice);
            Posicion anteriorPosicion = this.posicion;
            this.posicion = nuevaPosicion;
            matriz.get(nuevaPosicion.getFila()).
                    set(nuevaPosicion.getColumna(), this);
            matriz.get(anteriorPosicion.getFila()).
                    set(anteriorPosicion.getColumna(), null);
            return true;
        }
        return false;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setMovimiento(boolean movimiento) {
        this.movimiento = movimiento;
    }
    
    public void setPosicion(Posicion posicion){
        this.posicion = posicion;
    }

    public void setVision(int vision) {
        this.vision = vision;
    }
    
    public ArrayList<Posicion> inspeccionar(Categoria categoria, int columnas,
            int filas, List<List<Actor>> matriz, Posicion posicion){
        int posX = posicion.getFila();
        int posY = posicion.getColumna();
        ArrayList<Posicion> posiciones = new ArrayList<>();
        
        if(posX == 0){
            if(posY == 0){
                inspeccionInferiorDerecha(categoria, posiciones, matriz,
                        posX, posY);
            }
            else if(posY == columnas - 1){
                inspeccionInferiorIzquierda(categoria, posiciones, matriz, 
                        posX, posY);
            }
            else{
                inspeccionInferiorDerecha(categoria, posiciones, matriz, 
                        posX, posY);
                inspeccionInferiorIzquierda(categoria, posiciones, matriz, 
                        posX, posY);
            }
        }
        else if(posX == filas - 1){
            if(posY == 0){
                inspeccionSuperiorDerecha(categoria, posiciones, matriz, 
                        posX, posY);
            }
            else if(posY == columnas - 1){
                inspeccionSuperiorIzquierda(categoria, posiciones, matriz, 
                        posX, posY);
            }
            else{
                inspeccionSuperiorDerecha(categoria, posiciones, matriz, 
                        posX, posY);
                inspeccionSuperiorIzquierda(categoria, posiciones, matriz, 
                        posX, posY);
            }
        }
        else{
            if(posY == 0){
                inspeccionSuperiorDerecha(categoria, posiciones, matriz, 
                        posX, posY);
                inspeccionInferiorDerecha(categoria, posiciones, matriz, 
                        posX, posY);
            }
            else if(posY == columnas -1){
                inspeccionSuperiorIzquierda(categoria, posiciones, matriz, 
                        posX, posY);
                inspeccionInferiorIzquierda(categoria, posiciones, matriz, 
                        posX, posY);
            }
            else{
                inspeccionSuperiorDerecha(categoria, posiciones, matriz, 
                        posX, posY);
                inspeccionSuperiorIzquierda(categoria, posiciones, matriz, 
                        posX, posY);
                inspeccionInferiorDerecha(categoria, posiciones, matriz, 
                        posX, posY);
                inspeccionInferiorIzquierda(categoria, posiciones, matriz, 
                        posX, posY);
            }
        }
        return posiciones;
    }
    
    private void inspeccionInferiorDerecha(Categoria categoria, 
            ArrayList<Posicion> posiciones,List<List<Actor>> matriz, 
            int posX, int posY){
        for(int i=posX; i<=posX+vision; i++){
            for(int j=posY; j<=posY+vision; j++){
                if(posX == i && posY == j && 
                        (categoria == null || 
                        categoria.equals(Categoria.POLICIA)))
                    continue;
                Posicion posicion = new Posicion(j, i);
                if(Categoria.AGENTE.equals(categoria)){
                    if(Validacion.validarCoordenada(matriz, posicion) == 0){
                        if(Validacion.esAgente(matriz,posicion) && 
                                Validacion.validarPosicion(posiciones, posicion))
                            posiciones.add(posicion);
                    }
                }
                else if(Categoria.POLICIA.equals(categoria)){
                    if(Validacion.validarCoordenada(matriz, posicion) == 0){
                        if(Validacion.esPolicia(matriz,posicion) && 
                                Validacion.validarPosicion(posiciones, posicion))
                            posiciones.add(posicion);
                    }
                }
                else{
                    if(Validacion.validarCoordenada(matriz, posicion) == 1){
                        if(Validacion.validarPosicion(posiciones, posicion))
                            posiciones.add(posicion);
                    }
                }
            }
        }
    }
    
    private void inspeccionInferiorIzquierda(Categoria categoria, 
            ArrayList<Posicion> posiciones, List<List<Actor>> matriz, 
            int posX, int posY){
        for(int i=posX; i<=posX+vision; i++){
            for(int j=posY; j>=posY-vision; j--){
                if(posX == i && posY == j && 
                        (categoria == null || 
                        categoria.equals(Categoria.POLICIA)))
                    continue;
                Posicion posicion = new Posicion(j, i);
                if(Categoria.AGENTE.equals(categoria)){
                    if(Validacion.validarCoordenada(matriz, posicion) == 0){
                        if(Validacion.esAgente(matriz,posicion) && 
                                Validacion.validarPosicion(posiciones, posicion))
                            posiciones.add(posicion);
                    }
                }
                else if(Categoria.POLICIA.equals(categoria)){
                    if(Validacion.validarCoordenada(matriz, posicion) == 0){
                        if(Validacion.esPolicia(matriz,posicion) && 
                                Validacion.validarPosicion(posiciones, posicion))
                            posiciones.add(posicion);
                    }
                }
                else{
                    if(Validacion.validarCoordenada(matriz, posicion) == 1){
                        if(Validacion.validarPosicion(posiciones, posicion))
                            posiciones.add(posicion);
                    }
                }
            }
        }
    }
    
    private void inspeccionSuperiorDerecha(Categoria categoria, 
            ArrayList<Posicion> posiciones, List<List<Actor>> matriz, 
            int posX, int posY){
        for(int i=posX; i>=posX-vision; i--){
            for(int j=posY; j<=posY+vision; j++){
                if(posX == i && posY == j && 
                        (categoria == null || 
                        categoria.equals(Categoria.POLICIA)))
                    continue;
                Posicion posicion = new Posicion(j, i);
                if(Categoria.AGENTE.equals(categoria)){
                    if(Validacion.validarCoordenada(matriz, posicion) == 0){
                        if(Validacion.esAgente(matriz,posicion) && 
                                Validacion.validarPosicion(posiciones, posicion))
                            posiciones.add(posicion);
                    }
                }
                else if(Categoria.POLICIA.equals(categoria)){
                    if(Validacion.validarCoordenada(matriz, posicion) == 0){
                        if(Validacion.esPolicia(matriz,posicion) && 
                                Validacion.validarPosicion(posiciones, posicion))
                            posiciones.add(posicion);
                    }
                }
                else{
                    if(Validacion.validarCoordenada(matriz, posicion) == 1){
                        if(Validacion.validarPosicion(posiciones, posicion))
                            posiciones.add(posicion);
                    }
                }
            }
        }
    }
    
    private void inspeccionSuperiorIzquierda(Categoria categoria, 
            ArrayList<Posicion> posiciones, List<List<Actor>> matriz, 
            int posX, int posY){
        for(int i=posX; i>=posX-vision; i--){
            for(int j=posY; j>=posY-vision; j--){
                if(posX == i && posY == j && 
                        (categoria == null || 
                        categoria.equals(Categoria.POLICIA)))
                    continue;
                Posicion posicion = new Posicion(j, i);
                if(Categoria.AGENTE.equals(categoria)){
                    if(Validacion.validarCoordenada(matriz, posicion) == 0){
                        if(Validacion.esAgente(matriz,posicion) && 
                                Validacion.validarPosicion(posiciones, posicion))
                            posiciones.add(posicion);
                    }
                }
                else if(Categoria.POLICIA.equals(categoria)){
                    if(Validacion.validarCoordenada(matriz, posicion) == 0){
                        if(Validacion.esPolicia(matriz,posicion) && 
                                Validacion.validarPosicion(posiciones, posicion))
                            posiciones.add(posicion);
                    }
                }
                else{
                    if(Validacion.validarCoordenada(matriz, posicion) == 1){
                        if(Validacion.validarPosicion(posiciones, posicion))
                            posiciones.add(posicion);
                    }
                }
            }
        }
    }
}
