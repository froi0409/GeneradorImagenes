/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.generadorfiguras.manejadores;

import com.froi.generadorfiguras.estructuras.ArbolAVL;

/**
 *
 * @author froi-pc
 */
public class ManejadorPrincipal {
    private ArbolAVL arbolCapas;
    
    public ManejadorPrincipal() {
        this.arbolCapas = new ArbolAVL();
    }

    public ArbolAVL getArbolCapas() {
        return arbolCapas;
    }

    public void setArbolCapas(ArbolAVL arbolCapas) {
        this.arbolCapas = arbolCapas;
    }
    
}
