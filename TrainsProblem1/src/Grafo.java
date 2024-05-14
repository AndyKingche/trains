import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo {

	private Map<Character, Map<Character, Integer>> rrecorrido = new HashMap<>();
	
	public void agergarArista(char inicio, char fin, int distancia) {
		rrecorrido.putIfAbsent(inicio, new HashMap<>());
		rrecorrido.get(inicio).put(fin, distancia);
		
	}
	
	public int obtenerDistancia(List<Character> camino) {
		
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
	
}
