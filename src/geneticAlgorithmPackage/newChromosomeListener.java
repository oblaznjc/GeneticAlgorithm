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
public class newChromosomeListener implements ActionListener {

	private EditableViewer editableViewer;

	public newChromosomeListener(EditableViewer editableViewer) {
		this.editableViewer = editableViewer;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.editableViewer.createButtonGrid();
		this.editableViewer.frame.setTitle(this.editableViewer.title + ": " + "New Chromosome");

	}

}
