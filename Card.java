/* Author: Ethan Jossi
 * This is the Card Class for project 2
 */

public class Card {

    private int rank;
    private int suit;
    private static final String[] rankNames = new String[]{"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
            "Nine", "Ten", "Jack", "Queen", "King"}; // A String array representing all the possible card names
    private static final String[] suitNames = new String[]{"Spades", "Hearts", "Clubs", "Diamonds"}; // A String array representing the card suits

    /**
     * The Constructor to create a new card object
     * @param rank int - rank of the card
     * @param suit int - suit of the card
     */
    public Card(int rank, int suit) {
        // Checks to make sure the card is within a valid range
        if (1 <= rank && rank <= 13 && 1 <= suit && suit <= 4) {
            this.rank = rank;
            this.suit = suit;
        } else {
            System.out.println("Invalid Card");
            this.rank = 1;
            this.suit = 1;
        }
    }

    /**
     * gets the Rank Number
     * @return - integer - rank number
     */
    public int getRankNum() {
        return this.rank;
    }

    /**
     * Gets the Suit Number
     * @return int
     */
    public int getSuitNum() {
        return this.suit;
    }

    /**
     * Returns the rank of the card, in a name format
     * @return String
     */
    public String getRankName() {
        return rankNames[rank-1];
    }

    /**
     * Returns the suit of the card, in a name format
     * @return String
     */
    public String getSuitName() {
        return suitNames[suit-1];
    }

    /**
     * Overrides the default toString method
     * Returns the card name follow by "of" and then suit name
     * Example: "Ace of Spades"
     * @return String
     */
    @Override
    public String toString() {
        return getRankName() + " of " + getSuitName();
    }

    /**
     * Overrides the default equals method.
     * A Card object is equal to another card object if the two
     * objects have the same suit number and rank number.
     * @param obj Any object. Recommended only Card objects. Otherwise, always false.
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (obj instanceof Card) {
            Card c = (Card) obj;
            return this.rank == c.rank && this.suit == c.suit;
        } else {
            return false;
        }
    }
}
