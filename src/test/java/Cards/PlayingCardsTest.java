package Cards;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayingCardsTest {

  @Test
  void setIllegalSuit() {
    IllegalArgumentException invalidSuit = Assertions.assertThrows(IllegalArgumentException.class,
        () -> new PlayingCards('W', 10), "Invalid suit!");
  }

  @Test
  void setIllegalFace() {
    IllegalArgumentException invalidFace = Assertions.assertThrows(IllegalArgumentException.class,
        () -> new PlayingCards('D', -1), "Illegal face!");
  }
}