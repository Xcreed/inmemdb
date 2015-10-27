package inmemdb.structures;

/**
 * Class for doubly linked list, linear data structure for the game
 * @author Randy
 *
 * @param <T>
 */

public class DoubleLinkedList <T> {
	
	private DoubleNode<T> head = null; //null node for the head of the list
	private DoubleNode<T> tail = null; //null node for the tail of the list
	private int index;
	
	/**
	 * Return the length of the list.
	 * 
	 * @return length (integer)
	 */
	public int getLength() {
		int counter = 0; 
		DoubleNode<T> tmp = head;
		
		while (tmp != null) {
			counter++;
			tmp = tmp.getNext();
			}
		return counter;
	}
	
	/**
	 * Returns the position number (index)  of a given element.
	 * Position number (index) starts at cero (0).
	 * @param pData
	 * @return position
	 */
	
	public int positionInList(T pData){
		
		int index = 0;
		DoubleNode<T> tmp = head; 
		
		while(tmp != null){
			if(tmp.getData().equals(pData)){
				index++;
				break;
			}else{
				tmp = tmp.getNext();
			}
		}
		return index;
	}
		
	/**
	 * Returns a true if list's empty, else false.
	 * 
	 * @return boolean 
	 */
	public boolean isEmpty(){
		if (head == null){  //optional: getLength() == 0
			return true;
		}else{
			return false;
			}
		}
	
	/**
	 * Insert an element (pData) at the beginning of the list.
	 * 
	 * @param pData
	 */
	public void insertBeginning(T pData){
		
		DoubleNode<T> data = new DoubleNode<T>(pData);
		
		if(isEmpty()){
			head = tail = data;
			index = 0;
		}else{
			head.setPrev(data); //head.prev = data;
		}
		data.setNext(head); //data.next = head;
		head = data; //head = data;
		index++;
	}
	
	/**
	 * Insert an element (tData) at the end of the list.
	 * 
	 * @param pData
	 */
	public void insertEnd(T pData){
		
		DoubleNode<T> data = new DoubleNode<T>(pData);
		
		if(isEmpty()){
			head = tail = data;
			index = 0;
		}else{
			tail.setNext(data); //tail.next = data;
			data.setPrev(tail); //data.prev = tail;
		}
		tail = data; //tail = head;
		index++;
	}
	
	/**
	 * Return a list (type StringBuilder) that shows all the node together.
	 * 
	 * @return list 
	 */
	public void print(){	
		
		StringBuilder list = new StringBuilder();
		DoubleNode<T> tmp = head;
		
		while(tmp != null){
			//System.out.println(list);
			list.append(tmp.getData() + ",");
			tmp = tmp.getNext();
		}
		System.out.println(list);
		//return list;
	}
	
	/**
	 * Given a number, search and return the element
	 * from the position in the list. 
	 * @param i
	 * @return item
	 */
	public T getItem(int i) {
		
		if (head == tail) {
			return (T) head.getData();
		}
		
		else  {
		
			DoubleNode<T> temp = head;
			
			if (temp != null) {
				for (int j = 1; j < i; j++) {
					
					temp = temp.getNext();
				}
			} else {
				System.out.println("Index out of reach");
				return null;
			}
			return (T) temp.getData();

		}
			
	}
	
	/**
	 * Return the search (pData) element, else false.
	 * @param pData
	 * @return pData
	 */
	public Object search(T pData){
		DoubleNode<T> data = new DoubleNode<T>(pData);
		boolean bool = false;
	
		if(isEmpty()){
			return null;
		}else{
			DoubleNode<T> tmp = head; 
			while(tmp != null){
				if(tmp.getData() == pData){
					return tmp;
				}else{
					tmp = tmp.getNext(); 
				} 
			}
			System.out.println("Item not found");
			return null;
		}
	}
	
	/**
	 * Removes the first the element of the list. 
	 */
	public void deleteBeginning(){
		
		//List only has one element
		if (head == tail) {
			head = tail = null;
		} else {
	
		DoubleNode<T> tmp = head.getNext();
		
		head = head.getNext();
		head.setNext(tmp.getNext());
		head.setPrev(null);
		}
	}
	
	/**
	 * Removes the last element of the list. 
	 */
	public void deleteEnd() {
		//List only has one element
		if (head == tail) {
			head = tail = null;
		} else {
			tail = tail.getPrev();
			tail.setNext(null);			
		}
	}
	
	/**
	 * Deletes (pData) from any middle position inside the list.
	 * Any middle position are any position that isn't the beginning
	 * or the end. 
	 * @param pData
	 */
	public void deleteMiddle(T pData){
		
		DoubleNode<T> tmp = head;
		if(contains(pData) == true){
			while(tmp != null){
				if (tmp.getData() == pData){
					tmp.getPrev().setNext(tmp.getNext());
					tmp.setPrev(null);
					tmp.getNext().setPrev(tmp.getPrev());
					tmp.setNext(null);
					break;
				}else{
					tmp = tmp.getNext();
				}
			}	
		}else{
			return;
		}
	}
	
	
	/**
	 * Deletes an given item from the list at any position. 
	 * @param pData
	 */
	public void delete(T pData){
		
		DoubleNode<T> tmp = head;
		
		while(tmp != null){
			if(tmp.getData() == pData && tmp.getPrev() == null){ // is at head
				deleteBeginning();
				break;
			}else if(tmp.getData() == pData && tmp.getPrev() != null && tmp.getNext() != null){ // is at some middle
				deleteMiddle(pData);
				break;
			}else if(tmp.getData() == pData && tmp.getNext() == null){ // is at tail
				deleteEnd();
				break;
			}else{
				tmp = tmp.getNext();
			}
		}
	}


	/**
	 * Return the search  element, else false.
	 * @param pData
	 * @return pData
	 */
	public boolean contains(T pData){
		DoubleNode<T> data = new DoubleNode<T>((T) pData);
		boolean bool = false;
	
		if(isEmpty()){
			return false;
		}else{
			DoubleNode<T> tmp = head; 
			while(tmp != null){
				if(tmp.getData().equals(pData)){
					bool = true;
					return bool;
				}else{
					tmp = tmp.getNext(); 
				} 
			}
			System.out.println("Item not found");
			return bool;
		}
	}

}
