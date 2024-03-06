/* Author: Ethan Jossi
 * This is the Card Class for project 2
 */

public class UnoWarMatch {
    private AI ai1;
    private AI ai2;

    /**
     * The Constructor for UnoWarMatch. Takes in two AI objects as the
     * parameters. Can be a BiggestCardAI or SmallestCardAI too.
     * @param ai1 The first AI playing the game - this will be player 1
     * @param ai2 The second AI playing the game - this will be player 2
     */
    public UnoWarMatch(AI ai1, AI ai2) {
        this.ai1 = ai1;
        this.ai2 = ai2;
    }

    /**
     * Plays a single game of UnoWarMatch.
     * Returns true if AI1 won that game, otherwise returns
     * false indicating that AI2 won.
     * @return boolean
     */
    public boolean playGame() {
        // Initialize all the local needed variables
        Deck deck = new Deck();
        Hand ai1Hand = new Hand(deck, 5);
        Hand ai2Hand = new Hand(deck, 5);

        int ai1Wins = 0;
        int ai2Wins = 0;
        boolean AI1playFirst = true;

        // Plays rounds until one of the AI's has won 10 rounds.
        while (ai1Wins < 10 && ai2Wins < 10) {
            if (playRound(deck, ai1Hand, ai2Hand, AI1playFirst)) {
                ai1Wins++;
                AI1playFirst = true;
            } else {
                ai2Wins++;
                AI1playFirst = false;
            }
        }
        return ai1Wins == 10;

    }

    /**
     * Plays a single round of UnoWarMatch.
     * Returns true if AI1 won the round, otherwise
     * false indicating that AI2 won the round.
     * @param deck Deck - the deck that the game is associated with
     * @param ai1Hand Hand - AI1's hand
     * @param ai2Hand Hand - AI2's hand
     * @param AI1playFirst boolean - true if AI1 plays first this round
     * @return
     */
    private boolean playRound(Deck deck, Hand ai1Hand, Hand ai2Hand, boolean AI1playFirst) {
        // Returns true if ai1 won the round, false if ai2 won.
        // take turns of ai1 and ai2 playing until one of them can't play.

        // We need a new top card everytime we start a new round.
        CardPile pile = new CardPile(deck.draw());

        Card ai1Play = null;
        Card ai2Play = null;

        if (AI1playFirst) { // AI1 plays first this round
            //System.out.println("AI1 played first"); // For testing purposes
            while (true) { // This while loops allows the AI's to take turns playing cards until one of them can't play.
                ai1Play = ai1.getPlay(ai1Hand, pile);
                //System.out.println(ai1Play); // For testing purposes
                pile.play(ai1Play);
                if (!ai1Hand.remove(ai1Play)) {
                    return false;
                }

                ai2Play = ai2.getPlay(ai2Hand, pile);
                //System.out.println(ai2Play); // For testing purposes
                pile.play(ai2Play);
                if (!ai2Hand.remove(ai2Play)) {
                    return true;
                }
            }
        } else { // AI2 plays first this round
            //System.out.println("AI2 played first"); // For testing purposes
            while (true) { // This while loops allows the AI's to take turns playing cards until one of them can't play.
                ai2Play = ai2.getPlay(ai2Hand, pile);
                //System.out.println(ai2Play); // For testing purposes
                pile.play(ai2Play);
                if (!ai2Hand.remove(ai2Play)) {
                    return true;
                }

                ai1Play = ai1.getPlay(ai1Hand, pile);
                //System.out.println(ai1Play); // For testing purposes
                pile.play(ai1Play);
                if (!ai1Hand.remove(ai1Play)) {
                    return false;
                }
            }
        }
    }

    /**
     * Returns the winRate with a given number of games
     * The win rate is the number of times that AI1 won.
     * @param nTrials int
     * @return double
     */
    public double winRate(int nTrials) {
        int totalAI1Wins = 0;

        // Plays a bunch of games and counts the number of times AI1 won.
        for (int i = 0; i < nTrials; i++) {
            if (playGame()) {
                totalAI1Wins++;
            }
        }
        return ((double) totalAI1Wins)/((double) nTrials); // Returns the win rate
    }
}
