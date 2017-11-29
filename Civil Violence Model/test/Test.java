
import com.cvm.model.Actor;
import com.cvm.model.Agente;
import com.cvm.model.Posicion;
import com.cvm.model.Universo;
import java.util.ArrayList;
import com.cvm.util.Aleatorio;
import com.cvm.util.Validacion;
import java.util.List;

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
    private static List<List<Actor>> matriz = new ArrayList<List<Actor>>();
    
    public static void main(String[] args){
        inicializarMatriz(3, 2);
        colocarAgentes(3-1, 2-1, matriz, obtenerAgentes(56, (float)6, 2));
        
    }
    
    public static void inicializarMatriz(int columnas, int filas){
        matriz = new ArrayList<List<Actor>>();
        for(int i=0; i<filas; i++){
            matriz.add(new ArrayList<Actor>());
            for(int j=0; j<columnas; j++){
                matriz.get(i).add(null);
            }
        }
    }
    
    public static ArrayList<Agente> obtenerAgentes(int densidad, float tamanio, 
            int vision){
        ArrayList<Agente> agentes = new ArrayList<>();
        int numeroDeAgentes = 
                (int)((float)tamanio * (float)densidad/100);
        for(int a=0; a<numeroDeAgentes; a++){
            agentes.add(new Agente(Math.random(), Math.random(), vision));
        }
        
        return agentes;
    }
      
    public static void colocarAgentes(int columnas, int filas, 
            List<List<Actor>> matriz, ArrayList<Agente> poblacion){
        Posicion coordenada;
        for(int i=0; i<poblacion.size(); i++){
            do{
                coordenada = Aleatorio.posicionAleatoria(filas, columnas);
            }while(!Validacion.validarCoordenada(matriz, coordenada));
            poblacion.get(i).setPosicion(coordenada);
            matriz.get(coordenada.getFila()).set(
                    coordenada.getColumna(), poblacion.get(i));
        }
        System.out.println("");
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