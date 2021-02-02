package geneticAlgorithmPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
/**
 * 
 * @author oblaznjc and gottlijd
 * 
 *         Purpose: <br>
 *         Restriction: <br>
 *         For example: <br>
 *
 */
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
				+ System.getProperty("file.separator") + "chromosomeRepo")); // professor does not have access
		int result = fileChooser.showOpenDialog(fileChooser);
		if (result == JFileChooser.APPROVE_OPTION) {
			this.selectedFile = fileChooser.getSelectedFile();
		}

		try {
			PrintWriter printWriter = new PrintWriter(this.selectedFile);

			try {
				printWriter.println(this.editableViewer.getChromosome().getUpdatedGeneString());
			} catch (NullPointerException e) {
				this.editableViewer.frame.setTitle("Load chromosome before saving!");
			}

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