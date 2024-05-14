import java.util.AbstractMap;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

//Grafo representado como un mapa donde la clave exterior es el nodo de inicio,
// y el mapa interior contiene los nodos de destino y las distancias correspondientes.

public class Grafo {

	private Map<Character, Map<Character, Integer>> rrecorrido = new HashMap<>();
	
	// Método para agregar una arista que es el conector entre nodos al grafo.
	
	public void agergarArista(char inicio, char fin, int distancia) {
		
		// Si no hay un mapeo para el nodo de inicio, se crea uno nuevo.
		rrecorrido.putIfAbsent(inicio, new HashMap<>());
		rrecorrido.get(inicio).put(fin, distancia);
		
	}
	
	/**
	 * Calcula la distancia total de una lista de caracteres que representan un camino
	 * @param camino Una lista de caracteres donde cada carácter representa un nodo en el camino.
	 * @return La distancia total del camino. Si un camino no existe, retorna -1.
	 * */
	public int obtenerDistanciaLista(List<Character> camino) {
		
		int distancia = 0;
		
		for(int i = 0; i<camino.size()-1; i++ ) {
			char inicio = camino.get(i);
			
			char fin = camino.get(i + 1);
			
			if(!rrecorrido.containsKey(inicio)|| !rrecorrido.get(inicio).containsKey(fin)) {
				return -1;
			}
			
			distancia += rrecorrido.get(inicio).get(fin);
					
			
	}
		
		return distancia;
	}
	
	
	/***
	 * Calcula el número de rutas desde un nodo inicial a un nodo final con un máximo de paradas.
	 * @param Es el nodo de inicio
	 * @param fin el nodo final
	 * @param maxParadas el numero maximo de paradas permitidas
	 * @return El número de rutas desde el nodo inicio al nodo fin con un máximo de paradas.
 */

	
	public int rutasConMaxParadas(char inicio, char fin, int maxParadas) {
		
		return contadordeRutasconMaxParadas(inicio, fin, maxParadas, 0);
	}
	
	
	/***
	 * Método recursivo que cuenta las rutas desde un nodo actual a un nodo final con un máximo de paradas.
	 * 
	 * @param posactual Es el nodo actual en el recorrido
	 * @param fin el nodo final
	 * @param maxParadas el número maximo de paradas permitido
	 * @param stops el numero actual de las paradas en la ruta
	 * @return el numero de rutas desde el nodo actual y al nodo final con un maximo de paradas.
	 */
	private int contadordeRutasconMaxParadas(char posactual, char fin, int maxParadas, int stops) {
		
		int contador = 0; 
		
		if(stops > maxParadas) {
			
			return 0;
		}
		
		if(posactual == fin && stops > 0) {
			
			return 1;
		}
		
		
		if(rrecorrido.containsKey(posactual)) {
			
			for( char siguiente: rrecorrido.get(posactual).keySet()) {
				
				contador += contadordeRutasconMaxParadas(siguiente,fin, maxParadas, stops + 1 );
			}
			
		}
		
		return contador;		
		
	}
	
	/***
	 * Calcula el número de rutas desde un nodo inicial a un nodo final con un número exacto de paradas.
	 * 
	 * @param inicio El nodo inicio
	 * @param fin El nodo Final
	 * @param paradasExactas El número exacto de paradas requerido
	 * @return El número de rutas desde el nodo inicio al nodo fin con un número exacto de paradas.
	 */
	
	public int rutasConParadasFijas(char inicio, char fin, int paradasExactas) {
		
		return contadordeRutasConParadasFijas(inicio, fin, paradasExactas, 0);
	}
	
	/***
	 * Método recursivo que cuenta las rutas desde un nodo actual a un nodo final con un número exacto de paradas.
	 * 
	 * @param posactual El nodo actual en el recorrido.
	 * @param fin El nodo final.
	 * @param paradasExactas El número exacto de paradas requerido.
	 * @param stops El número actual de paradas en la ruta.
	 * @return El número de rutas desde el nodo actual al nodo final con un número exacto de paradas.
	 */
	
