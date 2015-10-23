package inmemdb.nosql;

import inmemdb.structures.BinarySearchTree;

public class IndexBTS<T> extends Index{

	private BinarySearchTree tree;
	
	public IndexBTS() {
		tree = new BinarySearchTree();	
	}
	
	public void insert(T element) {
		
		if (type.check(element)){
			tree.addNode(element);
		} else {
			System.out.println("Invalid type");
		}
	}
	
	public void delete(T element) {
		tree.remove(element);
	}
}
