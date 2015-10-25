package inmemdb.nosql;

public class TypeBinary <T extends Number> extends Type {

	public TypeBinary(int length) {
		super(length);
	} 

	/**
	 * Check if the element is correct
	 * @param element
	 * @return
	 */
	public boolean check(T element) {
		if (element instanceof Number && element.toString().length() <= length) {
			return true;
		}else {
			return false;
		}
	}

}
