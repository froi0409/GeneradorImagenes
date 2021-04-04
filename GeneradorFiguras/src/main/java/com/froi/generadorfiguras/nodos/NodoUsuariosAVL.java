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
public class NodoUsuariosAVL {
    private String idUsuario;
    private int clave;
    private NodoUsuariosAVL izquierdo;
    private NodoUsuariosAVL derecha;
    private int altura;
    
    public NodoUsuariosAVL(String idUsuario) {
        this.idUsuario = idUsuario;
        this.izquierdo = null;
        this.derecha = null;
    }
    
    public String getIdUsuario() {
        return idUsuario;
    }
    
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public NodoUsuariosAVL getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoUsuariosAVL izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoUsuariosAVL getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoUsuariosAVL derecha) {
        this.derecha = derecha;
    }
    
    @Override
    public String toString() {
        return idUsuario;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }
    
}
