package inmemdb.nosql;

public class SchemaJoin<T> extends Schema<T>{
	
	private Schema joinedSchema;
	
	public SchemaJoin(String name, String folderLocation) {
		super(name, folderLocation);
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
		return super.deleteIndex(index);
	}
	
	/**
	 * Inserts an element to a given index
	 * Only in the Join type schema
	 */
	public boolean insertToIndex(int containingIndex, T itemToInsert) {
		if (super.insertToIndex(containingIndex, itemToInsert)) {
			System.out.println("Item inserted to index " + containingIndex);
			return true;
		} else {
			System.out.println("Failed to insert");
			return false;
		}
	}
	
	/**
	 * Deletes element in this table
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
	
	/**
	 * Creates two separate Indexes with the same info
	 * one for each table
	 * @param treeType
	 * @param indexType
	 * @param length
	 * @return
	 */
	public boolean createJoinedIndex(String treeType, String indexType, String indexName, int length) {
		super.createIndex(treeType, indexType, indexName, length);
		joinedSchema.createIndex(treeType, indexType, indexName, length);
		return true;
	}
	

}
