package inmemdb.nosql;

import inmemdb.structures.SplayTree;

public class IndexSplay<T> extends Index {

	private SplayTree tree;

	public IndexSplay() {
		tree = new SplayTree();
	}

	public void insert(boolean pass, T element) {
		
		if (pass){ 
			tree.insert(element);
		} else {
			System.out.println("Invalid type");
		}
	}

	public void delete(T element) {
		tree.remove(element);
	}

}
