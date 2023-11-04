package co.edu.unbosque.model;

public class Prim {

	
	// Definir el número de vértices disponibles en el grafo
	
	private static final int countOfVertices = 9;
	
	
	/* Crear findMinKeyVertex() para encontrar el vértice v que tiene
	 * un valor de clave mínimo y que aún no se ha agregado MST  
	 */
	
	public int findMinKeyVertex(int keys[], boolean setOfMST[]) {
		
		// Inicializar el valor mínimo y su índice
		
		int min_index = -1;
		
		int min_value = Integer.MAX_VALUE;
		
		
		// Iterar sobre todos los vértices para encontrar el vértice clave-valor mínimo  
		
		for (int v = 0; v <countOfVertices; v++ )
		if (setOfMST[v] == false && keys[v] < min_value) {
			min_value = keys[v];
			min_index = v;
			
		}
		
		return min_index;
		
	}
	
	// Crear showMinimumSpanningTree para imprimir el MST construido almacenado en mstArray[]
	
	public void showMinimunSpanningTree(int mstArray[], int graphArray[][]) {
		
		System.out.println("Borde \t\t Peso");
		
		for (int j = 1; j < countOfVertices; j++) 
		
			System.out.println(mstArray[j]+ " <-> " + j + "\t\t" + graphArray[j][mstArray[j]]);
		
	}
	
	/* Crear designMST() para construir e imprimir el MST. graphArray[][] es una matriz de adyacencia 
	 * que define el grafo para MST. 
	 */
	
	public void designMST(int graphArray[][]) {
		
		// Crear una matriz de tamaño del número total de vértices, es decir, countOfVertices para almacenar el MST 
		
		int mstArray[] = new int [countOfVertices];
		
		// Crear keys[] para seleccionar una arista que tenga un peso mínimo en el corte 
		
		int keys[] = new int [countOfVertices];
	
		// Crear setOfMST array de tipo booleano para representar el conjunto de vértices incluidos en MST
		
		boolean setOfMST[] = new boolean [countOfVertices];
		
		// Establezca el valor de las claves en infinito   
		
		for (int j = 0; j < countOfVertices; j++) {
			keys[j] = Integer.MAX_VALUE;
			setOfMST[j] = false;
			
		}
		
		// Establezca el valor 0 en el 1er vértice porque los primeros vértices siempre se incluyen en MST.
		
		keys[0] = 0; // Se selecciona como primer vértice
		
		mstArray[0] = -1; // Establece el primer valor de mstArray en -1 para convertirlo en la raíz de MST
		
		// Los vértices en el MST serán iguales a countOfVértices 
		
		for (int i = 0; i < countOfVertices -1; i++) {
			
			// Seleccione el vértice que tiene clave mínima y que aún no se agrega en el MST del conjunto de vértices
			
			int edge = findMinKeyVertex(keys, setOfMST);
			
			// Agregue el vértice de clave mínima seleccionado a setOfMST  
			
			setOfMST[edge] = true;
			
			/* Cambie el valor de clave y el índice primario de todos los vértices adyacentes del vértice seleccionado. 
			 * Solo se tienen en cuenta los vértices que aún no están incluidos en el árbol de expansión mínimo.   
			 */
			
			for (int vtx = 0; vtx < countOfVertices; vtx++ )

				/* El valor de graphArray[edge][vertex] es distinto de cero solo para los vértices adyacentes de m setOfMST[vertex] es false para los vértices que aún no están incluidos en el árbol de expansión mínimo   
                 * cuando el valor de graphArray[edge][vertex] es menor que key[vertex], actualizamos la clave  
				 */
				
				if(graphArray[edge][vtx] != 0 && setOfMST[vtx] == false && graphArray[edge][vtx] < keys[vtx]) {
					
					mstArray[vtx] = edge;
					
					keys[vtx] = graphArray[edge][vtx];
					
					
				}
	
			}
		
		// Imprimir el árbol de expansión mínimo construido   
		
		showMinimunSpanningTree(mstArray, graphArray);

	}

}