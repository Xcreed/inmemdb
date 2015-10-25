package inmemdb.nosql;

public class TypeString <T extends String> extends Type{

	public TypeString(int length) {
		super(length);
	}
	
	/**
	 * Check if the element is correct
	 * @param element
	 * @return
	 */
	public boolean check(T element) {
		if (element instanceof String && element.length() <= length) {
			System.out.println("Valid string");
			return true;
		} else {
			System.out.println("Invalid string, must be under " + length + " characters");
			return false;
		}
	}

}
