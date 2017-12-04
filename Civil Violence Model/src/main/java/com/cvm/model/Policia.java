/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvm.model;

import com.cvm.util.Aleatorio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ij_le
 */
public class Policia extends Actor{
    
    public Policia(){
        super(Categoria.POLICIA);
    }

    public Policia(boolean movimiento, int vision) {
        super(movimiento, Categoria.POLICIA, vision);
    }
    
    public void actuar(int columnas, int filas, List<List<Actor>> matriz, 
            int maxTurnoPrision, Prision prision){
        ArrayList<Posicion> posicionAgentes = inspeccionar(Categoria.AGENTE, 
                columnas, filas, matriz, this.getPosicion());
        ArrayList<Actor> agentesActivos =  
                obtenerAgentesActivos(matriz, posicionAgentes);
        Agente agenteActivo;
        if(!agentesActivos.isEmpty()){
             agenteActivo= seleccionarAgenteActivo(agentesActivos);
             arrestarAgente(agenteActivo, maxTurnoPrision, prision);
             liberarEspacioEnMatriz(agenteActivo.getPosicion(), matriz);
        }
    }
    
    public void arrestarAgente(Agente agente, int maxTurnoPrision, Prision prision){
        int condena = Aleatorio.enteroAleatorio(1, maxTurnoPrision);
        prision.colocarPrisionero(agente, condena);
    } 
    
    private ArrayList<Actor> obtenerAgentesActivos(List<List<Actor>> matriz,
            ArrayList<Posicion> posiciones){
        ArrayList<Actor> agentesActivos = new ArrayList<>();
        
        for(int i=0; i<posiciones.size(); i++){
            int posX = posiciones.get(i).getFila();
            int posY = posiciones.get(i).getColumna();
            Agente agente = (Agente)(matriz.get(posX).get(posY)); 
            if(agente.getEstado().equals(Estado.ACTIVO))
                agentesActivos.add(agente);
        }
        
        return agentesActivos;
    }
    
    private void liberarEspacioEnMatriz(Posicion posicion, List<List<Actor>> matriz){
        int posX = posicion.getFila();
        int posY = posicion.getColumna();
        
        matriz.get(posX).set(posY, null);
    }
    
    private Agente seleccionarAgenteActivo(ArrayList<Actor> agentesActivos){
        int indice = Aleatorio.enteroAleatorio(0, agentesActivos.size() - 1);
        return (Agente) agentesActivos.get(indice);
    }
}
