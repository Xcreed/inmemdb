package inmemdb.structures;


public class BSTNode<T> extends Node{

	public T data;
	int key; 
	
	public BSTNode leftChild;
	public BSTNode rightChild;
	
	public BSTNode(T value){
		super(value);
		this.data = value;
		leftChild = null;
		rightChild = null;
	}
	
	public BSTNode(T value, int key){
		super(value);
		this.data = value;
		leftChild = null;
		rightChild = null;
		this.key = key;
	}

	public String toString(){
		//return "Name: "+ name + "     Data: " + data;
		return ""+data;
	}
}