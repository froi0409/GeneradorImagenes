/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.generadorfiguras.estructuras;

import com.froi.generadorfiguras.nodos.NodoMatriz;

/**
 *
 * @author froi-pc
 */
public class MatrizDispersa {
    private int totalNodos;
    private int totalFilas;
    private int totalColumnas;
    private NodoMatriz inicio;

    public MatrizDispersa() {
        inicio = new NodoMatriz(0,0,"nodoI");
        this.totalNodos = 0;
        this.totalFilas = 0;
        this.totalColumnas = 0;
    }
    
    public NodoMatriz insertarFila(int fila) {
        NodoMatriz cabeza = inicio.getSiguienteFila();
        String filaString = "";
        filaString += fila;
        NodoMatriz nuevo = new NodoMatriz(0,fila,filaString);
        if(cabeza == null) {
            inicio.setSiguienteFila(nuevo);
            nuevo.setAnteriorFila(inicio);
        } else {
            if(cabeza.getY() > fila) {
                nuevo.setSiguienteFila(cabeza);
                cabeza.setAnteriorFila(nuevo);
                inicio.setSiguienteFila(nuevo);
                nuevo.setAnteriorFila(inicio);
            } else {
                NodoMatriz aux = cabeza;
                while(aux.getSiguienteFila() != null) {
                    if(aux.getSiguienteFila().getY() > fila && aux.getY() < fila) {
                        nuevo.setSiguienteFila(aux.getSiguienteFila());
                        aux.getSiguienteFila().setAnteriorFila(nuevo);
                        nuevo.setAnteriorFila(aux);
                        aux.setSiguienteFila(nuevo);
                        totalFilas++;
                        return nuevo;
                    }
                    aux = aux.getSiguienteFila();
                }
                aux.setSiguienteFila(nuevo);
                nuevo.setAnteriorFila(aux);
            }
        }
        if(fila > totalFilas) {
            totalFilas = fila;
        }
        return nuevo;
    }
    
    public NodoMatriz insertarColumna(int columna) {
        NodoMatriz cabeza = inicio.getSiguienteColumna();
        String columnaString = "";
        columnaString += columna;
        NodoMatriz nuevo = new NodoMatriz(columna, 0, columnaString);
        if(cabeza == null) {
            inicio.setSiguienteColumna(nuevo);
            nuevo.setAnteriorColumna(inicio);
        } else {
            if(cabeza.getX() > columna) {
                nuevo.setSiguienteColumna(cabeza);
                cabeza.setAnteriorColumna(nuevo);
                inicio.setSiguienteColumna(nuevo);
                nuevo.setAnteriorColumna(inicio);
            } else {
                NodoMatriz aux = cabeza;
                while(aux.getSiguienteColumna() != null) {
                    if(aux.getSiguienteColumna().getX() > columna && aux.getX() < columna) {
                        nuevo.setSiguienteColumna(aux.getSiguienteColumna());
                        aux.getSiguienteColumna().setAnteriorColumna(nuevo);
                        nuevo.setAnteriorColumna(aux);
                        aux.setSiguienteColumna(nuevo);
                        totalColumnas++;
                        return nuevo;
                    }
                    aux = aux.getSiguienteColumna();
                }
                aux.setSiguienteColumna(nuevo);
                nuevo.setAnteriorColumna(aux);
            }
        }
        if(columna > totalColumnas) {
            totalColumnas = columna;
        }
        return nuevo;
    }
    
    public void insertar(int columna, int fila, String info) {
        NodoMatriz nuevo = new NodoMatriz(columna, fila, info);
        insertar(nuevo);
    }
    
    public void insertar(NodoMatriz nodo) {
        NodoMatriz nuevo = nodo;
        int fila = nodo.getY();
        int columna = nodo.getX();
        NodoMatriz inicioFila = obtenerFila(fila, true);
        NodoMatriz inicioColumna = obtenerColumna(columna, true);
        
        //Insercion en columna
        NodoMatriz cabeza = inicioColumna.getSiguienteFila();
        if(cabeza == null) {
            inicioColumna.setSiguienteFila(nuevo);
            nuevo.setAnteriorFila(inicioColumna);
        } else {
            if(cabeza.getY() > fila) {
                nuevo.setSiguienteFila(cabeza);
                cabeza.setAnteriorFila(nuevo);
                inicioColumna.setSiguienteFila(nuevo);
                nuevo.setAnteriorFila(inicioColumna);
            } else {
                NodoMatriz aux = cabeza;
                boolean insertado = false;
                while(aux.getSiguienteFila() != null) {
                    if(aux.getSiguienteFila().getY() > fila) {
                        nuevo.setSiguienteFila(aux.getSiguienteFila());
                        aux.getSiguienteFila().setAnteriorFila(nuevo);
                        nuevo.setAnteriorFila(aux);
                        aux.setSiguienteFila(nuevo);
                        insertado = true;
                        break;
                    }
                    aux = aux.getSiguienteFila();
                }
                if(!insertado) {
                    aux.setSiguienteFila(nuevo);
                    nuevo.setAnteriorFila(aux);
                }
            }
        }
        //insercion en fila
        cabeza = inicioFila.getSiguienteColumna();
        if(cabeza == null) {
            inicioFila.setSiguienteColumna(nuevo);
            nuevo.setAnteriorColumna(inicioFila);
        } else {
            if(cabeza.getX() > columna) {
                nuevo.setSiguienteColumna(cabeza);
                cabeza.setAnteriorColumna(nuevo);
                inicioFila.setSiguienteColumna(nuevo);
                nuevo.setAnteriorColumna(inicioFila);
            } else {
                NodoMatriz aux = cabeza;
                boolean insertado = false;
                while(aux.getSiguienteColumna() != null) {
                    if(aux.getSiguienteColumna().getX() > columna) {
                        nuevo.setSiguienteColumna(aux.getSiguienteColumna());
                        aux.getSiguienteColumna().setAnteriorColumna(nuevo);
                        nuevo.setAnteriorColumna(aux);
                        aux.setSiguienteColumna(nuevo);
                        insertado = true;
                        break;
                    }
                    aux = aux.getSiguienteColumna();
                }
                if(!insertado) {
                    aux.setSiguienteColumna(nuevo);
                    nuevo.setAnteriorColumna(aux);
                }
            }
        }
        totalNodos++;
    }
    
