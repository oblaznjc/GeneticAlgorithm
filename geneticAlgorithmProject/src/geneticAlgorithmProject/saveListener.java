package geneticAlgorithmProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class saveListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String filename = "Chromosome2.txt";
		PrintWriter printWriter = null;

		try {
			printWriter = new PrintWriter(new File(filename));

			printWriter.println("101010101010");
			printWriter.println("101010101010");
			printWriter.println("101010101010");

		} catch (FileNotFoundException e1) {
			System.out.println("File not found");
			e1.printStackTrace();
			return;
		}
		printWriter.close();
	}
}