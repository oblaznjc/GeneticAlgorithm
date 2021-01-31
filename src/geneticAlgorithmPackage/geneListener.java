package geneticAlgorithmPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class geneListener implements ActionListener {

	private Gene gene;

	public geneListener(Gene gene) {
		this.gene = gene;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.gene.changeBit();

	}

}
