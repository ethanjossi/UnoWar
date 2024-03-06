/* Author: Ethan Jossi
 * This is the AI Class for project 2
 */

public class AI {

    /**
     * Gets the play of the AI. Returns the first possible card to play
     * from the hand. If none of the cards can be played, returns false.
     * @param hand The hand of card for the AI to choose from
     * @param cardPile The card pile for the AI to play on
     * @return Card
     */
    public Card getPlay(Hand hand, CardPile cardPile) {
        for (int i = 0; i < hand.getSize(); i++) {
            if (cardPile.canPlay(hand.get(i))) {
                return hand.get(i);
            }
        }
        return null;
    }

    /**
     * Returns the toString - "Random Card AI".
     * @return String
     */
    public String toString() {
        return "Random Card AI";
    }
}
