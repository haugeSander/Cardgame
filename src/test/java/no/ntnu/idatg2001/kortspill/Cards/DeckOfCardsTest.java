package no.ntnu.idatg2001.kortspill.Cards;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import org.junit.jupiter.api.Test;

class DeckOfCardsTest {

  @Test
  void getDeckOfCards() {
    DeckOfCards newDeck = new DeckOfCards();
    assertEquals(newDeck.getDeckOfCards().size(), 52);
  }

  /**
   * Test to check if there is any identical cards.
   */
  @Test
  void checkNoIdenticalCards() {
    DeckOfCards newDeck = new DeckOfCards();
    HashSet<String> noIdentical = new HashSet<>();
    for (PlayingCards b : newDeck.getDeckOfCards()) {
      noIdentical.add(b.toString());
    }
    assertEquals(noIdentical.size(), 52);
  }

  @Test
  void dealHand() {
    DeckOfCards newDeck = new DeckOfCards();
    ArrayList<PlayingCards> handOfCards = newDeck.dealHand(5);
    assertEquals(handOfCards.size(), 5);
  }
}