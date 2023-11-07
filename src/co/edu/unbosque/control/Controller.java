package co.edu.unbosque.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Kruskal;
import co.edu.unbosque.model.Prim;
import co.edu.unbosque.model.TaskProblem;
import co.edu.unbosque.model.TaskProblem.Task;
import co.edu.unbosque.model.TravellingSalesmanProblem;
import co.edu.unbosque.view.MainView;
import co.edu.unbosque.view.PrimView;
import co.edu.unbosque.model.Graph;

public class Controller implements ActionListener{
	
	private Prim p;
	private Kruskal graph;
	private TaskProblem taskProblem;
	private MainView mainView;
	private PrimView primView;
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
		primView = new PrimView();
		setListeners();
		p = new Prim();
		taskProblem = new TaskProblem();
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
			mainView.setVisible(false);
			primView.setVisible(true);
			break;
		case"Kruskal":
			System.out.println("Kruskal");
			break;
		case"Viajante":
			int nCities;
			try {
				nCities = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de ciudades"));
			}catch(NumberFormatException ee) {
				JOptionPane.showMessageDialog(null, "Debe ingresar un número");
				break;
			}
			
			Graph graph = new Graph(nCities);
			
			for(int i = 0; i < nCities-1; i++) {
				for(int j = i+1; j < nCities; j++) {
					int distance;
					try {
						distance = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la distancia de la "
								+ "ciudad "+i+" a la ciudad "+j));
					}catch(NumberFormatException ee) {
						JOptionPane.showMessageDialog(null, "Debe ingresar un número");
						break;
					}
					graph.addDistance(i, j, distance);
				}
			}
			
	        ArrayList<Integer> route = TravellingSalesmanProblem.findRoute(graph);
	        JOptionPane.showMessageDialog(null, "La ruta óptima encontrada es: "+ route);
			
			break;
		case "Asignación":
			//System.out.println("Asignación");
			taskProblem.setA(new ArrayList<Task>());
			taskProblem.addTask("a", 1, 4);
			taskProblem.addTask("b", 0, 6);
			taskProblem.addTask("c", 5, 7);
			taskProblem.addTask("d", 3, 9);
			taskProblem.addTask("e", 6, 10);
			taskProblem.addTask("f", 8, 11);
			taskProblem.addTask("g", 8, 12);
			taskProblem.addTask("h", 12, 16);
			
			String allTasksTit = "Estas son las tareas disponibles:\n";
			String allTasks;
			allTasks = new String("");
			for(Task t : taskProblem.getA()) {
				allTasks += t.getName() + " \nInicio: " + t.getS() + "\nFinal: " + t.getF() + "\n";
			}
			
			//System.out.println("Tareas: " + allTasks);
			mainView.showMessage(allTasksTit + allTasks);
			
			String response = "La mejor combinacion es:\n";
			for(Task t : taskProblem.solve()) {
				response += t.getName() + ", ";
			}
			
			mainView.showMessage(response);
			
			break;
		default:
			JOptionPane.showMessageDialog(null, "Error");
			break;
		
		}
		
	}
}
