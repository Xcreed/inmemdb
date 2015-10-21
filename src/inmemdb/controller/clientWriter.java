package inmemdb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class clientWriter {
	Socket socket;
    String message;
    PrintWriter output;

    //public clientWriter(Socket socket){
    //    this.socket = socket;
    //}
    public clientWriter(Socket socket){
        this.socket = socket;
    }

    public void sendMessage(String message){
        try {
            output = new PrintWriter(socket.getOutputStream(),true);
            output.println(message);
            output.flush();
            System.out.println("cliW message sent");

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
