package geneticAlgorithmPackage;

import java.util.ArrayList;

public class Chromosome {
	ArrayList<Gene> geneList = new ArrayList<Gene>();
	private String geneString = "";

	public Chromosome() {
		for (int i = 0; i < 100; i++) {
			Gene gene = new Gene(i);
			gene.addActionListener(new geneListener(gene));
			this.geneList.add(gene);
			this.geneString = this.getGeneString() + gene.bit;
		}
		System.out.println(this.getGeneString());
	}

	public Chromosome(String geneString) {
		this.geneString = geneString;
		for (int index = 0; index < geneString.length(); index++) {
			int bit = Character.getNumericValue(geneString.charAt(index));
			Gene gene = new Gene(index, bit);
			gene.addActionListener(new geneListener(gene));
			this.geneList.add(gene);
		}
		System.out.println(this.getGeneString());

	}

	public String getGeneString() {
		return geneString;
	}
}
