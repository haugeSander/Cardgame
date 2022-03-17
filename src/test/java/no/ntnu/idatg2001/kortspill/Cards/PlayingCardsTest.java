package no.ntnu.idatg2001.kortspill.Cards;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URL;
import no.ntnu.idatg2001.kortspill.Controller.Controller;
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

  @Test
  void combineToPng() {
    PlayingCards h10 = new PlayingCards('H', 10);
    assertEquals(h10.getPngValue(), "H10.png");
    URL urlForPhoto = Controller.class.getResource("/DeckOfCardsPNG/C1.png");
    System.out.println(urlForPhoto);
  }
}