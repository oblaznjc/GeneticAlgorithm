package geneticAlgorithmPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class loadListener implements ActionListener {

	private EditableViewer editableViewer;

	public loadListener(EditableViewer editableViewer) {
		this.editableViewer = editableViewer;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String filename = "Chromosome2.txt";
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(filename));
			String geneString = "";
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				// System.out.println(line);
				geneString += line;
			}
			Chromosome chromosome = new Chromosome(geneString);
			this.editableViewer.createButtonGrid(chromosome);
			this.editableViewer.frame.setTitle(this.editableViewer.title + ": " + filename);

		} catch (FileNotFoundException e1) {
			System.out.println("File not found");
			e1.printStackTrace();
			return;
		}
		scanner.close();
	}
}
