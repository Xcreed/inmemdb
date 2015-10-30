package inmemdb.nosql;

import inmemdb.structures.BinarySearchTree;

@SuppressWarnings("rawtypes")

/**
 * IndexBST extends from Index, and work for the indexes inside an 
 * Binary Search Tree. All actions return a boolean when performed 
 * or not.
 * 
 * @param <T>
 */
public class IndexBTS<T> extends Index{

	protected BinarySearchTree tree;
	/**
	 * Constructor.
	 * 
	 * @param type
	 * @param name
	 * @param length
	 */
	public IndexBTS(String type, String name, int length) {
		super(type, name, length);
		tree = new BinarySearchTree();	
		
	}
	
	/**
	 * Inserts an element after checking its type.
	 * 
	 * @param pass
	 * @param element
	 * @return boolean
	 */
	public <U> boolean insert(U element) {
		if (super.check(element)) {
			tree.addNode(element);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Deletes an element.
	 * 
	 * @param element
	 * @return boolean
	 */
	public boolean delete(T element) {
		return tree.remove(element);
	}
	
	/**
	 * Returns the AVLTree for 
	 * the working index.
	 * 
	 * @return tree
	 */
	public BinarySearchTree getTree() {
		return tree;
	}
}
