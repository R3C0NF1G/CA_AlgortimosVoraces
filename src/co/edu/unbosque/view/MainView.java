package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainView extends JFrame{
	
	private JLabel title;
	
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
		
		title = new JLabel("Jeteperra");
		title.setFont(new Font("Cooper black", Font.BOLD, 20));
		title.setBounds(220, 20, 220, 20);
		getContentPane().add(title);
		
	}

}
