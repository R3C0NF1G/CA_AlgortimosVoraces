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
import co.edu.unbosque.model.AssignProblem;
import co.edu.unbosque.model.Graph;

public class Controller implements ActionListener{

	private Kruskal graph;
	private TaskProblem taskProblem;
	private AssignProblem assignProb;
	private MainView mainView;
	private PrimView primView;
	private Prim p;
		
	
	public Controller() {
		
		mainView = new MainView();
		primView = new PrimView();
		p = new Prim();
		setListeners();
		
		taskProblem = new TaskProblem();
		assignProb = new AssignProblem();
	
	}

	/*public void startupKruskal() {
		
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
	*/
	
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
			mainView.setVisible(false);
			primView.setVisible(true);
			
			
			primView.getSaveArray().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						
						int num_verts = Integer.parseInt(primView.getInpNumVerts().getText());
						
		                String graphArrayString = primView.getInpArray().getText();
		                
		                String[] rows = graphArrayString.split("\n");
		                
		                int graphArray[][] = new int[num_verts][num_verts];

		                for (int i = 0; i < num_verts; i++) {
		                    for (int j = 0; j < num_verts; j++) {
		                    	
		                        graphArray[i][j] = Integer.parseInt(rows[i].split(" ")[j]);
		                        
		                    }
		                }

		                p.createMinSpanningTree(graphArray);
						
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "Debe llenar los campos con datos válidos.",
							      "ERORR 404 NOT FOUND :(", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			
			primView.getReturnB().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					primView.setVisible(false);
			        mainView.setVisible(true);
				}
			});
			
			
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
			int res[] = assignProb.solve();
			
			//Mostrar el resultado
			
			String resBuild = "";
			for(int i = 0; i < res.length; i++) {
				resBuild += "Trabajador " + i + " -> " + res[i] + "\n"; 
			}
			mainView.showMessage(resBuild);
			break;
		default:
			JOptionPane.showMessageDialog(null, "Error");
			break;
		
		}
		
	}
}