    public NodoMatriz busqueda(int columna, int fila) {
        NodoMatriz nodoColumna = obtenerColumna(columna, false);
        if(nodoColumna != null) {
            NodoMatriz aux = nodoColumna;
            while(aux != null) {
                if(aux.getY() == fila) {
                    return aux;
                }
                aux = aux.getSiguienteFila();
            }
            return null;
        } else {
            return null;
        }
    }
    
    public NodoMatriz obtenerFila(int fila, boolean bandera) {
        NodoMatriz aux = inicio.getSiguienteFila();
        while(aux != null) {
            if(aux.getY() == fila) {
                return aux;
            }
            aux = aux.getSiguienteFila();
        }
        if(bandera) {
            return insertarFila(fila);
        }
        return null;
    }
    
    public NodoMatriz obtenerColumna(int columna, boolean bandera) {
        NodoMatriz aux = inicio.getSiguienteColumna();
        while(aux != null) {
            if(aux.getX() == columna) {
                return aux;
            }
            aux = aux.getSiguienteColumna();
        }
        if(bandera) {
            return insertarColumna(columna);
        }
        return null;
    }

    public int getTotalNodos() {
        return totalNodos;
    }

    public int getTotalFilas() {
        return totalFilas;
    }

    public int getTotalColumnas() {
        return totalColumnas;
    }
    
    public String dotCode() {
        String codigo = "";
        codigo += "digraph matriz {\n";
        codigo += "node [shape = box]\n";
        codigo += "e0[ shape = point, width = 0 ];\n";
        codigo += "e1[ shape = point, width = 0 ];\n";
        codigo += getCodigoNodos();
        codigo += "}\n";
        return codigo;
    }
    
    private String getCodigoNodos() {
        String codigo = "";
        int cont = 1;
        if(inicio != null) {
            NodoMatriz aux = inicio;
            while(aux != null) {
                NodoMatriz auxF = aux;
                codigo += "subgraph cluster_" + cont + " {\n";
                while(auxF != null) {
                    String coord = auxF.getX() + "o" + auxF.getY();
                    codigo += "nodo" + coord + " [ label =\"" + auxF.getInfo() + "\", width = 1.5, style = filled, group = " + cont + " ];\n";
                    auxF = auxF.getSiguienteFila();
                }
                cont++;
                codigo += "color=\"White\";\n";
                codigo += "}\n";
                aux = aux.getSiguienteColumna();
            }
            
            aux = inicio;
            while(aux != null) {
                NodoMatriz auxF = aux;
                while(auxF != null) {
                    String coord = auxF.getX() + "o" + auxF.getY();
                    if(auxF.getAnteriorColumna() != null) {
                        String coordAuxF = auxF.getAnteriorColumna().getX() + "o" + auxF.getAnteriorColumna().getY();
                        codigo += "nodo" + coord +"->nodo" + coordAuxF + "\n";
                    }
                    if(auxF.getAnteriorFila() != null){
                        String coordAuxF = auxF.getAnteriorFila().getX() + "o" + auxF.getAnteriorFila().getY();
                        codigo += "nodo" + coord +"->nodo" + coordAuxF + "\n";
                    }
                    if(auxF.getSiguienteColumna() != null) {
                        String coordAuxF = auxF.getSiguienteColumna().getX() + "o" + auxF.getSiguienteColumna().getY();
                        codigo += "nodo" + coord +"->nodo" + coordAuxF + "\n";
                    }
                    if(auxF.getSiguienteFila() != null) {
                        String coordAuxF = auxF.getSiguienteFila().getX() + "o" + auxF.getSiguienteFila().getY();
                        codigo += "nodo" + coord +"->nodo" + coordAuxF + "\n";
                    }
                    
                    auxF = auxF.getSiguienteColumna();
                }
                auxF = aux;
                codigo += "{ rank = same; ";
                while(auxF != null) {
                    codigo += "nodo" + auxF.getX() + "o" + auxF.getY() + "; ";
                    auxF = auxF.getSiguienteColumna();
                }
                codigo += " };\n";
                aux = aux.getSiguienteFila();
            }
            
//            aux = inicio;
//            while(aux != null) {
//                NodoMatriz auxF = aux;
//                codigo += "{ rank = same; ";
//                while(auxF != null) {
//                    codigo += "nodo" + auxF.getX() + "o" + auxF.getY() + "; ";
//                    auxF = auxF.getSiguienteColumna();
//                }
//                codigo += " };\n";
//                aux = aux.getSiguienteFila();
//            }
        }
        return codigo;
    }
    
}
