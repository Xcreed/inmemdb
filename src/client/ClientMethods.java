package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientMethods {
	ClientWriter cW ;
	
	public ClientMethods(Socket socket){
		this.cW = new ClientWriter(socket);
		InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String inBr;
		
		System.out.println("Methods");
		
		System.out.println("1. Schema(String name, String path)");
		System.out.println("2. createIndex(String treeType, String indexType, String indexName, int length)");
		System.out.println("3. insertToIndex(int containingIndex, String itemToInsert)");
		System.out.println("4. deleteIndex(String index)");
		System.out.println("5. deleteInIndex(String containingIndex, String itemToRemove)");
		System.out.println("6. search(String searchItem)");
		
		System.out.println("Enter the number of the method that you want to execute");
		
		cW.sendMessage("message from client");
		while(true){
			try{
		        inBr = br.readLine();
		        if(inBr.equals("1")){
		        	String name="";
		        	String path="";
		        	System.out.println("Enter name: ");
		        	while(true){
		        		inBr = br.readLine();
		        		if (inBr!=null){
		        			if(name==""){
		        				name = inBr;
		        				break;
		        			}
		        		}
		        	}
		        	System.out.println("Enter path: ");
		        	while(true){
		        		inBr = br.readLine();
		        		if(inBr!=null){
		        			if(path==""){
		        				path = inBr;
		        				break;
		        			}
		        		}
		        	}
		        	System.out.println("Name: "+name+"   Path: "+path);
		        	Schema( name,  path, cW);
		        }else if(inBr.equals("2")){
		        	String treeType="";
		        	String indexType="";
		        	String indexName="";
		        	String length="";
		        	
		        	System.out.println("treeType : ");
		        	while(true){
		        		inBr = br.readLine();
		        		if (inBr!=null){
		        			if(treeType==""){
		        				treeType = inBr;
		        				break;
		        			}
		        		}
		        	}
		        	System.out.println("Enter indexType: ");
		        	while(true){
		        		inBr = br.readLine();
		        		if(inBr!=null){
		        			if(indexType==""){
		        				indexType = inBr;
		        				break;
		        			}
		        		}
		        	}
		        	System.out.println("Enter indexName: ");
		        	while(true){
		        		inBr = br.readLine();
		        		if(inBr!=null){
		        			if(indexName==""){
		        				indexName = inBr;
		        				break;
		        			}
		        		}
		        	}
		        	System.out.println("Enter length: ");
		        	while(true){
		        		inBr = br.readLine();
		        		if(inBr!=null){
		        			if(length==""){
		        				length = inBr;
		        				break;
		        			}
		        		}
		        	}
		        	System.out.println("treeType: "+treeType+"   indexType: "+indexType+"   indexName: "+indexName+"   length: "+length);
		        	createIndex( treeType,  indexType,  indexName,  length);
		        }else if(inBr.equals("3")){
		        	String containingIndex="";
		        	String itemToInsert="";
		        	System.out.println("Enter containingIndex : ");
		        	while(true){
		        		inBr = br.readLine();
		        		if (inBr!=null){
		        			if(containingIndex==""){
		        				containingIndex = inBr;
		        				break;
		        			}
		        		}
		        	}
		        	System.out. println("Enter itemToInsert: "+itemToInsert);
		        	while(true){
		        		inBr = br.readLine();
		        		if (inBr!=null){
		        			if(itemToInsert==""){
		        				itemToInsert = inBr;
		        				break;
		        			}
		        		}
		        	}
		        	System.out. println("containingIndex: "+containingIndex+"   itemToInsert: "+itemToInsert);
		        	insertToIndex(containingIndex, itemToInsert);
	        	}else if(inBr.equals("4")){
		        	String index="";
		        	System.out.println("Enter index : ");
		        	while(true){
		        		inBr = br.readLine();
		        		if (inBr!=null){
		        			if(index==""){
		        				index = inBr;
		        				break;
		        			}
		        		}
		        	}
		        	System.out. println("index: "+index);
		        	deleteIndex(index);
	        	}else if(inBr.equals("5")){
		        	String containingIndex="";
		        	String itemToRemove="";
		        	System.out.println("Enter containingIndex : ");
		        	while(true){
		        		inBr = br.readLine();
		        		if (inBr!=null){
		        			if(containingIndex==""){
		        				containingIndex = inBr;
		        				break;
		        			}
		        		}
		        	}
		        	System.out.println("Enter itemToRemove : ");
		        	while(true){
		        		inBr = br.readLine();
		        		if (inBr!=null){
		        			if(itemToRemove==""){
		        				itemToRemove = inBr;
		        				break;
		        			}
		        		}
		        	}
		        	System.out. println("containingIndex: "+containingIndex+"   itemToRemove: "+itemToRemove);
		        	deleteInIndex(containingIndex, itemToRemove);
	        	}else if(inBr.equals("6")){
		        	String searchItem="";
		        	System.out.println("Enter searchItem : ");
		        	while(true){
		        		inBr = br.readLine();
		        		if (inBr!=null){
		        			if(searchItem==""){
		        				searchItem = inBr;
		        				break;
		        			}
		        		}
		        	}
		        	System.out. println("searchItem: "+searchItem);
		        	search(searchItem);
	        	}else{
	        		System.out.println("Invalid. Try again:");
	        	}
			} catch (IOException e) {
	            // TODO Auto-generated catch block
				System.out.println("Error  Class: ClientMethods");
	            e.printStackTrace();
	        }
	        
		}
		
	}
	
	public void Schema(String name, String path, ClientWriter cW){
		cW.sendMessage("Schema");
		cW.sendMessage("Name: "+name);
		cW.sendMessage("Path: "+ path);
	}
	
	public void createIndex(String treeType, String indexType, String indexName, String length){   //int length 
		cW.sendMessage("createIndex");
		cW.sendMessage("treeType: "+ treeType);
		cW.sendMessage("indexType: "+ indexType);
		cW.sendMessage("indexName: "+ indexName);
		cW.sendMessage("length: "+ length);
	}
	

	public void insertToIndex(String containingIndex, String itemToInsert) {
		cW.sendMessage("insertToIndex");
		cW.sendMessage("containingIndex: " + containingIndex);
		cW.sendMessage("itemToInsert: " + itemToInsert);
	}
	

	
	private void deleteIndex(String index) {    //int
		cW.sendMessage("deleteIndex");
		cW.sendMessage("index: " + index);
	}
	
	private void deleteInIndex(String containingIndex, String itemToRemove) {    //int
		cW.sendMessage("deleteInIndex");
		cW.sendMessage("containingIndex: " + containingIndex);
		cW.sendMessage("itemToRemove: " + itemToRemove);
	}

	private void search(String searchItem) {
		cW.sendMessage("search");
		cW.sendMessage("searchItem: " + searchItem);
	}
	
}
