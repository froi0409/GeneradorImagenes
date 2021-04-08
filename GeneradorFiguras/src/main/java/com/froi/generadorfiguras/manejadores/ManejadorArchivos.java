/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froi.generadorfiguras.manejadores;

import com.froi.generadorfiguras.analizadores.capas.CapasLexer;
import com.froi.generadorfiguras.analizadores.capas.ParserCapas;
import com.froi.generadorfiguras.estructuras.ArbolAVL;
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
    
    public void manejarArchivoIm(File archivoEntrada) {
        
    }
    
    public void manejarArchivoUsr(File archivoEntrada) {
        
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