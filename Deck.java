/* Author: Ethan Jossi
 * This is the Deck Class for Project 2
 */

public class Deck {

    private Card[] deck;
    private int top;

    /**
     * Creates a new Deck Object
     * Initializes all the Card Objects in the deck.
     * Then calls the shuffle() method and scrambles the deck
     */
    public Deck() {
        this.top = 0;
        this.deck = new Card[52];

        // Fills the deck full of unique cards
        int cardPosition = 0;
        for (int suit = 1; suit <= 4; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                this.deck[cardPosition] = new Card(rank, suit);
                cardPosition++;
            }
        }
        shuffle(); // Ensures that the deck starts shuffled
    }

    /**
     * Scrambles all the Card objects in the Card[] deck
     * This method uses the Durstenfeld-Fisher-Yates algorithm.
     */
    public void shuffle() {
        for (int i = deck.length-1; i >= 1; i--) {
            int j = (int) (Math.random() * (double) (i + 1)); // Choosing two random indexes to swap
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    /**
     * Draws and returns the top Card object from the deck.
     * If the deck is empty, shuffles the deck first, and then returns the top card.
     * @return The "top" card on the deck
     */
    public Card draw() {

        // If the deck is empty, shuffle the deck and reset the top variable to the first card.
        if (top == 52) {
            shuffle();
            top = 1;
        } else {
            top++;
        }
        return deck[top-1]; // Return the top card on the deck
    }

    /**
     * Returns the number of card objects remaining in the deck
     * @return int
     */
    public int cardsRemaining() {
        return 52-top;
    }

    /**
     * Returns true if the deck is empty, otherwise false.
     * @return boolean
     */
    public boolean isEmpty() {
        return cardsRemaining() == 0;
    }

    /**
     * Overrides the default toString Object method.
     * Returns a string of the deck in the following format:
     * ["Ace of Spades", "Ace of Diamonds", "Two of clubs", .....]
     * @return String
     */
    @Override
    public String toString() {
        String total = "[";
        for (int i = 0; i < deck.length; i++) {
            total += deck[i].toString() + ", ";
        }
        return total + "]";
    }
}
