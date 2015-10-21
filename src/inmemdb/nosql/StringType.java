package inmemdb.nosql;

public class StringType <U> extends Schema{

	public StringType(String name) {
		super(name);
	}

	public <T extends String> void insertToIndex(int index, T element) {
		super.createIndex(index);
		U tree = (U) schema.getItem(index);
		System.out.println(tree.getClass());
	}
}
