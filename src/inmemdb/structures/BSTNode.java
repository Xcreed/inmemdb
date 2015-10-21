package inmemdb.structures;

public class BSTNode<T> extends Node{
	T data;
	
	BSTNode leftChild;
	BSTNode rightChild;
	
	public BSTNode(T value){
		super(value);
		this.data = value;
		leftChild = null;
		rightChild = null;
	}

	public String toString(){
		//return "Name: "+ name + "     Data: " + data;
		return ""+data;
	}
}