package inmemdb.structures;

public class SplayNode<T> extends Node {
	public SplayNode leftChild;
	public SplayNode rightChild;
	public SplayNode parent;
	public T data; 
	
	public SplayNode(){
		super();
		this.leftChild=null;
		this.rightChild=null;
		this.parent=null;
	}
	public SplayNode(T value){
		super(value);
		this.data = value;
		this.leftChild=null;
		this.rightChild=null;
		this.parent=null;
	}
	
	/**
	 * toString allows the data to be printed as
	 * a String.
	 */
	public String toString(){
		return ""+ data; 
	}
}
