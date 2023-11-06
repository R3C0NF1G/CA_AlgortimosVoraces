package co.edu.unbosque.model;

/**
 * Creamos una clase llamada Graph que representa el grafo dirigido.
 * 
 * @author RootSoftworks
 */
public class Graph {
	
	private int nCities;
	private int[][] distances;
	
	/**
	 * El constructor de la clase Graph toma el numero de ciudades como parametro e inicializa 
	 * el tamaño del arreglo bidimensional distances para almacenar las distancias entre ciudades.
	 * 
	 * @param nCities
	 */
	public Graph(int nCities) {
		this.nCities = nCities;
		distances = new int[nCities][nCities];
	}
	
	/**
	 * El metodo addDistance permite agregar distancias entre las ciudades. 
	 * Dado que el grafo es no dirigido, almacenamos la distancia tanto desde la ciudad origen 
	 * hasta la ciudad destino como desde la ciudad destino hasta la ciudad origen.
	 * 
	 * @param fromCity
	 * @param toCity
	 * @param distance
	 */
	public void addDistance(int fromCity, int toCity, int distance) {
		distances[fromCity][toCity] = distance;
		distances[toCity][fromCity] = distance;
	}
	
	/**
	 * El metodo getDistance permite obtener la distancia entre dos ciudades.
	 * 
	 * @param fromCity
	 * @param toCity
	 * @return
	 */
	public int getDistance(int fromCity, int toCity) {
		return distances[fromCity][toCity];
	}
	
	/**
	 * El metodo getNumCities devuelve el numero de ciudades en el grafo.

	 * 
	 * @return
	 */
	public int getNumCities() {
		return nCities;
	}

}
