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
							System.out.println("From client "+in);
							if(in=="Schema"){
								//Name: 
								in = input.readLine();
								String name= in.substring(6);
								//Path:
								in = input.readLine();
								String path = in.substring(6);
								
								//Call the Schema method 
								
							}else if (in=="createIndex"){
								//treeType: 
								in = input.readLine();
								String treeType= in.substring(10);
								//indexType: 
								in = input.readLine();
								String indexType = in.substring(11);
								//indexName: 
								in = input.readLine();
								String indexName= in.substring(11);
								//length: 
								in = input.readLine();
								String length = in.substring(8);
								
								//Call the createIndex method
							
							}else if(in=="insertIndex"){   
								in = input.readLine();
								//index:
								String index = in.substring(7);
								
								//Call the insertIndex method
								
							}else if(in=="insertToIndex"){
								//containingIndex: 
								in = input.readLine();
								String containingIndex = in.substring(17);
								//itemToInsert:
								in = input.readLine();
								String itemToInsert = in.substring(14);
								
								//Call the insertToIndex method
								
							}else if(in=="createFolder"){
								//path: 
								in = input.readLine();
								String path = in.substring(6);
								
								//Call the createFolder method 
								
							}else if (in=="deleteIndex"){
								//index
								in = input.readLine();
								String index = in.substring(11);	
								
								//Call the deleteIndex method 
								
							}else if (in=="search"){
								//searchItem
								in = input.readLine();
								String searchItem = in.substring(11);
								
								//Call the search method here
								
							}else if (in=="deleteInIndex"){
								//containingIndex: 
								in = input.readLine();
								String containingIndex = in.substring(15);
								//itemToRemove: 
								in = input.readLine();
								String itemToRemove = in.substring(12);
								
								//Call the deleteInIndex method here
							}
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