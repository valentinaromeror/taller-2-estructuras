package uniandes.dpoo.estructuras.logica;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * No pueden agregarse nuevos atributos.
 * Implemente los métodos usando operaciones sobre arreglos.
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones.
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /** Retorna una copia del arreglo de enteros. */
    public int[] getCopiaEnteros( )
    {
        return Arrays.copyOf(arregloEnteros, arregloEnteros.length);
    }

    /** Retorna una copia del arreglo de cadenas. */
    public String[] getCopiaCadenas( )
    {
        return Arrays.copyOf(arregloCadenas, arregloCadenas.length);
    }

    /** Retorna la cantidad de valores en el arreglo de enteros. */
    public int getCantidadEnteros( )
    {
        return arregloEnteros.length;
    }

    /** Retorna la cantidad de valores en el arreglo de cadenas. */
    public int getCantidadCadenas( )
    {
        return arregloCadenas.length;
    }

    /** Agrega un entero al final (aumenta tamaño en 1). */
    public void agregarEntero( int entero )
    {
        int n = arregloEnteros.length;
        int[] nuevo = Arrays.copyOf(arregloEnteros, n + 1);
        nuevo[n] = entero;
        arregloEnteros = nuevo;
    }

    /** Agrega una cadena al final (aumenta tamaño en 1). */
    public void agregarCadena( String cadena )
    {
        int n = arregloCadenas.length;
        String[] nuevo = Arrays.copyOf(arregloCadenas, n + 1);
        nuevo[n] = cadena;
        arregloCadenas = nuevo;
    }

    /** Elimina TODAS las apariciones de un valor en enteros. */
    public void eliminarEntero( int valor )
    {
        int contarNo = 0;
        for (int x : arregloEnteros) if (x != valor) contarNo++;
        if (contarNo == arregloEnteros.length) return; // nada que borrar
        int[] nuevo = new int[contarNo];
        int i = 0;
        for (int x : arregloEnteros) if (x != valor) nuevo[i++] = x;
        arregloEnteros = nuevo;
    }

    /** Elimina TODAS las apariciones de una cadena (case sensitive según enunciado general). */
    public void eliminarCadena( String cadena )
    {
        int contarNo = 0;
        for (String s : arregloCadenas) if (!s.equals(cadena)) contarNo++;
        if (contarNo == arregloCadenas.length) return;
        String[] nuevo = new String[contarNo];
        int i = 0;
        for (String s : arregloCadenas) if (!s.equals(cadena)) nuevo[i++] = s;
        arregloCadenas = nuevo;
    }

    /**
     * Inserta un nuevo entero en la posición dada (con límites).
     * Si pos < 0 → al inicio; si pos > tamaño → al final.
     */
    public void insertarEntero( int entero, int posicion )
    {
        int n = arregloEnteros.length;
        int pos = posicion;
        if (pos < 0) pos = 0;
        if (pos > n) pos = n;

        int[] nuevo = new int[n + 1];
        // copia primera parte
        System.arraycopy(arregloEnteros, 0, nuevo, 0, pos);
        // inserta
        nuevo[pos] = entero;
        // copia resto
        if (pos < n) System.arraycopy(arregloEnteros, pos, nuevo, pos + 1, n - pos);
        arregloEnteros = nuevo;
    }

    /** Elimina un entero por posición (si es válida). */
    public void eliminarEnteroPorPosicion( int posicion )
    {
        int n = arregloEnteros.length;
        if (posicion < 0 || posicion >= n) return;
        int[] nuevo = new int[n - 1];
        if (posicion > 0) System.arraycopy(arregloEnteros, 0, nuevo, 0, posicion);
        if (posicion < n - 1) System.arraycopy(arregloEnteros, posicion + 1, nuevo, posicion, n - posicion - 1);
        arregloEnteros = nuevo;
    }

    /** Reinicia enteros a partir de doubles, truncando (cast a int). */
    public void reiniciarArregloEnteros( double[] valores )
    {
        if (valores == null) { arregloEnteros = new int[]{}; return; }
        int n = valores.length;
        int[] nuevo = new int[n];
        for (int i = 0; i < n; i++) nuevo[i] = (int) valores[i]; // truncamiento hacia 0
        arregloEnteros = nuevo;
    }

    /** Reinicia cadenas con toString() de cada objeto. */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
        if (objetos == null) { arregloCadenas = new String[]{}; return; }
        int n = objetos.length;
        String[] nuevo = new String[n];
        for (int i = 0; i < n; i++) nuevo[i] = String.valueOf(objetos[i]);
        arregloCadenas = nuevo;
    }

    /** Convierte todos los enteros a su valor absoluto (in-place). */
    public void volverPositivos( )
    {
        for (int i = 0; i < arregloEnteros.length; i++)
            arregloEnteros[i] = Math.abs(arregloEnteros[i]);
    }

    /** Ordena de menor a mayor. */
    public void organizarEnteros( )
    {
        Arrays.sort(arregloEnteros);
    }

    /** Ordena cadenas lexicográficamente. */
    public void organizarCadenas( )
    {
        Arrays.sort(arregloCadenas);
    }

    /** Cuenta apariciones de un entero. */
    public int contarApariciones( int valor )
    {
        int c = 0;
        for (int x : arregloEnteros) if (x == valor) c++;
        return c;
    }

    /** Cuenta apariciones de una cadena (sin diferenciar mayúsculas/minúsculas). */
    public int contarApariciones( String cadena )
    {
        int c = 0;
        for (String s : arregloCadenas)
            if (s.equalsIgnoreCase(cadena)) c++;
        return c;
    }

    /**
     * Devuelve las posiciones donde aparece un valor en enteros.
     * Si no aparece, retorna arreglo de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
        int c = 0;
        for (int x : arregloEnteros) if (x == valor) c++;
        if (c == 0) return new int[]{};

        int[] pos = new int[c];
        int j = 0;
        for (int i = 0; i < arregloEnteros.length; i++)
            if (arregloEnteros[i] == valor) pos[j++] = i;
        return pos;
    }

    /**
     * Rango de enteros: [min, max]. Si está vacío, arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {
        if (arregloEnteros.length == 0) return new int[]{};
        int min = arregloEnteros[0], max = arregloEnteros[0];
        for (int x : arregloEnteros) { if (x < min) min = x; if (x > max) max = x; }
        return new int[]{ min, max };
    }

    /** Histograma (valor → frecuencia). */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
        HashMap<Integer, Integer> h = new HashMap<>();
        for (int x : arregloEnteros) h.put(x, h.getOrDefault(x, 0) + 1);
        return h;
    }

    /**
     * Cuenta cuántos **valores distintos** aparecen más de una vez.
     * (O sea, cuántos tienen frecuencia >= 2).
     */
    public int contarEnterosRepetidos( )
    {
        HashMap<Integer,Integer> h = calcularHistograma();
        int c = 0;
        for (int f : h.values()) if (f >= 2) c++;
        return c;
    }

    /** Compara si dos arreglos de enteros son idénticos (mismo orden). */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
        if (otroArreglo == null) return false;
        if (arregloEnteros.length != otroArreglo.length) return false;
        for (int i = 0; i < arregloEnteros.length; i++)
            if (arregloEnteros[i] != otroArreglo[i]) return false;
        return true;
    }

    /** Verifica si tienen los mismos elementos (posible distinto orden). */
    public boolean mismosEnteros( int[] otroArreglo )
    {
        if (otroArreglo == null) return false;
        if (arregloEnteros.length != otroArreglo.length) return false;
        int[] a = Arrays.copyOf(arregloEnteros, arregloEnteros.length);
        int[] b = Arrays.copyOf(otroArreglo,    otroArreglo.length);
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    /**
     * Genera nuevos enteros aleatorios uniformes en [minimo, maximo] (inclusive)
     * y cambia el contenido del arreglo.
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
        if (cantidad < 0) cantidad = 0;
        if (minimo > maximo) { int t = minimo; minimo = maximo; maximo = t; }

        int[] nuevo = new int[cantidad];
        int rango = maximo - minimo + 1; // asumiendo minimo <= maximo
        for (int i = 0; i < cantidad; i++)
            nuevo[i] = minimo + (int)(Math.random() * rango);
        arregloEnteros = nuevo;
    }
}
