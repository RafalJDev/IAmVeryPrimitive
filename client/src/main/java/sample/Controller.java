package sample;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Controller {
  
  @FXML
  public ImageView image1;
  
  @FXML
  public void onMouse(MouseEvent mouseEvent) {
    image1.setFitHeight(400.0);
  }
  
}