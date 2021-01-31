package geneticAlgorithmPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

public class saveListener implements ActionListener {

	private EditableViewer editableViewer;
	private File selectedFile;

	public saveListener(EditableViewer editableViewer) {
		this.editableViewer = editableViewer;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home") + System.getProperty("file.separator")
				+ "git" + System.getProperty("file.separator") + "GeneticAlgorithm"
				+ System.getProperty("file.separator") + "chromosomeRepo"));
		int result = fileChooser.showOpenDialog(fileChooser);
		if (result == JFileChooser.APPROVE_OPTION) {
			this.selectedFile = fileChooser.getSelectedFile();
		}

		try {
			PrintWriter printWriter = new PrintWriter(this.selectedFile);
			printWriter.println(this.editableViewer.getChromosome().getUpdatedGeneString());
			printWriter.close();
		} catch (FileNotFoundException e1) {
			System.out.println("File not found");
			e1.printStackTrace();
			return;
		} catch (NullPointerException e2) {
			System.out.println("No chromosome is present to save!");
			e2.printStackTrace();
			return;
		}
	}
}