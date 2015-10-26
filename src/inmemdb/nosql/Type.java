package inmemdb.nosql;

public class Type <T>{
	
	protected int length;

	public Type(int length) {
		this.length = length;
		
	}
	
	public int getLength() {
		return length;
	}
	
	public boolean check(T element) {
		return false;
	}
	
	public boolean insert(T element) {
		check(element);
		return true;
	}
}
