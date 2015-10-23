package inmemdb.nosql;

import java.nio.charset.Charset;

public class TypeChar <T extends Charset> extends Type{

	public TypeChar(int length) {
		super(length);
	}
	
	public boolean check(T element) {
		return false;
	}

}
