/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.generadorfiguras.nodos;

import com.froi.generadorfiguras.estructuras.ListaDoblementeEnlazada;

/**
 *
 * @author froi-pc
 */
public class Usuario {
    private String identificador;
    private ListaDoblementeEnlazada listaImagenes;
    
    public Usuario() {
        this.listaImagenes = new ListaDoblementeEnlazada();
    }
}
