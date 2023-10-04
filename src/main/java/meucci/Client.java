package meucci;

import java.io.*;
import java.net.*;

public class Client {

    int serverPort;
    String serverAddress;

    Socket client;
    BufferedReader stdIn, in;
    PrintWriter out;

    public Client(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    public Socket connect(){

        try {
            client = new Socket(serverAddress, serverPort);
            
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(), true);
            stdIn = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Connesso al server con IP: " + serverAddress +":"+serverPort);

            client.close();

        } catch (UnknownHostException e) {
            System.err.println("Host sconosciuto");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("ERRORE");
            System.exit(1);
        }

        
        return client;
    }

    public void communicate(){

        String userInput;
            
        try {
            while((userInput = stdIn.readLine()) != null){
                out.println(userInput);
                System.out.println("Server: " + in.readLine());
            }
        
        } catch (IOException e) {
                    
        }
    }

}