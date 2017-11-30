
import com.cvm.model.Actor;
import com.cvm.model.Agente;
import com.cvm.model.Categoria;
import com.cvm.model.Posicion;
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
    private static int vision = 4;
    
    public static void main(String[] args){
        inicializarMatriz(3, 3);
        Posicion pos1 = new Posicion(2, 2);
        Posicion pos2 = new Posicion(1, 1);
        matriz.get(2).set(2, new Actor(Categoria.AGENTE, pos1, vision));
        matriz.get(1).set(1, new Actor(Categoria.AGENTE, pos2, vision));
        ArrayList<Posicion> espacios = obtenerEspacios(3, 3, matriz, pos2);
        colocarAgentes(3-1, 2-1, matriz, obtenerAgentes(56, (float)6, 2));
        
    }
    
    private static ArrayList<Posicion> obtenerEspacios(int columnas, int filas, 
            List<List<Actor>> matriz, Posicion posicion){
        int posX = posicion.getFila();
        int posY = posicion.getColumna();
        ArrayList<Posicion> espacios = new ArrayList<>();
        
        if(posX == 0){
            if(posY == 0){
                inspeccionInferiorDerecha(espacios, matriz, posX, posY);
            }
            else if(posY == columnas - 1){
                inspeccionInferiorIzquierda(espacios, matriz, posX, posY);
            }
            else{
                inspeccionInferiorDerecha(espacios, matriz, posX, posY);
                inspeccionInferiorIzquierda(espacios, matriz, posX, posY);
            }
        }
        else if(posX == filas - 1){
            if(posY == 0){
                inspeccionSuperiorDerecha(espacios, matriz, posX, posY);
            }
            else if(posY == columnas - 1){
                inspeccionSuperiorIzquierda(espacios, matriz, posX, posY);
            }
            else{
                inspeccionSuperiorDerecha(espacios, matriz, posX, posY);
                inspeccionSuperiorIzquierda(espacios, matriz, posX, posY);
            }
        }
        else{
            if(posY == 0){
                inspeccionSuperiorDerecha(espacios, matriz, posX, posY);
                inspeccionInferiorDerecha(espacios, matriz, posX, posY);
            }
            else if(posY == columnas -1){
                inspeccionSuperiorIzquierda(espacios, matriz, posX, posY);
                inspeccionInferiorIzquierda(espacios, matriz, posX, posY);
            }
            else{
                inspeccionSuperiorDerecha(espacios, matriz, posX, posY);
                inspeccionSuperiorIzquierda(espacios, matriz, posX, posY);
                inspeccionInferiorDerecha(espacios, matriz, posX, posY);
                inspeccionInferiorIzquierda(espacios, matriz, posX, posY);
            }
        }
        return espacios;
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
    
    private static void inspeccionInferiorDerecha(ArrayList<Posicion> espacios, 
            List<List<Actor>> matriz, int posX, int posY){
        for(int i=posX; i<=posX+vision; i++){
            for(int j=posY; j<=posY+vision; j++){
                if(posX == i && posY == j)
                    continue;
                Posicion posicion = new Posicion(j, i);
                    if(Validacion.validarCoordenada(matriz, posicion)){
                        if(Validacion.validarPosicion(espacios, posicion))
                            espacios.add(posicion);
                    }
            }
        }
    }
    
    private static void inspeccionInferiorIzquierda(ArrayList<Posicion> espacios, 
            List<List<Actor>> matriz, int posX, int posY){
        for(int i=posX; i<=posX+vision; i++){
            for(int j=posY; j>=posY-vision; j--){
                if(posX == i && posY == j)
                    continue;
                Posicion posicion = new Posicion(j, i);
                if(Validacion.validarCoordenada(matriz, posicion))
                    if(Validacion.validarPosicion(espacios, posicion))
                            espacios.add(posicion);
            }
        }
    }
    
    private static void inspeccionSuperiorDerecha(ArrayList<Posicion> espacios, 
            List<List<Actor>> matriz, int posX, int posY){
        for(int i=posX; i>=posX-vision; i--){
            for(int j=posY; j<=posY+vision; j++){
                if(posX == i && posY == j)
                    continue;
                Posicion posicion = new Posicion(j, i);
                    if(Validacion.validarCoordenada(matriz, posicion))
                        if(Validacion.validarPosicion(espacios, posicion))
                            espacios.add(posicion);
            }
        }
    }
    
    private static void inspeccionSuperiorIzquierda(ArrayList<Posicion> espacios, 
            List<List<Actor>> matriz, int posX, int posY){
        for(int i=posX; i>=posX-vision; i--){
            for(int j=posY; j>=posY-vision; j--){
                if(posX == i && posY == j)
                    continue;
                Posicion posicion = new Posicion(j, i);
                if(Validacion.validarCoordenada(matriz, posicion))
                    if(Validacion.validarPosicion(espacios, posicion))
                            espacios.add(posicion);
            }
        }
    }
} 