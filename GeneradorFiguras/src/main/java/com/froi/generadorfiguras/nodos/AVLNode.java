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
public class AVLNode {
    private String identificador;
    private int altura;
    private AVLNode izquierdo;
    private AVLNode derecho;
    
    public AVLNode(String identificador) {
        this.identificador = identificador;
        this.altura = 0;
        this.izquierdo = null;
        this.derecho = null;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public AVLNode getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(AVLNode izquierdo) {
        this.izquierdo = izquierdo;
    }

    public AVLNode getDerecho() {
        return derecho;
    }

    public void setDerecho(AVLNode derecho) {
        this.derecho = derecho;
    }
    
    
    
}
