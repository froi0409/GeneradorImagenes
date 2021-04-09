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
        if(parametro.compareTo(nodo.getIdentificador()) == 0) {
            return nodo;
        } 
        if(parametro.compareTo(nodo.getIdentificador()) > 0) {
            return buscar(parametro, nodo.getDerecha());
        }
        if(parametro.compareTo(nodo.getIdentificador()) < 0) {
            return buscar(parametro, nodo.getIzquierdo());
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
    
}
