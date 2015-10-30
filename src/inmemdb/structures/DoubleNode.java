package inmemdb.structures;
/**
 * Class node for the DoubleLinkedList.
 *
 * @param <T>
 */

public class DoubleNode<T> {
	
	
	private DoubleNode<T> next; 
	private DoubleNode<T> prev;
	private T data; 			
	
	
	/**
	 * Construct an element (data) for the list.
	 * 
	 * @param data
	 */
	public DoubleNode (T data) {
		this.data = data;
	}

	/**
	 * Set the next node in the list. 
	 * 
	 * @param next
	 */
	public void setNext(DoubleNode<T> next) {
		this.next = next;
	}
	
	/**
	 * Set the previous node in the list. 
	 * 
	 * @param prev
	 */
	public void setPrev(DoubleNode<T> prev){
		this.prev = prev;
	}
	
	/**
	 * Returns the next node in the list. 
	 * 
	 * @return node
	 */
	public DoubleNode<T> getNext() {
		return next;
	}
	
	/**
	 * Return the previous node in the list.
	 * 
	 * @return node
	 */
	public DoubleNode<T> getPrev(){
		return prev;
	}
	
	/**
	 * Returns the data (info)  of a node.
	 * 
	 * @return object
	 */
	public Object getData() {
		return data;
	}
}