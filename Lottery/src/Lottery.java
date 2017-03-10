import java.util.Random;
import javax.swing.JOptionPane;

/**
 * @author Lee Tzilantonis
 */
public class Lottery {

	public static void main(String[] args) {

		int[] gen = new int[3]; // Setting the length of the array to allow for easy looping with no null
		int[] num = new int[3];

		Random r = new Random(); // Create an instance fo the Random object to be used more than once.
		gen[0] = r.nextInt(10);
		gen[1] = r.nextInt(10);
		gen[2] = r.nextInt(10);
		// 		Alternate way of inputting numbers, easier for coder to edit.
		//      for (int i = 0; i < num.length; i++) {
		//      	gen[i] = r.nextInt(10);
		//      }


		for (int n : gen) { // Loop through all the generated numbers 1 by 1
			System.out.println("CHEAT: " + n); // Print a cheat view of the number for testing purposes
		}

		// Simple input of an integer, although i left out the try / catch statements.
		num[0] = Integer.parseInt(JOptionPane.showInputDialog(null, "Please guess a number between 0-9"));
		num[1] = Integer.parseInt(JOptionPane.showInputDialog(null, "Please guess a number between 0-9"));
		num[2] = Integer.parseInt(JOptionPane.showInputDialog(null, "Please guess a number between 0-9"));

		//  	Alternate way of inputting numbers, easier for coder to edit.
		//      for (int i = 0; i < num.length; i++) {
		//      	num[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Please guess a number between 0-9"));
		//      }

		for (int n : num) { // Looping through all the entered numbers 1 by 1
			if (n <=0 || n > 9) { // Checking if the numbers are outside the validation rules
				// because the numbers are not valid, we send a message then silently exit the program.
				JOptionPane.showMessageDialog(null, "Please only enter numbers between 0-9");
				System.exit(1);
			}
		}

		/**
		 * Required checklist to make sure that all outcomes are accounted for
		 * this is just a reference but can also be used to understand the code.
		 * 
		 * 012 - 012
		 * 012 - 0
		 * 012 - 1
		 * 012 - 2
		 * 01 - 01
		 * 01 - 02
		 * 01 - 12
		 * 12 - 01
		 * 12 - 02
		 * 12 - 12
		 * 012 - 210
		 * 012 - 201
		 * 012 - 102
		 * 012 - 120
		 * 
		 */

		int winnings = 0; // The final winnings

		if (gen[0] == num[0] && gen[1] == num[1] && gen[2] == num[2]) { // All three match in the same order
			winnings = 1000000;
		} else {
			if ((gen[0] == num[2] && gen[1] == num[1] && gen[2] == num[0]) ||
					(gen[0] == num[2] && gen[1] == num[0] && gen[2] == num[1]) ||
					(gen[0] == num[1] && gen[1] == num[0] && gen[2] == num[2]) ||
					(gen[0] == num[0] && gen[1] == num[2] && gen[2] == num[1]) ||
					(gen[0] == num[1] && gen[1] == num[2] && gen[2] == num[0])) { // All three match but all have been tested in all the possible combinations.
				winnings = 1000;
			} else if (gen[0] == num[0]) { // First check for the two matching
				if (gen[1] == num[1] || gen[1] == num[2]) { // another one of the two num[]'s matches so two match
					winnings = 100;
				} else { // Otherwise only one has matched
					winnings = 10;
				}
			} else if (gen[0] == num[1]) { // Second check for the two matching, notice the num[0] has changed to num[1]
				if (gen[1] == num[0] || gen[1] == num[2]) { // another one of the two num[]'s matches so two match
					winnings = 100;
				} else { // Otherwise only one has matched
					winnings = 10;
				}
			} else if (gen[0] == num[2]) { // Thrid check for the two matching, notice the num[1] has changed to num[2]
				if (gen[1] == num[1] || gen[1] == num[0]) { // another one of the two num[]'s matches so two match
					winnings = 100;
				} else { // Otherwise only one has matched
					winnings = 10;
				}
			}
		}

		switch(winnings) { // Same as writing a whole lot of if else's bit easier
		case 0:
			JOptionPane.showMessageDialog(null, "You didnt match anything winning $0");
			break;
		case 10:
			JOptionPane.showMessageDialog(null, "You matched a number winning $10");
			break;
		case 100:
			JOptionPane.showMessageDialog(null, "You matched two numbers winning $100");
			break;
		case 1000:
			JOptionPane.showMessageDialog(null, "You matched all numbers in the wrong order winning $1,000");
			break;
		case 1000000:
			JOptionPane.showMessageDialog(null, "You matched all numbers in the right order winning $1,000,000");
			break;
		default:
			JOptionPane.showMessageDialog(null, "We dont know what you won, something went wrong");
			break;
			// The main reason for not going something like JOptionPane.showMessageDialog(null, "You won $" + winnings);
			// was because i felt the messages required more customisation to make it feel like you are winning more.
		}

	}

}
