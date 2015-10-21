package inmemdb.controller;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class serverReader implements Runnable{
	String in, out;
	Socket sSocket;
	serverWriter SerWriter;
	
	public serverReader(Socket socket){
		this.sSocket = socket;
		SerWriter = new serverWriter(sSocket);
		thread();
	}
	
	public void thread(){
		Thread thread = new Thread(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try{
						BufferedReader input = new BufferedReader(new InputStreamReader(sSocket.getInputStream()));
						while(true){
							in = input.readLine();
							System.out.println(in);
							System.out.println("From client (0,11): "+in.substring(0,12));
						}
					}catch(Exception e){
						e.printStackTrace();
					}
				
				}
		};
		thread.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}