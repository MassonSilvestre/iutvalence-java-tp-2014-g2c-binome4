package tp.java.puissance4.binome4;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.RootPaneContainer;
import javax.swing.WindowConstants;



import java.awt.Component;

public class ihmPuissance4 extends JFrame implements Runnable {

	protected JFrame fenetre;

	@Override
	public void run() {
		
		this.fenetre = new JFrame();
		new Menu(fenetre);
		this.fenetre.setTitle("Puissance 4");
		this.fenetre.setSize(600, 700);
		this.fenetre.setVisible(true);
		this.fenetre.setResizable(false);
		
		JPanel grille = new JPanel();
		JPanel joueur = new JPanel();
		JPanel colonne = new JPanel();
		JLabel texte = new JLabel("Le joueur courant est : ");
		
		JSplitPane ensemble = new JSplitPane();		
		ensemble = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		
		JSplitPane splitInferieur = new JSplitPane();		
		splitInferieur = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		
		//grille.setResizeWeight(1.0);
		ensemble.setEnabled(false);
		ensemble.setBorder(null);
		ensemble.setDividerSize(0);
		splitInferieur.setEnabled(false);
		splitInferieur.setBorder(null);
		splitInferieur.setDividerSize(0);
		splitInferieur.setResizeWeight(0.1);
		
		colonne.setLayout(( new GridLayout(1, 7)));
		for (int i = 1; i < 8; i++) {
				JButton bouton = new JButton(""+i);				
				colonne.add(bouton);
			};
		
		grille.setLayout(( new GridLayout(6, 7)));
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 6; j++) {
				JButton bouton = new JButton();
				bouton.setBackground(Color.RED);
				grille.add(bouton);
			}
		};
		
		
		fenetre.add(ensemble);
		splitInferieur.add(colonne);
		splitInferieur.add(grille);
		joueur.add(texte);
		ensemble.add(joueur);
		ensemble.add(splitInferieur);
		

	}
}