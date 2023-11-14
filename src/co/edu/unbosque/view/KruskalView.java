package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Esta clase es una vista auxiliar para la implementacion del algoritmo de Kruskal.
 * Se utiliza para solicitar el ingreso de los datos necesarios para realizar el algoritmo.
 * @author RootSoftworks
 *
 */
public class KruskalView extends JFrame{
	
	private JLabel title;
	private JLabel num_verts;
	private JLabel num_edges;
	private JTextField inpNumVerts;
	private JTextField inpNumEdges;
	private JButton save;
	private JButton returnB;
	
	/**
	 * Este constructor es usado para configurar la ventana auxiliar.
	 */
	public KruskalView () {
		
		execute();
		
		getContentPane().setLayout(null);
		setTitle("Algoritmo de Kruskal");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(560,400);
		getContentPane().setBackground(Color.gray);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(false);
	}

	/**
	 * Este metodo inicializa todos los componentes Swing que componen la vista, como titulos y botones.
	 */
	private void execute() {
		// TODO Auto-generated method stub
		title = new JLabel("Algoritmo de Kruskal");
		title.setFont(new Font("Cooper black", Font.BOLD, 20));
		title.setBounds(180, 20, 220, 20);
		getContentPane().add(title);
		
		num_verts = new JLabel("");
		
		num_verts = new JLabel("Digite el número de vértices: ");
		num_verts.setBounds(60, 60, 200, 30);
		getContentPane().add(num_verts);
		
		num_edges = new JLabel("Digite el número de bordes: ");
		num_edges.setBounds(60, 120, 200, 30);
		getContentPane().add(num_edges);
		
		inpNumVerts = new JTextField("");
		inpNumVerts.setBounds(320, 60, 100, 30);
		getContentPane().add(inpNumVerts);
		
		inpNumEdges = new JTextField("");
		inpNumEdges.setBounds(320, 120, 100, 30);
		getContentPane().add(inpNumEdges);
		
		save = new JButton("Guardar");
		save.setBackground(Color.BLACK);
		save.setForeground(Color.WHITE);
		save.setBounds(180, 190, 100, 30);
		getContentPane().add(save);
		
		returnB = new JButton(" <-- ");
		returnB.setBackground(Color.BLACK);
		returnB.setForeground(Color.WHITE);
		returnB.setBounds(50, 190, 100, 30);
		getContentPane().add(returnB);
		
	}

	public JLabel getNum_verts() {
		return num_verts;
	}

	public void setNum_verts(JLabel num_verts) {
		this.num_verts = num_verts;
	}

	public JLabel getNum_edges() {
		return num_edges;
	}

	public void setNum_edges(JLabel num_edges) {
		this.num_edges = num_edges;
	}

	public JTextField getInpNumVerts() {
		return inpNumVerts;
	}

	public void setInpNumVerts(JTextField inpNumVerts) {
		this.inpNumVerts = inpNumVerts;
	}

	public JTextField getInpNumEdges() {
		return inpNumEdges;
	}

	public void setInpNumEdges(JTextField inpNumEdges) {
		this.inpNumEdges = inpNumEdges;
	}

	public JButton getSave() {
		return save;
	}

	public void setSave(JButton save) {
		this.save = save;
	}

	public JButton getReturnB() {
		return returnB;
	}

	public void setReturnB(JButton returnB) {
		this.returnB = returnB;
	}

	
}
