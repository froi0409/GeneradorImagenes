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
        tamaño++;
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
    
    /**
     * Permite buscar un nodo por posicion
     * @param posicion posicion en la que se encuentra el nodo
     * @return NodoAVL que se encuentra en la posicion solicitada
     */
    public NodoAVL buscar(int posicion) {
        if(posicion > tamaño) {
            throw new IndexOutOfBoundsException("Posición solicitada fuera de limites");
        }
        int cont = 0;
        NodoListaDoble aux = primero;
        while(aux != null) {
            if(cont == posicion) {
                return aux.getNodoCapa();
            }
            cont++;
            aux = aux.getSiguiente();
        }
        return null;
    }
    
    public void imprimirLista() {
        if(primero != null) {
            NodoListaDoble aux = primero;
            while(aux != null) {
                System.out.println("nodo: " + aux.getNodoCapa().getIdentificador());
                aux = aux.getSiguiente();
            }
        }
    }

    public int getTamaño() {
        return tamaño;
    }
    
    public String getDotCode(String padre) {
        String codigo = "";
        NodoListaDoble aux = primero;
        while(aux != null) {
            codigo += "capa" + padre + "o" + aux.getNodoCapa().getIdentificador() + " [ label =\"capa: " + aux.getNodoCapa().getIdentificador() + "\"];\n";
            aux = aux.getSiguiente();
        }
        aux = primero;
        while(aux != null) {
            if(aux == primero) {
                codigo += "nodo" + padre + "->capa" + padre + "o" + aux.getNodoCapa().getIdentificador();
            } else {
                codigo += "->capa" + padre + "o" + aux.getNodoCapa().getIdentificador();
            }
            aux = aux.getSiguiente();
        }
        codigo += "\n";
        return codigo;
    }
    
}
