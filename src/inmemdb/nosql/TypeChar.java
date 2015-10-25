package inmemdb.nosql;

import java.nio.charset.Charset;

public class TypeChar <T extends Charset> extends Type{

	public TypeChar(int length) {
		super(length);
	}
	
	/**
	 * Check if the element is correct
	 * @param element
	 * @return
	 */
	public boolean check(T element) {
		if (element.toString().length() <= length) {
			return true;
		} else {
			return false;
		}
	}

}
