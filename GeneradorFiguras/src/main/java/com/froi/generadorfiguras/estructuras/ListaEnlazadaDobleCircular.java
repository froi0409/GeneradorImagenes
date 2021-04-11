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
    
    public void insertar(String identificador, ListaDoblementeEnlazada listaCapas) {
        NodoListaDobleC nuevo = new NodoListaDobleC(identificador, listaCapas);
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
                if(aux.getIdentificador().equals(identificador)) {
                    throw new RuntimeException("NodoDuplicado");
                }
                if((identificador.compareTo(aux.getIdentificador()) > 0 && identificador.compareTo(aux.getSiguiente().getIdentificador()) < 0) || (aux == ultimo)) {
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
    
    /**
     * Metodo que nos permite obtener un nodo perteneciente a la lista
     * 
     * @param identificador Identificador del objeto a encontrar
     * @return Nodo que contiene el objeto a identificar
     */
    public NodoListaDobleC buscar(String identificador) {
        if(primero != null) {
            NodoListaDobleC aux = primero;
            do {
                if(aux.getIdentificador().equals(identificador)) {
                    return aux;
                }
                aux = aux.getSiguiente();
            } while(aux != primero);
        }
        return null;
    }
    
    public NodoListaDobleC buscar(int posicion) {
        int cont = 0;
        if(posicion > tamaño) {
            throw new IndexOutOfBoundsException("Posicion solicitadaa fuera de limites");
        }
        int conta = 0;
        NodoListaDobleC aux = primero;
        do {
            if(conta == posicion) {
                System.out.println("Nodo encontrado: " + aux.getIdentificador());
                return aux;
            }
            cont++;
            aux = aux.getSiguiente();
        } while(aux != primero);
        return null;
    }
    
    /**
     * Genera el código .dot para generar la gráfica de la estructura
     * @return Código .dot que permitirá la creación de una imagen
     */
    public String dotCode() {
        String codigo = "";
        codigo += "digraph listaDoble {\n";
        codigo += "node [shape = box]\n";
        codigo += "edge [dir = both]\n";
        codigo += "e0[ shape = point, width = 0 ];\n";
        codigo += "e1[ shape = point, width = 0 ];\n";
        codigo += getCodigoNodos();
        codigo += "}\n";
        return codigo;
    }
    
    /**
     * Permite obtener el codigo que declara y enlaza los nodos. Todo para graphviz
     * @return Código .dot que contiene la definición y conexión de nodos
     */
    public String getCodigoNodos() {
        String codigo = "";
        if(primero != null) {
            NodoListaDobleC aux = primero;
            int cont = 1;
            
            do {
                codigo += "subgraph cluster_" + cont + " {\n";
                codigo += "nodo" + aux.getIdentificador() + " [ label =\"id: " + aux.getIdentificador() + "\"];\n";
                codigo += aux.getListaCapas().getDotCode(aux.getIdentificador());
                codigo += "}\n";
                cont++;
                aux = aux.getSiguiente();
            } while (aux != primero);
            
            
            
            aux = primero;
            codigo += "rank = same { ";
            do {
                if(aux == primero) {
                    codigo += "nodo" + aux.getIdentificador() ;
                } else {
                    codigo += "->nodo" + aux.getIdentificador();
                }
                if(aux.getSiguiente() == primero) {
                    codigo += "->nodo" + aux.getSiguiente().getIdentificador();
                }
                
                aux = aux.getSiguiente();
            } while (aux != primero);
            codigo += " };\n";
        }
        return codigo;
    }
    
    public int getTamaño() {
        return tamaño;
    }
    
}