package inmemdb.structures;

public class BNode<T> extends Node {
	BNode next;
	BNode prev;
	int key; 
	T data;
	
	BPages leftChild;
	BPages rightChild;
	
	public BNode(T value){
		super(value);
		this.data = value;
		this.next = null;
	}

	public BNode(T value, int key){
		super(value);
		this.data = value;
		this.key = key;
		this.next = null;
	}
	
	public T getData(){
		return this.data;
	}
	
	public int getKey(){
		return key;
	}
	
	public String toString(){
		return ""+ data; 
	}
	
}
