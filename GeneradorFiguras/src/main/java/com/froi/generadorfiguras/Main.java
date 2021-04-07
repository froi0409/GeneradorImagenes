/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.generadorfiguras;

import com.froi.generadorfiguras.estructuras.AVLTree;
import com.froi.generadorfiguras.estructuras.ArbolAVL;
import com.froi.generadorfiguras.nodos.NodoAVL;

/**
 *
 * @author froi-pc
 */
public class Main {
    public static void main(String args[]) {
        ArbolAVL arbol = new ArbolAVL();
//        arbol.insertar(new NodoAVL("id1"));
//        arbol.insertar(new NodoAVL("id2"));
//        arbol.insertar(new NodoAVL("id3"));
//        arbol.insertar(new NodoAVL("fd4"));
//        arbol.insertar(new NodoAVL("id5"));
//        arbol.insertar(new NodoAVL("rd6"));
//        arbol.insertar(new NodoAVL("id7"));
//        arbol.insertar(new NodoAVL("aid8"));
//        arbol.eliminar("id2");
////        AVLTree arbol = new AVLTree();
//        arbol.insertar("id1");
//        arbol.insertar("id2");
//        arbol.insertar("id3");
//        arbol.insertar("id4");
//        arbol.insertar("id5");
//        arbol.insertar("fd6");
//        arbol.insertar("id7");
//        arbol.insertar("id8");
//        arbol.insertar("id9");


        arbol.insertar(new NodoAVL("20"));
        arbol.insertar(new NodoAVL("30"));
        arbol.insertar(new NodoAVL("40"));
        arbol.insertar(new NodoAVL("35"));
        arbol.insertar(new NodoAVL("15"));
        arbol.insertar(new NodoAVL("50"));
        arbol.insertar(new NodoAVL("55"));
        arbol.insertar(new NodoAVL("56"));
        arbol.insertar(new NodoAVL("57"));
        arbol.insertar(new NodoAVL("58"));
        arbol.eliminar("30");
        
//        arbol.insertar(new NodoAVL("2"));
//        arbol.insertar(new NodoAVL("5"));
//        arbol.insertar(new NodoAVL("3"));
        System.out.println("INORDEN\n");
        arbol.inoden();
        System.out.println("\n\n\nPREORDEN\n");
        arbol.preOrden();
        System.out.println("\n\n\nPOSTORDEN\n");
        arbol.postOrden();
        System.out.println("\n\n");
        System.out.println("Tamaño: " + arbol.getTamaño());
        arbol.imprimirArbol();
    }
}
