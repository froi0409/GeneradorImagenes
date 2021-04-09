/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.generadorfiguras.manejadores;

import com.froi.generadorfiguras.analizadores.capas.CapasLexer;
import com.froi.generadorfiguras.analizadores.capas.ParserCapas;
import com.froi.generadorfiguras.analizadores.imagenes.ImagenesLexer;
import com.froi.generadorfiguras.analizadores.imagenes.ParserImagenes;
import com.froi.generadorfiguras.analizadores.usuarios.ParserUsuarios;
import com.froi.generadorfiguras.analizadores.usuarios.UsuariosLexer;
import com.froi.generadorfiguras.estructuras.ArbolAVL;
import com.froi.generadorfiguras.estructuras.ListaEnlazadaDobleCircular;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;

/**
 *
 * @author froi-pc
 */
public class ManejadorArchivos {
    
    public void manejarArchivoCap(File archivoEntrada, ArbolAVL arbolCapas) {
        //Obtenemos el código del archivo .cap
        String codigo = getCadenaArchivo(archivoEntrada);
        StringReader reader = new StringReader(codigo);
        CapasLexer lexer = new CapasLexer(reader);
        ParserCapas parser = new ParserCapas(lexer, arbolCapas);
        try {
            parser.parse();
        } catch (Exception e) {
            System.out.println("Error al analizar el codigo de capas: " + e.getMessage());
        }
        arbolCapas.imprimirArbol();
    }
    
    public void manejarArchivoIm(File archivoEntrada, ListaEnlazadaDobleCircular listaImagenes, ArbolAVL arbolCapas) {
        String codigo = getCadenaArchivo(archivoEntrada);
        StringReader reader = new StringReader(codigo);
        ImagenesLexer lexer = new ImagenesLexer(reader);
        ParserImagenes parser = new ParserImagenes(lexer, listaImagenes, arbolCapas);
        try {
            parser.parse();
            listaImagenes.imprimir();
        } catch (Exception e) {
            System.out.println("Error al analizar el codigo de imagenes: " + e.getMessage());
        }
    }
    
    public void manejarArchivoUsr(File archivoEntrada, ArbolAVL arbolUsuarios, ListaEnlazadaDobleCircular listaImagenes) {
        String codigo = getCadenaArchivo(archivoEntrada);
        StringReader reader = new StringReader(codigo);
        UsuariosLexer lexer = new UsuariosLexer(reader);
        ParserUsuarios parser = new ParserUsuarios(lexer, arbolUsuarios, listaImagenes);
        try{
            parser.parse();
        } catch(Exception e) {
            System.out.println("Error al analizar el codigo de los usuarios: " + e.getMessage());
        }
    }
    
    private String getCadenaArchivo(File archivo) {
        try {
            FileReader fileReader = new FileReader(archivo);
            BufferedReader lectorArchivo = new BufferedReader(fileReader);
            String cadena, codigo = "";
            //Almacenamos el codigo en la variable codigo
            while((cadena = lectorArchivo.readLine()) != null) {
                codigo += cadena + "\n";
            }
            return codigo;
        } catch (Exception e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
            return null;
        }
    }
    
}
