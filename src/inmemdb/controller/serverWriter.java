package inmemdb.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



public class serverWriter{
	Socket socket;
	String out;
	PrintWriter output;
	
	public serverWriter(Socket socket){
		this.socket = socket;
		
	}
	
	public void sendMessage(String Message) {
		// TODO Auto-generated method stub
		try{
			output = new PrintWriter(socket.getOutputStream(),true);
			output.println(Message);
			output.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}

}