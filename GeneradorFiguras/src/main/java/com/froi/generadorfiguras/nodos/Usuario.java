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
    
    public Usuario(String identificador) {
        this.listaImagenes = new ListaDoblementeEnlazada();
        this.identificador = identificador;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public ListaDoblementeEnlazada getListaImagenes() {
        return listaImagenes;
    }

    public void setListaImagenes(ListaDoblementeEnlazada listaImagenes) {
        this.listaImagenes = listaImagenes;
    }
    
}
