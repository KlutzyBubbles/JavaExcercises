
import javax.swing.JOptionPane;

/**
 * @author Lee Tzilantonis
 */
public class NumbersDemo2 {

    public static void main(String[] args) {
    	// Initializing the variables from the input dialog
        double a = Double.parseDouble(JOptionPane.showInputDialog("Please enter number a"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Please enter number b"));
        
     	// calling all methods with both variables
        displayTwiceTheNumber(a);
        displayNumberPlusFive(a);
        displayNumberSquared(a);
        displayTwiceTheNumber(b);
        displayNumberPlusFive(b);
        displayNumberSquared(b);
    }
    
    public static void displayTwiceTheNumber(double num) {
    	// Displays a message with the calculation of the expression num * 2
        JOptionPane.showMessageDialog(null, num + " times 2: " + (num * 2));
    }
    
    public static void displayNumberPlusFive(double num) {
    	// Displays a message with the calculation of the expression num + 5
        JOptionPane.showMessageDialog(null, num + " plus 5: " + (num + 5));
    }
    
    public static void displayNumberSquared(double num) {
    	// Displays a message with the calculation of the expression num * num
        JOptionPane.showMessageDialog(null, num + " squared: " + (num * num));
    }
    
}
