package inmemdb.nosql;

import inmemdb.structures.BinarySearchTree;

@SuppressWarnings("rawtypes")
public class IndexBTS<T> extends Index{

	protected BinarySearchTree tree;
	
	public IndexBTS() {
		tree = new BinarySearchTree();	
		
	}
	
	public void insert(boolean pass, T element) {
		if (pass){
			tree.addNode(element);
			System.out.println("Inserting...");
		} else {
			System.out.println("Invalid input");
		}
	}

	public void delete(T element) {
		tree.remove(element);
	}
}
