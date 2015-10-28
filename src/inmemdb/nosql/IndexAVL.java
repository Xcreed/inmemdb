package inmemdb.nosql;

import inmemdb.structures.AVLTree;

public class IndexAVL <T> extends Index {
	
	private AVLTree tree;
	
	public IndexAVL(String type, String name, int length) {
		super(type, name, length);
		tree = new AVLTree();	
	}
	/**
	 * Inserts an element after checking its type
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
	 * Deletes an element
	 * @param element
	 * @return
	 */
	public boolean delete(T element) {
		return tree.remove(element);
	}
	
	/**
	 * Returns tree
	 */
	public AVLTree getTree() {
		return tree;
	}

}
