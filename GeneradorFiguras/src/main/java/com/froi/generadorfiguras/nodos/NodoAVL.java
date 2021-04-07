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
public class NodoAVL {
    private String identificador;
    private Object contenido;
    private NodoAVL izquierdo;
    private NodoAVL derecha;
    private int factorEquilibrio;
    
    public NodoAVL(String identificador) {
        this.identificador = identificador;
        this.izquierdo = null;
        this.derecha = null;
    }
    public NodoAVL(String identificador, Object contenido) {
        this.identificador = identificador;
        this.contenido = contenido;
        this.izquierdo = null;
        this.derecha = null;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public NodoAVL getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoAVL izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoAVL getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoAVL derecha) {
        this.derecha = derecha;
    }

    public int getFactorEquilibrio() {
        return factorEquilibrio;
    }

    public void setFactorEquilibrio(int factorEquilibrio) {
        this.factorEquilibrio = factorEquilibrio;
    }

    public Object getContenido() {
        return contenido;
    }
    
}
