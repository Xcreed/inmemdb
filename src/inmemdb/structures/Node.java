package inmemdb.structures;

/**
 * Node class. 
 *
 * @param <T>
 */
public abstract class Node<T> implements Comparable<Node<T>>{
	
	private T data;
    
	/**
	 * Constructor. 
	 * 
	 */
	public Node(){
		data = null;
	}
	
	/**
	 * Constructor node. 
	 * 
	 * @param value
	 */
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
    
    /**
     * Returns the data as a type String.
     * @return String
     */
    public String toString(){
        return data.toString();
    }
	
    /**
     *Returns the data of a given node. 
     * @return data
     */
    public T getData(){ 
    	return data;
    }

}