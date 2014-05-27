package Puissance4;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;




public class Fenetre extends JFrame implements Runnable, ActionListener {

	private static final long serialVersionUID = 1L;
	protected JFrame fenetre;
	private Pion couleurCourante;
	private Plateau plateau;
	private affichageTableau grille;
	JButton [] boutonColonne;
	
	public Fenetre(Plateau plateau) {
		this.plateau = plateau;
		this.couleurCourante = Pion.PION_JAUNE;
	}
	
public void run() {		
		initialisationFenetre ();
	}


	
	public void initialisationFenetre () {
		this.fenetre = new JFrame();
		new Menu(fenetre);
		this.fenetre.setTitle("Puissance 4");
		this.fenetre.setSize(600, 700);
		this.fenetre.setVisible(true);
		this.fenetre.setResizable(false);
		this.boutonColonne = new JButton [8];
		
		JPanel joueur = new JPanel();
		JPanel colonne = new JPanel();
		JPanel joueurCourant = new JPanel() ;
		JLabel texte = new JLabel("Le joueur courant est : ");
		JLabel nomJoueur = new JLabel("Robert ");		
		
		joueurCourant.setLayout(( new GridLayout(1, 2)));
		joueurCourant.add(texte);
		joueurCourant.add(nomJoueur);		
		
		JSplitPane ensemble = new JSplitPane();		
		ensemble = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		
		JSplitPane splitInferieur = new JSplitPane();		
		splitInferieur = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		
		ensemble.setEnabled(false);
		ensemble.setBorder(null);
		ensemble.setDividerSize(0);
		splitInferieur.setEnabled(false);
		splitInferieur.setBorder(null);
		splitInferieur.setDividerSize(0);
		splitInferieur.setResizeWeight(0.1);
		
		
		
		colonne.setLayout(( new GridLayout(1, 7)));
		for (int i = 0; i < 7; i++) {
			boutonColonne [i] = new JButton();
			colonne.add(boutonColonne [i]);
			boutonColonne[i].addActionListener(this);
			};
		
			grille = new affichageTableau(this.plateau);
			
		
		fenetre.add(ensemble);
		splitInferieur.add(colonne);
		splitInferieur.add(grille);
		joueur.add(joueurCourant);
		ensemble.add(joueur);
		ensemble.add(splitInferieur);
		
	}
	
	public void actionPerformed(ActionEvent event) {
		
		JButton selectedItem =  (JButton) event.getSource();
		int colonneSelectionner = 0;
		String colorString = "";
		
		if(this.couleurCourante.valeur()==Pion.PION_JAUNE.valeur()) colorString = "Joueur Jaune";
		if(this.couleurCourante.valeur()==Pion.PION_ROUGE.valeur()) colorString = "Joueur Rouge";
		if(selectedItem == this.boutonColonne[0]) colonneSelectionner = 0;
		if(selectedItem == this.boutonColonne[1]) colonneSelectionner = 1;
		if(selectedItem == this.boutonColonne[2]) colonneSelectionner = 2;
		if(selectedItem == this.boutonColonne[3]) colonneSelectionner = 3;
		if(selectedItem == this.boutonColonne[4]) colonneSelectionner = 4;
		if(selectedItem == this.boutonColonne[5]) colonneSelectionner = 5;
		if(selectedItem == this.boutonColonne[6]) colonneSelectionner = 6;
		
		this.plateau.placerPion(colonneSelectionner, couleurCourante);
		this.grille.refreshTray();
		if((this.grille.getTray().recherche4PionsAlignes())||(this.grille.getTray().estPlein())) {
			if(this.grille.getTray().recherche4PionsAlignes()) {
				JOptionPane.showMessageDialog(this, "Victoire du "+colorString, "Fin de la partie", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
			if(this.grille.getTray().estPlein()) {
				JOptionPane.showMessageDialog(this, "Egalité entre les deux opposants !", "Fin de la partie", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		}

		this.changerJoueur();
		

	}
	
	private void changerJoueur() {
		if(this.couleurCourante.valeur()==Pion.PION_JAUNE.valeur()) this.couleurCourante = Pion.PION_ROUGE;
		else if(this.couleurCourante.valeur()==Pion.PION_ROUGE.valeur()) this.couleurCourante = Pion.PION_JAUNE;

	}
	
}
