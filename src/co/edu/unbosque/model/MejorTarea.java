package co.edu.unbosque.model;

import java.util.Arrays;

public class MejorTarea {

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
	
	public boolean yaEscogida(boolean[][] asignacion, int tarea, int trabajador) {
	
		for(int i = 0; i < trabajador; i++) {
			if(asignacion[i][tarea]) {
				return true;
			}
		}
		return false;
	}

}
