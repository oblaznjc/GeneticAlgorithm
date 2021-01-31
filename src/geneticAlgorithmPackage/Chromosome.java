package geneticAlgorithmPackage;

import java.util.ArrayList;

public class Chromosome {
	ArrayList<Gene> geneList = new ArrayList<Gene>();

	public Chromosome() {
		for (int i = 0; i < 100; i++) {
			Gene gene = new Gene(i);
			this.geneList.add(gene);
		}
	}

	public Chromosome(String genes) {
		for (int index = 0; index < genes.length(); index++) {
			int bit = Character.getNumericValue(genes.charAt(index));
			Gene gene = new Gene(index, bit);
			this.geneList.add(gene);
		}
	}
}
