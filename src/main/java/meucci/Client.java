package meucci;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 6789;
        
        try (
            Socket client = new Socket(serverAddress, serverPort);
            
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

                String userInput;
            
                while((userInput = stdIn.readLine()) != null){
                    out.println(userInput);
                    System.out.println("Risposta del server " + in.readLine());
                }
            
            String response = in.readLine();
            System.out.println("Server: " + response); 

            client.close();
        } catch (IOException e) {

        }
    }
}