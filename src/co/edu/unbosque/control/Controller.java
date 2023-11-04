package co.edu.unbosque.control;

import java.util.Scanner;

import co.edu.unbosque.model.Kruskal;
import co.edu.unbosque.model.Prim;

public class Controller {

	Prim p;
	Kruskal graph;
	
	int graphArray[][] = new int [][]{{ 0, 4, 0, 0, 0, 0, 0, 8, 0 } ,
		{ 4, 0, 8, 0, 0, 0, 0 , 11, 0 } ,
		{ 0, 8, 0, 7, 0, 4, 0, 0, 2 } ,
		{ 0, 0, 7, 0, 9, 14, 0, 0, 0 } ,
		{ 0, 0, 0, 9, 0, 10, 0, 0, 0 } ,
		{ 0, 0, 4, 14, 10, 0, 2, 0, 0 } ,
		{ 0, 0, 0, 0, 0, 2, 0, 1, 6 } ,
		{ 8, 11, 0, 0, 0, 0, 1, 0, 7 } ,
		{ 0, 0, 2, 0, 0, 0, 6, 7 , 0 }};
		
		int v,e;
		Scanner sc;
	
	public Controller() {
		
		p = new Prim();
		sc = new Scanner(System.in);
		
		System.out.println("Introduzca el número de vértices: ");
		
		v = sc.nextInt();
		
		System.out.println("Introduzca el número de bordes");
		
		e = sc.nextInt();
		
		graph = new Kruskal(v, e);
	}

	public void startupPrim() {
		// TODO Auto-generated method stub
		p.designMST(graphArray);
	}

	public void startupKruskal() {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < e; i++) {
			System.out.println("Introduzca el valor de origen para Edge(Borde/s)[" + i + "]");
			graph.edgeArray[i].source = sc.nextInt();
			
			System.out.println("Introduzca el valor de destino para Edge(Borde/s)[" + i + "]");
			graph.edgeArray[i].destination = sc.nextInt();
			
			System.out.println("Introduzca el peso para Edge(Borde/s)[" + i + "]");
			graph.edgeArray[i].weight = sc.nextInt();
		}
		
		graph.applyKruskal();
	}
}
