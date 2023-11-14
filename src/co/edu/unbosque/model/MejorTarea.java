package co.edu.unbosque.model;

import java.util.Arrays;

/**
 * Esta clase contiene la implementacion de la solucion para el problema de asignacion de tareas, realizada con un enfoque voraz
 * El problema trata de que dada una matriz de costos, se debe asignar la mejor tarea a cada trabajador, donde las tareas son las columnas y los trabajadores las filas
 * @author RootSoftworks
 *
 */
public class MejorTarea {

	/**
	 * Este método contiene la solucion del problema. 
	 * Primero, define la matriz de costos que se quiere resolver.
	 * Se utiliza una matriz de valores booleanos que sera del mismo tamaño que la de costos.
	 * Esta matriz representa las posiciones de la matriz de costo que no han sido asignadas aún.
	 * @return Matriz booleana
	 */
	public boolean[][] asignacionOptima() {
		int trabajador, tarea;
		
		int[][] costos = {{16, 20, 18},
				 {11, 15, 17},
				 {17, 1, 20}};

		boolean[][] asignacion = {{false, false, false},
						{false, false, false},
						{false, false, false}};

		
		for(trabajador = 0; trabajador < costos.length; trabajador++) {
			asignacion[trabajador][mejorTarea(trabajador, costos, asignacion)] = true;
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
	 * Este método revisa cuál es la mejor tarea que se le puede asignar a un trabajador.
	 * Para ello, revisa fila por fila cuál es el menor valor de costo, y se lo asigna a ese trabajador.
	 * Pero antes, se asegura de que esa tarea no esté asignada aún a ningún otro trabajador, si está asignada, entonces le asignará la segunda mejor tarea que puede hacer.
	 * @param trabajador
	 * @param costos
	 * @param asignacion
	 * @return
	 */
	public int mejorTarea(int trabajador, int[][] costos, boolean[][] asignacion) {
		int tarea, min, mejorTarea = 0;
		
		min = Integer.MAX_VALUE;
		
		for(tarea = 0; tarea < costos.length; tarea++) {
			if(!yaEscogida(asignacion, tarea, trabajador) && costos[trabajador][tarea] < min) {
				min = costos[trabajador][tarea];
				mejorTarea = tarea;
			}
		}
		
		return mejorTarea;
	}
	
	/**
	 * Este método revisa que la tarea que se quiere asignar a un trabajador no haya sido asignada a ningún otro trabajador.
	 * Devuelve true si la tarea ya fue asignada.
	 * Devuelve false si la tarea aún no ha sido asignada.
	 * @param asignacion
	 * @param tarea
	 * @param trabajador
	 * @return
	 */
	public boolean yaEscogida(boolean[][] asignacion, int tarea, int trabajador) {
	
		for(int i = 0; i < trabajador; i++) {
			if(asignacion[i][tarea]) {
				return true;
			}
		}
		return false;
	}

}
