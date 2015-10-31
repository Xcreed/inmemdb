package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientWriter {
	Socket socket;
    String message;
    PrintWriter output;

    //public clientWriter(Socket socket){
    //    this.socket = socket;
    //}
    public ClientWriter(Socket socket){
        this.socket = socket;
    }

    public void sendMessage(String message){
        try {
            output = new PrintWriter(socket.getOutputStream(),true);
            output.println(message);
            output.flush();
            System.out.println("cliW message sent");

        } catch (UnknownHostException e) {
        	System.out.println("Error1  Class: ClientWriter");
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
        	System.out.println("Error2  Class: ClientWriter");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
