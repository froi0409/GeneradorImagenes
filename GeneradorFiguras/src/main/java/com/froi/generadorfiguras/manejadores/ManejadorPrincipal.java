/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.generadorfiguras.manejadores;

import com.froi.generadorfiguras.estructuras.ArbolAVL;
import com.froi.generadorfiguras.estructuras.ListaEnlazadaDobleCircular;

/**
 *
 * @author froi-pc
 */
public class ManejadorPrincipal {
    private ArbolAVL arbolCapas;
    private ListaEnlazadaDobleCircular listaImagenes;
    private ArbolAVL arbolUsuarios;
    
    public ManejadorPrincipal() {
        this.arbolCapas = new ArbolAVL();
        this.listaImagenes = new ListaEnlazadaDobleCircular();
        this.arbolUsuarios = new ArbolAVL();
    }

    public ArbolAVL getArbolCapas() {
        return arbolCapas;
    }

    public void setArbolCapas(ArbolAVL arbolCapas) {
        this.arbolCapas = arbolCapas;
    }

    public ListaEnlazadaDobleCircular getListaImagenes() {
        return listaImagenes;
    }

    public void setListaImagenes(ListaEnlazadaDobleCircular listaImagenes) {
        this.listaImagenes = listaImagenes;
    }

    public ArbolAVL getArbolUsuarios() {
        return arbolUsuarios;
    }

    public void setArbolUsuarios(ArbolAVL arbolUsuarios) {
        this.arbolUsuarios = arbolUsuarios;
    }
    
    
}