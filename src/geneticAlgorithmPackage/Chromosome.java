package geneticAlgorithmPackage;

import java.util.ArrayList;

public class Chromosome {
	ArrayList<Gene> geneList = new ArrayList<Gene>();
	private String geneString = "";
	private EditableViewer editableViewer;

	public Chromosome(EditableViewer editableViewer) {
		this.editableViewer = editableViewer;
		for (int i = 0; i < 100; i++) {
			Gene gene = new Gene(i);
			gene.addActionListener(new geneListener(gene, this.editableViewer));
			this.geneList.add(gene);
			this.geneString = this.geneString + gene.getBit();
		}
	}

	public Chromosome(EditableViewer editableViewer, String geneString) {
		this.editableViewer = editableViewer;
		this.geneString = geneString;
		for (int index = 0; index < geneString.length(); index++) {
			int bit = Character.getNumericValue(geneString.charAt(index));
			Gene gene = new Gene(index, bit);
			gene.addActionListener(new geneListener(gene, this.editableViewer));
			this.geneList.add(gene);
		}
	}

	public String getUpdatedGeneString() {
		this.geneString = "";
		for (Gene gene : geneList) {
			this.geneString = this.geneString + gene.getBit();
		}
		return this.geneString;
	}

	public ArrayList<Gene> getGeneList() {
		return geneList;
	}
}
