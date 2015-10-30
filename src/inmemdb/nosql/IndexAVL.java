package inmemdb.nosql;

import inmemdb.structures.AVLTree;

/**
 * IndexAVL extends from Index, and  work for the indexes inside an 
 * AVLTree. All actions return a boolean when performed or not.
 *
 * @param <T>
 */
public class IndexAVL <T> extends Index{
	
	private AVLTree tree;
	
	/**
	 * Constructor.
	 * 
	 * @param type
	 * @param name
	 * @param length
	 */
	public IndexAVL(String type, String name, int length) {
		super(type, name, length);
		tree = new AVLTree();	
	}
	
	/**
	 * Inserts an element after checking its type.
	 * 
	 * @param pass
	 * @param element
	 * @return
	 */
	public <U> boolean insert(U element) {
		if (super.check(element)) {
			tree.insert(element);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Deletes an element.
	 * 
	 * @param element
	 * @return
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
	public AVLTree getTree() {
		return tree;
	}

}
