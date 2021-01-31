package geneticAlgorithmProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class loadListener implements ActionListener {

	private EditableViewer editableViewer;

	public loadListener(EditableViewer editableViewer) {
		this.editableViewer = editableViewer;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String filename = "Chromosome1.txt";
		Scanner scanner = null;

		try {
			scanner = new Scanner(new File(filename));
			// System.out.println("File contents are: ");
			String geneString = "";
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				// System.out.println(line);
				geneString += line;
			}
			Chromosome chromosome = new Chromosome(geneString);
			editableViewer.createButtonGrid(chromosome);
			// editableViewer.createButtonGrid();

		} catch (FileNotFoundException e1) {
			System.out.println("File not found");
			e1.printStackTrace();
			return;
		}
		scanner.close();
	}
}
