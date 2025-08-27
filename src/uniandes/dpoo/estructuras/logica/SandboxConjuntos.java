package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.Collections;

/**
 * Métodos sobre conjuntos (TreeSet) usando únicamente la interfaz NavigableSet.
 */
public class SandboxConjuntos
{
    /** Conjunto ordenado lexicográficamente. */
    private NavigableSet<String> arbolCadenas;

    /** Constructor: conjunto vacío. */
    public SandboxConjuntos( )
    {
        arbolCadenas = new TreeSet<String>( );
    }

    /** Retorna las cadenas como lista (orden natural ascendente). */
    public List<String> getCadenasComoLista( )
    {
        return new ArrayList<>(arbolCadenas);
    }

    /** Retorna las cadenas como lista pero de mayor a menor. */
    public List<String> getCadenasComoListaInvertida( )
    {
        return new ArrayList<>(arbolCadenas.descendingSet());
    }

    /** Menor cadena (o null si vacío). */
    public String getPrimera( )
    {
        return arbolCadenas.isEmpty() ? null : arbolCadenas.first();
    }

    /** Mayor cadena (o null si vacío). */
    public String getUltima( )
    {
        return arbolCadenas.isEmpty() ? null : arbolCadenas.last();
    }

    /**
     * Cadenas >= a la recibida (incluyéndola si existe).
     * Retorna una colección independiente.
     */
    public Collection<String> getSiguientes( String cadena )
    {
        if (arbolCadenas.isEmpty()) return new ArrayList<>();
        return new ArrayList<>(arbolCadenas.tailSet(cadena, true));
    }

    /** Cantidad de cadenas en el conjunto. */
    public int getCantidadCadenas( )
    {
        return arbolCadenas.size();
    }

    /** Agrega una cadena (si no existe). */
    public void agregarCadena( String cadena )
    {
        arbolCadenas.add(cadena);
    }

    /** Elimina exactamente la cadena dada (case sensitive). */
    public void eliminarCadena( String cadena )
    {
        arbolCadenas.remove(cadena);
    }

    /** Elimina la cadena ignorando mayúsculas/minúsculas. */
    public void eliminarCadenaSinMayusculasOMinusculas( String cadena )
    {
        if (cadena == null || arbolCadenas.isEmpty()) return;
        // Buscar la que sea equalsIgnoreCase y removerla.
        String toDelete = null;
        for (String s : arbolCadenas)
        {
            if (s.equalsIgnoreCase(cadena))
            {
                toDelete = s;
                break;
            }
        }
        if (toDelete != null) arbolCadenas.remove(toDelete);
    }

    /** Elimina la primera cadena (si existe). */
    public void eliminarPrimera( )
    {
        if (!arbolCadenas.isEmpty()) arbolCadenas.pollFirst();
    }

    /** Reinicia el conjunto con toString() de cada objeto de la lista. */
    public void reiniciarConjuntoCadenas( List<Object> objetos )
    {
        arbolCadenas.clear();
        if (objetos == null) return;
        for (Object o : objetos) arbolCadenas.add(String.valueOf(o));
    }

    /**
     * Convierte todas las cadenas a MAYÚSCULAS.
     * (Se reconstruye el set para mantener el orden consistente).
     */
    public void volverMayusculas( )
    {
        NavigableSet<String> nuevo = new TreeSet<>();
        for (String s : arbolCadenas) nuevo.add(s.toUpperCase());
        arbolCadenas = nuevo;
    }

    /** Devuelve un TreeSet con las cadenas ordenadas de MAYOR a MENOR. */
    public TreeSet<String> invertirCadenas( )
    {
        TreeSet<String> invertido = new TreeSet<>(Collections.reverseOrder());
        invertido.addAll(arbolCadenas);
        return invertido;
    }

    /** Verifica si TODOS los elementos del arreglo están en el conjunto. */
    public boolean compararElementos( String[] otroArreglo )
    {
        if (otroArreglo == null) return true; // no hay nada que falte
        for (String s : otroArreglo)
        {
            if (!arbolCadenas.contains(s)) return false;
        }
        return true;
    }
}
