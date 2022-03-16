package no.ntnu.idatg2001.kortspill;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Application {

  @Override
  public void start(Stage stage) throws Exception {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("kortspill-sandeth.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 600, 600);

    stage.setTitle("CardGame");
    stage.setScene(scene);
    stage.show();
  }

  @Override
  public void stop() {
    System.exit(0);
  }

  public static void main(String[] args) {
    launch(args);
  }
}

