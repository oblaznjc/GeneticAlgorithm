package geneticAlgorithmPackage;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditableViewer {

	private JFrame frame;
	private JPanel buttonGrid;

	public EditableViewer() {
		this.frame = new JFrame();
		this.frame.setTitle("Editable Chomosome Viewer");

		// createButtonGrid(); // May or may not add
		this.buttonGrid = new JPanel();

		this.frame.add(createAdminPanel(), BorderLayout.SOUTH);

		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(500, 500);
		this.frame.setVisible(true);

	}

	private JPanel createAdminPanel() {
		JPanel adminPanel = new JPanel();
		JButton newChromosomeButton = new JButton("New Chromosome");
		JButton loadButton = new JButton("Load");
		JButton saveButton = new JButton("Save");
		JButton mutateButton = new JButton("Mutate");
		JTextField mutationRate = new JTextField("Mutation Rate");
		adminPanel.add(newChromosomeButton);
		adminPanel.add(loadButton);
		adminPanel.add(saveButton);
		adminPanel.add(mutateButton);
		adminPanel.add(mutationRate);

		loadButton.addActionListener(new loadListener(this));
		saveButton.addActionListener(new saveListener());
		newChromosomeButton.addActionListener(new newChromosomeListener(this));
		return adminPanel;
	}

	public void createButtonGrid() {
		this.buttonGrid.removeAll();
		this.buttonGrid.setLayout(new GridLayout(10, 10));
		Chromosome chromosome = new Chromosome();
		for (Gene gene : chromosome.geneList) {
			gene.setSize(30, 30);
			this.buttonGrid.add(gene);
		}
		this.frame.add(this.buttonGrid);
		this.frame.setVisible(true);

	}

	public void createButtonGrid(Chromosome chromosome) {
		this.buttonGrid.removeAll();
		this.buttonGrid.setLayout(new GridLayout(10, 10));
		for (Gene gene : chromosome.geneList) {
			gene.setSize(30, 30);
			this.buttonGrid.add(gene);
		}
		this.frame.add(this.buttonGrid);
		this.frame.setVisible(true);
	}

}
