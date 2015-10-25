package inmemdb.nosql;

import inmemdb.structures.BinarySearchTree;

@SuppressWarnings("rawtypes")
public class IndexBTS<T> extends Index{

	protected BinarySearchTree tree;
	
	public IndexBTS() {
		tree = new BinarySearchTree();	
		
	}
	
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

	public boolean delete(T element) {
		return tree.remove(element);
	}
	
	public BinarySearchTree getTree() {
		return tree;
	}
}
