package Puissance4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class BoutonGrille extends JButton implements ActionListener   {
	
	
	public int numeroLigne;
	
	public BoutonGrille(){
		
	}
	
	public BoutonGrille(int numeroLigne){
		this.numeroLigne=numeroLigne;		
	}
	

	public void actionPerformed(ActionEvent e) {

		
	}
}
