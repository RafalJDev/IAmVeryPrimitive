package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

  @FXML
  public javax.swing.text.html.ImageView image1;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    URL resource = getClass().getResource("/sample/sample.fxml");

    Parent root = FXMLLoader.load(resource);

    primaryStage.setTitle("Hello World");
    primaryStage.setScene(new Scene(root, 300, 275));

    primaryStage.show();
  }

  public void onMouse(MouseEvent mouseEvent) {
    image1.getImage().getGraphics().getColor().brighter();
  }
}
