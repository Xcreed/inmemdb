package inmemdb.controller;

import java.net.Socket;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class clientReader {
    Socket socket;
    String in;
    public static String ip = "192.168.133.1";

    public clientReader(){
        thread();

    }

    public void thread(){
        Thread thread = new Thread(){
            @Override
            public void run() {
                // TODO Auto-generated method stub
                try{
                    socket = new Socket(ip, 8080);
                    clientWriter cliWriter = new clientWriter(socket);
                    cliWriter.sendMessage("cR From client");
                    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    while(true){
                        in = input.readLine();
                        System.out.println("in from server: "+in);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        };
        thread.start();
    }


}
