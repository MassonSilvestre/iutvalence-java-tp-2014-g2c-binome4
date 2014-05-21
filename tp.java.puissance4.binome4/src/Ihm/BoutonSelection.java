package Ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class BoutonSelection extends JButton implements ActionListener   {
	
	

	
	public BoutonSelection(){
		
	}
	
	public BoutonSelection(int numeroLigne){
		this.setText(Integer.toString(numeroLigne));
	}
	

	public void actionPerformed(ActionEvent e) {

		
	}
}
