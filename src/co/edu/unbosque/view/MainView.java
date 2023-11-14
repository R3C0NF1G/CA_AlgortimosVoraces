package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Esta es la clase principal de la vista, contiene todos los elementos visuales y hereda de la clase JFrame.
 * @author RootSoftworks
 *
 */
public class MainView extends JFrame{
	
	private JLabel title;
	
	private JLabel subTitle;
	
	private JButton prim;
	private JButton kruskal;
	private JButton viajero;
	private JButton tarea;
	private JButton trabajador;
	private JLabel asignacionesLabel;
	
	/**
	 * Dentro del constructor se realiza toda la configuracion del JFrame, que es esta clase. Se le pone tamaño, layout y titulo. 
	 */
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
	
	/**
	 * Este metodo inicializa y configura cada elemento visual, como botones y titulos.
	 */
	public void execute() {
		
		title = new JLabel("Algoritmo voráces");
		title.setFont(new Font("Cooper black", Font.BOLD, 20));
		title.setForeground(Color.BLACK);
		title.setBounds(180, 20, 220, 30);
		getContentPane().add(title);
		
		subTitle = new JLabel("By: R00TS0FTW0RKS .::. :$");
		subTitle.setFont(new Font("Arial", Font.ITALIC, 15));
		subTitle.setForeground(Color.BLACK);
		subTitle.setBounds(180, 100, 220, 30);
		getContentPane().add(subTitle);
		
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
		
		asignacionesLabel = new JLabel("Asignaciones:");
		asignacionesLabel.setBounds(414, 250, 100, 30);
		getContentPane().add(asignacionesLabel);
		
		tarea = new JButton("Tarea");
		tarea.setBackground(Color.BLACK);
		tarea.setForeground(Color.WHITE);
		tarea.setBounds(414, 310, 100, 30);
		getContentPane().add(tarea);
		
		trabajador = new JButton("Trabajador");
		trabajador.setBackground(Color.BLACK);
		trabajador.setForeground(Color.WHITE);
		trabajador.setBounds(414, 280, 100, 30);
		getContentPane().add(trabajador);
		
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

	public JButton getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(JButton trabajador) {
		this.trabajador = trabajador;
	}
	

}
