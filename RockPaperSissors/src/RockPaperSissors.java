import java.util.Random;
import javax.swing.JOptionPane;

/**
 * @author Lee Tzilantonis
 */
public class RockPaperSissors {

    public static void main(String[] args) {
        
        int gen = (new Random()).nextInt(3) + 1; // The random is not initialize elsewhere because it is only needed once.
        System.out.println("COMPUTER: " + gen); // A print of the computers value for testing
        String guess = JOptionPane.showInputDialog(null, "Please guess: r - p - s");
        
        // The equalsIgnoreCase() is self-explanitory but basically ignores case
        // EXAMPLE: INPUT=r IF=equalsIgnoreCase("R") - RETURNS: true
        if (!guess.equalsIgnoreCase("R")) {
            if (!guess.equalsIgnoreCase("P")) {
                if (!guess.equalsIgnoreCase("S")) { // The input was neither r-p-s making the input invalid
                	// And alert message is shown and then the program is exited silently
                     JOptionPane.showMessageDialog(null, "Please only enter r - p - s");
                     System.exit(1);
                }
            }
        }
        // Turning the letter input into a number to easily compare with the computers choice
        int num = guess.equalsIgnoreCase("R") ? 1 : guess.equalsIgnoreCase("P") ? 2 : guess.equalsIgnoreCase("S") ? 3 : 0; // A series of conditional operators that switch the r-p-s input into 1-2-3
        if (num == 0) { // The input wasnt r-p-s because the num is 0
        	// And alert message is shown and then the program is exited silently
            JOptionPane.showMessageDialog(null, "Please only enter r - p - s");
            System.exit(1);
        }
        
        System.out.println("PLAYER: " + num + " : " + guess); // Printing the players guess in both letter and number format for testing
        
        if (num == gen) { // Both numbers match meaning both players picked the same option
            JOptionPane.showMessageDialog(null, "The game was a draw!");
            // No need for System.exit(1); because the main method ends after the statement
        } else { // There has to be a winner (the fight is on)
        	/**
        	 * Had to compare manually but the code is:
        	 * 2 beats 1
        	 * 3 beats 2
        	 * 1 beats 3
        	 * 
        	 * Just a small looping of numbers from 1-3
        	 */
            if (num == 1) {
            	// Gen can't be 1 because we know the values aren't the same
                if (gen == 2) {
                    displayLoser();
                } else {
                    displayWinner();
                }
            } else if (num == 2) {
            	// Gen can't be 2 because we know the values aren't the same
                if (gen == 3) {
                    displayLoser();
                } else {
                    displayWinner();
                }
            } else { // Num is 3
            	// Gen can't be 3 because we know the values aren't the same
                if (gen == 1) {
                    displayLoser();
                } else {
                    displayWinner();
                }
            }
        }
        
    }
    
    // These methods were created to prevent me from copying and pasting un-needed code
    public static void displayWinner() {
        JOptionPane.showMessageDialog(null, "You won!");
    }
    
    public static void displayLoser() {
        JOptionPane.showMessageDialog(null, "You lost!");
    }
    
}
