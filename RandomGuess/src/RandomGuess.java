import java.util.Random;
import javax.swing.JOptionPane;

/**
 * @author Lee Tzilantonis
 */
public class RandomGuess {

    public static void main(String[] args) {
    	// Using JOptionPane to get input, although i didnt feel it needed validation
        int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Please guess a number between 1-20"));
        int gen = (new Random()).nextInt(20) + 1; // Using the Random object to get a random number between 1-20
        // The num input is collected first to prevent cheating
        int dif = gen - num; // the difference is calculated for checking. It is stored as a variable because it is used more than once
        if (num == gen) { // The numbers are the same
            JOptionPane.showMessageDialog(null, "You guessed correct!");
        } else if (num > gen) { // The users number is higher
            JOptionPane.showMessageDialog(null, "You guessed " + -dif + " to high");
        } else { // Otherwise the computers number has to be higher
            JOptionPane.showMessageDialog(null, "You guessed " + dif + " to low");
        }
    }
    
}
