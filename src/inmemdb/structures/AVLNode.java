package inmemdb.structures;


public class AVLNode<T> extends Node{
	public AVLNode leftChild;
	public AVLNode rightChild;
	
	public int height;
	public T data;
	int key;

	/*public AVLNode(T value) {
		super(value);
		this.data = value;
		leftChild = null;
		rightChild = null;
		height = 0;
	}*/
	
	public AVLNode(T value, int key) {
		super(value);
		this.data = value;
		this.key = key;
		leftChild = null;
		rightChild = null;
		height = 0;
	}

	
	/**
	 * toString allows the data to be handled as
	 * a String.
	 */
	public String toString(){
		return ""+ data; 
	}
}