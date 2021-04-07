/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.generadorfiguras.estructuras;

import com.froi.generadorfiguras.nodos.AVLNode;
import com.froi.generadorfiguras.nodos.NodoAVL;

/**
 *
 * @author froi-pc
 */
public class AVLTree {
    private AVLNode raiz;
    
    public AVLTree() {
        this.raiz = null;
    }
    
    public void actualizarAltura(AVLNode nodo) {
        nodo.setAltura(1 + Math.max(altura(nodo.getIzquierdo()), altura(nodo.getDerecho())));
    }

    private int altura(AVLNode nodo) {
        return nodo == null ? -1 : nodo.getAltura();
    }

    int factorEquilibrio(AVLNode nodo) {
        if(nodo == null) {
            return 0;
        }
        return altura(nodo.getDerecho()) - altura(nodo.getIzquierdo());
    }
    
    private AVLNode rotacionDerecha(AVLNode nodo) {
        AVLNode auxI = nodo.getIzquierdo();
        AVLNode auxD = auxI.getDerecho();
        auxI.setDerecho(nodo);
        nodo.setIzquierdo(auxD);
        actualizarAltura(nodo);
        actualizarAltura(auxI);
        return auxI;
    }
    
    private AVLNode rotacionIzquierda(AVLNode nodo) {
        AVLNode auxD = nodo.getDerecho();
        AVLNode auxI = auxD.getIzquierdo();
        auxD.setIzquierdo(nodo); 
        nodo.setDerecho(auxI);
        actualizarAltura(nodo);
        actualizarAltura(auxD);
        return auxD;
    }
   
    /**
     * Método de balanceo de nodos, se espera que sirva para inserción o eliminación de nodos
     * @param nodo Nodo en actividad
     * @return 
     */
    private AVLNode rebalanceo(AVLNode nodo) {
        actualizarAltura(nodo);
        int balance = factorEquilibrio(nodo);
        if(balance > 1) {
            if(altura(nodo.getDerecho().getDerecho()) > altura(nodo.getDerecho().getIzquierdo())) {
                nodo = rotacionIzquierda(nodo);
            } else {
                nodo.setDerecho(rotacionDerecha(nodo));
                nodo = rotacionIzquierda(nodo);
            } 
        } else if(balance < -1){
            if(altura(nodo.getIzquierdo().getIzquierdo()) > altura(nodo.getIzquierdo().getDerecho())) {
                nodo = rotacionDerecha(nodo);
            } else {
                nodo.setIzquierdo(rotacionIzquierda(nodo.getIzquierdo()));
                nodo = rotacionDerecha(nodo);
            }
        }
        return nodo;
    }
    
    public AVLNode insertar(AVLNode nodo, String identificador) {
        System.out.println("comparando " + identificador + " con " + nodo.getIdentificador() + " = " + nodo.getIdentificador().compareTo(identificador));
        if(nodo == null) {
            return new AVLNode(identificador);
        } else if(nodo.getIdentificador().compareTo(identificador) < 0) {
            System.out.println("hola");
            nodo.setIzquierdo(insertar(nodo.getIzquierdo(), identificador));
        } else if(nodo.getIdentificador().compareTo(identificador) > 0) {
            System.out.println("adios");
            nodo.setDerecho(insertar(nodo, identificador));
        } else {
            throw new RuntimeException("Parametro Duplicado");
        }
        return rebalanceo(nodo);
    }
    
    public void insertar(String identificador) {
        if(raiz == null) {
            raiz = new AVLNode(identificador);
        } else {
            raiz = insertar(raiz, identificador);
        }
    }
    
    private void inOrden(AVLNode nodo) {
        if(nodo == null) return;
        inOrden(nodo.getIzquierdo());
        System.out.println("Nodo: " + nodo.getIdentificador());
        inOrden(nodo.getDerecho());
    }
    
    public void inoden() {
        inOrden(raiz);
    }
    
    private void preOrden(AVLNode nodo) {
        if(nodo == null) return;
        System.out.println("Nodo: " + nodo.getIdentificador());
        preOrden(nodo.getIzquierdo());
        preOrden(nodo.getDerecho());
    }
    
    public void preOrden() {
        preOrden(raiz);
    }
    
    private void postOrden(AVLNode nodo) {
        if(nodo == null) return;
        postOrden(nodo.getIzquierdo());
        postOrden(nodo.getDerecho());
        System.out.println("Nodo: " + nodo.getIdentificador());
    }
    
    public void postOrden() {
        postOrden(raiz);
    }
    
}
