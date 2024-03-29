package geneticAlgorithmPackage;

import java.awt.Color;
import java.util.Random;

import javax.swing.JButton;
/**
 * 
 * @author oblaznjc and gottlijd
 * 
 *         Purpose: <br>
 *         Restriction: <br>
 *         For example: <br>
 *
 */
public class Gene extends JButton {

	private static final Color oneBitBackground = Color.GREEN;
	private static final Color oneBitForeground = Color.BLACK;
	private static final Color zeroBitBackground = Color.BLACK;
	private static final Color zeroBitForeground = Color.GREEN;

	private int bit;

	public Gene(int index) {
		Random random = new Random();
		this.bit = random.nextInt(2);
		updateColor();
		this.setText("" + index);
	}

	public Gene(int index, int bit) {
		this.bit = bit;
		updateColor();
		this.setText("" + index);
	}

	public void updateColor() {
		if (this.getBit() == 0) {
			this.setBackground(zeroBitBackground);
			this.setForeground(zeroBitForeground);
		} else {
			this.setBackground(oneBitBackground);
			this.setForeground(oneBitForeground);
		}
	}

	public void changeBit() {
		if (this.getBit() == 0) {
			this.bit = 1;
		} else {
			this.bit = 0;
		}
		updateColor();
	}

	public int getBit() {
		return bit;
	}
}
