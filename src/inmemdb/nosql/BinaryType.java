package inmemdb.nosql;

public class BinaryType <U> extends Schema{

	public BinaryType(String name) {
		super(name);
	}

	public <T extends Number> void insertToIndex(int index, T element) {
		
		super.createIndex(index);
		U tree = (U) schema.getItem(index);
		
		System.out.println(tree.getClass());
	}
	
	private String toBinary(int toConvert) {
		String binaryNumber = Integer.toBinaryString(toConvert);
		return binaryNumber;
	}
}
