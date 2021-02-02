package geneticAlgorithmPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
public class loadListener implements ActionListener {

	private EditableViewer editableViewer;
	private File selectedFile;

	public loadListener(EditableViewer editableViewer) {
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

		Scanner scanner = null;

		try {
			scanner = new Scanner(this.selectedFile);
			String geneString = "";
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				// System.out.println(line);
				geneString += line;
			}
			Chromosome chromosome = new Chromosome(this.editableViewer, geneString);
			this.editableViewer.frame.setTitle(this.editableViewer.title + ": " + this.selectedFile.getName());
			this.editableViewer.createButtonGrid(chromosome);

		} catch (FileNotFoundException e1) {
			System.out.println("File not found");
			e1.printStackTrace();
			return;
		}
		scanner.close();
	}
}
