package co.edu.unbosque.model;

import javax.swing.JOptionPane;

/**
 * Creamos una clase llamada Prim para contener la logica principal del algoritmo de prim.
 * 
 * @author RootSoftworks
 */

public class Prim {

	private int num_verts; // Número de vértices en el grafo. 	
	private int min_index;	// Índice del vértice con el valor mínimo.
	private int min_value; // Valor mínimo encontrado.
	public int graphArray[][]; // Matriz de adyacencia que representa el grafo.

	
	/**
     * Constructor de la clase Prim. Inicializa el número de vértices y la matriz de adyacencia.
     */
	
	public Prim() {
		
		this.num_verts = num_verts;
		graphArray = new int [num_verts][num_verts];
		this.min_index = 0;
		this.min_value = 0;
		
	}
	
	/**
     * Este método implementa el algoritmo de Prim para crear el árbol de expansión mínimo del grafo ponderado.
     *
     * @param graphArray Matriz de adyacencia que representa el grafo ponderado.
     */
	
	public void createMinSpanningTree (int graphArray[][]) {
		
		
		/**
		*  1. Se inicializan las variables num_verts, mstArray, keys y setOfMst.
		*  2. Num_verts representa el número de vértices en el grafo, y los arreglos mstArray, 
		*  keys y setOfMst se utilizan para almacenar el MST (Arbol de expansion mínimo), 
		*  los valores clave y el conjunto de vértices incluidos en el MST, respectivamente.
		*/
		
		num_verts = graphArray.length;
		
		int mstArray[] = new int [num_verts];
		
		int keys[] = new int [num_verts];
		
		Boolean setOfMst[] = new Boolean [num_verts];
		
		/**
		* El arreglo keys se inicializa con valores enteros máximos, 
		* y setOfMst se inicializa con false para todos los vértices.
		*/
		
		for (int j = 0; j < num_verts; j++) {
			
			keys[j] = Integer.MAX_VALUE;
			
			setOfMst[j] = false;
			
		}
	
		keys[0] = 0; //El valor clave del primer vértice se establece en 0
		
		mstArray[0] = -1; // mstArray[0] se establece en -1 ya que el primer vértice no tiene un padre en el MST.
		
		//Prim's Algorithm:
		
		/*
		 * Esta parte del código implementa el núcleo del algoritmo de Prim. 
		 * Iterativamente selecciona el vértice clave mínimo del conjunto de vértices aún no incluidos en el MST 
		 * (findMinVertex método), lo incluye en el MST y actualiza los valores clave de sus vértices adyacentes 
		 * si no están en el MST y el peso del borde es menor que el valor clave actual.
		 */
		
		for (int i = 0; i < num_verts - 1; i++) {  //Este bucle se encarga de agregar num_verts - 1 aristas al MST.
			
			int edge = findMinVertex(keys, setOfMst); //
			
			setOfMst[edge] = true; //El vértice edge se marca como parte del MST al establecer setOfMst[edge] en true.
			
			/*
			 * Este bucle interno itera sobre todos los vértices en el grafo. 
			 * Para cada vértice verifica si hay una arista entre el vértice actual edge y vertex 
			 * (graphArray[edge][vertex] != 0) También verifica si el vértice aún no está en el MST 
			 * (!setOfMst[vertex]) y si el peso de la arista entre edge y vertex es menor que el valor 
			 * clave del vértice (graphArray[edge][vertex] < keys[vertex]).
			 */
			
			for (int vertex = 0; vertex < num_verts; vertex++) {
				
				//Si se cumplen las siguientes condiciones entonces:
				
				if(graphArray[edge][vertex] != 0 && !setOfMst[vertex] && graphArray[edge][vertex] < keys[vertex]) {
					
					/*
					 * 1. mstArray[vertex] se establece en edge, indicando que la arista que conecta edge y vertex es parte del MST.
					 * 2. El valor clave del vértice (keys[vertex]) se actualiza con el peso de la arista.
					 */
					
					mstArray[vertex] = edge;
					
					keys[vertex] = graphArray[edge][vertex];
				}
				
			}
			
		}
		
		/*
		 * Después de que el bucle externo se completa, se llama a la función printMst para imprimir el árbol 
		 * de expansión mínimo, utilizando la información almacenada en mstArray y graphArray.
		 */
		
		printMst(mstArray, graphArray);
		
	}
	
	/**
     * Encuentra el vértice con el valor mínimo en las claves que aún no se han incluido en el árbol de expansión mínimo.
     *
     * @param keys      Arreglo de claves de los vértices.
     * @param setOfMst  Arreglo booleano que indica si el vértice ya está en el árbol de expansión mínimo.
     * @return Índice del vértice con el valor mínimo.
     */
	
	public int findMinVertex(int keys[], Boolean setOfMst[]) {
		
		min_index = -1;
		
		min_value = Integer.MAX_VALUE;
		
		for (int vertex = 0; vertex < keys.length; vertex++) {
			
			if(!setOfMst[vertex] && keys[vertex] < min_value) {
				
				min_value = keys[vertex];
				
				min_index = vertex;
			}
		}
		
		return min_index;
	}
	
	 /**
     * Imprime el árbol de expansión mínimo en una ventana emergente.
     *
     * @param mstArray   Arreglo que almacena el árbol de expansión mínimo.
     * @param graphArray Matriz de adyacencia que representa el grafo ponderado.
     */
	
	public void printMst(int mstArray[], int graphArray[][]) {

	    StringBuilder output = new StringBuilder ("|BORDE| \t |PESO|\n");

	    for (int j = 1; j < mstArray.length; j++) {
	    	
	    	String edge = mstArray[j] + " < - > " + j;
	    	
	    	String weight = String.valueOf(graphArray[j][mstArray[j]]);
	    	
	    	int spaces = 12 - edge.length();
	    	
	    	output.append(edge);
	    	
	    	for (int i = 0; i < spaces; i++) {
				
	    		output.append("   ");
	    		
			}
	    	
	    	output.append(weight).append("\n");
	    	
	    }

	    JOptionPane.showMessageDialog(null, output.toString());
	}
}
