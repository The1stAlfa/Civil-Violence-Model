/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvm.sys;

import com.cvm.model.Simulador;
import static com.cvm.util.Conversion.conversionEntero;
import static com.cvm.util.Conversion.conversionDouble;
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
        try {
            Thread.sleep(1500);
	} catch (InterruptedException e) {
        	e.printStackTrace();}
        iniciarSimulacion(solicitarParametrosDeSimulacion());
        // TODO code application logic here
    }
    
    public static void iniciarSimulacion(Object[] parametros){
        simulacion = new Simulador(
                conversionEntero(parametros[2]), 
                conversionEntero(parametros[3]), 
                conversionDouble(parametros[6]),
                conversionEntero(parametros[7]),
                new int[]{
                    conversionEntero(parametros[0]),
                    conversionEntero(parametros[1])},
                conversionEntero(parametros[8]),
                conversionEntero(parametros[4]),
                conversionEntero(parametros[5]));

        for(int turno=0; turno<conversionEntero(parametros[8]); turno++){
            limpiarPantalla();
            System.out.println("*** CIVIL VIOLENCE MODEL ***");
            System.out.println("          SIMULADOR        \n");
            simulacion.ejecutarSimulacro();
        }
    }
    
    public static Object[] solicitarParametrosDeSimulacion(){
        Object[] parametros = new Object[9];
        System.out.println("Para iniciar la simulacion");
        System.out.println("Ingrese los siguiente parametros...\n");
        try {
            Thread.sleep(2000);
	} catch (InterruptedException e) {
        	e.printStackTrace();}
        System.out.print("*** Tamaño de Universo ***\nFilas: ");
        parametros[0] = consola.nextLine();
        System.out.print("Columnas: ");
        parametros[1] = consola.nextLine();
        System.out.print("Densidad de Agentes: ");
        parametros[2] = consola.nextLine();
        System.out.print("Densidad de Policias: ");
        parametros[3] = consola.nextLine();
        System.out.print("Vision de Agentes: ");
        parametros[4] = consola.nextLine();
//        System.out.print("Vision de Policias: ");
        parametros[5] = consola.nextLine();
        System.out.print("Legitimidad del Gobierno: ");
        parametros[6] = consola.nextLine();
        System.out.print("Maximo de Turnos en prision: ");
        parametros[7] = consola.nextLine();
        System.out.print("Numero de Turnos para simulacion: ");
        parametros[8] = consola.nextLine();
        
        return parametros;
    }
    
    public static void limpiarPantalla(){
        for(int i=0; i<40; i++)
            System.out.println("");
    }
}
