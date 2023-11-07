package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MainView extends JFrame{
	
	private JLabel title;
	
	private JButton prim;
	private JButton kruskal;
	private JButton viajero;
	private JButton tarea;
	
	public MainView() {
		execute();
		
		getContentPane().setLayout(null);
		setTitle("Algoritmos voráces");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(560, 400);
		getContentPane().setBackground(Color.gray);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	public void execute() {
		
		title = new JLabel("Algoritmo voráces");
		title.setFont(new Font("Cooper black", Font.BOLD, 20));
		title.setForeground(Color.BLACK);
		title.setBounds(180, 20, 220, 30);
		getContentPane().add(title);
		
		prim = new JButton("Prim");
		prim.setBackground(Color.BLACK);
		prim.setForeground(Color.WHITE);
		prim.setBounds(24, 310, 100, 30);
		getContentPane().add(prim);
		
		kruskal = new JButton("Kruskal");
		kruskal.setBackground(Color.BLACK);
		kruskal.setForeground(Color.WHITE);
		kruskal.setBounds(154, 310, 100, 30);
		getContentPane().add(kruskal);
		
		viajero = new JButton("Viajante");
		viajero.setBackground(Color.BLACK);
		viajero.setForeground(Color.WHITE);
		viajero.setBounds(284, 310, 100, 30);
		getContentPane().add(viajero);
		
		tarea = new JButton("Asignación");
		tarea.setBackground(Color.BLACK);
		tarea.setForeground(Color.WHITE);
		tarea.setBounds(414, 310, 100, 30);
		getContentPane().add(tarea);
		
	}
	
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public JButton getPrim() {
		return prim;
	}

	public void setPrim(JButton prim) {
		this.prim = prim;
	}

	public JButton getKruskal() {
		return kruskal;
	}

	public void setKruskal(JButton kruskal) {
		this.kruskal = kruskal;
	}

	public JButton getViajero() {
		return viajero;
	}

	public void setViajero(JButton viajero) {
		this.viajero = viajero;
	}

	public JButton getTarea() {
		return tarea;
	}

	public void setTarea(JButton tarea) {
		this.tarea = tarea;
	}

}
