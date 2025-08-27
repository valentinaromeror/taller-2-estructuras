package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 * Llave = cadena invertida del valor. Valores únicos.
 */
public class SandboxMapas
{
    /** Mapa (llave=reverse(valor), valor=original). */
    private Map<String, String> mapaCadenas;

    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    }

    /** Utilidad: invierte una cadena. */
    private String invertir(String s) {
        if (s == null) return null;
        return new StringBuilder(s).reverse().toString();
    }

    /** Retorna los VALORES ordenados ASC, como lista (copia). */
    public List<String> getValoresComoLista( )
    {
        List<String> vals = new ArrayList<>(mapaCadenas.values());
        Collections.sort(vals);
        return vals;
    }

    /** Retorna las LLAVES ordenadas DESC, como lista (copia). */
    public List<String> getLlavesComoListaInvertida( )
    {
        List<String> keys = new ArrayList<>(mapaCadenas.keySet());
        Collections.sort(keys, Collections.reverseOrder());
        return keys;
    }

    /** Retorna el menor (lex) entre los VALORES; null si vacío. */
    public String getPrimera( )
    {
        if (mapaCadenas.isEmpty()) return null;
        String min = null;
        for (String v : mapaCadenas.values())
            if (min == null || v.compareTo(min) < 0) min = v;
        return min;
    }

    /** Retorna el mayor (lex) entre los VALORES; null si vacío. */
    public String getUltima( )
    {
        if (mapaCadenas.isEmpty()) return null;
        String max = null;
        for (String v : mapaCadenas.values())
            if (max == null || v.compareTo(max) > 0) max = v;
        return max;
    }

    /**
     * Retorna una colección con las llaves en MAYÚSCULAS (copia).
     * El orden no importa.
     */
    public Collection<String> getLlaves( )
    {
        List<String> out = new ArrayList<>(mapaCadenas.size());
        for (String k : mapaCadenas.keySet()) out.add(k.toUpperCase());
        return out;
    }

    /** Cantidad de valores diferentes (tamaño del mapa). */
    public int getCantidadCadenasDiferentes( )
    {
        return mapaCadenas.size();
    }

    /**
     * Agrega un valor; su llave = valor invertido.
     * No duplica si el valor ya existe.
     */
    public void agregarCadena( String cadena )
    {
        if (cadena == null) return;
        if (mapaCadenas.containsValue(cadena)) return; // ya está ese valor
        mapaCadenas.put(invertir(cadena), cadena);
    }

    /** Elimina por LLAVE (si existe). */
    public void eliminarCadenaConLLave( String llave )
    {
        if (llave == null) return;
        mapaCadenas.remove(llave);
    }

    /** Elimina por VALOR (si existe). */
    public void eliminarCadenaConValor( String valor )
    {
        if (valor == null) return;
        String toRemove = null;
        for (Map.Entry<String,String> e : mapaCadenas.entrySet()) {
            if (e.getValue().equals(valor)) { toRemove = e.getKey(); break; }
        }
        if (toRemove != null) mapaCadenas.remove(toRemove);
    }

    /** Reinicia el mapa con toString() de cada objeto (valores únicos). */
    public void reiniciarMapaCadenas( List<Object> objetos )
    {
        mapaCadenas.clear();
        if (objetos == null) return;
        for (Object o : objetos) {
            String v = String.valueOf(o);
            if (!mapaCadenas.containsValue(v)) {
                mapaCadenas.put(invertir(v), v);
            }
        }
    }

    /** Convierte TODAS las llaves a MAYÚSCULAS; valores se conservan. */
    public void volverMayusculas( )
    {
        if (mapaCadenas.isEmpty()) return;
        Map<String,String> nuevo = new HashMap<>();
        for (Map.Entry<String,String> e : mapaCadenas.entrySet()) {
            nuevo.put(e.getKey().toUpperCase(), e.getValue());
        }
        mapaCadenas = nuevo;
    }

    /**
     * Verifica si el conjunto de valores del mapa coincide con el del arreglo,
     * ignorando repetidos y sin importar el orden.
     */
    public boolean compararValores( String[] otroArreglo )
    {
        // Construir lista de únicos del mapa (ordenada)
        List<String> valsMapa = new ArrayList<>(mapaCadenas.values());
        Collections.sort(valsMapa);
        List<String> unicosMapa = new ArrayList<>();
        for (String s : valsMapa) if (unicosMapa.isEmpty() || !unicosMapa.get(unicosMapa.size()-1).equals(s)) unicosMapa.add(s);

        // Construir lista de únicos del arreglo (ordenada)
        List<String> valsArg = new ArrayList<>();
        if (otroArreglo != null) {
            for (String s : otroArreglo) valsArg.add(s);
        }
        Collections.sort(valsArg);
        List<String> unicosArg = new ArrayList<>();
        for (String s : valsArg) if (unicosArg.isEmpty() || !unicosArg.get(unicosArg.size()-1).equals(s)) unicosArg.add(s);

        if (unicosMapa.size() != unicosArg.size()) return false;
        for (int i = 0; i < unicosMapa.size(); i++) {
            if (!unicosMapa.get(i).equals(unicosArg.get(i))) return false;
        }
        return true;
    }
}

