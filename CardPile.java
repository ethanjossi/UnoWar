/* Author: Ethan Jossi
 * This is the CardPile Class for project 2
 */

public class CardPile {
    private Card topCard;
    private int size;

    /**
     * Constructor used to initialize a new card pile.
     * @param topCard The start or "top" of the card pile.
     */
    public CardPile(Card topCard) {
        this.topCard = topCard;
        this.size = 1;
    }

    /**
     * Returns true if the card is playable on the card pile, otherwise false.
     * @param card A card to play on the card pile
     * @return boolean
     */
    public boolean canPlay(Card card) {
        if (card == null) {
            return false;
        }
        // Returns true if the num and suit are the same, otherwise false
        return card.getRankNum() >= topCard.getRankNum() || card.getSuitNum() == topCard.getSuitNum();
    }

    /**
     * Plays a card on the card pile, making it the new top card.
     * Check first to make sure that the card is playable.
     * If it is not playable, prints "Illegal move detected!".
     * @param card The card to play
     */
    public void play(Card card) {
        if (canPlay(card)) {
            topCard = card;
            size++;
        } else {
            System.out.println("Illegal move detected!");
        }
    }

    /**
     * Returns the number of cards in the card pile
     * @return int
     */
    public int getNumCards() {
        return size;
    }

    /**
     * Returns the top card of the card pile
     * @return Card
     */
    public Card getTopCard() {
        return topCard;
    }
}
