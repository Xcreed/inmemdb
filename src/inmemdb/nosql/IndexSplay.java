package inmemdb.nosql;

import inmemdb.structures.SplayTree;

public class IndexSplay<T> {

	private SplayTree tree;

	public IndexSplay() {
		tree = new SplayTree();
	}

	public void insert(T element) {

		if (type.check(element)) {
			tree.insert(element);
		} else {
			System.out.println("Invalid type");
		}
	}

	public void delete(T element) {
		tree.remove(element);
	}

}
