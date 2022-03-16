package no.ntnu.idatg2001.kortspill.Cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    int hCounter = (int) hand.stream().filter(c -> c.getSuit() == 'H').count();
    int dCounter = (int) hand.stream().filter(c -> c.getSuit() == 'D').count();
    int sCounter = (int) hand.stream().filter(c -> c.getSuit() == 'S').count();
    int cCounter = (int) hand.stream().filter(c -> c.getSuit() == 'C').count();

    if (hCounter >= 5 || dCounter >= 5 || sCounter >= 5 || cCounter >= 5)
      flush = true;

    return flush;
  }

  /**
   * Method of seeing if a hand has Straight.
   * @return Boolean, straight = true.
   */
  private boolean checkCardsForStraight() {
    boolean straight = false;
    ArrayList<Integer> sorted = new ArrayList<>();
    int consecutive = 0;

    for (PlayingCards b : hand) {
      sorted.add(b.getFace());
    }

    List<Integer> uniqueSorted = sorted.stream().distinct().collect(Collectors.toList());
    Collections.sort(uniqueSorted);

    for (int i = 1; i < uniqueSorted.size(); i++) {
      if (uniqueSorted.get(i) - uniqueSorted.get(i-1) == 1)
        consecutive++;
      else
        consecutive=0;
    }

    if (consecutive >= 5) {
      straight = true;
    }
    return straight;
  }

  /**
   * Counts if there is multiples of same faces.
   * @return String if there is a pair or triple, blank if nothing.
   */
  private String sameFaceCount() {
    boolean pair = false;
    boolean triple = false;
    int count = 0;

    for (int i = 0; i < hand.size(); i++) {
      int finalI = i;
      count = (int) hand.stream().filter(c -> c.getFace() == finalI).count();
      System.out.println(count);

      if (count == 2)
        pair = true;
      if (count == 3) {
        triple = true;
      }
    }

    if (pair)
      return "Pair!";
    else if (triple)
      return "Triple!";
    else
      return "";
  }

  /**
   * Method to check all point giving combinations.
   * @return True if cards has Flush/Straight/pair or triple.
   */
  public String checkCards() {
    if (checkCardsForStraight() && checkCardsForFlush()) {
      return "Royal Flush!";
    } else if (checkCardsForStraight()) {
      return "Straight!";
    } else if (checkCardsForFlush()) {
      return "Flush!";
    } else if (sameFaceCount().equalsIgnoreCase("Triple!")) {
      return "Triple!";
    } else if (sameFaceCount().equalsIgnoreCase("Pair!")) {
      return "Pair";
    }else
      return "No points.";
  }

  /**
   * Method counting the hearts.
   * @return Returns all heart cards as String.
   */
  public String countHearts() {
    List<PlayingCards> hearts = hand.stream().filter(c -> c.getSuit() == 'H').toList();
    if (hearts.isEmpty())
      return "";
    else
      return hearts.toString();
  }

  /**
   * Method which counts the faces' values.
   * @return integer of all face values summed.
   */
  public int countFaces() {
    return hand.stream().map(PlayingCards::getFace).reduce(0,(a,b) -> a+b);
  }

  /**
   * Getter for the hand.
   * @return String representation of the hand.
   */
  public String getHand() {
    return hand.toString();
  }
}
