/* Author: Ethan Jossi
 * This is the SmallestCardAI Class for project 2
 */

public class SmallestCardAI extends AI {

    /**
     * Gets the play from the AI. Returns the smallest possible playable
     * card in the hand, by rank. If none of the cards are playable,
     * returns null.
     * @param hand The hand of card for the AI to choose from
     * @param cardPile The card pile for the AI to play on
     * @return Card
     */
    @Override
    public Card getPlay(Hand hand, CardPile cardPile) {
        Card smallestValidCard = null; // The end card that is returned
        int smallestValidCardRank = 15; // Stores the rank of that card so we can compare ranks.
        for (int i =0; i < hand.getSize(); i++) { // For loop finds the smallest playable card.
            if (cardPile.canPlay(hand.get(i)) && smallestValidCardRank > hand.get(i).getRankNum()) {
                smallestValidCard = hand.get(i);
                smallestValidCardRank = hand.get(i).getRankNum();
            }
        }
        return smallestValidCard;
    }

    /**
     * Returns the toString - "Smallest Card AI".
     * @return String
     */
    public String toString() {
        return "Smallest Card AI";
    }
}
