package inmemdb.nosql;

import inmemdb.structures.DoubleLinkedList;

public class NumberType <U> extends Schema{
	
	public NumberType(String name) {
		super(name);
	}
	
	public <T extends Number> void insertToIndex(int index, T element) {
		super.createIndex(index);
		U tree = (U) schema.getItem(index);
		
		System.out.println(tree.getClass());
	}

}
