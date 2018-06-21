package server;

import com.google.gson.Gson;
import model.Ship;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  
  public static void main(String[] args) throws IOException {
    System.out.println("Server");
    
    ServerSocket serverSocket = new ServerSocket(10000);
    
    Socket socket = serverSocket.accept();
    
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
    
    out.println("hej");
    out.println("hej2");

//    out.flush();
    
    sentToClient(out);
    
    serverSocket.close();
    socket.close();
  }
  
  public static void sentToClient(PrintWriter out) {
    
    Ship statek = new Ship("Statek");
    
    Gson gson = new Gson();
    
    String s = gson.toJson(statek);
    System.out.println(s);
    
    out.println("gson");
    out.println("model.Ship");
    out.println(s);
  }
}
