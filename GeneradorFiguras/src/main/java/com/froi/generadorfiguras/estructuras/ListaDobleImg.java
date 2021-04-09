/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.generadorfiguras.estructuras;

import com.froi.generadorfiguras.nodos.NodoListaDobleC;
import com.froi.generadorfiguras.nodos.NodoListaDobleImg;

/**
 *
 * @author froi-pc
 */
public class ListaDobleImg {
    private NodoListaDobleImg primero;
    private int tamaño;
    
    public ListaDobleImg() {
        this.primero = null;
        this.tamaño = 0;
    }
    
    public void insertar(NodoListaDobleC nodoImagen) {
        try {
            NodoListaDobleImg nuevo = new NodoListaDobleImg(nodoImagen);
            if(primero == null) {
                primero = nuevo;
            } else { 
                NodoListaDobleImg aux = primero;
                System.out.println("El primero de la lista es: " + primero.getNodoImagen().getIdentificador());
                while(aux.getSiguiente() != null) {
                    System.out.println("pudo entrar a la condicion");
                    aux = aux.getSiguiente();
                }
                aux.setSiguiente(nuevo);
                nuevo.setAnterior(aux);
            }
            tamaño++;
        } catch (Exception e) {
            System.out.println("Error al insertar nodoImagen: " + e.getMessage());
        }
    }
    
    public NodoListaDobleC buscar(String identificador) {
        if(primero != null) {
            NodoListaDobleImg aux = primero;
            while(aux != null) {
                if(aux.getNodoImagen().getIdentificador().equals(identificador)) {
                    return aux.getNodoImagen();
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }
    
    public void imprimirLista() {
        if(primero != null) {
            NodoListaDobleImg aux = primero;
            while(aux != null) {
                System.out.println("nodo: " + aux.getNodoImagen().getIdentificador());
                aux = aux.getSiguiente();
            }
        }
    }
}
