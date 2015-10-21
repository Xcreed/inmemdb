package inmemdb.nosql;

public class Main {

	public static void main(String[] args) {

		@SuppressWarnings("rawtypes")
		NumberType n = new NumberType("Numbers");
		n.insertToIndex(0, 10);
		
		String h = Integer.toBinaryString(10);
	}

}
