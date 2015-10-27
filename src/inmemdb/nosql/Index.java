package inmemdb.nosql;

import inmemdb.structures.Tree;

@SuppressWarnings({ "rawtypes" })
/**
 * Asbtract class for the differents types of 
 * index. 
 * 
 * @author Juan Pablo, Randy, Alejandra
 *
 * @param <T>
 */
public class Index <T> {
	
	protected Tree<?> tree;
	protected Type<?> type;
	
	/**
	 *Index
	 */
	public Index() {
	}
	
	/**
	 * Insert
	 */
	public void insert() {
	}
	
	 /**
	  *Remove 
	  */
	public void remove() {
	}
	
	/**
	 * Set the given generic type.
	 * @param type
	 */
	public void setType(Type<?> type) {
		this.type = type;
	}
	
	/**
	 * Return the type. 
	 * @return type
	 */
	public Type getType() {
		return type;
	}
	
	/**
	 * 
	 * @param toConvert
	 * @return binaryNumber
	 */
	protected String toBinary(int toConvert) {
		String binaryNumber = Integer.toBinaryString(toConvert);
		return binaryNumber;
	}
	
	/**
	 * Returns the working tree.
	 * @return tree
	 */
	public Tree getTree() {
		return tree;
	}
}
