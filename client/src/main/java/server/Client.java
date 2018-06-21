package server;

import com.google.gson.Gson;
import model.Ship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
  
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    System.out.println("Client");
    
    Socket socket = new Socket("localhost", 10000);
    
    BufferedReader bufferedReader =
        new BufferedReader(new InputStreamReader(socket.getInputStream()));
    
    String s = bufferedReader.readLine();
    
    System.out.println(s);
    
    s = bufferedReader.readLine();
    System.out.println(s);
    
    getShipFromServer(bufferedReader);
    
    socket.close();
  }
  
  public static void getShipFromServer(BufferedReader bufferedReader) throws IOException, ClassNotFoundException {
    
    String s = "";
    
    s = bufferedReader.readLine();
    System.out.println(s + "1");
    
    if (s.equals("gson")) {
      s = bufferedReader.readLine();
      if (s.equals("model.Ship")) {
        
        s = bufferedReader.readLine();
        
        Gson gson = new Gson();
        Ship ship = gson.fromJson(s, Ship.class);
        
        System.out.println("Das is ship " + ship + " und fcuken " + ship.name);
      }
    }
    
    
  }
}
