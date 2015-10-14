package inmemdb.structures;

public abstract class Node<T> implements Comparable<Node<T>>{
	
	private T data;
    
    public Node(T value){
        this.data = value;
    }
     
    /**
     * a negative, zero, or a positive integer as the node's value 
     * is greater than, equal to, or less than the compared node's value
     */
    public int compareTo(Node<T> a){
        String temp1 = this.toString();
        String temp2 = a.toString();
        return temp1.compareTo(temp2);
    }
     
    public String toString(){
        return data.toString();
    }
	
    public T getData(){ 
    	return data;
    }

}
