package Cards;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HandOfCardsTest {

  @Test
  void checkCards() {
    HandOfCards hand = new HandOfCards(52);
    assertEquals(hand.checkCards(), "Royal Flush!");
  }

  @Test
  void getPngList() {
    HandOfCards hand = new HandOfCards(5);
    System.out.println(hand.getHandAsPng());
  }
}