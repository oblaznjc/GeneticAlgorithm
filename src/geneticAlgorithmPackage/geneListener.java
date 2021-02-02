package geneticAlgorithmPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 
 * @author oblaznjc and gottlijd
 * 
 *         Purpose: <br>
 *         Restriction: <br>
 *         For example: <br>
 *
 */
public class geneListener implements ActionListener {

	private Gene gene;
	private EditableViewer editableViewer;

	public geneListener(Gene gene, EditableViewer editableViewer) {
		this.gene = gene;
		this.editableViewer = editableViewer;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.editableViewer.updateMutantTitle();
		this.gene.changeBit();

	}

}
