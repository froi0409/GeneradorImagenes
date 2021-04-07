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
public class NodoListaDoble {
    private int posicion;
    private NodoAVL nodoCapa;
    private NodoListaDoble anterior;
    private NodoListaDoble siguiente;
    
    public NodoListaDoble(NodoAVL nodoCapa){
        this.nodoCapa = nodoCapa;
        this.anterior = null;
        this.siguiente = null;
    }

    public NodoAVL getNodoCapa() {
        return nodoCapa;
    }

    public void setNodoCapa(NodoAVL nodoCapa) {
        this.nodoCapa = nodoCapa;
    }

    public NodoListaDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoListaDoble anterior) {
        this.anterior = anterior;
    }

    public NodoListaDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoListaDoble siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
