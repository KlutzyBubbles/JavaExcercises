
import javax.swing.JOptionPane;

/**
 * @author Lee Tzilantonis
 */
public class Percentages {

    public static void main(String[] args) {
    	// Initializing the variables
        double a = 2D;
        double b = 5D;
        
        // call the computePercentage() method with parameters both ways
        computePercentage(a, b);
        computePercentage(b, a);
    }
    
    public static void computePercentage(double a, double b) {
    	// Simple message showing the percentage of the values.
        JOptionPane.showMessageDialog(null, a + " is %" + ((a / b) * 100) + " of " + b);
    }
    
}
