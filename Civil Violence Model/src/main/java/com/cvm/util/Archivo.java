/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvm.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ij_le
 */
public class Archivo {
    private static BufferedWriter bw;
    private static File archivo;
    
    public static boolean grabar(String ruta, String data) throws IOException{
        archivo = new File(System.getProperty("user.dir"), ruta);
        
        if(archivo.exists()){
            bw = new BufferedWriter(new FileWriter(archivo, true));
            bw.write(data);
            bw.newLine();
            bw.close();
            return true;
        } 
        else {
            if(archivo.createNewFile()){
                bw = new BufferedWriter(new FileWriter(archivo));
                bw.write(data);
                bw.newLine();
                bw.close();
                return true;
            }// El fichero no existe y hay que crearlo
        }
        return false;
    }
    
    public static boolean leer(String ruta){
        return false;
    }
}