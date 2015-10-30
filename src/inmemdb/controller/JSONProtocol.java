package inmemdb.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import inmemdb.nosql.Index;
import inmemdb.nosql.IndexAVL;
import inmemdb.nosql.IndexBTS;
import inmemdb.nosql.IndexSplay;
import inmemdb.nosql.Schema;
import inmemdb.structures.AVLTree;
import inmemdb.structures.BinarySearchTree;
import inmemdb.structures.SplayTree;

public class JSONProtocol <T>{
	
	File jsonFile = new File("res/jsonprotocol.json");
	
	protected Schema table;
	
	
	public void writeSchema(Schema schemaToSave) {
		
		this.table = schemaToSave;
		JSONObject clientObj = new JSONObject();
				
		clientObj.put("name", table.name);
		JSONArray indexes = new JSONArray();

		for (int i = 1; i < table.schema.getLength(); i++) {
			
			Index index = (Index) table.schema.getItem(i);
			
			//Make sure index cannot have more than 3 elements
			
			if (index instanceof IndexBTS) {
				IndexBTS indexType = (IndexBTS) table.schema.getItem(i);
				BinarySearchTree indexTree = indexType.getTree();
				for (int j = 1; j < 4; j++) {
					T data = indexTree.keyBST.searchKeyReturnValue(j);
					indexes.add(indexType.getName() + ": " + data);
				}
				
			} else if (index instanceof IndexAVL) {
				IndexAVL indexType = (IndexAVL) table.schema.getItem(i);
				AVLTree indexTree = indexType.getTree();
				for (int j = 1; j < 4; j++) {
					T data = (T) indexTree.keyAVL.searchKeyReturnValue(j);
					indexes.add(indexType.getName() + ": " + data);
				}
			} else if (index instanceof IndexSplay) {
				IndexSplay indexType = (IndexSplay) table.schema.getItem(i);
				SplayTree indexTree = indexType.getTree();
				//Method not implement for Splay Tree
//				for (int j = 1; j < 4; j++) {
//					T data = indexTree.keySP.searchKeyReturnValue(j);
//					indexes.add(indexType.getName() + ": " + data);
//				}
			}
		}
		clientObj.put("Indexes: ", indexes);

		System.out.println("If this fails, you're not using Windows");
		File schemaFile = new File(table.getSchemaLocation() + "\\" + table.name + ".json");
		try (FileWriter file = new FileWriter(schemaFile)) {
			file.write(clientObj.toJSONString());
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + clientObj);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
}
