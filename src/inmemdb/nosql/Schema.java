package inmemdb.nosql;

import inmemdb.structures.BinaryTree;
import inmemdb.structures.DoubleLinkedList;

public abstract class Schema<T> {
	
	protected String name;
	protected DoubleLinkedList<T> schema = new DoubleLinkedList<T>();
	protected T type;//Type of the schema
	protected int length;//length of elements
	protected byte[] sharedSecret;
	
	/**
	 * Creates a new schema
	 * @param name
	 */
	public Schema(String name) {
		this.name = name;
		System.out.println(name + " table created.");
		//generateSharedSecret()
	}
	
	/**
	 * Adds an index to the schema
	 * Needs to add type parameter
	 */
	public boolean createIndex(int I) {
		
//		if (treeType.equals("BiTree")) {
//			//Creates a binary Tree and adds it to the list
//			BinaryTree<T> biTree = new BinaryTree();
//			schema.insertAtBeginning(biTree);
//			
//		}
		schema.insertAtEnd(new BinaryTree<T>());
		return false;
		
	}
	
	/**
	 * Delete schema
	 * --Implement delete won't delete joined schema
	 * @throws Throwable 
	 */
	public boolean delete() throws Throwable {
		schema = null;
		this.finalize();
		return false;
	}
	
	/**
	 * Delete an index inside the schema
	 * @param Index
	 */
	public boolean deleteIndex(int Index) {
		return false;
		
	}
	
	/**
	 * Searches an item in all the schema
	 * --Missing interpretation
	 * @param searchItem
	 */
	public <T> void search(T searchItem) {
		
	}
	
//	/**
//	 * Inserts an element in the schema
//	 * @param element
//	 */
//	public void insert(T element) {
//		
//		
//	}
	
	public void join(Schema otherSchema) {
		
	}
	

}
