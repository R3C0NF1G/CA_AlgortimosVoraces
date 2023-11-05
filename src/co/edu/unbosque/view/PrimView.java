package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PrimView extends JFrame{

	private JLabel title;
	private JLabel labInpArray;
	private JTextField inpArray;
	private JButton saveArray;
	
	public PrimView() {
		
		execute();
		
		getContentPane().setLayout(null);
		setTitle("Algoritmo de Prim");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(560,400);
		getContentPane().setBackground(Color.gray);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(false);
		
	}

	private void execute() {
		// TODO Auto-generated method stub
		
		title = new JLabel("Algoritmo de Prim");
		title.setFont(new Font("Cooper black", Font.BOLD, 20));
		title.setBounds(180, 20, 220, 20);
		getContentPane().add(title);
		
		labInpArray = new JLabel("Introduzca los\n valores para\n crear el Array:");
		labInpArray.setBounds(20, 60, 100, 30);
		getContentPane().add(labInpArray);
		
		inpArray = new JTextField("");
		inpArray.setBounds(380, 60, 100, 30);
		getContentPane().add(inpArray);
		
		saveArray = new JButton("Guardar");
		saveArray.setBackground(Color.BLACK);
		saveArray.setForeground(Color.WHITE);
		saveArray.setBounds(240, 180, 100, 30);
		getContentPane().add(saveArray);
		
	}

	public JTextField getInpArray() {
		return inpArray;
	}

	public void setInpArray(JTextField inpArray) {
		this.inpArray = inpArray;
	}

	public JButton getSaveArray() {
		return saveArray;
	}

	public void setSaveArray(JButton saveArray) {
		this.saveArray = saveArray;
	}
	
}
