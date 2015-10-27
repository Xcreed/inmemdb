package inmemdb.nosql;

import inmemdb.structures.AVLTree;
import inmemdb.structures.Tree;

@SuppressWarnings({ "hiding", "rawtypes" })
public class Index <T> {
	
	protected Tree<?> tree;
	protected Type<?> type;
	
	public Index() {
	}
	
	public void insert() {
	}
	
	public void remove() {
	}
	
	public void setType(Type<?> type) {
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}
	protected String toBinary(int toConvert) {
		String binaryNumber = Integer.toBinaryString(toConvert);
		return binaryNumber;
	}
	
	public Tree getTree() {
		return tree;
	}
}
