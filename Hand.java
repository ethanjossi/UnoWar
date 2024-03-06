/* Author: Ethan Jossi
 * This is the Hand Class for Project 2
 */

public class Hand {
    private Card[] hand;
    private Deck deck;

    /**
     * Creates a new Hand Object
     * Draws cards from the Deck passed in till the Hand is full.
     * @param deck The Deck Object used to draw Cards to fill the hand
     * @param size The number of cards in the hand
     */
    public Hand(Deck deck, int size) {
        this.deck = deck;
        hand = new Card[size];
        for (int i = 0; i < size; i++) {
            hand[i] = this.deck.draw();
        }
    }

    /**
     * Returns the size of the Hand.
     * @return int
     */
    public int getSize() {
        return hand.length;
    }

    /**
     * Returns the Card Object at the specified index
     * Indexing starts at 0.
     * Example: For a hand of size 5, indexes are 0-4
     * @param i Integer representing the position of the card
     * @return The card object at the index
     */
    public Card get(int i) {
        if (i >= hand.length || i < 0) {
            System.out.println("Invalid hand index!");
            return hand[0];
        }
        return hand[i];
    }

    /**
     * Removes the card from the hand. If the card is null, returns false.
     * If the card is not found, returns false.
     * Else, returns true indicating the card was successfully removed from the hand.
     * @param card The card to remove from the hand
     * @return Card
     */
    public boolean remove(Card card) {
        if (card == null) {
            return false;
        }
        // Finding the card in the hand, if it's not there, index = -1
        int cardIndex = -1;
        for (int i = 0; i < hand.length; i++) {
            if (hand[i].equals(card)) {
                cardIndex = i;
            }
        }
        if (cardIndex == -1) {
            return false;
        }
        hand[cardIndex] = deck.draw();
        return true;
    }
}
