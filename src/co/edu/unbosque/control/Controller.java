package co.edu.unbosque.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Kruskal;
import co.edu.unbosque.model.Prim;
import co.edu.unbosque.view.MainView;

public class Controller implements ActionListener{
	
	private Prim p;
	private Kruskal graph;
	private MainView mainView;
	private Scanner sc;
	private int v,e;
	
	private int graphArray[][] = new int [][]{{ 0, 4, 0, 0, 0, 0, 0, 8, 0 } ,
		{ 4, 0, 8, 0, 0, 0, 0 , 11, 0 } ,
		{ 0, 8, 0, 7, 0, 4, 0, 0, 2 } ,
		{ 0, 0, 7, 0, 9, 14, 0, 0, 0 } ,
		{ 0, 0, 0, 9, 0, 10, 0, 0, 0 } ,
		{ 0, 0, 4, 14, 10, 0, 2, 0, 0 } ,
		{ 0, 0, 0, 0, 0, 2, 0, 1, 6 } ,
		{ 8, 11, 0, 0, 0, 0, 1, 0, 7 } ,
		{ 0, 0, 2, 0, 0, 0, 6, 7 , 0 }};
		
	
	public Controller() {
		
		mainView = new MainView();
		setListeners();
		p = new Prim();
		sc = new Scanner(System.in);
		/*
		System.out.println("Introduzca el número de vértices: ");
		
		v = sc.nextInt();
		
		System.out.println("Introduzca el número de bordes");
		
		e = sc.nextInt();
		
		graph = new Kruskal(v, e);*/
	}

	public void startupPrim() {
		p.designMST(graphArray);
	}

	public void startupKruskal() {
		
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
	
	public void setListeners() {
		mainView.getPrim().addActionListener(this);
		mainView.getKruskal().addActionListener(this);
		mainView.getViajero().addActionListener(this);
		mainView.getTarea().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch(e.getActionCommand()) {
		
		case"Prim":
			System.out.println("Prim");
			break;
		case"Kruskal":
			System.out.println("Kruskal");
			break;
		case"Viajante":
			System.out.println("Viajante");
			break;
		case"Asignación":
			System.out.println("Asignación");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Error");
			break;
		
		}
		
	}
}
