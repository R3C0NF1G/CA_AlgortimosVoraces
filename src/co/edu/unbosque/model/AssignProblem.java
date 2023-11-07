package co.edu.unbosque.model;

import java.util.Arrays;

/**
 * {2, 7, 3, 1}
 * {8, 1, 4, 6}
 * {9, 3, 7, 2}
 * {1, 6, 5, 8}
 * 
 * 1. La mejor tarea (columna) para cada trabajador (fila)
 * 		Hallar el menor número de cada fila y restarle ese al resto de valores de la fila
 * 
 * @author RootSoftworks
 *
 */
public class AssignProblem {
	
//	private int[][] problem = { {15, 6, 2, 1},
//								{7, 17, 5, 9},
//								{9, 8, 10, 3},
//								{3, 1, 7, 11}};
	
	private int[][] problem = { {2, 7, 3, 1},
								{8, 1, 4, 6},
								{9, 3, 7, 2},
								{1, 6, 5, 8}};
	
	public AssignProblem() {
		
	}
	
	public void solve() {
		
		int min = 0;
		
		boolean isValid = false;
	
		
		for(int row = 0; row < problem.length; row++) {
			min = problem[row][0];
			for(int col = 0; col < problem[0].length; col++) {
				//System.out.print(problem[row][col]);
				//Columna a columna
				if(problem[row][col] < min) {
					min = problem[row][col];
				}
			}
			for(int colRestar = 0; colRestar < problem[0].length; colRestar++){//Restar el mínimo a cada elemento
				problem[row][colRestar] -= min;
				//System.out.print(problem[row][colRestar]);
			}
			//System.out.println("Mínimo de la fila " + row + ": " + min); //Funciona
			//Cambio de fila
			//System.out.println();
		}
		//Ya está la matriz lista para ver si se pueden asignar las tareas
		boolean ended = false;
		
		do {
			int zeroAmount = 0;
			int asignaciones[] = new int[problem.length]; //Array con las primeras asignaciones
			int listas[] =  new int[problem.length]; //Array con las filas que queden sin asignar
			
			for(int row = 0; row < problem.length; row++) {
				//Vamos trabajador por trabajador
				for(int col = 0; col < problem[0].length; col++) {
					if(problem[row][col] == 0) {
							//System.out.println("Asignado " + row + " la tarea " + col);
							if(listas[col] == 1) {
								continue;
							}else {
								asignaciones[row] = col;
								listas[col] = 1;
							}
							break;
					}
				}
			}
			//System.out.println(Arrays.toString(listas));
			//Miremos si todas las tareas fueron asignadas
			boolean solved = true;
			for(int i = 0; i < listas.length; i++) {
				if(listas[i] == 0) {
					solved = false;
				}
			}
			if(!solved) {
				//arreglar el problema
				for(int col = 0; col < problem.length; col++) {
					if(listas[col] == 0) {
						//Saquemos el mínimo de la columna
						int minAux = problem[0][col];
						for(int row = 0; row < problem.length; row++) {
							//System.out.println(problem[row][col]);
							//Aquí estamos parados en la columna sin asignar
							if(problem[row][col] == 0) {
								continue;
							}
							if(problem[row][col] < minAux) {
								minAux = problem[row][col];
							}
						}
						//System.out.println("Mínimo: " + minAux); //Funciona
						//Restarle el mínimo a cada elemento de la columna
						for(int row = 0; row < problem.length; row++) {
							if(problem[row][col] == 0) {
								continue;
							}
							problem[row][col] -= minAux;
							//System.out.println(problem[row][col]);
						}
					}
				}
			}else {
				ended = true;
			}
			
			for(int x : asignaciones) {
				System.out.print(x + ", ");
			}
			for(int col = 0; col < problem.length; col++) {
				for(int row = 0; row < problem.length; row++) {
					System.out.print(problem[col][row]);
				}
				System.out.println();
			}
			System.out.println();
		}while(!ended);
		
		
		//Falta: Agregar parte visual y el coste total de las actividades 
		//(Sumar los valores correspondientes de cada actividad que hará el recurso)
		
		
	}
}
