package Cards;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class DeckOfCardsTest {

  @Test
  void getDeckOfCards() {
    DeckOfCards newDeck = new DeckOfCards();
    assertEquals(newDeck.getDeckOfCards().size(), 52);
  }

  @Test
  void dealHand() {
    DeckOfCards newDeck = new DeckOfCards();
    ArrayList<PlayingCards> handOfCards = newDeck.dealHand(5);
    assertEquals(handOfCards.size(), 5);
  }
}