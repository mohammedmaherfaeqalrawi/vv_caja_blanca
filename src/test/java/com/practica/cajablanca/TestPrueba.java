package com.practica.cajablanca;

import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.EmptyCollectionException;
import com.cajanegra.SingleLinkedListImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


public class TestPrueba {
    //Tests cajaBlanca for mayorLongitud
    @Test
    void mayorLongitudCamino1() throws EmptyCollectionException {
        Editor editor = new Editor();
        assertEquals(null, editor.mayorLongitud());
    }
    @Test
    void mayorLongitudCamino2() throws EmptyCollectionException, IOException {
        Writer fileWriter = new FileWriter("test.txt", false);
        fileWriter.write("20\n4500");
        fileWriter.close();
        Editor editor = new Editor();
        editor.leerFichero("test.txt");
        assertEquals("4500", editor.mayorLongitud());
    }
    // Tests caja blanca for public int numPalabras(int inicio, int fin, String palabra);
    @Test
    public void NumPalabrasParametrizadaCamino1() throws IOException{
        Editor editor = new Editor();
        Exception thrown=assertThrows(IllegalArgumentException.class, () -> {
            editor.numPalabras(-1,2,"hola");
        });
        assertEquals("La línea de inicio no puede ser menor o igual a cero",thrown.getMessage());
    }
    @Test
    public void NumPalabrasParametrizadaCamino2(){
        Editor editor = new Editor();
        Exception thrown=assertThrows(IllegalArgumentException.class, () -> {
            editor.numPalabras(1,1,"hola");
        });
        assertEquals("La línea fin no puede ser mayor que el máximo de líneas",thrown.getMessage());
    }
    @Test
    public void NumPalabrasParametrizadaCamino3(){
        Editor editor = new Editor();
        assertEquals(0,editor.numPalabras(1,0,"hola"));
    }
    @Test
    public void NumPalabrasParametrizadaCamino4() throws IOException {
        Writer fileWriter = new FileWriter("test.txt", false);
        fileWriter.write("hola amigo");
        fileWriter.close();
        Editor editor = new Editor();
        editor.leerFichero("test.txt");
        assertEquals(0,editor.numPalabras(1,1,"hola"));
    }
    @Test
    public void NumPalabrasParametrizadaCamino5() throws IOException {
        Writer fileWriter = new FileWriter("test.txt", false);
        fileWriter.write(" \n ");
        fileWriter.close();
        Editor editor = new Editor();
        editor.leerFichero("test.txt");
        assertEquals(0,editor.numPalabras(1,2,"hola"));
    }
    @Test
    public void NumPalabrasParametrizadaCamino6() throws IOException {
        Writer fileWriter = new FileWriter("test.txt", false);
        fileWriter.write("hola\n ");
        fileWriter.close();
        Editor editor = new Editor();
        editor.leerFichero("test.txt");
        assertEquals(0,editor.numPalabras(1,2,"yepee"));
    }
    @Test
    public void NumPalabrasParametrizadaCamino7() throws IOException {
        Writer fileWriter = new FileWriter("test.txt", false);
        fileWriter.write("yepee\n ");
        fileWriter.close();
        Editor editor = new Editor();
        editor.leerFichero("test.txt");
        assertEquals(1,editor.numPalabras(1,2,"yepee"));
    }
    // Tests caja blanca for numPalabras()
    @Test
    public void NumPalabrasCamino1(){
        Editor editor = new Editor();
        assertThrows(EmptyCollectionException.class, () -> {
            editor.numPalabras();
        });
    }
    @Test
    public void NumPalabrasCamino4() throws EmptyCollectionException, IOException {
        Writer fileWriter = new FileWriter("test.txt", false);
        fileWriter.write("\n");
        fileWriter.close();
        Editor editor = new Editor();
        editor.leerFichero("test.txt");
        assertEquals(0,editor.numPalabras());

    }
    @Test
    public void NumPalabrasCamino5() throws EmptyCollectionException, IOException {
        Writer fileWriter = new FileWriter("test.txt", false);
        fileWriter.write("palabra");
        fileWriter.close();
        Editor editor = new Editor();
        editor.leerFichero("test.txt");
        assertEquals(1,editor.numPalabras());

    }

}