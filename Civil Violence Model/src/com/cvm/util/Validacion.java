/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvm.util;

import com.cvm.model.Actor;
import com.cvm.model.Agente;
import com.cvm.model.Categoria;
import com.cvm.model.Posicion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ij_le
 */
public class Validacion {
    public static int validarCoordenada(List<List<Actor>> matriz, 
            Posicion coordenada){
        try{
            if(matriz.get(coordenada.getFila()).get(
                    coordenada.getColumna())== null)
                return 1;
        }catch(IndexOutOfBoundsException e){
            return -1;
        }
        return 0;
    }
    
    public static boolean validarPrisionAgente(Agente agente){
        return agente.getEstaEnPrision();
    }
    
    public static boolean validarPosicion(ArrayList<Posicion> posiciones, 
            Posicion posicion){
        for(int i=0; i<posiciones.size(); i++){
            if(posiciones.get(i).getFila() == posicion.getFila() && 
                    posiciones.get(i).getColumna() == posicion.getColumna())
                return false;
        }
        return true;
    }
    
    public static boolean esAgente(List<List<Actor>> matriz, 
            Posicion coordenada){
        int posX = coordenada.getFila();
        int posY = coordenada.getColumna();
        Actor actor = matriz.get(posX).get(posY);
                
        if(actor.getCategoria().equals(Categoria.AGENTE))
            return true;
        return false;
    }
    
    public static boolean esPolicia(List<List<Actor>> matriz, 
            Posicion coordenada){
                int posX = coordenada.getFila();
        int posY = coordenada.getColumna();
        Actor actor = matriz.get(posX).get(posY);
        
        if(actor.getCategoria().equals(Categoria.POLICIA))
            return true;
        return false;
    }
}
