package co.edu.unbosque.model;

import java.util.ArrayList;

/**
 * Creamos una clase llamada TravellingSalesmanProblem para contener la logica principal del algoritmo del agente viajero.
 * 
 * @author RootSoftworks
 */
public class TravellingSalesmanProblem {
	
	/**
	 * Este metodo toma un objeto Graph como entrada y devuelve una lista de enteros que representa la ruta optima.
	 * Inicializamos un conjunto de variables y estructuras de datos, como una lista para almacenar la ruta, 
	 * un arreglo booleano para rastrear las ciudades visitadas y una variable para almacenar la 
	 * ciudad actual (comenzamos en la ciudad 0).
	 * 
	 * Usamos un bucle para encontrar la ruta optima. En cada iteracion, buscamos la siguiente ciudad a visitar.
	 * Iteramos sobre todas las ciudades disponibles que aun no han sido visitadas.
	 * Encontramos la ciudad no visitada con la distancia minima desde la ciudad actual.
	 * Agregamos la ciudad encontrada a la ruta y la marcamos como visitada. Actualizamos la ciudad actual.
	 * 
	 * Una vez que se han visitado todas las ciudades, volvemos a la ciudad de inicio agregandola 
	 * al final de la lista de la ruta.
	 * 
	 * @param grafo
	 * @return
	 */
	public static ArrayList<Integer> findRoute(Graph grafo) {
        int n = grafo.getNumCities();
        ArrayList<Integer> ruta = new ArrayList<>();
        boolean[] visitado = new boolean[n];
        int actual = 0; // ciudad 0

        ruta.add(actual);
        visitado[actual] = true;

        for (int i = 1; i < n; i++) {
            int siguienteCiudad = -1;
            int distanciaMinima = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
            	System.out.println("Ob distancia de actual: "+actual+", j: "+j+". Met: "+grafo.getDistance(actual, j));
            	System.out.println("Distancia minima: "+distanciaMinima+"\n");
                if (!visitado[j] && grafo.getDistance(actual, j) < distanciaMinima) {
                	System.out.println("Entró\n");
                    siguienteCiudad = j;
                    distanciaMinima = grafo.getDistance(actual, j);
                }
            }
            
            System.out.println("Con i: "+i+", siguiente ciudad: "+siguienteCiudad+"\n");

            if (siguienteCiudad != -1) {
                ruta.add(siguienteCiudad);
                visitado[siguienteCiudad] = true;
                actual = siguienteCiudad;
            }
        }

        // Regresar a la ciudad de inicio
        ruta.add(ruta.get(0));

        return ruta;
    }

}
