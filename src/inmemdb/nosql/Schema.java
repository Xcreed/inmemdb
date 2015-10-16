package inmemdb.nosql;

import inmemdb.structures.BinaryTree;
import inmemdb.structures.DoubleLinkedList;

public class Schema<T> {
	
	private String name;
	private DoubleLinkedList schema = new DoubleLinkedList();
	private T type;//Type of the schema
	private int length;//length of elements
	private byte[] sharedSecret;
	
	/**
	 * Creates a new schema
	 * @param name
	 */
	public Schema(String name) {
		this.name = name;
		System.out.println(name + "table created.");
		//generateSharedSecret()
	}
	
	/**
	 * Adds an index to the schema
	 * Needs to add type parameter
	 */
	public boolean createIndex(String treeType) {
		
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
	public boolean delete() throws Throwable {
		schema = null;
		this.finalize();
	}
	
	/**
	 * Delete an index inside the schema
	 * @param Index
	 */
	public boolean deleteIndex(int Index) {
		
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
	
	public boolean join(Schema otherSchema) {
		
	}
	

}
