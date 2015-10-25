package inmemdb.nosql;

public class Type <T>{
	
	protected int length;

	/**
	 * Length of the element
	 * @param length
	 */
	public Type(int length) {
		this.length = length;
		
	}
	
	/**
	 * Returns length
	 * @return
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * Check if the element is correct
	 * @param element
	 * @return
	 */
	public boolean check(T element) {
		return false;
	}

}
