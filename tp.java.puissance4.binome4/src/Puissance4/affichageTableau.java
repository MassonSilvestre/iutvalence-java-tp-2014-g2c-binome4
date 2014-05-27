package Puissance4;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class affichageTableau extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton[][] buttonArray = new JButton[7][6];
	private Plateau trayToDisplay;

	public affichageTableau(Plateau trayToDisplay) {
		this.trayToDisplay = trayToDisplay;
		this.setLayout(new GridLayout(1, 7));

		JPanel columnPanel = new JPanel();
		columnPanel.setLayout(new GridLayout(6, 1));

		for (int i = 0; i < 7; i++)
			for (int j = 0; j < 6; j++)
				this.buttonArray[i][j] = new JButton();

		for (JButton[] columnToFetch : this.buttonArray) {
			for (JButton boxToFetch : columnToFetch) {
				boxToFetch.setEnabled(false);
				columnPanel.add(boxToFetch);
			}
			this.add(columnPanel);
			columnPanel = new JPanel();
			columnPanel.setLayout(new GridLayout(6, 1));
		}

			this.refreshTray();

	}

	public void refreshTray() {

		for (int i = 0; i < 7; i++)
			for (int j = 0; j < 6; j++) {
				if (this.trayToDisplay.getPlateau()[i][Math.abs(j - 5)]
						.valeur() == Pion.PION_JAUNE.valeur())
					this.buttonArray[i][j].setBackground(Color.YELLOW);
				if (this.trayToDisplay.getPlateau()[i][Math.abs(j - 5)]
						.valeur() == Pion.PION_ROUGE.valeur())
					this.buttonArray[i][j].setBackground(Color.RED);
				if (this.trayToDisplay.getPlateau()[i][Math.abs(j - 5)]
						.valeur() == Pion.CASE_VIDE.valeur())
					this.buttonArray[i][j].setBackground(Color.WHITE);
			}
	}

	public void changeTray(Plateau newTray) {
		this.trayToDisplay = newTray;
	}

	public JButton[][] getArray() {
		return this.buttonArray;
	}

	public Plateau getTray() {
		return this.trayToDisplay;
	}

}
