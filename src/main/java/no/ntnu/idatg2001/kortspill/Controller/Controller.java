package no.ntnu.idatg2001.kortspill.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import no.ntnu.idatg2001.kortspill.Cards.HandOfCards;
import no.ntnu.idatg2001.kortspill.Cards.PlayingCards;

public class Controller implements Initializable {
  //public javafx.scene.control.TextArea cardToText;
  public TextField SumOfFaces;
  public TextField CardsOfHearts;
  public TextField FlushTF;
  public ImageView Card1;
  public ImageView Card2;
  public ImageView Card3;
  public ImageView Card4;
  public ImageView Card5;
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
    URL urlForPhoto = Controller.class.getResource("/DeckOfCardsPNG/");
    Image image1 = new Image(urlForPhoto + hand.getHandAsPng().get(0));
    Card1.setImage(image1);
    Image image2 = new Image(urlForPhoto + hand.getHandAsPng().get(1));
    Card2.setImage(image2);
    Image image3 = new Image(urlForPhoto + hand.getHandAsPng().get(2));
    Card3.setImage(image3);
    Image image4 = new Image(urlForPhoto + hand.getHandAsPng().get(3));
    Card4.setImage(image4);
    Image image5 = new Image(urlForPhoto + hand.getHandAsPng().get(4));
    Card5.setImage(image5);
    //for (int i = 1; i-1 < hand.getHandAsPng().size(); i++) {
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
