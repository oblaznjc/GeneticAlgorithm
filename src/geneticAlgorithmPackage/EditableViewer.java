package geneticAlgorithmPackage;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author oblaznjc and gottlijd
 * 
 *         Purpose: <br>
 *         Restriction: <br>
 *         For example: <br>
 *
 */
public class EditableViewer {

	public JFrame frame;
	private JPanel buttonGrid;
	public final String title = "Editable Chomosome Viewer";
	private Chromosome chromosome;
	private JTextField mutationRate;

	/**
	 * ensures: creates a specific JPanel and instantiates chromosome
	 */
	public EditableViewer() {
		this.chromosome = null;
		this.frame = new JFrame();
		this.frame.setTitle(title);
		this.buttonGrid = new JPanel();
		this.frame.add(createAdminPanel(), BorderLayout.SOUTH);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(500, 500);
		this.frame.setVisible(true);

	}

	/**
	 * ensures: creates an admin panel and associated buttons with listeners
	 * 
	 * @return the admin panel to be added to frame
	 */
	private JPanel createAdminPanel() {
		JPanel adminPanel = new JPanel();
		JButton newChromosomeButton = new JButton("New Chromosome");
		JButton loadButton = new JButton("Load");
		JButton saveButton = new JButton("Save");
		JButton mutateButton = new JButton("Mutate");
		this.mutationRate = new JTextField("(input / num genes)");
		adminPanel.add(newChromosomeButton);
		adminPanel.add(loadButton);
		adminPanel.add(saveButton);
		adminPanel.add(mutateButton);
		adminPanel.add(mutationRate);

		loadButton.addActionListener(new loadListener(this));
		saveButton.addActionListener(new saveListener(this));
		newChromosomeButton.addActionListener(new newChromosomeListener(this));
		mutateButton.addActionListener(new mutateListener(this));
		return adminPanel;
	}

	/**
	 * ensures: creates a randomized chromosome and and adds it to a button grid
	 * panel
	 */
	public void createButtonGrid() {
		this.buttonGrid.removeAll();
		this.buttonGrid.setLayout(new GridLayout(10, 10));
		this.chromosome = new Chromosome(this);
		for (Gene gene : getChromosome().geneList) {
			gene.setSize(30, 30);
			this.buttonGrid.add(gene);
		}
		this.frame.add(this.buttonGrid);
		this.frame.setVisible(true);
		this.frame.repaint();

	}

	/**
	 * ensures: accepts a loaded chromosome and and adds it to a button grid
	 * 
	 * @param chromosome <br>
	 *                   requires: chromosome
	 */
	public void createButtonGrid(Chromosome chromosome) {
		this.chromosome = chromosome;
		this.buttonGrid.removeAll();
		this.buttonGrid.setLayout(new GridLayout(10, 10));
		for (Gene gene : this.getChromosome().geneList) {
			gene.setSize(30, 30);
			this.buttonGrid.add(gene);
		}
		this.frame.add(this.buttonGrid);
		this.frame.setVisible(true);
		this.frame.repaint();
	}

	/**
	 * ensures: returns the chromosome visualized in editable viewer
	 * 
	 * @return chromosome
	 */
	public Chromosome getChromosome() {
		return chromosome;
	}

	/**
	 * ensures: gets the user input from mutation rate text field
	 * 
	 * @return user input if between 0 and chromosome size <br>
	 *         else returns 0
	 */
	public int getMutationNumber() {
		String text = this.mutationRate.getText();
		try {
			int mutationNumber = Integer.parseInt(text);
			if (mutationNumber < 0 || mutationNumber > this.getChromosome().getGeneList().size()) {
				throw new NumberFormatException();
			}
			return mutationNumber;
		} catch (NumberFormatException e) {
			this.frame.setTitle("Enter Mutation Rate between 0 and " + this.getChromosome().getGeneList().size());
			return 0;
		}

	}

	/**
	 * ensures: called to rename the title when a mutation occurs
	 */
	void updateMutantTitle() {
		this.frame.setTitle(this.title + ": Mutant");
	}

}
