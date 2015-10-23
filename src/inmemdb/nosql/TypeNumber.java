package inmemdb.nosql;

public class TypeNumber <T extends Number> extends Type{ 
	
	public TypeNumber(int length) {
		super(length);
	}
	
	public boolean check(T element) {
		
		
		return false;
		
	}

}
