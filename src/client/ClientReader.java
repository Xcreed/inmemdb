package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReader {
    Socket socket;
    String in;
    public String ip = "192.168.133.1";

    public ClientReader(Socket socket){
        thread(socket);
        //ClientMethods cm = new ClientMethods();

    }

    public void thread(Socket socket){
        Thread thread = new Thread(){
            @Override
            public void run() {
                // TODO Auto-generated method stub
                try{
                    
                    ClientWriter cliWriter = new ClientWriter(socket);
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