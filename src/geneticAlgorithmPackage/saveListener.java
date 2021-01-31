package geneticAlgorithmPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class saveListener implements ActionListener {

	private EditableViewer editableViewer;

	public saveListener(EditableViewer editableViewer) {
		this.editableViewer = editableViewer;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String filename = "SavedChromosome1.txt";

		try {

			PrintWriter printWriter = new PrintWriter(new File(filename));

			printWriter.println(this.editableViewer.getChromosome().getGeneString());

			printWriter.close();
		} catch (FileNotFoundException e1) {
			System.out.println("File not found");
			e1.printStackTrace();
			return;
		}

	}
}