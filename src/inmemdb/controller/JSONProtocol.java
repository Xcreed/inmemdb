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

public class JSONProtocol {
	
	File jsonFile = new File("res/jsonprotocol.json");
	
	protected Schema table;
	
	
	public void writeSchema(Schema schemaToSave) {
		
		this.table = schemaToSave;
		JSONObject clientObj = new JSONObject();
				
		clientObj.put("name", table.name);
		JSONArray indexes = new JSONArray();
		System.out.println(table.schema.getLength());
		for (int i = 0; i < table.schema.getLength(); i++) {
			
			Index index = (Index) table.schema.getItem(i);
			
			System.out.println(index.getClass());
			
			if (index instanceof IndexBTS) {
				IndexBTS indexType = (IndexBTS) table.schema.getItem(i);
				BinarySearchTree indexTree = indexType.getTree();
				System.out.println("Hey");
				indexes.add("" + indexType.getName() + ": " + indexTree.getDataString());
//				bool = indexTree.findNode(searchItem);
			} else if (index instanceof IndexAVL) {
				IndexAVL indexType = (IndexAVL) table.schema.getItem(i);
				AVLTree indexTree = indexType.getTree();
				indexes.add("" + indexType.getName() + ": " + indexTree.getDataString());
//				bool = indexTree.search(searchItem);
			} else if (index instanceof IndexSplay) {
				IndexSplay indexType = (IndexSplay) table.schema.getItem(i);
				SplayTree indexTree = indexType.getTree();
				indexes.add("" + indexType.getName() + ": " + indexTree.getDataString());
//				bool = indexTree.search(searchItem);
			}
		}
		clientObj.put("Indexes: ", indexes);

		try (FileWriter file = new FileWriter(jsonFile,true)) {
			file.write(clientObj.toJSONString());
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + clientObj);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
}
