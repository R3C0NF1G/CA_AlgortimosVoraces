package co.edu.unbosque.model;


public class MejorTrabajador {
	
	
	public  boolean[][] asignacionOptima() {
		int trabajador, tarea;
		
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
	
	public boolean yaEscogida(boolean[][] asignacion, int trabajador, int tarea) {
	
		for(int i = 0; i < tarea; i++) {
			if(asignacion[trabajador][i]) {
				return true;
			}
		}
		return false;
	}

}

