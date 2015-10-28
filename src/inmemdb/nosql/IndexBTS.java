package inmemdb.nosql;

import inmemdb.structures.BinarySearchTree;

@SuppressWarnings("rawtypes")
public class IndexBTS<T> extends Index{

	protected BinarySearchTree tree;
	
	public IndexBTS(String type, String name, int length) {
		super(type, name, length);
		tree = new BinarySearchTree();	
		
	}
	
	/**
	 * Inserts an element after checking its type
	 * @param pass
	 * @param element
	 * @return
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
	public BinarySearchTree getTree() {
		return tree;
	}
}
