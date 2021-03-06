/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.generadorfiguras.manejadores;

import com.froi.generadorfiguras.estructuras.ListaDoblementeEnlazada;
import com.froi.generadorfiguras.estructuras.MatrizDispersa;
import com.froi.generadorfiguras.nodos.NodoMatriz;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author froi-pc
 */
public class ManejadorGraficas {

    /**
     * Permite generar una grafica (con graphviz) sobre el estado de la memoria
     * @param dotCode codigo .dot
     * @param nombreArchivo Nombre que tendrán los archivos generados
     * @param panel panel donde se pondrá la imagen
     */
    public void graficarEstadoMemoria(String dotCode, String nombreArchivo, JPanel panel) {
        String nomArch = nombreArchivo + ".dot";
        System.out.println(dotCode);
        FileWriter fichero = null;
        try {
            fichero = new FileWriter(nomArch);
            PrintWriter writer = new PrintWriter(fichero);
            writer.print(dotCode);
            fichero.close();
        } catch (Exception e) {
            System.out.println("Error al escribir el archivo dot: " + e.getMessage());
        } finally {
            try {
                if(null != fichero) {
                    fichero.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar el archivo");
            }
        }
        try {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("dot -Tpng " + nomArch  + " -o " + nombreArchivo + ".png");
            System.out.println("dot -Tpng " + nomArch  + " -o " + nombreArchivo + ".png");
            Thread.sleep(500);
            JOptionPane.showMessageDialog(null, "Imagen Generada en la carpeta del proyecto");
        } catch (Exception e) {
            System.out.println("Error al generar la imagen");
        }
    }
    
    public void graficarImagen(ListaDoblementeEnlazada listaCapasGraficar, JPanel panelGraficacion) {
        panelGraficacion.removeAll();
        int x = 0;
        int y = 0;
        for(int i = 0; i < listaCapasGraficar.getTamaño(); i++){
            MatrizDispersa matrizAux = (MatrizDispersa) listaCapasGraficar.buscar(i).getContenido();
            int totalColumnas = matrizAux.getTotalColumnas();
            int totalFilas = matrizAux.getTotalFilas();
            if(totalColumnas > x){
                x = totalColumnas;
            }
            if(totalFilas > y) {
                y = totalFilas;
            }
            
        }
        System.out.println("El total de columnas es: " + x + ". Y el total de filas es: " + y);
        int anchoBtn = panelGraficacion.getWidth() / x;
        int altoBtn = panelGraficacion.getHeight() / y;
        
        for(int capa = listaCapasGraficar.getTamaño()-1; capa >= 0; capa--) {
            for(int i = 1; i <= x; i++){
                for(int j = 1; j <= y; j++) {
                    MatrizDispersa matrizAux = (MatrizDispersa) listaCapasGraficar.buscar(capa).getContenido();
                    NodoMatriz nodo;
                    if((nodo = matrizAux.busqueda(i, j)) != null)
                    {
                        int xPane = 20*i - 20;
                        int yPane = 20*j - 20;
                        nodo.getBoton().setBounds(xPane, yPane, 20, 20);
                        nodo.getBoton().setBackground(Color.decode(nodo.getInfo()));
                        nodo.getBoton().setVisible(true);
                        nodo.getBoton().setEnabled(false);
                        panelGraficacion.add(nodo.getBoton());
                    }
                }
            } 
        }
        panelGraficacion.repaint();
        panelGraficacion.setPreferredSize(new Dimension(20*x, 20*y));
        
//        JButton matrizBotones[][] = new JButton[y][x];
//        panelGraficacion.setLayout(new GridLayout(y,x));
//
//        for(int i = 0; i < y; i++) {
//            for(int j = 0; j < x; j++) {
//                matrizBotones[i][j] = new JButton("");
//                matrizBotones[i][j].setBounds(20, 10, 360, 360);
//                matrizBotones[i][j].setBackground(Color.red);
//                panelGraficacion.add(matrizBotones[i][j]);
//            }
//        }
    }
    
}
