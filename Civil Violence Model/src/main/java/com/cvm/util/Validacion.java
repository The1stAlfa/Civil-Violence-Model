/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvm.util;

import com.cvm.model.Actor;
import com.cvm.model.Agente;
import com.cvm.model.Categoria;
import com.cvm.model.Estado;
import com.cvm.model.Posicion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ij_le
 */
public class Validacion {
    
    public static boolean esAgenteActivo(List<List<Actor>> matriz, 
            Posicion coordenada){
        int posX = coordenada.getFila();
        int posY = coordenada.getColumna();
        Actor actor = matriz.get(posX).get(posY);
                
        if(actor.getCategoria().equals(Categoria.AGENTE)){
            if(((Agente)actor).getEstado().equals(Estado.ACTIVO))
                return true;
        }
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
    
    public static boolean validarIngresoEntero(String dato, int limiteInferior, 
            int limiteSuperior){
        int entero;
        
        try{
            entero = Integer.parseInt(dato);
        }catch(NumberFormatException e){
            if(dato.isEmpty())
                System.out.println("Ingreso de datos requerido.");
            else
                System.out.println("Formato de Ingreso Invalido");
            return false;
        }
        if(entero < limiteInferior || entero > limiteSuperior){
            System.out.println("Ingreso Invalido");
            return false;
        }
        return true;
    }
    
    public static boolean validarIngresoDouble(String dato, double limiteInferior, 
            double limiteSuperior){
        double flotante;
        
        try{
            flotante = Double.parseDouble(dato);
        }catch(NumberFormatException e){
            if(dato.isEmpty())
                System.out.println("Ingreso de datos requerido.");
            else
                System.out.println("Formato de Ingreso Invalido");
            return false;
        }
        if(flotante < limiteInferior || flotante > limiteSuperior){
            System.out.println("Ingreso Invalido");
            return false;
        }
        return true;
    }
    
    public static boolean validarIngresoTexto(String dato){
        if(dato.isEmpty())
            return false;
        return true;
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
