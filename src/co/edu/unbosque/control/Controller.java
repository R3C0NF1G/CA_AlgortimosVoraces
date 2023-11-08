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
import co.edu.unbosque.view.KruskalView;
import co.edu.unbosque.view.MainView;
import co.edu.unbosque.view.PrimView;
import co.edu.unbosque.model.AssignProblem;
import co.edu.unbosque.model.Graph;

public class Controller implements ActionListener{


	private TaskProblem taskProblem;
	private AssignProblem assignProb;
	private MainView mainView;
	private PrimView primView;
	private KruskalView kruskalView;
	private Prim p;
	private Kruskal k;
		
	
	public Controller() {
		
		mainView = new MainView();
		primView = new PrimView();
		kruskalView = new KruskalView();
		p = new Prim();
		setListeners();
		
		taskProblem = new TaskProblem();
		assignProb = new AssignProblem();
	
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
	
			mainView.setVisible(false);
			kruskalView.setVisible(true);
			
			kruskalView.getSave().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					try {
						
						int num_verts = Integer.parseInt(kruskalView.getInpNumVerts().getText());
						
						int num_edges = Integer.parseInt(kruskalView.getInpNumEdges().getText());
						
						k = new Kruskal(num_verts, num_edges);
						
						for (int i = 0; i < num_edges; i++) {
							
						    String sourceStr = JOptionPane.showInputDialog("Introduzca el valor de origen para Edge(Borde/s)[" + i + "]");
						    int source = Integer.parseInt(sourceStr);
						    k.edgeArray[i].source = source;

						    String destinationStr = JOptionPane.showInputDialog("Introduzca el valor de destino para Edge(Borde/s)[" + i + "]");
						    int destination = Integer.parseInt(destinationStr);
						    k.edgeArray[i].destination = destination;

						    String weightStr = JOptionPane.showInputDialog("Introduzca el peso para Edge(Borde/s)[" + i + "]");
						    int weight = Integer.parseInt(weightStr);
						    k.edgeArray[i].weight = weight;
						    
						}
						
						k.applyKruskal();
						
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "Debe llenar los campos con datos válidos.",
							      "ERORR 404 NOT FOUND :(", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				
			});
			
			kruskalView.getReturnB().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					kruskalView.setVisible(false);
			        mainView.setVisible(true);
				}
			});
			
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
