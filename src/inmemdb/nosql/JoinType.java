package inmemdb.nosql;

@SuppressWarnings("rawtypes")
public class JoinType extends Schema{
	
	public <T extends Schema> JoinType(String name) {
		super(name);
	}

	public void join(Schema joiningTo) {
		schema.insertAtEnd(joiningTo);
	}

}
