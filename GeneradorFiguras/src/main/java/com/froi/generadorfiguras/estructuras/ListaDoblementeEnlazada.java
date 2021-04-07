/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.generadorfiguras.estructuras;

import com.froi.generadorfiguras.nodos.NodoAVL;
import com.froi.generadorfiguras.nodos.NodoListaDoble;

/**
 *
 * @author froi-pc
 */
public class ListaDoblementeEnlazada {
    private NodoListaDoble primero;
    private int tamaño;
    
    public ListaDoblementeEnlazada() {
        this.primero = null;
        this.tamaño = 0;
    }
    
    public void insertar(NodoAVL nodoCapa) {
        NodoListaDoble nuevo = new NodoListaDoble(nodoCapa);
        if(primero == null) {
            primero = nuevo;
        } else {
            NodoListaDoble aux = primero;
            while(aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
            nuevo.setAnterior(aux);
            
        }
    }
    
    /**
     * Permite buscar el nodo que contenga alguna capa
     * @param identificador Identificador de la capa
     * @return Nodo de capa
     */
    public NodoAVL buscar(String identificador) {
        if(primero != null) {
            NodoListaDoble aux = primero;
            while(aux != null) {
                if(aux.getNodoCapa().getIdentificador().equals(identificador)) {
                    return aux.getNodoCapa();
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }
    
}
