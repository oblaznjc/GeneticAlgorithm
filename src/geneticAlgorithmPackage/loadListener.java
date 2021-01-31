package geneticAlgorithmPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
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
		
		
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(fileChooser);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		}
		
		
		
		

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
			this.editableViewer.frame.setTitle(this.editableViewer.title + ": " + filename);
			this.editableViewer.createButtonGrid(chromosome);

		} catch (FileNotFoundException e1) {
			System.out.println("File not found");
			e1.printStackTrace();
			return;
		}
		scanner.close();
	}
}
