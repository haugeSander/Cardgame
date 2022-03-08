package Cards;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class which represents a hand of cards.
 * Minimum amount equals 5, and may contain up to X.
 */
public class HandOfCards {
  private DeckOfCards deck;
  private ArrayList<PlayingCards> hand;

  public HandOfCards(int amount) {
    deck = new DeckOfCards();
    hand = deck.dealHand(amount);
  }

  /**
   * Method for checking if hand has flush.
   * @return True if there is flush.
   */
  private boolean checkCardsForFlush() {
    boolean flush = false;

    int redCards = (int) (hand.stream().filter(c -> c.getSuit() == 'H').count() +
            hand.stream().filter(c -> c.getSuit() == 'D').count());
    if (redCards > 4) {
      flush = true;
    }
    return flush;
  }

  /**
   * Poor method of seeing if a hand has Straight.
   * @return Boolean, straight = true.
   */
  private boolean checkCardsForStraight() {
    boolean straight = false;
    ArrayList<Integer> sorted = new ArrayList<>();
    int consecutive = 0;

    for (PlayingCards b : hand) {
      sorted.add(b.getFace());
    }
    Collections.sort(sorted);

    for (int i = 1; i < sorted.size(); i++) {
      if (sorted.get(i-1) + sorted.get(i) == 1) { //Something wrong
        consecutive++;
      }
    }
    if (consecutive > 5)
      straight = true;

    System.out.println(consecutive);

    return straight;
  }

  /**
   * Method to check all point giving combinations.
   * @return True if cards has Flush or Straight.
   */
  public boolean checkCards() {
    if (checkCardsForStraight() && checkCardsForFlush()) {
      System.out.println("Straight & Flush!!");
      return true;
    } else if (checkCardsForStraight()) {
      System.out.println("Straight!");
      return true;
    } else if (checkCardsForFlush()) {
      System.out.println("Flush!");
      return true;
    } else
      return false;
  }
}
