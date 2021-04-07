/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.generadorfiguras.estructuras;

import com.froi.generadorfiguras.nodos.NodoListaDobleC;

/**
 *
 * @author froi-pc
 */
public class ListaEnlazadaDobleCircular {
    private NodoListaDobleC primero;
    private NodoListaDobleC ultimo;
    private int tamaño;
    
    public ListaEnlazadaDobleCircular() {
        this.primero = null;
        this.ultimo = null;
        this.tamaño = 0;
    }
    
    public void insertar(String identificador) {
        NodoListaDobleC nuevo = new NodoListaDobleC(identificador);
        if(primero == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else if(tamaño == 1) {
            if(identificador.compareTo(primero.getIdentificador()) > 0) { //La cadena nueva es mayos
                ultimo = nuevo;
                primero.setSiguiente(ultimo);
                primero.setAnterior(ultimo);
                ultimo.setSiguiente(primero);
                ultimo.setAnterior(primero);
            } else if(identificador.compareTo(primero.getIdentificador()) < 0) {
                primero = nuevo;
                primero.setSiguiente(ultimo);
                primero.setAnterior(ultimo);
                ultimo.setSiguiente(primero);
                ultimo.setAnterior(primero);
            } else {
                throw new RuntimeException("NodoYaExistente");
            }
        } else {
            NodoListaDobleC aux = primero;
            while(true) {
                if((identificador.compareTo(aux.getIdentificador()) > 0 && identificador.compareTo(aux.getSiguiente().getIdentificador()) < 0) || (aux == ultimo)) {
                    System.out.println("entró a la condición");
                    if(aux == primero) {
                        primero.setAnterior(nuevo);
                        nuevo.setSiguiente(primero);
                        nuevo.setAnterior(ultimo);
                        ultimo.setSiguiente(nuevo);
                        primero = nuevo;
                        break;
                    } else if(aux == ultimo) {
                        ultimo.setSiguiente(nuevo);
                        nuevo.setAnterior(ultimo);
                        nuevo.setSiguiente(primero);
                        primero.setAnterior(nuevo);
                        ultimo = nuevo;
                        break;
                    } else {
                        nuevo.setSiguiente(aux.getSiguiente());
                        nuevo.setAnterior(aux);
                        aux.getSiguiente().setAnterior(nuevo);
                        aux.setSiguiente(nuevo);
                        break;
                    }
                }
                aux = aux.getSiguiente();
                System.out.println(aux.getSiguiente().getIdentificador());
            }
        }
        tamaño++;
    }
    
    public void imprimir() {
        if(primero != null) {
            NodoListaDobleC aux = primero;
            do {
                System.out.println("Nodo: " + aux.getIdentificador());
                aux = aux.getSiguiente();
            }while(aux != primero);
        }
    }
}