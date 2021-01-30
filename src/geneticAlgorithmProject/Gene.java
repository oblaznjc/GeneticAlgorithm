package geneticAlgorithmProject;

import java.awt.Color;

import javax.swing.JButton;

public class Gene extends JButton {
	public Gene() {
		this.setBackground(Color.green);
	}
	public Gene(int i) {
		this.setBackground(Color.green);
		this.setText("" + i);
	}
}
