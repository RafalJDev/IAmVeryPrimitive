package sample;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class Main extends Application {
  
  public static void main(String[] args) {
    launch(args);
  }
  
  @Override
  public void start(Stage primaryStage) throws Exception {
    URL resource = getClass().getResource("/sample/sample.fxml");
    
    Parent root = FXMLLoader.load(resource);
    
    String image = getClass().getResource("/img/battleship.png").toExternalForm();
    root.setStyle("-fx-background-image: url('" + image + "'); " +
                      "-fx-background-position: center center; " +
                      "-fx-background-repeat: stretch;");
    
    primaryStage.setTitle("Hello World");
    primaryStage.setScene(new Scene(root, 1000, 975));
    
    primaryStage.setMaximized(true);
    
    primaryStage.show();
    
    System.out.println("tu");
    
    new Thread(() -> {
      playKurwaMusic();
    })
        .start();
    
    someMudaFukaTask(primaryStage);
  }
  
  public void someMudaFukaTask(Stage primaryStage) {
    Task<Integer> task = new Task<Integer>() {
      @Override
      protected Integer call() throws Exception {
        System.out.println("tak");
        
        try {
          Thread.sleep(3500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        
        Button button = new Button();
        
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(button);
        Scene scene = new Scene(stackPane, 100, 100);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        return 0;
      }
    };
    
    new Thread(task)
        .start();
  }
  
  public void playKurwaMusic() {
    String musicFile = "Cyberpunk 2077 – E3 2018 Trailer Music  DJ Hyper - SPOILER (4K).mp3";     // For example
    
    Media sound = new Media(new File(musicFile).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(sound);
    mediaPlayer.play();
    try {
      Thread.sleep(20000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
