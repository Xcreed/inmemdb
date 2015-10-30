package inmemdb.nosql;

import inmemdb.structures.SplayTree;

/**
 * IndexSplay extends from Index  and work for the indexes inside a 
 * SplayTree. All actions return a boolean when performed or not.
 *
 * @param <T>
 */

public class IndexSplay<T> extends Index {

	protected SplayTree tree;
	
	/**
	 * Constructor. 
	 * 
	 * @param type
	 * @param name
	 * @param length
	 */
	public IndexSplay(String type, String name, int length) {
		super(type, name, length);
		tree = new SplayTree();
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
	 * @return boolean
	 */
	public boolean delete(T element) {
		tree.delete(element);
		return true;
	}
	
	/**
	 * Returns the SlayTree for 
	 * the working index.
	 * 
	 * @return tree
	 */
	public SplayTree getTree() {
		return tree;
	}

}
