package inmemdb.nosql;

public class TypeBinary <T extends Number> extends Type {

	public TypeBinary(int length) {
		super(length);
	} 

	public boolean checkB(T element) {
		if (element instanceof Number && element.toString().length() <= length) {
			return true;
		}else {
			return false;
		}
	}

}
