package geneticAlgorithmProject;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditableViewer {

	public EditableViewer() {
		JFrame frame = new JFrame();
		frame.setTitle("Editable Chomosome Viewer");

		frame.add(createButtonGrid());
		frame.add(createAdminPanel(), BorderLayout.SOUTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);

	}

	private JPanel createAdminPanel() {
		JPanel adminPanel = new JPanel();
		JButton mutateButton = new JButton("Mutate");
		JButton loadButton = new JButton("Load");
		JButton saveButton = new JButton("Save");
		JTextField mutationRate = new JTextField("Mutation Rate");
		adminPanel.add(mutateButton);
		adminPanel.add(loadButton);
		adminPanel.add(saveButton);
		adminPanel.add(mutationRate);
		loadButton.addActionListener(new loadListener());
		saveButton.addActionListener(new saveListener());
		return adminPanel;
	}

	private JPanel createButtonGrid() {
		ArrayList<JButton> buttonList = new ArrayList<>();
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(10, 10));
		panel.setSize(300, 300);
		for (int i = 0; i < 100; i++) {
			Gene gene = new Gene(i);
			gene.setSize(30, 30);
			panel.add(gene);
		}
		return panel;
	}
}
