package co.edu.unbosque.model;


/**
 * Esta clase contiene la implementacion de la solucion al problema de asignacion de trabajadores.
 * El problema consiste en que dada una matriz de costos, se busca asignar el trabajador más óptimo para cada tarea, donde las tareas son las columnas y los trabajadores son las filas.
 * @author RootSoftworks
 *
 */
public class MejorTrabajador {
	
	
	/**
	 * Este metodo contiene la implementacion voraz de la solucion del problema.
	 * Se definen dos matrices, una que es la de los costos, es decir, de numeros enteros, y otra que es booleana, que representa los trabajadores que ya se les asigno una tarea.
	 * @return Matriz booleana
	 */
	public  boolean[][] asignacionOptima() {
		int tarea;
		
		int[][] costos = {{16, 20, 18},
				 {11, 15, 17},
				 {17, 1, 20}};

		boolean[][] asignacion = {{false, false, false},
						{false, false, false},
						{false, false, false}};

		
		for(tarea = 0; tarea < costos.length; tarea++) {
			asignacion[mejorTrabajador(costos, asignacion, tarea)][tarea] = true;
		}
		
//		for(int i = 0; i < asignacion.length; i++) {
//			for(int j = 0; j < asignacion[0].length; j++) {
//				System.out.print("[" + asignacion[i][j] + "] ");
//			}
//			System.out.println();
//		}
		return asignacion;
	}
	/**
	 * Este método revisa cuál es el trabajador que hace la tarea con un menor costo.
	 * Para ello, revisa columna por columna cuál es el menor valor de costo, y se lo asigna a esa tarea.
	 * Pero antes, se asegura de que ese trabajador no esté asignado aun a ninguna tarea, pero si esa tarea ya la está realizando otro trabajador, entonces le asigna la segunda mejor tarea.
	 * @param i
	 * @param costos
	 * @param asignacion
	 * @return
	 */
	public int mejorTrabajador(int[][] costos, boolean[][] asignacion, int i) {
		int trabajador, min, mejorTrabajador = 0;
		
		min = Integer.MAX_VALUE;
		
		for(trabajador = 0; trabajador < costos.length; trabajador++) {
			if(!yaEscogida(asignacion, trabajador, i) && costos[trabajador][i] < min) {
				min = costos[trabajador][i];
				mejorTrabajador = trabajador;
			}
		}
		
		return mejorTrabajador;
	}
	
	/**
	 * Este metodo revisa que no haya otro trabajador con la misma tarea asignada.
	 * Si ya esa tarea tiene trabajador, retorna true.
	 * Si no tiene un trabajador asignado, retorna false.
	 * @param asignacion
	 * @param trabajador
	 * @param tarea
	 * @return
	 */
	public boolean yaEscogida(boolean[][] asignacion, int trabajador, int tarea) {
	
		for(int i = 0; i < tarea; i++) {
			if(asignacion[trabajador][i]) {
				return true;
			}
		}
		return false;
	}

}

