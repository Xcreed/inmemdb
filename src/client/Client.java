package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	///ClientReader cR = new ClientReader();
	//ClientWriter cW = new ClientWriter(cR.socket);
	
	public static void main(String[] args) throws IOException{
		settingSocket();
		/*Socket socket;
		ClientReader cR = new ClientReader();
		socket = cR.socket;
		if (socket == null){
			System.out.println("It is null");
		}
		ClientWriter cW = new ClientWriter(cR.socket);
		ClientMethods cM = new ClientMethods(cW);*/
	}
	
	public static void settingSocket(){
		String ip = "192.168.133.1";
		try {
			Socket socket = new Socket(ip, 8080);
			ClientReader cR = new ClientReader(socket);
			ClientWriter cW = new ClientWriter(socket);
			ClientMethods cM = new ClientMethods(socket);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}