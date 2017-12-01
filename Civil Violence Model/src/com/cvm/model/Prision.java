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
public class Prision {
    protected ArrayList<Prisionero> prisioneros;

    public Prision() {
        prisioneros = new ArrayList<Prisionero>();
    }
     
    public void actualizarTurnoEnPrision(){
        for(int i=0; i<prisioneros.size(); i++)
            prisioneros.get(i).aumentarTurnoEnPrision();
    }
    
    public int cantidadPrisioneros(){
        return this.prisioneros.size();
    }
    
    public void colocarPrisionero(Agente agente, int condena){
        prisioneros.add(new Prisionero(agente, condena));
    }
    
    public ArrayList<Prisionero> getPrisioneros() {
        return prisioneros;
    }
    
    private void liberarPrisionero(List<List<Actor>> matriz, 
            Prisionero prisionero){
        Actor actor = prisionero.getAgente();
        int columnas = matriz.get(0).size();
        int filas = matriz.size();
        Posicion coordenada= new Posicion();
        int posX, posY;
        
        do{
            coordenada = Aleatorio.posicionAleatoria(columnas - 1, filas - 1);
        }while(Validacion.validarCoordenada(matriz, coordenada) == 0);
        posX = coordenada.getFila();
        posY = coordenada.getColumna();
        actor.setPosicion(coordenada);
        matriz.get(posX).set(posY, actor);
    }
    
    public void liberarPrisioneros(List<List<Actor>> matriz){
        for(int i=prisioneros.size()-1; i>=0; i--){
            Prisionero prisionero = prisioneros.get(i);
            if(prisionero.getTurnosEnPrision() == prisionero.getCondena()){
                liberarPrisionero(matriz, prisionero);
                prisioneros.remove(i);
            }
        }
    }

    public void setPrisioneros(ArrayList<Prisionero> prisioneros) {
        this.prisioneros = prisioneros;
    }
}
