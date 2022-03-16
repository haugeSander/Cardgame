package no.ntnu.idatg2001.kortspill.Cards;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HandOfCardsTest {

  @Test
  void checkCards() {
    HandOfCards hand = new HandOfCards(52);
    assertEquals(hand.checkCards(), "Royal Flush!");
  }
}