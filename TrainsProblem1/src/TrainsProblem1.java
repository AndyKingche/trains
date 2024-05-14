import java.util.Arrays;
import java.util.List;

public class TrainsProblem1 {

	public static void main(String[] args) {
		
		Grafo grafo = new Grafo();
		
		grafo.agergarArista('A', 'B', 5);
		grafo.agergarArista('B', 'C', 4);
		grafo.agergarArista('C', 'D', 8);
		grafo.agergarArista('D', 'C', 8);
		grafo.agergarArista('D', 'E', 6);
		grafo.agergarArista('A', 'D', 5);
		grafo.agergarArista('C', 'E', 2);
		grafo.agergarArista('E', 'B', 3);
		grafo.agergarArista('A', 'E', 7);
		
		List<List<Character>> camino = Arrays.asList(
				
				Arrays.asList('A','B','C'),
				Arrays.asList('A','D'),
				Arrays.asList('A','D','C'),
				Arrays.asList('A','E','B','C','D'),
				Arrays.asList('A','E','D')
				);
		
		
		for(int i=0; i < camino.size(); i++) {
			
			int result = grafo.obtenerDistanciaLista(camino.get(i));
			System.out.println("OUTPUT "+(i+1)+": "+(result == -1 ? "NO SUCH ROUTE" : result));
		}
		
		
		int rutasConPradasExactas = grafo.rutasConMaxParadas('C', 'C', 3);
		
		System.out.println("Number of trips starting at A and ending at C with exactly 4 stops: " + rutasConPradasExactas);
		
		int rutasConMaximasParadas = grafo.rutasConParadasFijas('A', 'C', 4);
		
		System.out.println("Number of trips starting at C and ending at C with a maximum of 3 stops: " + rutasConMaximasParadas);
		
		
		int rutaCorta = grafo.rutaCorta('A', 'C');
		
		System.out.println("Length of the shortest route from A to C: " + rutaCorta);
		
		int rutaCorta2 = grafo.rutaCorta('B', 'B');
		
		System.out.println("Length of the shortest route from B to B: " + rutaCorta2);
		
		int routesWithDistanceLessThan30 = grafo.rutasConDistanciaMenosde('C', 'C', 30);
		
		System.out.println("Number of different routes from C to C with a distance of less than 30: " + routesWithDistanceLessThan30);
		
	}

}
