import java.util.Random;

/**
 * @author Lee Tzilantonis
 */
public class Die {
    
    private int number; // This is the number for the Die Object NOT the main method
    
    public static void main(String[] args) {
    	/**
    	 * NOTE: I didnt design the Die object to only be rolled once
    	 * i found that instancing two objects would be a waste so
    	 * i created a method that can re-roll the Die object for a
    	 * new random number.
    	 */
    	Die d = new Die(); // creating and instance of the Die class
        int hold = d.getValue(); // This is the first value.
        d.reRoll(); // Re-rolling to generate a new number
        System.out.println("First: " + hold); // Printing the first value
        System.out.println("Second: " + d.getValue()); // Printing the second value
        
        System.out.println(); // Blank line
        
        if (hold == d.getValue()) { // Check to see if values match
            System.out.println("Both dice have the same value"); // Printing the result
        } else if (hold > d.getValue()) { // Check if the first is greater thant he second
            System.out.println("First die is higher by " + (hold - d.getValue())); // Printing the result with the difference
        } else { // Otherwise the first has to be smaller than the second
            System.out.println("Second die is higher by " + (d.getValue() - hold)); // Printing the result with the difference
        }
    }
    
    public Die() {
    	// The Die needs a value so a call of re-roll will do the job
        this.reRoll();
    }
    
    public int getValue() { // Simple return of a value, no validation
        return this.number;
    }
    
    public void reRoll() {
    	// Using the Random object to create an integer
    	// from 0-5 (nextInt works like arrays) and then 
    	// adding one two it to make it a number between 1-6
        this.number = (new Random()).nextInt(6) + 1;
    }
    
}
