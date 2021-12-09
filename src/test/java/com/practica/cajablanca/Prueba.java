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


public class Prueba {
    // Tests caja blanca for numPalabras
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
