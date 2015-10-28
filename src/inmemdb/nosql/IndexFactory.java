package inmemdb.nosql;

public class IndexFactory {
	
	private Index newIndex;
	
	public Index makeIndex(){
		newIndex = null;
		return new Index();
	}
	
}
