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
	public <U> boolean createIndex(String treeType) {
		
		return false;
	}
	
//	public void setArgsType(int treeIndex, String argsType) {
////		if (argsType.equals("Number")) {
////			Tree tree = schema.getItem(treeIndex);
////			
////			Tree<V extends Number> t = new Tree();
////		}
////		else if (argsType.equals("String")) {
////			
////		}
////		else if (argsType.equals("Image")) {
////			
////		}
////		else if (argsType.equals("Binary")) {
////			
////		}
////		else if (argsType.equals("Video")) {
////			
////		}
////		else if (argsType.equals("char")) {
////			
////		}
////		
//	}
	
	
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

	/**
	 * Checks the type of file
	 * Usable for image/video files
	 * Only jpeg and mp4
	 * @param fileName
	 * @return
	 * @throws IOException 
	 */
	public String getFileType(String fileName) throws IOException {    
//		"image/jpeg" -- "video/mp4"
		Path filePath = Paths.get(fileName);
		return Files.probeContentType(filePath);
	}
	

}
