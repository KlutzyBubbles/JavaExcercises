package cards;

import java.util.Random;

/**
 * @author Lee Tzilantonis
 */
public class CardWithEnum {

	public enum Number {
		// Note how all the Enums are in order, this helps with the comparison
		Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King;
	}
	
	public enum Suit {
		// We could do extra comparison on suits as well but i put them in any order
		Clubs, Diamonds, Hearts, Spades;
	}
	
	private Number number; // The char value of the suit
    private Suit suit; // The number for the card (1-13 or Ace,2-10, Jack, Queen, King)

    public CardWithEnum() {
        Random r = new Random(); // Creating an instance of the Random object to be use multiple times
        this.number = Number.values()[r.nextInt(Number.values().length)]; // Creating a random number from the Number enums
        this.suit = Suit.values()[r.nextInt(Suit.values().length)]; // Same as above but with 4 numbers (for the suit)
    }
    
    public CardWithEnum(Suit suit, Number number) {
    	// This is an extra constructor i added to show how you can choose your own card
    	// there are no explicit changes to variables, it is all handled with methods
        this.setSuit(suit);
        this.setNumber(number);
    }
    
    public Suit getSuit() { // Return the suit
        return suit;
    }

    public void setSuit(Suit suit) { // set the suit to a value
        this.suit = suit;
    }

    public Number getNumber() { // Return the card number
        return number;
    }

    public void setNumber(Number number) { // Set the cards number
        this.number = number;
    }
    
    public String getDisplayValue() { // Return a readable version of the card
        StringBuilder b = new StringBuilder(); // String builder is more efficient than String += "something"
        return b.append(this.number.toString()).append(" of ").append(this.suit.toString()).toString(); // Generating the string using the Enum.toString()
    }
    
    public boolean isSameAs(CardWithEnum c) { // The comparison method to help with eliminating card duplications
        if (this.getNumber() == c.getNumber()) { // Checking if the numbers are the same
            if (this.getSuit() == c.getSuit()) // When the numbers are the same if the suits are too then return true;
                return true;
        }
        return false;
    }
	
}
