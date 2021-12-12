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
    
    
    //Test del sustiruir palabra
    @Test
    @DisplayName("Test sustituir palabra en lista vacía")
    public void sustituirPalabraCamino1() throws EmptyCollectionException, IOException {

        Writer sustituirpalabra = new FileWriter("sustituirpalabra.txt", false);
        //sustituirpalabra.write("200");
        sustituirpalabra.close();

        Editor edit = new Editor();
        edit.leerFichero("sustituirpalabra.txt");
        edit.sustituirPalabra("200", "250");
        assertEquals(true, edit.editIsEmpty());
    }

    //Camino 2 no es factible por lo que no se prueba.

    @Test
    @DisplayName("Test sustituir palabra")
    public void sustituirPalabraCamino3() throws EmptyCollectionException, IOException {
        Writer sustituirpalabra = new FileWriter("sustituirpalabra.txt", false);
        sustituirpalabra.write("200");
        sustituirpalabra.close();

        Editor edit = new Editor();
        edit.leerFichero("sustituirpalabra.txt");
        edit.sustituirPalabra("200", "250");
        assertEquals("250", edit.getLinea(1).getAtPos(1));
    }

    @Test
    @DisplayName("Test sustituir una palabra que no existe")
    public void sustituirPalabraCamino4() throws EmptyCollectionException, IOException {
        Writer sustituirpalabra = new FileWriter("sustituirpalabra.txt", false);
        sustituirpalabra.write("220");
        sustituirpalabra.close();

        Editor edit = new Editor();
        edit.leerFichero("sustituirpalabra.txt");
        edit.sustituirPalabra("200", "250");
        assertEquals("220", edit.getLinea(1).getAtPos(1));
    }

    @Test
    @DisplayName("Test sustituir palabra con más de un elemento en el editor")
    public void sustituirPalabraCamino5() throws EmptyCollectionException, IOException {
        Writer sustituirpalabra = new FileWriter("sustituirpalabra.txt", false);
        sustituirpalabra.write("220\n300");
        sustituirpalabra.close();

        Editor edit = new Editor();
        edit.leerFichero("sustituirpalabra.txt");
        edit.sustituirPalabra("220","250");
        assertEquals("250", edit.getLinea(1).getAtPos(1));
        assertEquals("300", edit.getLinea(2).getAtPos(1));
    }

}
