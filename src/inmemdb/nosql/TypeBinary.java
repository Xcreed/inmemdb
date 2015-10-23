package inmemdb.nosql;

public class TypeBinary <T extends Number> extends Type {

	public TypeBinary(int length) {
		super(length);
	} 

	public boolean check(T element) {
		return false;
		
	}

	private String toBinary(int toConvert) {
		String binaryNumber = Integer.toBinaryString(toConvert);
		return binaryNumber;
	}
}
