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
    
    public void eliminar(String identificador) {
        if(raiz == null) {
            throw new RuntimeException("No se pueden eliminar nodos de un arbol vacío");
        } else {
            System.out.println("Raiz Before: " + raiz.getIdentificador());
            raiz = eliminar(identificador, raiz);
            System.out.println("Raiz After: " + raiz.getIdentificador());
            tamaño--;
        }
    }
    
    private NodoAVL eliminar(String identificador, NodoAVL aux) {
        NodoAVL padre = aux;
        System.out.println("Nodo Eliminar: " + aux.getIdentificador());
        if(aux.getIdentificador().compareTo(identificador) == 0) {
            if(aux.getDerecha() == null && aux.getIzquierdo() == null) {
                padre = null;
            } else if(aux.getDerecha() != null && aux.getIzquierdo() == null) {
                padre = aux.getDerecha();
            } else if(aux.getIzquierdo() != null && aux.getDerecha() == null) {
                padre = aux.getIzquierdo();
            } else {
                NodoAVL nodoRecuperado = getDerechoAbsoluto(aux, aux.getIzquierdo());
                nodoRecuperado.setDerecha(aux.getDerecha());
                nodoRecuperado.setIzquierdo(aux.getIzquierdo());
                padre = nodoRecuperado;
            }
        } else {
            if(aux.getIdentificador().compareTo(identificador) > 0) {
                aux.setIzquierdo(eliminar(identificador, aux.getIzquierdo()));
            } else {
                aux.setDerecha(eliminar(identificador, aux.getDerecha()));
            }
        }
        if((factorEquilibrio(aux.getIzquierdo()) - factorEquilibrio(aux.getDerecha())) == 2) {
            if(factorEquilibrio(aux.getIzquierdo().getIzquierdo()) - factorEquilibrio(aux.getIzquierdo().getDerecha()) == -1) {
                padre = rotacionDobleIzquierda(aux);
            } else if(identificador.compareTo(aux.getIdentificador()) > 0) {
                padre = rotacionIzquierda(aux);
            } else {
                padre = rotacionDerecha(aux);
            }
        }
        if((factorEquilibrio(aux.getIzquierdo()) - factorEquilibrio(aux.getDerecha())) == -2) {
            if(factorEquilibrio(aux.getDerecha().getIzquierdo()) - factorEquilibrio(aux.getDerecha().getDerecha()) == 1) {
                padre = rotacionDobleDerecha(aux);
            } else if(identificador.compareTo(aux.getDerecha().getIdentificador()) > 0) {
                padre = rotacionIzquierda(aux);
            } else {
                padre = rotacionDerecha(aux);
            }                    
        }
        equilibrar(padre);
        return padre;
    }
    
    private NodoAVL getDerechoAbsoluto(NodoAVL nodoPadre, NodoAVL nodo) {
        if(nodo.getDerecha() == null) {
            NodoAVL aux = nodo;
            if(nodo.getIzquierdo() != null) {
                nodoPadre.setDerecha(nodo.getIzquierdo());
            }
            nodoPadre.setDerecha(null);
            return aux;
            
        } else {
            return getDerechoAbsoluto(nodo, nodo.getDerecha());
        }
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
                    if(factorEquilibrio(aux.getIzquierdo().getIzquierdo()) - factorEquilibrio(aux.getIzquierdo().getDerecha()) == -1) {
                        padre = rotacionDobleIzquierda(aux);
                    } else if(nuevo.getIdentificador().compareTo(aux.getIdentificador()) < 0) {
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
                if((factorEquilibrio(aux.getIzquierdo()) - factorEquilibrio(aux.getDerecha())) == -2) {
                    if(factorEquilibrio(aux.getDerecha().getIzquierdo()) - factorEquilibrio(aux.getDerecha().getDerecha()) == 1) {
                        padre = rotacionDobleDerecha(aux);
                    } else if(nuevo.getIdentificador().compareTo(aux.getDerecha().getIdentificador()) < 0) {
                        padre = rotacionIzquierda(aux);
                    } else {
                        padre = rotacionDerecha(aux);
                    }                    
                }
            }
        } else {
            //Los identificadres son iguales y por lo tanto no se pueden añadir
            //(no se pueden añadir elementos con identificador repetido)
            
            throw new RuntimeException("Nodo Repetido");
        }
        equilibrar(aux);
        return padre;
    }
    
    public void equilibrar(NodoAVL aux) {
        if(aux.getIzquierdo() == null && aux.getDerecha() != null) {
            aux.setFactorEquilibrio(aux.getDerecha().getFactorEquilibrio() + 1);
        } else if(aux.getDerecha() == null && aux.getIzquierdo() != null) {
            aux.setFactorEquilibrio(aux.getIzquierdo().getFactorEquilibrio() + 1);
        } else {
            aux.setFactorEquilibrio(Math.max(factorEquilibrio(aux.getIzquierdo()), factorEquilibrio(aux.getDerecha())) + 1);
        }
        System.out.println("Factor equilibrio para " + aux.getIdentificador() + ": " + aux.getFactorEquilibrio());
    }
    
    public NodoAVL buscar(String parametro) {
        return buscar(parametro, raiz);
    }
    
    public NodoAVL buscar(String parametro, NodoAVL nodo) {
        if(raiz == null) {
            return null;
        } 
        try {
            if(parametro.compareTo(nodo.getIdentificador()) == 0) {
                return nodo;
            } 
            if(parametro.compareTo(nodo.getIdentificador()) > 0) {
                return buscar(parametro, nodo.getDerecha());
            }
            if(parametro.compareTo(nodo.getIdentificador()) < 0) {
                return buscar(parametro, nodo.getIzquierdo());
            }
        } catch (Exception e) {
            return null;
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
    
    private NodoAVL rotacionDobleIzquierda(NodoAVL nodo) {
        NodoAVL aux;
        nodo.setIzquierdo(rotacionDerecha(nodo.getIzquierdo()));
        aux = rotacionIzquierda(nodo);
        return aux;
    }
    
    private NodoAVL rotacionDobleDerecha(NodoAVL nodo) {
        NodoAVL aux;
        nodo.setDerecha(rotacionIzquierda(nodo.getDerecha()));
        aux = rotacionDerecha(nodo);
        return aux;
    }
    
    private int factorEquilibrio(NodoAVL nodo) {
        if(nodo == null) {
            return -1;
        }
        return nodo.getFactorEquilibrio(); // <- Cambiar
    }
    
    private void inOrden(NodoAVL nodo) {
        if(nodo == null) return;
        inOrden(nodo.getIzquierdo());
        System.out.println("Nodo: " + nodo.getIdentificador());
        inOrden(nodo.getDerecha());
    }
    
    public void inoden() {
        inOrden(raiz);
    }
    
    private void preOrden(NodoAVL nodo) {
        if(nodo == null) return;
        System.out.println("Nodo: " + nodo.getIdentificador());
        preOrden(nodo.getIzquierdo());
        preOrden(nodo.getDerecha());
    }
    
    public void preOrden() {
        preOrden(raiz);
    }
    
    private void postOrden(NodoAVL nodo) {
        if(nodo == null) return;
        postOrden(nodo.getIzquierdo());
        postOrden(nodo.getDerecha());
        System.out.println("Nodo: " + nodo.getIdentificador());
    }
    
    public void postOrden() {
        postOrden(raiz);
    }
    
    public void imprimirArbol() {
        imprimirArbol(raiz);
    }
    
    public void imprimirArbol(NodoAVL nodo) {
        if(nodo == null) return;
        System.out.println("NODO: " + nodo.getIdentificador());
        if(nodo.getIzquierdo() != null) {
            System.out.println("Izquierdo: " + nodo.getIzquierdo().getIdentificador());
        } 
        if(nodo.getDerecha() != null) {
            System.out.println("Derecha: " + nodo.getDerecha().getIdentificador());
        }
        System.out.println("\n\n");
        imprimirArbol(nodo.getDerecha());
        imprimirArbol(nodo.getIzquierdo());
    }

    public int getTamaño() {
        return tamaño;
    }
    
    /**
     * Permite obtener el codigo .dot que sirve para generar una grafica de graphviz
     * @return codigo dot
     */
    public String dotCode() {
        String dotCode = "";
        dotCode += "digraph arbol {\n";
        dotCode += "rankdir=TB\n";
        dotCode += "node [shape = record]\n";
        dotCode += getCodigoNodos(raiz);
        dotCode += "}\n";
        return dotCode;
    }
    
    /**
     * Metodo que nos sirve para hallar las conexiones que cada nodo debe tener
     * @param nodo Nodo a evaluar
     * @return DotCode con las declaraciones de nodos y conexiones necesarias
     */
    public String getCodigoNodos(NodoAVL nodo) {
        String codigoNodos = "";
        if(raiz != null) {
            if(nodo.getIzquierdo() == null && nodo.getDerecha() == null) {
                codigoNodos += "nodo" + nodo.getIdentificador() + " [ label =\"" + nodo.getIdentificador() + "\"];\n";
            } else {
                codigoNodos += "nodo" + nodo.getIdentificador() + " [ label =\"<C0>|" + nodo.getIdentificador() +"|<C1>\"];\n";
            }
            if(nodo.getIzquierdo() != null) {
                codigoNodos += getCodigoNodos(nodo.getIzquierdo()) + "nodo" + nodo.getIdentificador() +":C0->nodo" + nodo.getIzquierdo().getIdentificador() + "\n";
            }
            if(nodo.getDerecha() != null) {
                codigoNodos += getCodigoNodos(nodo.getDerecha()) + "nodo" + nodo.getIdentificador() +":C1->nodo" + nodo.getDerecha().getIdentificador() + "\n";
            }
        }
        return codigoNodos;
    }
    
    /**
     * Permite llenar una lista doblemente enlazada en base a un orden establecido
     * @param lista Lista doblemente enlazada, la cual será llenada
     * @param orden Orden en el que se llenara la lita
     * @param limite Cantidad de datos que deberían llenar la lista
     */
    public void llenarListaDoble(ListaDoblementeEnlazada lista, String orden, int limite) {
        if(orden.equals("INORDEN")) {
            llenarInorden(raiz, lista, 0, limite);
        } else if(orden.equals("PREORDEN")) {
            llenarPreorden(raiz, lista, 0, limite);
        } else if(orden.equals("POSTORDEN")) {
            llenarPostorden(raiz, lista, 0, limite);
        }
    }
    
    private void llenarInorden(NodoAVL nodo, ListaDoblementeEnlazada lista, int actual, int limite) {
        if(nodo == null || actual == limite) return;
        llenarInorden(nodo.getIzquierdo(), lista, actual, limite);
        lista.insertar(nodo);
        actual = actual + 1;
        if(actual == limite) return;
        llenarInorden(nodo.getDerecha(), lista, actual, limite);
    }
    
    private void llenarPreorden(NodoAVL nodo, ListaDoblementeEnlazada lista, int actual, int limite) {
        if(nodo == null || actual == limite) return;
        lista.insertar(nodo);
        actual = actual + 1;
        llenarPreorden(nodo.getIzquierdo(), lista, actual, limite);
        if(actual == limite) return;
        llenarPreorden(nodo.getDerecha(), lista, actual, limite);
    }
    
    private void llenarPostorden(NodoAVL nodo, ListaDoblementeEnlazada lista, int actual, int limite) {
        if(nodo == null || actual == limite) return;
        
        llenarPostorden(nodo.getIzquierdo(), lista, actual, limite);
        if(actual == limite) return;
        llenarPostorden(nodo.getDerecha(), lista, actual, limite);
        lista.insertar(nodo);
        actual = actual + 1;
    }
    
    public void llenarListaDobleList(ListaDoblementeEnlazada listaDoble) {
        if(raiz != null) {
            llenarListaDobleList(listaDoble, raiz);
        }
    }
    
    public void llenarListaDobleList(ListaDoblementeEnlazada listaDoble, NodoAVL nodo) {
        if(nodo == null) return;
        llenarListaDobleList(listaDoble, nodo.getIzquierdo());
        listaDoble.insertar(nodo);
        llenarListaDobleList(listaDoble, nodo.getDerecha());
    }
    
    public NodoAVL getRaiz() {
        return raiz;
    }
    
}
