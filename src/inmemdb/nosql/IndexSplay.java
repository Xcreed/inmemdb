package inmemdb.nosql;

import inmemdb.structures.SplayTree;

public class IndexSplay<T> extends Index {

	protected SplayTree tree;

	public IndexSplay() {
		tree = new SplayTree();
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
	
	public SplayTree getTree() {
		return tree;
	}

}
