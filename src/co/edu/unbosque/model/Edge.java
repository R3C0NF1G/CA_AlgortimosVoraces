package co.edu.unbosque.model;

/**
 * La clase `Edge` representa una arista en un grafo ponderado. Implementa la interfaz Comparable
 * para permitir la comparación de bordes basada en sus pesos.
 * 
 * @author RootSoftworks
 */

public class Edge implements Comparable<Edge> {

	/*
	 * Source: Identificador del vértice fuente de la arista.
	 * Destination: Identificador del vértice destino de la arista.
	 * Weight: Peso de la arista.
	 */
	
	public int source, destination, weight; 
	
	 /**
     * Compara dos bordes basándose en sus pesos.
     *
     * @param edgeToCompare Borde a comparar con el borde actual.
     * @return Un valor negativo si el peso del borde actual es menor que el peso del borde comparado,
     *         cero si son iguales, y un valor positivo si el peso del borde actual es mayor.
     */
	
	
	@Override
	public int compareTo(Edge edgeToCompare) {
		// TODO Auto-generated method stub
		return this.weight - edgeToCompare.weight;
	}

}
