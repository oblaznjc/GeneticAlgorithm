package geneticAlgorithmProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class newChromosomeListener implements ActionListener {

	private EditableViewer editableViewer;

	public newChromosomeListener(EditableViewer editableViewer) {
		this.editableViewer = editableViewer;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.editableViewer.createButtonGrid();
	}

}
