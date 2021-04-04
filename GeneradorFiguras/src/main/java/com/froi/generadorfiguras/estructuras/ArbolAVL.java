/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.generadorfiguras.estructuras;

import com.froi.generadorfiguras.nodos.NodoAVL;

/**
 *
 * @author froi-pc
 */
public class ArbolAVL {
    private NodoAVL raiz;
    private int tamaño;
    
    public ArbolAVL() {
        this.raiz = null;
        this.tamaño = 0;
    }
    
    
    
    public void insertar(NodoAVL nodoInsertar) {
        if(raiz == null) {
            raiz = nodoInsertar;
        } else {
            raiz = insertarNodo(nodoInsertar, raiz);
        }
        tamaño++;
    }
    
    private NodoAVL insertarNodo(NodoAVL nuevo, NodoAVL aux) {
        NodoAVL padre = aux;
        if(nuevo.getIdentificador().compareTo(aux.getIdentificador()) < 0) {
            if(aux.getIzquierdo() == null) {
                aux.setIzquierdo(nuevo);
            } else {
                aux.setIzquierdo(insertarNodo(nuevo, aux.getIzquierdo()));
                //Se verifica si es necesario equilibrar el arbol
                if((factorEquilibrio(aux.getIzquierdo()) - factorEquilibrio(aux.getDerecha())) == 2) {
                    if(nuevo.getIdentificador().compareTo(aux.getIdentificador()) == -1) {
                        padre = rotacionIzquierda(aux);
                    } else {
                        padre = rotacionDerecha(aux);
                    }
                }
            }
        } else if (nuevo.getIdentificador().compareTo(aux.getIdentificador()) > 0) {
            if(aux.getDerecha() == null) {
                aux.setDerecha(nuevo);
            } else {
                aux.setDerecha(insertarNodo(nuevo, aux.getDerecha()));
                //Se verifica si es necesario equilibrar el arbol
                if(nuevo.getIdentificador().compareTo(aux.getDerecha().getIdentificador()) == 1) {
                    padre = rotacionIzquierda(aux);
                } else {
                    padre = rotacionDerecha(aux);
                }
            }
        } else {
            //Los identificadres son iguales y por lo tanto no se pueden añadir
            //(no se pueden añadir elementos con identificador repetido)
            return null;
        }
        if(aux.getIzquierdo() == null && aux.getDerecha() != null) {
            aux.setFactorEquilibrio(aux.getDerecha().getFactorEquilibrio() + 1);
        } else if(aux.getDerecha() == null && aux.getIzquierdo() != null) {
            aux.setFactorEquilibrio(aux.getIzquierdo().getFactorEquilibrio() + 1);
        } else {
            aux.setFactorEquilibrio(Math.max(factorEquilibrio(aux.getIzquierdo()), factorEquilibrio(aux.getDerecha())) + 1);
        }
        return padre;
    }
    
    public NodoAVL buscar(String parametro) {
        return buscar(parametro, raiz);
    }
    
    public NodoAVL buscar(String parametro, NodoAVL nodo) {
        if(raiz == null) {
            return null;
        } 
        if(parametro.compareTo(raiz.getIdentificador()) == 0) {
            return raiz;
        } 
        if(parametro.compareTo(raiz.getIdentificador()) > 0) {
            return buscar(parametro, raiz.getDerecha());
        }
        if(parametro.compareTo(raiz.getIdentificador()) < 0) {
            return buscar(parametro, raiz.getIzquierdo());
        }
        return null;
    }
    
    
    
    private NodoAVL rotacionIzquierda(NodoAVL nodo) {
        NodoAVL aux = nodo.getIzquierdo();
        nodo.setIzquierdo(aux.getDerecha());
        aux.setDerecha(nodo);
        nodo.setFactorEquilibrio(Math.max(factorEquilibrio(nodo.getIzquierdo()), factorEquilibrio(nodo.getDerecha())) + 1);
        aux.setFactorEquilibrio(Math.max(factorEquilibrio(aux.getIzquierdo()), factorEquilibrio(aux.getDerecha())) + 1);
        return aux;
    }
    
    private NodoAVL rotacionDerecha(NodoAVL nodo) {
        NodoAVL aux = nodo.getDerecha();
        nodo.setDerecha(aux.getIzquierdo());
        aux.setIzquierdo(nodo);
        nodo.setFactorEquilibrio(Math.max(factorEquilibrio(nodo.getIzquierdo()), factorEquilibrio(nodo.getDerecha())));
        aux.setFactorEquilibrio(Math.max(factorEquilibrio(aux.getIzquierdo()), factorEquilibrio(aux.getDerecha())));
        return aux;
    }
    
    private int factorEquilibrio(NodoAVL nodo) {
        if(nodo == null) {
            return -1;
        }
        return nodo.getFactorEquilibrio(); // <- Cambiar
    }
    
    private void inOrden() {
        
    }
    
    private void preOrden() {
        
    }
    
    private void postOrden() {
        
    }
    
}