	private int contadordeRutasConParadasFijas(char posactual, char fin, int paradasExactas, int stops) {
		
		int contador = 0;
		
		if(stops == paradasExactas && posactual == fin) {
			
			return 1;
		}
		
		if(stops >= paradasExactas) {
			
			return 0;
		}
		
		if(rrecorrido.containsKey(posactual)) {
			
			for( char siguiente: rrecorrido.get(posactual).keySet()) {
				
				contador += contadordeRutasConParadasFijas(siguiente,fin, paradasExactas, stops + 1 );
			}
			
		}
		
		return contador;		
		
	}
	
	/***
	 * Encuentra la distancia de la ruta más corta desde un nodo inicial a un nodo final.
	 * 
	 * @param inicio El nodo de inicio.
	 * @param fin El nodo final.
	 * @return La distancia de la ruta más corta desde el nodo inicio al nodo fin. Si no existe ruta, retorna -1.
	 */
	public int rutaCorta(char inicio, char fin) {
		
		return contadorRutaCorta(inicio, fin, new HashSet<>(),0, false);
	}
	/***
	 * Método recursivo que encuentra la distancia de la ruta más corta desde un nodo actual a un nodo final.
	 * 
	 * @param posicionActual El nodo actual en el recorrido.
	 * @param fin El nodo final.
	 * @param visitado Un conjunto de nodos visitados
	 * @param distancia La distancia acumulada en el recorrido hasta el nodo actual.
	 * @param hasvisited Indica si se ha visitado algún nodo en el recorrido.
	 * @return La distancia de la ruta más corta desde el nodo actual al nodo final. Si no existe ruta, retorna -1.
	 */
	private int contadorRutaCorta(char posicionActual, char fin, Set<Character> visitado, int distancia, boolean hasvisited) {
		
		if(posicionActual == fin && hasvisited) {
			return distancia;
		}
		
		//visitado.add(posicionActual);
		
		int result = Integer.MAX_VALUE;
		
		Map<Character,Integer> rutas = rrecorrido.get(posicionActual);
		
		for(Map.Entry<Character, Integer> ruta: rutas.entrySet() ) {
			
			if(!visitado.contains(ruta.getKey())|| (ruta.getKey() == fin && hasvisited)) {
				
				visitado.add(posicionActual);
				
				int rutaDistancia = contadorRutaCorta(ruta.getKey(), fin, new HashSet<>(visitado), distancia + ruta.getValue(), true);
				
				if(rutaDistancia < result ) {
					result = rutaDistancia;
				}
				
				visitado.remove(posicionActual);
			}
			
		}
		
		return result == Integer.MAX_VALUE ? -1 : result ;
	}
	
	
	/***
	 * Calcula el número de rutas desde un nodo inicial a un nodo final con una distancia máxima especificada.
	 * 
	 * @param inicio El nodo de inicio.
	 * @param fin El nodo final.
	 * @param maximaDistancia La distancia máxima permitida para la ruta.
	 * @return El número de rutas desde el nodo inicio al nodo fin con una distancia menor que la especificada.
	 */
	public int rutasConDistanciaMenosde(char inicio, char fin, int maximaDistancia) {
		
		return contadorRutaDistanciaMenosde(inicio, fin, maximaDistancia,0);
		
	}
	/***
	 * Método recursivo que cuenta las rutas desde un nodo actual a un nodo final con una distancia máxima especificada.
	 * 
	 * @param posactual El nodo actual en el recorrido.
	 * @param fin El nodo final.
	 * @param maxDistancia La distancia máxima permitida para la ruta.
	 * @param distancia La distancia acumulada en el recorrido hasta el nodo actual.
	 * @return El número de rutas desde el nodo actual al nodo final con una distancia menor que la especificada.
	 */
	private int contadorRutaDistanciaMenosde(char posactual, char fin, int maxDistancia, int distancia) {
		
		
		
		if(distancia >= maxDistancia) { 
			return 0;
		}
		int contador = 0;
		if(posactual == fin && distancia >0) {
			contador ++;
		}
		
		if(rrecorrido.containsKey(posactual)) {            
			for(char siguiente: rrecorrido.get(posactual).keySet()) {
				
				contador += contadorRutaDistanciaMenosde(siguiente, fin, maxDistancia, distancia + rrecorrido.get(posactual).get(siguiente));
			}
			
		}
		
		return contador;
	}
	
}
