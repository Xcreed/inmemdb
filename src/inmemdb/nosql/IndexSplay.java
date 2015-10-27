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
	public boolean insert(boolean pass, T element) {
		
		if (pass){ 
			tree.insert(element);
			return true;
		} else {
			System.out.println("Invalid type");
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
