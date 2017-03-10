package cards;

/**
 * @author Lee Tzilantonis
 */
public class PickTwoCards {

    public static int CARDS_IN_SUIT = 13; // The number of cards in a suit (13*4=52) so no jokers);

    public static void main(String[] args) {
        Card c1 = new Card(); // Creating an instance of a random card
        Card c2 = new Card();
        
        if (c1.isSameAs(c2)) { // Using the build in object method to check card values
            while (c1.isSameAs(c2)) { // Making sure a new card is selected until the cards are different
                c2 = new Card();
            }
        }
        
        System.out.println("Player: " + c1.getDisplayValue()); // Displaying generated cards
        System.out.println("Computer: " + c2.getDisplayValue() + "\n"); // Same as above but with a line break after it
        
        if (c1.getNumber() == c2.getNumber()) { // Checking if the numbers are the same
            System.out.print("No one wins! you have the same numbered card");
        } else if (c1.getNumber() > c2.getNumber()) { // Checking if the first card has a higher number
            System.out.println("Player wins by " + (c1.getNumber() - c2.getNumber())); // Result along with the difference
        } else { // Otherwise the first card has to be the smaller card
            System.out.println("Computer wins by " + (c2.getNumber() - c1.getNumber())); // Result along with the difference
        }
        
        // Doing the same as above but with CardWithEnum
        CardWithEnum c3 = new CardWithEnum();
        CardWithEnum c4 = new CardWithEnum();
        
        if (c3.isSameAs(c4)) { // Using the build in object method to check card values
        	while (c3.isSameAs(c4)) { // Making sure a new card is selected until the cards are different
        		c3 = new CardWithEnum();
        	}
        }
        
        System.out.println("Player: " + c3.getDisplayValue()); // Displaying generated cards
        System.out.println("Computer: " + c4.getDisplayValue() + "\n"); // Same as above but with a line break after it
        
        if (c3.getNumber() == c4.getNumber()) { // Checking if the Number Enums are the same
        	System.out.print("No one wins! you have the same numbered card");
        } else if (c3.getNumber().compareTo(c4.getNumber()) > 0) { // in this case c3 is a higher value than c4
        	// compareTwo() returns: a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
        	System.out.println("Player wins by " + (c3.getNumber().compareTo(c4.getNumber()))); // Result along with the difference
        } else {
        	System.out.println("Computer wins by " + (c4.getNumber().compareTo(c3.getNumber()))); // Result along with the difference
        }
    }
    
}
