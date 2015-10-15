package inmemdb.nosql;

import inmemdb.structures.BinaryTree;
import inmemdb.structures.DoubleLinkedList;

public class Schema {
	
	String name;
	DoubleLinkedList schema = new DoubleLinkedList();
	
	/**
	 * Creates a new schema
	 * @param name
	 */
	public Schema(String name) {
		this.name = name;
	}
	
	/**
	 * Adds an index to the schema
	 * Needs to add type parameter
	 */
	public void createIndex(String treeType) {
		
		if (treeType.equals("BiTree")) {
			//Creates a binary Tree and adds it to the list
			BinaryTree<?> biTree = new BinaryTree();
			schema.insertAtBeginning(biTree);
			
		}
		
	}
	
	/**
	 * Delete schema
	 * --Implement delete won't delete joined schema
	 * @throws Throwable 
	 */
	public void delete() throws Throwable {
		schema = null;
		this.finalize();
	}
	
	/**
	 * Delete an index inside the schema
	 * @param Index
	 */
	public void deleteIndex(int Index) {
		
	}
	
	/**
	 * Searches an item in all the schema
	 * --Missing interpretation
	 * @param searchItem
	 */
	public <T> void search(T searchItem) {
		
	}
	
	/**
	 * Inserts an element in the schema
	 * @param element
	 */
	public <T> void insert(T element) {
		
	}
	

}
