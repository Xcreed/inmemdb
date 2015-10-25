package inmemdb.structures;


public class BSTNode<T> extends Node{
	T data;
	int key; 
	
	BSTNode leftChild;
	BSTNode rightChild;
	
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