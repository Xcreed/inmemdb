package inmemdb.nosql;

import inmemdb.structures.Tree;

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
	

	protected String toBinary(int toConvert) {
		String binaryNumber = Integer.toBinaryString(toConvert);
		return binaryNumber;
	}
	
	

}
