/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.generadorfiguras.nodos;

import com.froi.generadorfiguras.estructuras.ArbolAVL;
import com.froi.generadorfiguras.estructuras.ListaDoblementeEnlazada;

/**
 *
 * @author froi-pc
 */
public class NodoListaDobleC {
    private String identificador;
    private ListaDoblementeEnlazada listaCapas;
    private NodoListaDobleC siguiente;
    private NodoListaDobleC anterior;
    
    public NodoListaDobleC(String identificador) {
        this.identificador = identificador;
        this.siguiente = null;
        this.anterior = null;
        this.listaCapas = new ListaDoblementeEnlazada();
        
    }
    public NodoListaDobleC(String identificador, ListaDoblementeEnlazada listaCapas) {
        this.identificador = identificador;
        this.siguiente = null;
        this.anterior = null;
        this.listaCapas = listaCapas;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public ListaDoblementeEnlazada getListaCapas() {
        return listaCapas;
    }

    public void setListaCapas(ListaDoblementeEnlazada listaCapas) {
        this.listaCapas = listaCapas;
    }

    public NodoListaDobleC getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoListaDobleC siguiente) {
        this.siguiente = siguiente;
    }

    public NodoListaDobleC getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoListaDobleC anterior) {
        this.anterior = anterior;
    }
    
    public String dotCode(ArbolAVL arbolCapas) {
        String codigo = "";
        codigo += "digraph listaDoble {\n";
        codigo += "rankdir=TB\n";
        codigo += "node [shape = record]\n";
        codigo += listaCapas.getDotCodeArbol(identificador, arbolCapas);
        codigo += "}\n";
        return codigo;
    }
    
}
