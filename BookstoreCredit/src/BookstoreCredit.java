
import javax.swing.JOptionPane;

/**
 * @author Lee Tzilantonis
 */
public class BookstoreCredit {

    public static void main(String[] args) {
    	// Simple Input Dialog to collect a double value for the students score inside the call to calcCredit()
        calcCredit(Double.parseDouble(JOptionPane.showInputDialog("Please enter the students score")));
    }
    
    public static void calcCredit(double num) {
    	// Credit is num * 10 and because the value only needs to be used once there is no use storing it.
        JOptionPane.showMessageDialog(null, "The student gets $" + (num * 10) + " for their score of " + num);
    }
    
}
