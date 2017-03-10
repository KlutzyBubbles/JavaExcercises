package cards;

import java.util.Random;

/**
 * @author Lee Tzilantonis
 */
public class Card {
    
    private char suit; // The char value of the suit
    private int number; // The number for the card (1-13 or Ace,2-10, Jack, Queen, King)

    public Card() {
        Random r = new Random(); // Creating an instance of the Random object to be use multiple times
        this.number = r.nextInt(PickTwoCards.CARDS_IN_SUIT) + 1; // Creating a random integer from 1-13 (notice the +1)
        switch (r.nextInt(4) + 1) { // Same as above but with 4 numbers (for the suit)
        //  and using a switch statement so the value doesn't need to be stored for as long
        /**
         * Please note there are two other ways of making this more efficient
         * 
         * 1. changing the numbers 1-4 to 0-3 so that no +1 is needed.
         * 2. keeping the suit as an int in the object and changing it when needed
         *    Although this method will slow the program down if the getSuit is called more than once.
         * 
         * 1 = Spades
         * 2 = Hearts
         * 3 = Diamonds
         * 4 = Clubs
         * Default (aka else) = Diamonds
         */
            case 1:
                this.suit = 's';
                break;
            case 2:
                this.suit = 'h';
                break;
            case 3:
                this.suit = 'd';
                break;
            case 4:
                this.suit = 'c';
                break;
            default:
            	this.suit = 'd';
            	break;
        }
    }
    
    public Card(char suit, int number) {
    	// This is an extra constructor i added to show how you can choose your own card
    	// Notice that there are no explicit changes to variables, it is all handled with methods
        this.setSuit(suit);
        this.setNumber(number);
    }
    
    public char getSuit() { // Return the suit in raw form (char)
        return suit;
    }

    public void setSuit(char suit) { // set the suit to a value
        switch(suit) {
            case 's':
            case 'h':
            case 'd':
            case 'c':
                break;
            default: // default handles any chars that are not s, h, d or c and changes it to d
                this.suit = 'd';
                return;
        }
        this.suit = suit;
    }

    public int getNumber() { // Return the card number
        return number;
    }

    public void setNumber(int number) { // Set the cards number
        if (number > 0 && number <= PickTwoCards.CARDS_IN_SUIT) { // Checking that the number is valid
            this.number = number;
            return; // return; can be called with no parameters when in a void method to stop the method from going any further.
        } // because the code inside hasnt been executed there is no need for an else
        this.number = 1; // default value is 1 or Ace
    }
    
    public String getValue() { // Return the raw value (suit and number)
        return this.number + "" + this.suit;
    }
    
    public String getDisplayValue() { // Return a readable version of the card
        StringBuilder b = new StringBuilder(); // String builder is more efficient than String += "something"
        switch (this.number) { // Switching the number to check for special cards
        /**
         * 1 = Ace
         * 11 = Jack
         * 12 = Queen
         * 13 = King
         * Default = Add the number
         */
            case 1:
                b.append("Ace");
                break;
            case 11:
                b.append("Jack");
                break;
            case 12:
                b.append("Queen");
                break;
            case 13:
                b.append("King");
                break;
            default:
                b.append(this.number);
                break;
        }
        b.append(" of "); // Put the next append here so it isnt written 5 times for no reason.
        switch(this.suit) { // Switch the suit to get the proper name (self-explanitory)
            case 's':
                b.append("Spades");
                break;
            case 'h':
                b.append("Hearts");
                break;
            case 'd':
                b.append("Diamonds");
                break;
            case 'c':
                b.append("Clubs");
                break;
            default: // Somehow after the proper validation the char is still wrong, in this case the string returned is "ERROR"
                this.suit = 'd';
                return "ERROR";
        }
        return b.toString(); // Combining the StringBuilder object into a String object
    }
    
    public boolean isSameAs(Card c) { // The comparison method to help with eliminating card duplications
        if (this.getNumber() == c.getNumber()) { // Checking if the numbers are the same
            if (this.getSuit() == c.getSuit()) // When the numbers are the same if the suits are too then return true;
                return true;
        }
        return false;
    }
    
}
