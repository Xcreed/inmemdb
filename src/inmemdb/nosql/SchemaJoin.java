package inmemdb.nosql;

public class SchemaJoin<T> extends Schema<T>{
	
	private Schema joinedSchema;
	
	public SchemaJoin(String name) {
		super(name);
	}
	
	/**
	 * Joins a schema to this schema
	 * @param schemaToJoin
	 */
	public void joinSchema(Schema schemaToJoin) {
		System.out.println("Joining to " + schemaToJoin.name);
		this.joinedSchema = schemaToJoin;
	}
	
	
	public boolean deleteIndex(int index) {
		
	}
	
	/**
	 * Inserts index in this table and the one joined
	 * @param insertIndex
	 * @return
	 */
	public <U extends Index> boolean insertJoinedIndex(U insertIndex){
		
		super.insertIndex(insertIndex);
		joinedSchema.insertIndex(insertIndex);
		return true;
		
	}
	
	public boolean insertToIndex() {
		
	}
	
	/**
	 * Deletes element in this tables
	 * @param containingIndex
	 * @param itemToRemove
	 * @return
	 */
	public boolean deleteInJoinedIndex(int containingIndex, T itemToRemove) {
		boolean bool = false;
		if (super.deleteInIndex(containingIndex, itemToRemove)) {
			System.out.println("Item deleted in the Join Type table");
			bool = true;
		} else {
			System.out.println("Item wasn't found so couldn't be deleted");
			bool = false;
		}
		return bool;
	}
	
	/**
	 * Searches for an element in this table and the one joined
	 * @param element
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean joinedSearch(T element) {
		if (super.search(element) && joinedSchema.search(element)) {
			System.out.println("Item in both tables");
			return true;
		} else if (super.search(element) || joinedSchema.search(element)) {
			System.out.println("Item found in one of two tables");
			return true;
		} else {
			System.out.println("Item not found in any table");
			return false;
		}
	}
	

}
