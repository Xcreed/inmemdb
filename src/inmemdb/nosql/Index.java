package inmemdb.nosql;

import inmemdb.structures.AVLTree;
import inmemdb.structures.Tree;

@SuppressWarnings({ "hiding", "rawtypes" })
public class Index <T> {
	
	protected Tree<?> tree;
	protected Type<?> type;
	
	public Index() {
	}
	
	public void insert() {
	}
	
	public void remove() {
	}
	
	/**
	 * Sets index type
	 * @param type
	 */
	public void setType(Type<?> type) {
		this.type = type;
	}
	
	/**
	 * Returns index type
	 * @return
	 */
	public Type getType() {
		return type;
	}
	
	/**
	 * Converts integer to binary
	 * @param toConvert
	 * @return
	 */
	protected String toBinary(int toConvert) {
		String binaryNumber = Integer.toBinaryString(toConvert);
		return binaryNumber;
	}
	
	/**
	 * Returns index tree
	 * @return
	 */
	public Tree getTree() {
		return tree;
	}
	
	

}
