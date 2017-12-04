/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvm.sys;

import com.cvm.model.Simulador;
import com.cvm.util.Conversion;
import static com.cvm.util.Conversion.*;
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
                conversionBooleano(parametros[9]),
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
        Object[] parametros = new Object[10];
        System.out.println("Para iniciar la simulacion");
        System.out.println("Ingrese los siguiente parametros...\n");
        try {
            Thread.sleep(2000);
	} catch (InterruptedException e) {
        	e.printStackTrace();}
        System.out.println("*** Tamaño de Universo ***");
        System.out.println("Ingrese valores entre 3 y 500");
        do{
            System.out.print("Filas: ");
            parametros[0] = consola.nextLine();
        }while(!Validacion.validarIngresoEntero((String) parametros[0], 3, 500));
        System.out.println("Ingrese valores entre 3 y 500");    
        do{
            System.out.print("Columnas: ");
            parametros[1] = consola.nextLine();
        }while(!Validacion.validarIngresoEntero((String) parametros[1], 3, 500));
        System.out.println("\nEncender movimiento 1 o 0 para apagarlo");
        do{
            System.out.print("Movimiento: ");
            parametros[9] = consola.nextLine();
        }while(!Validacion.validarIngresoEntero((String) parametros[9], 0, 1));
        do{
            System.out.println("\nIngrese valores entre 0 y 99"
                    + "\nLa suma de las densidades entre Agente y Policia no "
                        + "debe sobrepasar el 99%");
            do{
                System.out.print("Densidad de Agentes %: ");
                parametros[2] = consola.nextLine();
            }while(!Validacion.validarIngresoEntero((String) parametros[2], 0, 100));
            System.out.println("\nIngrese valores entre 0 y 99"
                        + "\nLa suma de las densidades entre Agente y Policia no "
                        + "debe sobrepasar el 99%");
            do{
                System.out.print("Densidad de Policias %: ");
                parametros[3] = consola.nextLine();
            }while(!Validacion
                    .validarIngresoEntero((String) parametros[3], 0, 100));
        }while(conversionEntero(parametros[2]) 
                + conversionEntero(parametros[3]) > 99);    
        do{
            System.out.println("\nIngrese valores entre 0 y como maximo el "
                    + "tamanio de la matriz");
            do{    
                System.out.print("Vision de Agentes: ");
                parametros[4] = consola.nextLine();
            }while(!Validacion.validarIngresoEntero((String) parametros[4], 1, 100));
            System.out.println("\nIngrese valores entre 0 y como maximo el "
                        + "tamanio de la matriz");
            System.out.println("La vision del Policia debe ser diferente "
                        + "del Agente");
            do{    
                System.out.print("Vision de Policias: ");
                parametros[5] = consola.nextLine();
            }while(!Validacion.validarIngresoEntero((String) parametros[5], 1, 100));
        }while(conversionEntero(parametros[4]) == conversionEntero(parametros[5]));
        System.out.println("\nIngrese valores entre 0 y 1");
        do{
            System.out.print("Legitimidad del Gobierno: ");
            parametros[6] = consola.nextLine();
        }while(!Validacion.validarIngresoDouble((String) parametros[6], 0, 1));
        System.out.println("\nIngrese valores entre 1 y 2147483647");
        do{
            System.out.print("Maximo de Turnos en prision: ");
            parametros[7] = consola.nextLine();
        }while(!Validacion.validarIngresoEntero((String) parametros[7], 1, 
                Integer.MAX_VALUE));
        System.out.println("\nIngrese valores entre 1 y 2147483647");
        do{
            System.out.print("Numero de Turnos para simulacion: ");
            parametros[8] = consola.nextLine();
        }while(!Validacion.validarIngresoEntero((String) parametros[8], 1, 
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
