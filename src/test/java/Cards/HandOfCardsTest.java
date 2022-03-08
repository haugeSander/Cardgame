package Cards;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HandOfCardsTest {

  @Test
  void checkCards() {
    HandOfCards hand = new HandOfCards(7);
    assertTrue(hand.checkCards());
  }
}