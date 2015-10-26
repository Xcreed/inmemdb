package inmemdb.nosql;

import inmemdb.structures.AVLTree;

public class IndexAVL <T> extends Index {
	
	private AVLTree tree;
	
	public IndexAVL() {
		tree = new AVLTree();	
	}
	
	public boolean insert(boolean pass, T element) {
		
		if (pass){
			tree.insert(element);
			return true;
		} else {
			System.out.println("Invalid type");
			return false;
		}
	}
	
	public boolean delete(T element) {
		return tree.remove(element);
	}
	
	public AVLTree getTree() {
		return tree;
	}

}
