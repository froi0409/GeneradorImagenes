/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.generadorfiguras.estructuras;

import com.froi.generadorfiguras.nodos.NodoUsuariosAVL;

/**
 *
 * @author froi-pc
 */
public class AVLUsuarios {
    private NodoUsuariosAVL raiz;
    private int tamaño;
    
    public AVLUsuarios() {
        this.raiz = null;
        this.tamaño = 0;
    }
    
    public NodoUsuariosAVL buscar(String idUsuario) {
        return null;
    }
    
    /**
     * Nos permite insertar un usuario en el árbol AVL
     * @param nodoInsertar Nodo a insertar
     */
    public void insertar(NodoUsuariosAVL nodoInsertar) {
        if(raiz == null) {
            raiz = nodoInsertar;
        } else {
            raiz = insertarNodo(nodoInsertar, raiz);
        }
    }
    
    /**
     * Metodo que nos permite realizar el procedimiento para insertar un nodo en el árbol de usuarios
     * @param nuevo
     * @param aux
     * @return 
     */
    private NodoUsuariosAVL insertarNodo(NodoUsuariosAVL nuevo, NodoUsuariosAVL aux) {
        NodoUsuariosAVL padre = aux;
        if(nuevo.getIdUsuario().compareTo(aux.getIdUsuario()) < 0) {
            
        } else if(nuevo.getIdUsuario().compareTo(aux.getIdUsuario()) > 0) {
            
        } else {
            //Los id de los usuarios son iguales y por lo tanto no pueden repetirse
        }
        return null; //<- Recordar reemplazar
    }
}
