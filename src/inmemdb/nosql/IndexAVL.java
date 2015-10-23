package inmemdb.nosql;

import inmemdb.structures.AVLTree;

public class IndexAVL <T> extends Index {
	
	private AVLTree tree;
	
	public IndexAVL() {
		tree = new AVLTree();	
	}
	
	public void insert(T element) {
		
		if (type.check(element)){
			tree.insert(element);
		} else {
			System.out.println("Invalid type");
		}
	}
	
	public void delete(T element) {
		tree.remove(element);
	}

}
