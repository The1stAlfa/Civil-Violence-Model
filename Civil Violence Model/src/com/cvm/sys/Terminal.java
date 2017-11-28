/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvm.sys;

import java.util.Scanner;

/**
 *
 * @author ij_le
 */
public class Terminal {
    private Scanner consola;
    
    public Terminal(){
        consola = new Scanner(System.in);
    }
    
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
    
    public Object[] solicitarParametrosDeSimulacion(){
        Object[] parametros = new Object[9];
        System.out.println("Para iniciar la simulacion");
        System.out.println("Ingrese los siguiente parametros...\n");
        System.out.print("***Tamaño de Universo***\nNumero de Filas: ");
        parametros[0] = consola.nextLine();
        System.out.print("Numero de Columnas: ");
        parametros[1] = consola.nextLine();
        System.out.print("Densidad de Agentes: ");
        parametros[2] = consola.nextLine();
        System.out.print("Densidad de Policias: ");
        parametros[3] = consola.nextLine();
        System.out.print("Vision de Agentes: ");
        parametros[4] = consola.nextLine();
        System.out.print("Vision de Policias:");
        parametros[5] = consola.nextLine();
        System.out.print("Legitimidad del Gobierno: ");
        parametros[6] = consola.nextLine();
        System.out.print("Maximo de Turnos en prision: ");
        parametros[7] = consola.nextLine();
        System.out.print("Numero de Turnos para simulacion: ");
        parametros[8] = consola.nextLine();
        
        return parametros;
    }
}
