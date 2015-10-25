package inmemdb.nosql;

import inmemdb.structures.AVLTree;

public class IndexAVL <T> extends Index {
	
	private AVLTree tree;
	
	public IndexAVL() {
		tree = new AVLTree();	
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
	public AVLTree getTree() {
		return tree;
	}

}
