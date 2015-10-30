package inmemdb.controller;

import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{
	
	private ServerSocket sSocket;
	public static void main(String[] args){
		new Server();
	}
	
	public Server(){
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			 System.out.println("Server running and listening");
			 sSocket = new ServerSocket(8080);
			 while(true){
				Socket serSocket= sSocket.accept();
				serverWriter serWriter = new serverWriter(serSocket);
				serverReader SerReader = new serverReader(serSocket);
				serWriter.sendMessage("Sent from Server");
				
			 }
		}catch(Exception e){
			System.out.println("Error in server class: "+ e);
		}
	}
}
