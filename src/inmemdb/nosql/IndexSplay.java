package inmemdb.nosql;

import inmemdb.structures.SplayTree;

public class IndexSplay<T> extends Index {

	protected SplayTree tree;

	public IndexSplay(String type, int length) {
		super(type, length);
		tree = new SplayTree();
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
	public SplayTree getTree() {
		return tree;
	}

}
