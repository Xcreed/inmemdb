package inmemdb.structures;

/**
 * Node class for the SplayTree.
 * 
 * @param <T>
 */

public class SplayNode<T> extends Node {
	public SplayNode leftChild;
	public SplayNode rightChild;
	public SplayNode parent;
	public T data; 
	public int key;
	
	/*public SplayNode(){
		super();
		this.leftChild=null;
		this.rightChild=null;
		this.parent=null;
	}*/
	
	/**
	 * Constructor
	 * 
	 * @param value
	 * @param key
	 */
	public SplayNode(T value, int key){
		super(value);
		this.data = value;
		this.leftChild=null;
		this.rightChild=null;
		this.parent=null;
		this.key = key;
	}
	
	/**
	 *Return the data a type String.
	 * 
	 * @return String
	 */
	public String toString(){
		return ""+ data; 
	}
}
