package com.practica.cajablanca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.EmptyCollectionException;
import com.cajanegra.SingleLinkedListImpl;

public class Editor {

	private AbstractSingleLinkedListImpl<AbstractSingleLinkedListImpl<String>> editor;
	private AbstractSingleLinkedListImpl<String> lista;

	@SuppressWarnings("unchecked")
	public Editor() {
		editor = new SingleLinkedListImpl<AbstractSingleLinkedListImpl<String>>();
	}

	/**
	 * 
	 * @return el tamaño de la lista
	 */
	public int size() {
		return editor.size();
	}

	public boolean editIsEmpty() {
		return this.editor.size() == 0;
	}

	/**
	 * 
	 * @param linea
	 * @return la lista correspondiente a la línea pasada como parámetro
	 * @throws EmptyCollectionException si el editor está vacío
	 * @throws Si                       el número de línea es incorrecta lanza
	 *                                  IllegalArgumentException
	 */
	public AbstractSingleLinkedListImpl<String> getLinea(int linea) throws EmptyCollectionException {
		if (editor.isEmpty()) {
			throw new EmptyCollectionException(" editor ");
		}
		if (linea < 0 || linea > editor.size()) {
			throw new IllegalArgumentException();
		}
		return this.editor.getAtPos(linea);
	}

	/**
	 * Leemos un fichero de entrada con líneas de texto que cargaremos en nuestra
	 * lista de listas "lineas".
	 * 
	 * @param nombre del fichero del que leemos
	 */
	public void leerFichero(String nombreFichero) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String regex = "\\s+|,\\s*|\\.\\s*";
		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File(nombreFichero);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String cadena;
			while ((cadena = br.readLine()) != null) {
				String[] words = cadena.split(regex);
				lista = new SingleLinkedListImpl<String>();
				for (String s : words) {
					lista.addLast(s);
				}
				editor.addLast(lista);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra, tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// public int numPalabras(int inicio, int fin, String palabra) {
	/**
	 * 
	 * @param inicio
	 * @param fin
	 * @param palabra a buscar en el texto
	 * @return número de apariciones de palabra
	 * @throws EmptyCollectionException
	 * @throws IllegalArgumentException si inicio es &lt; 0 or fin &gt; size
	 */
	@SuppressWarnings("unchecked")
	public int numPalabras(int inicio, int fin, String palabra) {
		if (inicio <= 0)
			throw new IllegalArgumentException("La línea de inicio no puede ser menor o igual a cero");
		if (fin > this.editor.size())
			throw new IllegalArgumentException("La línea fin no puede ser mayor que el máximo de líneas");
		int apariciones = 0;
		if (this.editor.size() > 0) {
			while (inicio < fin) {
				this.lista = this.editor.getAtPos(inicio);
				int pos = 1;
				while (pos <= this.lista.size()) {
					String cadena = this.lista.getAtPos(pos);
					if (cadena.equals(palabra)) {
						apariciones++;
					}
					pos++;
				}
				inicio++;
			}
		}
		return apariciones;
	}

	public int numPalabras() throws EmptyCollectionException {
		if (this.editIsEmpty()) {
			throw new EmptyCollectionException("El editor está vacío");
		}
		int numPalabras = 0;
		if (this.size() > 0) {
			int i = 1;
			while (i <= this.size()) {
				this.lista = getLinea(i);
				for (String s : lista) {
					numPalabras++;
				}
				i++;
			}
		}
		return numPalabras;
	}

	/**
	 * 
	 * @return la palabra de mayor longitud
	 * @throws EmptyCollectionException
	 */
	public String mayorLongitud() throws EmptyCollectionException {
		String mayor = null;
		if (this.editor.size() > 0) {
			for (int i = 1; i <= this.editor.size(); i++) {
				this.lista = this.editor.getAtPos(i);
				for (int pos = 1; pos <= this.lista.size(); pos++) {
					String cadena = this.lista.getAtPos(pos);
					if (mayor == null) {
						mayor = cadena;
					} else if (cadena.length() > mayor.length()) {
						mayor = cadena;
					}
				}
			}
		}
		return mayor;
	}

	/**
	 * @param palabra
	 * @param nuevaPalabra Sustituye palabra por nuevapalabra a lo largo de todo el
	 *                     texto
	 */
	public void sustituirPalabra(String palabra, String nuevaPalabra) {
		if (this.editor.size() > 0) {
			AbstractSingleLinkedListImpl<AbstractSingleLinkedListImpl<String>> nuevoEditor = 
					new SingleLinkedListImpl<AbstractSingleLinkedListImpl<String>>();
			int i=1;
			do {
				AbstractSingleLinkedListImpl<String> aux = new SingleLinkedListImpl<String>();
				this.lista = this.editor.getAtPos(i);
				int j=1;
				while (j<=this.lista.size()) {
					if (this.lista.getAtPos(j).equals(palabra)) {
						aux.addLast(nuevaPalabra);
					}else {
						aux.addLast(this.lista.getAtPos(j));
					}
					j++;
				}
				nuevoEditor.addLast(aux);
				i++;
			}while (i<=this.editor.size());
			editor = nuevoEditor;
		}
	}

	public static void main(String[] args) throws EmptyCollectionException {
	
	}
}
