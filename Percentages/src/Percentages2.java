
import javax.swing.JOptionPane;

/**
 * @author Lee Tzilantonis
 */
public class Percentages2 {

	public static void main(String[] args) {
		// Initializing the variables from the input dialog
		double a = Double.parseDouble(JOptionPane.showInputDialog("Please enter first number"));
		double b = Double.parseDouble(JOptionPane.showInputDialog("Please enter second number"));

		// call the computePercentage() method with parameters both ways
		computePercentage(a, b);
		computePercentage(b, a);
	}

	public static void computePercentage(double a, double b) {
		// Simple message showing the percentage of the values.
		JOptionPane.showMessageDialog(null, a + " is %" + ((a / b) * 100) + " of " + b);
	}

}
