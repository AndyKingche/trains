# Trains

Este proyecto es parte de un proceso de selección para acceder a un puesto de trabajo. Se trata de una prueba de Java que demuestra mis habilidades y competencias en este lenguaje de programación.

## Descripción del Problema

El problema de los trenes consiste en calcular varias métricas relacionadas con un sistema ferroviario de ciudades interconectadas. Se nos proporciona un conjunto de rutas entre diferentes ciudades, cada una con una distancia asociada. Las métricas que debemos calcular incluyen la distancia de una ruta específica, el número de viajes entre dos ciudades con ciertas restricciones y la ruta más corta entre dos ciudades.

## Cómo Ejecutar el Programa

Para ejecutar el programa, sigue estos pasos:

1. Asegúrate de tener instalado Java en tu sistema (versión 11).
2. Clona este repositorio en tu máquina local.
3. Abre el proyecto en tu editor favorito.
4. Ejecuta el proyecto.

## Estructura del Código

El código se divide en las siguientes clases:

### Grafo

- `Grafo.java`: Esta clase representa el grafo de las rutas del tren y contiene los métodos para resolver los problemas planteados.

#### Métodos

- `agergarArista(char inicio, char fin, int distancia)`: Agrega una arista al grafo que representa una ruta entre dos ciudades con una distancia especificada.
- `obtenerDistanciaLista(List<Character> camino)`: Calcula la distancia total de un camino especificado en el grafo.
- `contadordeRutasconMaxParadas(char posactual, char fin, int maxParadas, int stops)`: Calcula el número de rutas entre dos ciudades con un máximo de paradas especificado.
- `contadordeRutasConParadasFijas(char posactual, char fin, int paradasExactas, int stops)`: Calcula el número de rutas entre dos ciudades con un número exacto de paradas especificado.
- `contadorRutaCorta(char posicionActual, char fin, Set<Character> visitado, int distancia, boolean hasvisited)`: Encuentra la ruta más corta entre dos ciudades en el grafo.
- `contadorRutaDistanciaMenosde(char posactual, char fin, int maxDistancia, int distancia)`: Calcula el número de rutas entre dos ciudades con una distancia total menor que la especificada.

### GrafoTest

- `GrafoTest.java`: Esta clase contiene los casos de prueba unitarios para la clase `Grafo`, que representa el grafo de las rutas del tren. Los métodos de esta clase prueban la funcionalidad de los diversos métodos de la clase `Grafo` para asegurarse de que funcionen correctamente según lo esperado.

#### Métodos de Prueba

- `testObtenerDistanciaLista()`: Verifica que el método `obtenerDistanciaLista()` calcule correctamente la distancia total de un camino especificado en el grafo.
- `testRutasConMaxParadas()`: Verifica que el método `testRutasConMaxParadas()` calcule correctamente la distancia total de rutas entre dos ciudades con un máximo de paradas especificado..
- `testRutasConParadasFijas()`: Verifica que el método `testRutasConParadasFijas()` calcule correctamente la distancia total de rutas entre dos ciudades con un número exacto de paradas especificado.
- `testRutaCorta()`: Verifica que el método `testRutaCorta()` calcule correctamente la distancia total de la ruta más corta entre dos ciudades en el grafo.
- `testRutasConDistanciaMenosde()`: Verifica que el método `testRutasConDistanciaMenosde()` calcule correctamente las rutas entre dos ciudades con una distancia total menor que la especificada.


### TrainsProblem1

- `TrainsProblem1.java`: Esta clase contiene el método `main()` que instancia y utiliza la clase `Grafo` para resolver el problema de los trenes.

