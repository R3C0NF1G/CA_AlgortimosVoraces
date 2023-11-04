package co.edu.unbosque.model;

import java.util.Arrays;

public class Kruskal {
	
	// Inicializar vértices, aristas y edgeArray  

	public Edge edgeArray[];
	public Subset subset;
	int v;
	int edges;
	
	// Uso del constructor para crear un árbol o gráfico
	
	public Kruskal(int v, int edges) {
		
		this.v = v;
		this.edges = edges;
		edgeArray = new Edge[this.edges];
		
		for (int i = 0; i < edges; ++i)
			edgeArray[i] = new Edge(); // Crear arista para todas las aristas dadas por el usuario
		
	}
	
	// Crear applyKruskal() para aplicar el algoritmo de Kruskal  
	
	public void applyKruskal() {
		
		// Inicializar finalResult array para almacenar el MST final 
		
		Edge finalResult[] = new Edge[v];
		int newEdge = 0;
		int index = 0;
		
		for (index = 0; index < v; ++index)
			finalResult[index] = new Edge();
		
		
		// Uso del método sort() para ordenar los bordes  
		
		Arrays.sort(edgeArray);
		
		// Crear una matriz de vértices de tipo Subconjunto para los subconjuntos de vértices 
		
		Subset subsetArray[] = new Subset[v];
		
		// Asignar memoria para crear subconjuntos de vértices
		
		for (index = 0; index < v; ++index)
			subsetArray[index] = new Subset();
		
		//  Se utiliza para crear un subconjunto con un solo elemento  
		
		for (int vtx = 0; vtx < v; ++vtx) {
			subsetArray[vtx].parent = vtx;
			subsetArray[vtx].value = 0;
			
		}
		
		index = 0;
	
	
		/* Uso del bucle while para elegir el borde más pequeño de los bordes 
		 * e incrementar el índice para la siguiente iteración
		 */
		
		while (newEdge < v -1) {
		
			// Crear una instancia de Edge para el siguiente borde
			
			Edge nextEdge = new Edge();
			nextEdge = edgeArray[index++];
			
		int nextSource = findSetOfElement(subsetArray, nextEdge.source);
		
		int nextDestination = findSetOfElement(subsetArray, nextEdge.destination);
		
		// Si el borde no crea un ciclo después de incluirlo, lo agregamos en el resultado e incrementamos el índice
		
		if(nextSource != nextDestination) {
			
			finalResult[newEdge++] = nextEdge;
			
			performUnion(subsetArray, nextSource, nextDestination);
				
		}
	}
		
		for(index = 0; index < newEdge; ++index)
			System.out.println(finalResult[index].source + " - " + finalResult[index].destination + ": " + finalResult[index].weight);
}
	
	// Crear findSetOfElement() para obtener el conjunto de un elemento 
	
	public int findSetOfElement(Subset subsetArray[], int i) {
		
		if(subsetArray[i].parent != i) 
			
			subsetArray[i].parent = findSetOfElement(subsetArray, subsetArray[i].parent);  
		
		return subsetArray[i].parent;  
		
	}
	
	// Crear performUnion() para realizar la unión de dos conjuntos  
	
	public void performUnion(Subset subsetArray[], int sourceRoot, int destinationRoot) {
		
		int nextSourceRoot = findSetOfElement(subsetArray, sourceRoot);
		
		int nextDestinationRoot = findSetOfElement(subsetArray, destinationRoot);
		
		if(subsetArray[nextSourceRoot].value < subsetArray[nextDestinationRoot].value)
			
			subsetArray[nextSourceRoot].parent = nextDestinationRoot;
		
		else if(subsetArray[nextSourceRoot].value > subsetArray[nextDestinationRoot].value)
			
			subsetArray[nextDestinationRoot].parent = nextSourceRoot;
		
		else {
			
			subsetArray[nextDestinationRoot].parent = nextSourceRoot;  
			
            subsetArray[nextSourceRoot].value++;  
            
		}
	}
}
