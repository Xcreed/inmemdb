package inmemdb.nosql;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import inmemdb.structures.BinaryTree;

public class Table {

	
	private MongoClient mc;
	private DB db;
	private DBCollection table;
	/**
	 * Creates a new table inside the database
	 * @param tableName
	 */
	
	public void Table() {
		mc = new MongoClient("localhost", 27017);
		db = mc.getDB("inmemdb");
	}
	
	public void createTable(String tableName) {
		
		table = db.getCollection(tableName);
		System.out.println("Table created successfully");	
	}

	
	public void addIndex(String treeType){
		
		if (treeType.equals("BiT")) {
			BinaryTree<String> biTree = new BinaryTree<String>();
			//table.save(new BasicDBObject());
		}
	}
}
