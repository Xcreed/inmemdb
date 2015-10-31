package inmemdb.controller;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import inmemdb.nosql.Schema;

public class serverReader implements Runnable{
	String in, out;
	Socket sSocket;
	serverWriter SerWriter;
	Encryption Encryption =  new Encryption();
	Schema schema;
	
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
							System.out.println("From client:   "+in);
							if(in.equals("Schema")){
								//Name: 
								in = input.readLine();
								String name= in.substring(6);
								//Path:
								in = input.readLine();
								String path = in.substring(6);
								
								//name = Encryption.encrypt(name);
								//path = Encryption.encrypt(name);
								
								//Calls the Schema method 
								System.out.println("Name" + name);
								System.out.println("Path" + path);
								schema = new Schema(name, path);
								
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
								int intLength = Integer.parseInt(length);
								
								//Call the createIndex method
								schema.createIndex(treeType, indexType, indexName, intLength);
						
							}else if(in=="insertToIndex"){
								//containingIndex: 
								in = input.readLine();
								String ContainingIndex = in.substring(17);
								int intContainingIndex = Integer.parseInt(ContainingIndex);
								//itemToInsert:
								in = input.readLine();
								String itemToInsert = in.substring(14);
								
								//Call the insertToIndex method
								schema.insertToIndex(intContainingIndex, itemToInsert);
								
							}else if (in=="deleteIndex"){
								//index
								in = input.readLine();
								String index = in.substring(11);	
								int intIndex = Integer.parseInt(index);

								//Call the deleteIndex method
								schema.deleteIndex(intIndex);
								
							}else if (in=="deleteInIndex"){
								//containingIndex: 
								in = input.readLine();
								String containingIndex = in.substring(15);
								int intContainingIndex = Integer.parseInt(containingIndex);
								//itemToRemove: 
								in = input.readLine();
								String itemToRemove = in.substring(12);
								
								//Call the deleteInIndex method here
								schema.deleteInIndex(intContainingIndex, itemToRemove);
					
							}else if (in=="search"){
								//searchItem
								in = input.readLine();
								String searchItem = in.substring(11);
								
								//Call the search method here
								schema.search(searchItem);
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