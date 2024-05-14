import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GrafoTest {

	private Grafo grafo;

    @Before
    public void setUp() {
        grafo = new Grafo();
        
		grafo.agergarArista('A', 'B', 5);
		grafo.agergarArista('B', 'C', 4);
		grafo.agergarArista('C', 'D', 8);
		grafo.agergarArista('D', 'C', 8);
		grafo.agergarArista('D', 'E', 6);
		grafo.agergarArista('A', 'D', 5);
		grafo.agergarArista('C', 'E', 2);
		grafo.agergarArista('E', 'B', 3);
		grafo.agergarArista('A', 'E', 7);
    }

    @Test
    public void testObtenerDistanciaLista() {
 
        List<Character> camino1 = Arrays.asList('A', 'B', 'C');
        List<Character> camino2 = Arrays.asList('A', 'D');
        List<Character> camino3 = Arrays.asList('A', 'D', 'C');
        List<Character> camino4 = Arrays.asList('A','E','B','C','D');
        List<Character> camino5 = Arrays.asList('A','E','D');
        
        assertEquals(9, grafo.obtenerDistanciaLista(camino1));
        assertEquals(5, grafo.obtenerDistanciaLista(camino2));
        assertEquals(13, grafo.obtenerDistanciaLista(camino3));
        assertEquals(22, grafo.obtenerDistanciaLista(camino4));
        
        // Prueba de un camino no existente
        assertEquals(-1, grafo.obtenerDistanciaLista(camino5));
    }

    @Test
    public void testRutasConMaxParadas() {
        assertEquals(2, grafo.rutasConMaxParadas('C', 'C', 3));        
        // Prueba de un nodo sin rutas
        assertEquals(0, grafo.rutasConMaxParadas('E', 'A', 2));
    }

    @Test
    public void testRutasConParadasFijas() {
    	assertEquals(3, grafo.rutasConParadasFijas('A', 'C', 4));    
        // Prueba de un nodo sin rutas
        assertEquals(0, grafo.rutasConParadasFijas('E', 'A', 2));
    }

    @Test
    public void testRutaCorta() {
        assertEquals(9, grafo.rutaCorta('A', 'C'));
        assertEquals(9, grafo.rutaCorta('B', 'B'));
        // Prueba de un nodo sin ruta
        assertEquals(-1, grafo.rutaCorta('E', 'A'));
    }

    @Test
    public void testRutasConDistanciaMenosde() {
        assertEquals(7, grafo.rutasConDistanciaMenosde('C', 'C', 30));      
        // Prueba de un nodo sin rutas
        assertEquals(0, grafo.rutasConDistanciaMenosde('E', 'A', 10));
    }
}
