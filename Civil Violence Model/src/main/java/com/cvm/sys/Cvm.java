/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvm.sys;

import com.cvm.model.Simulador;
import static com.cvm.util.Conversion.conversionEntero;
import static com.cvm.util.Conversion.conversionDouble;
import com.cvm.util.Validacion;
import java.time.LocalDateTime;
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
        String nombreArchivo = "cvm" + tiempo() + ".csv";
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
            simulacion.ejecutarSimulacro(nombreArchivo);
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
        System.out.println("*** Tamaño de Universo ***");
        do{
            System.out.print("Filas: ");
            parametros[0] = consola.nextLine();
        }while(!Validacion.validarIngresoEntero((String) parametros[0], 3, 500));
        do{
            System.out.print("Columnas: ");
            parametros[1] = consola.nextLine();
        }while(!Validacion.validarIngresoEntero((String) parametros[1], 3, 500));
        System.out.print("Densidad de Agentes: ");
        parametros[2] = consola.nextLine();
        System.out.print("Densidad de Policias: ");
        parametros[3] = consola.nextLine();
        do{
            System.out.print("Vision de Agentes: ");
            parametros[4] = consola.nextLine();
        }while(Validacion.validarIngresoEntero((String) parametros[4], 1, 100));
        do{
            System.out.print("Vision de Policias: ");
            parametros[5] = consola.nextLine();
        }while(Validacion.validarIngresoEntero((String) parametros[5], 1, 100));
        System.out.print("Legitimidad del Gobierno: ");
        parametros[6] = consola.nextLine();
        do{
            System.out.print("Maximo de Turnos en prision: ");
            parametros[7] = consola.nextLine();
        }while(Validacion.validarIngresoEntero((String) parametros[7], 1, 
                Integer.MAX_VALUE));
        do{
            System.out.print("Numero de Turnos para simulacion: ");
            parametros[8] = consola.nextLine();
        }while(Validacion.validarIngresoEntero((String) parametros[8], 1, 
                Integer.MAX_VALUE));
        
        return parametros;
    }
    
    public static void limpiarPantalla(){
        for(int i=0; i<40; i++)
            System.out.println("");
    }
    
    public static String tiempo(){
        LocalDateTime dateTime = LocalDateTime.now();
        String date = dateTime.toLocalDate().toString();
        String hour = String.valueOf(dateTime.getHour());
        String minute = String.valueOf(dateTime.getMinute());
        String second = String.valueOf(dateTime.getSecond());
        String time = hour + minute + second;
        
        return date+"-"+time;
    }
}
