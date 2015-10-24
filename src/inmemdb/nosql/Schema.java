package inmemdb.nosql;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.activation.MimetypesFileTypeMap;

import inmemdb.structures.BinarySearchTree;
import inmemdb.structures.DoubleLinkedList;
import inmemdb.structures.Tree;

public class Schema<T> {
	
	protected String name;
	protected DoubleLinkedList<Index> schema = new DoubleLinkedList<Index>();
	protected T type;//Type of the schema
	protected int length;//length of elements
	protected byte[] sharedSecret;
	protected ParameterizedType indexType;
	protected String newFolderLoc;
	
	/**
	 * Creates a new schema
	 * Missing folder creation, sharedSecret
	 * abstract factory implementation
	 * @param name
	 */
	public Schema(String name) {
		this.name = name;
		//createFolder()
		System.out.println(name + " table created.");
		//generateSharedSecret()
	}
	
	/**
	 * Adds an index to the schema
	 */
	public <U extends Index> boolean insertIndex(U index) {
		schema.insertAtEnd(index);
		return true;
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
	
	/**
	 * Inserts an element in the index structure
	 * @param element
	 */
	public <U> void insertToIndex(U element) {

	}
	
	public void join(Schema otherSchema) {
		
	}
	

}
