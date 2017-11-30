/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvm.util;

import com.cvm.model.Actor;
import com.cvm.model.Agente;
import com.cvm.model.Posicion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ij_le
 */
public class Validacion {
    public static boolean validarCoordenada(List<List<Actor>> matriz, 
            Posicion coordenada){
        try{
            return matriz.get(coordenada.getFila()).get(
                    coordenada.getColumna())== null;
        }catch(IndexOutOfBoundsException e){
            return false;
        }
        
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
}
