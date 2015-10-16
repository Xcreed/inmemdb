package inmemdb.structures;

public class intAVLNode {
	public intAVLNode leftChild;
	public intAVLNode rightChild;
	
	public int height;
	public int data;

	public intAVLNode(){
		leftChild = null;
        rightChild = null;
        height = 0;
	}

	public intAVLNode(int data){
		leftChild = null;
		rightChild = null;
        this.data = data;
        height = 0;
    } 
	
	public String toString(){
		return ""+ data; 
	}
	
}
