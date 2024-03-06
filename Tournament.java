/* Author: Ethan Jossi
 * This is the Card Class for project 2
 */

public class Tournament {

    private static final int NUMBER_OF_TRIALS = 1000;

    public static void main(String[] args) {
        AI randomCardAI = new AI();
        SmallestCardAI smallestCardAI = new SmallestCardAI();
        BiggestCardAI biggestCardAI = new BiggestCardAI();

        System.out.println("Random Card AI vs. Random Card AI winRate: " + new UnoWarMatch(randomCardAI, randomCardAI).winRate(NUMBER_OF_TRIALS));
        System.out.println("Random Card AI vs. Smallest Card AI winRate: " + new UnoWarMatch(randomCardAI, smallestCardAI).winRate(NUMBER_OF_TRIALS));
        System.out.println("Random Card AI vs. Biggest Card AI winRate: " + new UnoWarMatch(randomCardAI, biggestCardAI).winRate(NUMBER_OF_TRIALS));

        System.out.println("Smallest Card AI vs. Random Card AI winRate: " + new UnoWarMatch(smallestCardAI, randomCardAI).winRate(NUMBER_OF_TRIALS));
        System.out.println("Smallest Card AI vs. Smallest Card AI winRate: " + new UnoWarMatch(smallestCardAI, smallestCardAI).winRate(NUMBER_OF_TRIALS));
        System.out.println("Smallest Card AI vs. Biggest Card AI winRate: " + new UnoWarMatch(smallestCardAI, biggestCardAI).winRate(NUMBER_OF_TRIALS));

        System.out.println("Biggest Card AI vs. Random Card AI winRate: " + new UnoWarMatch(biggestCardAI, randomCardAI).winRate(NUMBER_OF_TRIALS));
        System.out.println("Biggest Card AI vs. Smallest Card AI winRate: " + new UnoWarMatch(biggestCardAI, smallestCardAI).winRate(NUMBER_OF_TRIALS));
        System.out.println("Biggest Card AI vs. Biggest Card AI winRate: " + new UnoWarMatch(biggestCardAI, biggestCardAI).winRate(NUMBER_OF_TRIALS));
    }
}
