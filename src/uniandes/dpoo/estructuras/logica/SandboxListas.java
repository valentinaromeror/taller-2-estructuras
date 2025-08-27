package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Métodos para practicar operaciones sobre listas (enteros y cadenas).
 * Todo opera sobre los atributos listaEnteros y listaCadenas.
 */
public class SandboxListas
{
    /** Lista de enteros. */
    private List<Integer> listaEnteros;

    /** Lista de cadenas. */
    private List<String> listaCadenas;

    /** Constructor: listas vacías. */
    public SandboxListas( )
    {
        listaEnteros = new ArrayList<Integer>( );
        listaCadenas = new LinkedList<String>( );
    }

    /** Copia de la lista de enteros. */
    public List<Integer> getCopiaEnteros( )
    {
        return new ArrayList<>(listaEnteros);
    }

    /** Copia de la lista de cadenas. */
    public List<String> getCopiaCadenas( )
    {
        return new ArrayList<>(listaCadenas);
    }

    /** Devuelve los enteros como arreglo (copia). */
    public int[] getEnterosComoArreglo( )
    {
        int n = listaEnteros.size();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = listaEnteros.get(i);
        return a;
    }

    /** Cantidad de enteros. */
    public int getCantidadEnteros( )
    {
        return listaEnteros.size();
    }

    /** Cantidad de cadenas. */
    public int getCantidadCadenas( )
    {
        return listaCadenas.size();
    }

    /** Agrega entero al final. */
    public void agregarEntero( int entero )
    {
        listaEnteros.add(entero);
    }

    /** Agrega cadena al final. */
    public void agregarCadena( String cadena )
    {
        listaCadenas.add(cadena);
    }

    /** Elimina TODAS las apariciones de un entero. */
    public void eliminarEntero( int valor )
    {
        for (Iterator<Integer> it = listaEnteros.iterator(); it.hasNext(); ) {
            if (it.next() == valor) it.remove();
        }
    }

    /** Elimina TODAS las apariciones de una cadena (sensitivo a mayúsculas). */
    public void eliminarCadena( String cadena )
    {
        for (Iterator<String> it = listaCadenas.iterator(); it.hasNext(); ) {
            if (it.next().equals(cadena)) it.remove();
        }
    }

    /**
     * Inserta entero en la posición dada (con límites).
     * Si pos < 0 → al inicio; si pos > tamaño → al final.
     */
    public void insertarEntero( int entero, int posicion )
    {
        int n = listaEnteros.size();
        int pos = posicion;
        if (pos < 0) pos = 0;
        if (pos > n) pos = n;
        listaEnteros.add(pos, entero);
    }

    /** Elimina entero por posición si es válida. */
    public void eliminarEnteroPorPosicion( int posicion )
    {
        if (posicion < 0 || posicion >= listaEnteros.size()) return;
        listaEnteros.remove(posicion);
    }

    /** Reinicia enteros a partir de doubles truncando. */
    public void reiniciarArregloEnteros( double[] valores )
    {
        listaEnteros.clear();
        if (valores == null) return;
        for (double d : valores) listaEnteros.add((int) d); // truncamiento hacia 0
    }

    /** Reinicia cadenas con toString() de cada objeto. */
    public void reiniciarArregloCadenas( List<Object> objetos )
    {
        listaCadenas.clear();
        if (objetos == null) return;
        for (Object o : objetos) listaCadenas.add(String.valueOf(o));
    }

    /** Vuelve todos los enteros positivos (valor absoluto). */
    public void volverPositivos( )
    {
        for (int i = 0; i < listaEnteros.size(); i++) {
            listaEnteros.set(i, Math.abs(listaEnteros.get(i)));
        }
    }

    /** Ordena enteros de MAYOR a MENOR. */
    public void organizarEnteros( )
    {
        Collections.sort(listaEnteros, Collections.reverseOrder());
    }

    /** Ordena cadenas lexicográficamente (ascendente). */
    public void organizarCadenas( )
    {
        Collections.sort(listaCadenas);
    }

    /** Cuenta apariciones de un entero. */
    public int contarApariciones( int valor )
    {
        int c = 0;
        for (int x : listaEnteros) if (x == valor) c++;
        return c;
    }

    /** Cuenta apariciones de una cadena (case-insensitive). */
    public int contarApariciones( String cadena )
    {
        int c = 0;
        for (String s : listaCadenas) if (s.equalsIgnoreCase(cadena)) c++;
        return c;
    }

    /**
     * Cuenta cuántos **valores distintos** aparecen más de una vez en la lista de enteros.
     * (frecuencia >= 2).
     */
    public int contarEnterosRepetidos( )
    {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for (int x : listaEnteros) freq.put(x, freq.getOrDefault(x, 0) + 1);
        int c = 0;
        for (int f : freq.values()) if (f >= 2) c++;
        return c;
    }

    /** Compara lista de enteros con arreglo, mismo orden y tamaño. */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
        if (otroArreglo == null) return false;
        if (listaEnteros.size() != otroArreglo.length) return false;
        for (int i = 0; i < otroArreglo.length; i++) {
            if (listaEnteros.get(i) != otroArreglo[i]) return false;
        }
        return true;
    }

    /**
     * Genera enteros aleatorios uniformes en [minimo, maximo] (inclusive),
     * reemplazando el contenido de la lista.
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
        if (cantidad < 0) cantidad = 0;
        if (minimo > maximo) { int t = minimo; minimo = maximo; maximo = t; }

        listaEnteros.clear();
        int rango = maximo - minimo + 1;
        for (int i = 0; i < cantidad; i++) {
            int v = minimo + (int)(Math.random() * rango);
            listaEnteros.add(v);
        }
    }
}

