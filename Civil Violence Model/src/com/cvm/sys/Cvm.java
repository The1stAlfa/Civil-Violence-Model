/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvm.sys;

import com.cvm.model.Simulador;

/**
 *
 * @author ij_le
 */
// Cvm = Civil Violence Model

public class Cvm {
    private static Terminal terminal;
    private static Simulador simulacion;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        terminal = new Terminal();
        System.out.println("*** CIVIL VIOLENCE MODEL ***");
        System.out.println("          SIMULADOR        \n");
        iniciarSimulacion(terminal.solicitarParametrosDeSimulacion());
        // TODO code application logic here
    }
    
    public static void iniciarSimulacion(Object[] parametros){
        simulacion = new Simulador();
    }
    
}
