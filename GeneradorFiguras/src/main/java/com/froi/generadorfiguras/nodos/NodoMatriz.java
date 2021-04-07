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
public class NodoMatriz {
    private NodoMatriz anteriorColumna;
    private NodoMatriz anteriorFila;
    private NodoMatriz siguienteColumna;
    private NodoMatriz siguienteFila;
    private String info;
    private int x;
    private int y;
    
    public NodoMatriz(int x, int y, String info) {
        this.x = x;
        this.y = y;
        this.info = info;
        this.anteriorColumna = null;
        this.anteriorFila = null;
        this.siguienteColumna = null;
        this.siguienteFila = null;
    }

    public NodoMatriz getAnteriorColumna() {
        return anteriorColumna;
    }

    public void setAnteriorColumna(NodoMatriz anteriorColumna) {
        this.anteriorColumna = anteriorColumna;
    }

    public NodoMatriz getAnteriorFila() {
        return anteriorFila;
    }

    public void setAnteriorFila(NodoMatriz anteriorFila) {
        this.anteriorFila = anteriorFila;
    }

    public NodoMatriz getSiguienteColumna() {
        return siguienteColumna;
    }

    public void setSiguienteColumna(NodoMatriz siguienteColumna) {
        this.siguienteColumna = siguienteColumna;
    }

    public NodoMatriz getSiguienteFila() {
        return siguienteFila;
    }

    public void setSiguienteFila(NodoMatriz siguienteFila) {
        this.siguienteFila = siguienteFila;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
}
