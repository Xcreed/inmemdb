package inmemdb.structures;

/**
 * Node class for the BinarySearchTree.
 *
 * @param <T>
 */
public class BSTNode<T> extends Node{

	public T data;
	int key; 
	public BSTNode leftChild;
	public BSTNode rightChild;
	
	/**
	 * Constructor
	 * 
	 * @param value
	 */
	public BSTNode(T value){
		super(value);
		this.data = value;
		leftChild = null;
		rightChild = null;
	}
	
	/**
	 * Constructor
	 * 
	 * @param value
	 * @param key
	 */
	public BSTNode(T value, int key){
		super(value);
		this.data = value;
		leftChild = null;
		rightChild = null;
		this.key = key;
	}
	
	/**
	 * Makes the data a String. 
	 * 
	 * @return String
	 */
	public String toString(){
		//return "Name: "+ name + "     Data: " + data;
		return ""+data;
	}
}