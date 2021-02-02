package geneticAlgorithmPackage;
/**
 * 
 * @author oblaznjc and gottlijd
 * 
 *         Purpose: <br>
 *         Restriction: <br>
 *         For example: <br>
 *
 */
public class ViewerMain {

	public static void main(String[] args) {
		// TODO Auto-gVenerated method stub
		handleOpenAll();
	}

	public static void handleOpenAll() {
		BestChromosomeViewer bestChromosomeViewer = new BestChromosomeViewer();
		EditableViewer editableViewer = new EditableViewer();
		PopulationViewer populationViewer = new PopulationViewer();
		EvolutionViewer evolutionViewer = new EvolutionViewer();
	}

}
