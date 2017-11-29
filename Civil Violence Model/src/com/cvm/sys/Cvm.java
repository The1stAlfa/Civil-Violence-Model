/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvm.sys;

import com.cvm.model.Simulador;
import java.util.Scanner;

/**
 *
 * @author ij_le
 */
// Cvm = Civil Violence Model

public class Cvm {
    private static Simulador simulacion;
    private static Scanner consola;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        consola = new Scanner(System.in);
        System.out.println("*** CIVIL VIOLENCE MODEL ***");
        System.out.println("          SIMULADOR        \n");
        iniciarSimulacion(solicitarParametrosDeSimulacion());
        // TODO code application logic here
    }
    
    public static void iniciarSimulacion(Object[] parametros){
        simulacion = new Simulador((int) parametros[2], (int) parametros[3], 
                (double) parametros[6], (int) parametros[7], new int[]{
                    (int)parametros[0], (int)parametros[1]},
                (int) parametros[4], (int) parametros[5], (int) parametros[8]);
        
        for(int turno=0; turno<(int)parametros[8]; turno++){
            simulacion.ejecutarSimulacro();
        }
    }
    
    public static Object[] solicitarParametrosDeSimulacion(){
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
