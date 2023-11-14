package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import co.edu.unbosque.model.Prim;

/**
 * Esta clase es una ventana auxiliar para la implementacion del algoritmo de Prim.
 * Se utiliza para ingresar los datos requeridos para el funcionamiento del algoritmo de Prim.
 * @author RootSoftworks
 *
 */
public class PrimView extends JFrame{

	private JLabel title;
	private JLabel labInpNumVerts;
	private JTextField inpNumVerts;
	private JLabel labInpArray;
	private JTextArea inpArray;
	private JButton saveArray;
	private JButton returnB;
	Prim p;
	
	/**
	 * Este constructor se utiliza para configurar la ventana auxiliar.
	 */
	public PrimView() {
		
		execute();
		p = new Prim();
		getContentPane().setLayout(null);
		setTitle("Algoritmo de Prim");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(560,400);
		getContentPane().setBackground(Color.gray);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(false);
		
	}

	/**
	 * Este metodo inicializa todos los componentes swing que componen la ventana.
	 */
	private void execute() {
		// TODO Auto-generated method stub
		
		title = new JLabel("Algoritmo de Prim");
		title.setFont(new Font("Cooper black", Font.BOLD, 20));
		title.setBounds(180, 20, 220, 20);
		getContentPane().add(title);
		
		labInpNumVerts = new JLabel("Digite el número de vértices: ");
		labInpNumVerts.setBounds(60, 60, 200, 30);
		getContentPane().add(labInpNumVerts);
		
		inpNumVerts = new JTextField("");
		inpNumVerts.setBounds(320, 60, 100, 30);
		getContentPane().add(inpNumVerts);
		
		labInpArray = new JLabel("Introduzca la matriz de pesos: ");
		labInpArray.setBounds(60, 110, 250, 40);
		getContentPane().add(labInpArray);
		
		inpArray = new JTextArea("");
		inpArray.setBounds(320, 110, 150, 150);
		getContentPane().add(inpArray);
		
		saveArray = new JButton("Guardar");
		saveArray.setBackground(Color.BLACK);
		saveArray.setForeground(Color.WHITE);
		saveArray.setBounds(300, 280, 100, 30);
		getContentPane().add(saveArray);
		
		returnB = new JButton(" <-- ");
		returnB.setBackground(Color.BLACK);
		returnB.setForeground(Color.WHITE);
		returnB.setBounds(420, 280, 60, 30);
		getContentPane().add(returnB);
		
	}

	public JLabel getLabInpNumVerts() {
		return labInpNumVerts;
	}

	public void setLabInpNumVerts(JLabel labInpNumVerts) {
		this.labInpNumVerts = labInpNumVerts;
	}

	public JTextField getInpNumVerts() {
		return inpNumVerts;
	}

	public void setInpNumVerts(JTextField inpNumVerts) {
		this.inpNumVerts = inpNumVerts;
	}

	public JLabel getLabInpArray() {
		return labInpArray;
	}

	public void setLabInpArray(JLabel labInpArray) {
		this.labInpArray = labInpArray;
	}

	public JTextArea getInpArray() {
		return inpArray;
	}

	public void setInpArray(JTextArea inpArray) {
		this.inpArray = inpArray;
	}

	public JButton getSaveArray() {
		return saveArray;
	}

	public void setSaveArray(JButton saveArray) {
		this.saveArray = saveArray;
	}

	public JButton getReturnB() {
		return returnB;
	}

	public void setReturnB(JButton returnB) {
		this.returnB = returnB;
	}
	
}
