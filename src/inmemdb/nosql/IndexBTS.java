package inmemdb.nosql;

import inmemdb.structures.BinarySearchTree;

@SuppressWarnings("rawtypes")
public class IndexBTS<T> extends Index{

	protected BinarySearchTree tree;
	
	public IndexBTS() {
		tree = new BinarySearchTree();	
		
	}
	
	/**
	 * Inserts an element after checking its type
	 * @param pass
	 * @param element
	 * @return
	 */
	public boolean insert(boolean pass, T element) {
		if (pass){
			tree.addNode(element);
			System.out.println("Inserting...");
			return true;
		} else {
			System.out.println("Invalid input");
			return false;
		}
	}
	
//	@SuppressWarnings("unchecked")
	public <U> boolean insert(U element) {
		return super.check(element);
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
