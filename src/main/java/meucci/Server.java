package meucci;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 6789;
        
        try {
            ServerSocket server = new ServerSocket(port);

            Socket client = server.accept();            

            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            
            System.out.println("Client connesso sulla porta: " + port);

            String inputStr = in.readLine();
            if(inputStr != null){

                System.out.println("Stringa ricevuta: " + inputStr);
                out.println(inputStr.toUpperCase());
            }

            out.close();
            in.close();
            server.close();
        } catch (IOException e) {

        }
    }
}
