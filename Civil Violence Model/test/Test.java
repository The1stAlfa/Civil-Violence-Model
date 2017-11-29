
import com.cvm.model.Agente;
import com.cvm.model.Posicion;
import java.util.ArrayList;
import com.cvm.util.Aleatorio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ij_le
 */
public class Test {
    public static void main(String[] args){
        pruebaAleatorios();
        
    }
    
    public static void pruebaAleatorios(){
        Posicion pos = Aleatorio.posicionAleatoria(5, 4);
        System.out.println(pos.getFila()+ "," + pos.getColumna());
    }
    
    public static void pruebaDeListaAgentes(){
        ArrayList<Agente> agentes = new ArrayList<>();
        int numeroDeAgentes = 
                (int)((float)89* (float)58/100);
        System.out.println(numeroDeAgentes);
        for(int a=0; a<numeroDeAgentes; a++){
            agentes.add(new Agente(Math.random(), Math.random(), 2));
        }
        for(int a=0; a<numeroDeAgentes; a++)
            System.out.println(agentes.get(a).getPerjuicio()+ "+" + agentes.get(a).getRiesgoAversion());
    }
} 