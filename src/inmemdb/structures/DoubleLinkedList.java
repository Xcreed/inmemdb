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
	
	public int positionInList(T pData){
		int position = 0;
		boolean bool = false;
		
		
		DoubleNode<T> tmp = head; 
		
		while(tmp != null){
			if(tmp.getData().equals(pData)){
				bool = true;
				return bool;
			}else{
				tmp = tmp.getNext();
			}
		}
	}
		
	/**
	 * Returns a true if empty, else false.
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
	 * Insert an element (tData) at the beginning of the list.
	 * 
	 * @param pData
	 */
	@SuppressWarnings("unchecked")
	public void insertAtBeginning(T tData){
		
		DoubleNode data = new DoubleNode<T>(tData);
		
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
	 * @param element
	 */
	public <T> void insertAtEnd(T element){
		
		DoubleNode data = new DoubleNode<T>(element);
		
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
		DoubleNode tmp = head;
		
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
	 * Return the search  element, else false.
	 * @param pData
	 * @return pData
	 */
	public Object search(T pData){
		DoubleNode<T> data = new DoubleNode<T>(pData);
		boolean bool = false;
	
		if(isEmpty()){
			return null;
		}else{
			DoubleNode tmp = head; 
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
	public void removeAtBeginning(){
		
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
	public void removeAtEnd() {
		//List only has one element
		if (head == tail) {
			head = tail = null;
		} else {
			tail = tail.getPrev();
			tail.setNext(null);			
		}
	}
	
	/**
	 * Removes an given item from the list. 
	 * @param pData
	 */
	public void removeFromList(T pData){
		
		 if( contains(pData) == true){
			 
		 }else{
			 return;
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
			DoubleNode tmp = head; 
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
