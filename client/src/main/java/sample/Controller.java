package sample;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import javax.swing.text.html.ImageView;

public class Controller {

  @FXML
  public ImageView image1;

  public void onMouse(MouseEvent mouseEvent) {
    image1.getImage().getGraphics().getColor().brighter();
  }
}
