/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.generadorfiguras.nodos;

/**
 *
 * @author froi-pc
 */
public class NodoListaDobleImg {
    private NodoListaDobleC nodoImagen;
    private NodoListaDobleImg anterior;
    private NodoListaDobleImg siguiente;
    
    public NodoListaDobleImg(NodoListaDobleC nodoImagen) {
        this.nodoImagen = nodoImagen;
        this.anterior = null;
        this.siguiente = null;
    }

    public NodoListaDobleC getNodoImagen() {
        return nodoImagen;
    }

    public void setNodoImagen(NodoListaDobleC nodoImagen) {
        this.nodoImagen = nodoImagen;
    }

    public NodoListaDobleImg getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoListaDobleImg anterior) {
        this.anterior = anterior;
    }

    public NodoListaDobleImg getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoListaDobleImg siguiente) {
        this.siguiente = siguiente;
    }
    
}
