package co.edu.unbosque.model;

import javax.swing.JOptionPane;

public class Prim {

	private int num_verts;
	private int min_index;
	private int min_value;
	public int graphArray[][];

	
	public Prim() {
		
		this.num_verts = num_verts;
		graphArray = new int [num_verts][num_verts];
		this.min_index = 0;
		this.min_value = 0;
		
		
	}
	
	public void createMinSpanningTree (int graphArray[][]) {
		
		num_verts = graphArray.length;
		
		int mstArray[] = new int [num_verts];
		
		int keys[] = new int [num_verts];
		
		Boolean setOfMst[] = new Boolean [num_verts];
		
		for (int j = 0; j < num_verts; j++) {
			
			keys[j] = Integer.MAX_VALUE;
			
			setOfMst[j] = false;
			
		}
		
		keys[0] = 0;
		
		mstArray[0] = -1;
		
		//Prim's Algorithm:
		
		for (int i = 0; i < num_verts - 1; i++) {
			
			int edge = findMinVertex(keys, setOfMst);
			
			setOfMst[edge] = true;
			
			for (int vertex = 0; vertex < num_verts; vertex++) {
				
				if(graphArray[edge][vertex] != 0 && !setOfMst[vertex] && graphArray[edge][vertex] < keys[vertex]) {
					
					mstArray[vertex] = edge;
					
					keys[vertex] = graphArray[edge][vertex];
				}
				
			}
			
		}
		
		printMst(mstArray, graphArray);
		
	}
	
	public int findMinVertex(int keys[], Boolean setOfMst[]) {
		
		min_index = -1;
		
		min_value = Integer.MAX_VALUE;
		
		for (int vertex = 0; vertex < keys.length; vertex++) {
			
			if(!setOfMst[vertex] && keys[vertex] < min_value) {
				
				min_value = keys[vertex];
				
				min_index = vertex;
			}
		}
		
		return min_index;
	}
	
	public void printMst(int mstArray[], int graphArray[][]) {

	    StringBuilder output = new StringBuilder ("|BORDE| \t |PESO|\n");

	    for (int j = 1; j < mstArray.length; j++) {
	    	
	    	String edge = mstArray[j] + " < - > " + j;
	    	
	    	String weight = String.valueOf(graphArray[j][mstArray[j]]);
	    	
	    	int spaces = 12 - edge.length();
	    	
	    	output.append(edge);
	    	
	    	for (int i = 0; i < spaces; i++) {
				
	    		output.append("   ");
	    		
			}
	    	
	    	output.append(weight).append("\n");
	    	
	    }

	    JOptionPane.showMessageDialog(null, output.toString());
	}
}
