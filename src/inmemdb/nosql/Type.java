package inmemdb.nosql;

public class Type <T>{
	
	private int length;

	public Type(int length) {
		this.length = length;
		
	}
	
	public int getLength() {
		return length;
	}
	
	public boolean check(T element) {
		return false;
	}
}
