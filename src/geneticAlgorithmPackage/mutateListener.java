package geneticAlgorithmPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class mutateListener implements ActionListener {

	private EditableViewer editableViewer;

	public mutateListener(EditableViewer editableViewer) {
		this.editableViewer = editableViewer;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.editableViewer.updateMutantTitle();
		Random random = new Random();

		try {
			for (Gene gene : this.editableViewer.getChromosome().getGeneList()) {
				if (random.nextInt(this.editableViewer.getChromosome().getGeneList().size()) < this.editableViewer
						.getMutationNumber()) {
					gene.changeBit();
				}
			}
		} catch (NullPointerException e) {
			this.editableViewer.frame.setTitle("Load chromosome before mutating!");
		}
	}

}
