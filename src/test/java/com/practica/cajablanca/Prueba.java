package com.practica.cajablanca;

import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.EmptyCollectionException;
import com.cajanegra.SingleLinkedListImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void emptyEditorNumPalabras(){
        Editor editor = new Editor();
        assertThrows(EmptyCollectionException.class, () -> {
            editor.numPalabras();
        });
    }
    @Test
    public void editorWithLineNumPalabras() throws EmptyCollectionException {
        AbstractSingleLinkedListImpl<AbstractSingleLinkedListImpl<String>> editor= new SingleLinkedListImpl<AbstractSingleLinkedListImpl<String>>();
        Editor Editor = new Editor(editor);
        SingleLinkedListImpl<String>line=new SingleLinkedListImpl<String>("hola");
        editor.addLast(line);
        assertEquals(1,Editor.numPalabras());

    }

}
