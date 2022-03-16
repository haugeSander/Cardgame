package no.ntnu.idatg2001.kortspill.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import no.ntnu.idatg2001.kortspill.Cards.HandOfCards;

public class Controller implements Initializable {
  public javafx.scene.control.TextArea cardToText;
  public TextField SumOfFaces;
  public TextField CardsOfHearts;
  public TextField FlushTF;
  private HandOfCards hand;

  /**
   * Exits program.
   */
  @FXML
  private void onExitClicked() {
    System.exit(0);
  }

  /**
   * When dealHand is clicked
   * the hand is set as a string representation.
   */
  @FXML
  private void onDealHandClicked() {
    cardToText.setText(hand.getHand());
  }

  /**
   * Button action of the Check cards button.
   * Sets textFields accordingly to HandOfCards methods.
   */
  @FXML
  private void onCheckCardsClicked() {
    FlushTF.setText(hand.checkCards());

    if (hand.countHearts().isBlank() || hand.countHearts().isEmpty())
      CardsOfHearts.setText("No Hearts!");
    else
      CardsOfHearts.setText(hand.countHearts());

    SumOfFaces.setText(String.valueOf(hand.countFaces()));
  }

  /**
   * Constructor for JavaFX program.
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    hand = new HandOfCards(5);
  }
}
