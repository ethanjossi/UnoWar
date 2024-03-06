/* Author: Ethan Jossi
 * This is the BiggestCardAI Class for project 2
 */

public class BiggestCardAI extends AI {

    /**
     * Gets the play from the AI. This AI returns the largest possible card
     * that is playable in the hand, by rank. If none of the cards are playable,
     * returns null.
     * @param hand The hand of card for the AI to choose from
     * @param cardPile The card pile for the AI to play on
     * @return Card
     */
    @Override
    public Card getPlay(Hand hand, CardPile cardPile) {
        Card largestValidCard = null; // The end card that is returned
        int largestValidCardRank = -1; // Stores the rank of that card so we can compare ranks.
        for (int i =0; i < hand.getSize(); i++) { // For loop finds the biggest card
            if (cardPile.canPlay(hand.get(i)) && largestValidCardRank < hand.get(i).getRankNum()) {
                largestValidCard = hand.get(i);
                largestValidCardRank = hand.get(i).getRankNum();
            }
        }
        return largestValidCard;
    }

    /**
     * Returns the toString - "Biggest Card AI".
     * @return String
     */
    public String toString() {
        return "Biggest Card AI";
    }
}
