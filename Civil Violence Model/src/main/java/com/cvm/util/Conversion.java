/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvm.util;

/**
 *
 * @author ij_le
 */
public class Conversion {
    
    public static boolean conversionBooleano(Object o){
        return Boolean.parseBoolean(o.toString());
    }
    
    public static int conversionEntero(Object o){
        return Integer.parseInt(o.toString());
    }
    
    public static double conversionDouble(Object o){
        return Double.parseDouble(o.toString());
    }
}
