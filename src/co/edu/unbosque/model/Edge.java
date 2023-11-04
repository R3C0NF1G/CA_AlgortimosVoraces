package co.edu.unbosque.model;

// Crear class Edge para crear un borde del grafo que implementa la interfaz Comparable  

public class Edge implements Comparable<Edge> {

	public int source, destination, weight;
	
	@Override
	public int compareTo(Edge edgeToCompare) {
		// TODO Auto-generated method stub
		return this.weight - edgeToCompare.weight;
	}

}
