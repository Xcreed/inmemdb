package inmemdb.nosql;

import java.io.File;
import java.lang.reflect.ParameterizedType;

import inmemdb.structures.AVLTree;
import inmemdb.structures.BinarySearchTree;
import inmemdb.structures.DoubleLinkedList;
import inmemdb.structures.SplayTree;

/**
 *Schema class for managing the schemas the client/user will
 *use. All actions return a boolean when performed or not. 
 *
 * @param <T>
 */
public class Schema<T> {
	
	public String name;
	public DoubleLinkedList<Index> schema = new DoubleLinkedList<Index>();
	protected byte[] sharedSecret;
	protected ParameterizedType indexType;
	protected String folderLocation;
	
	/**
	 * Constructor 1. 
	 * 
	 * @param name
	 */
	public Schema(String name) {
		this.name = name;
		//createFolder()
		System.out.println(name + " table created.");
		//generateSharedSecret()
	}
	
	/**
	 * Constructor 2. 
	 * 
	 * @param name
	 * @param path
	 */
	public Schema(String name, String path) {
		this.name = name;
		this.folderLocation = path;
		createFolder(path);
	}
	
	/**
	 * Creates an index in the schema.
	 * 
	 * @param treeType bts, avl, splay, b
	 * @param indexType char, string, number, image, video, binary
	 * @param length
	 * @return boolean
	 */
	public boolean createIndex(String treeType, String indexType, String indexName, int length) {           //$$##$##$#
		if (treeType.equals("bts")) {
			IndexBTS bts = new IndexBTS(indexType, indexName, length);
			insertIndex(bts);
			return true;
		} else if (treeType.equals("avl")) {
			IndexAVL avl = new IndexAVL(indexType, indexName, length);
			insertIndex(avl);
			return true;
		} else if (treeType.equals("splay")) {
			IndexSplay splay = new IndexSplay(indexType, indexName, length);
			insertIndex(splay);
			return true;
		} else if (treeType.equals("b")) {
//			IndexBTS bt = new IndexBTS(indexType, length);
//			insertIndex(bt);
			return true;
		} else {
			System.out.println("Parameters invalid.");
			return false;
		}
	}
	
	/**
	 * Adds an index to the schema.
	 * 
	 * @return boolean
	 */
	public <U extends Index> boolean insertIndex(U index) {
		schema.insertEnd(index);
		return true;
	}
	
	/**
	 * Deletes schema.
	 * --Implement delete won't delete joined schema.--
	 * 
	 * @throws Throwable
	 * @return false
	 */
	public boolean delete() throws Throwable {
		schema = null;
		this.finalize();
		return false;
	}
	
	/**
	 * Delete an index inside the schema
	 * 
	 * @param Index
	 * @return boolean
	 */
	public boolean deleteIndex(int index) {
		schema.deleteByIndex(index);

		return true;
	}
	
	/**
	 * Searches an item in all the schema.
	 * 
	 * @return boolean
	 * @param searchItem
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean search(T searchItem) {										//$$##$##$#
		Index index;
		boolean bool = false;
		for (int i = 0; i < schema.getLength(); i++) {
			index = schema.getItem(i);
			if (index instanceof IndexBTS) {
				IndexBTS indexType = (IndexBTS) schema.getItem(i);
				BinarySearchTree indexTree = indexType.getTree();
				bool = indexTree.findNode(searchItem);
			} else if (index instanceof IndexAVL) {
				IndexAVL indexType = (IndexAVL) schema.getItem(i);
				AVLTree indexTree = indexType.getTree();	
				bool = indexTree.search(searchItem);
			} else if (index instanceof IndexSplay) {
				IndexSplay indexType = (IndexSplay) schema.getItem(i);
				SplayTree indexTree = indexType.getTree();
				bool = indexTree.search(searchItem);
			}
		}
		return bool; 
	}
	
	/**
	 * Inserts an element in a given index structure.
	 * 
	 * @param element
	 * @return boolean
	 */
	@SuppressWarnings("rawtypes")
	public boolean insertToIndex(int containingIndex, T itemToInsert) {                                           //$$##$##$#
		Index index = schema.getItem(containingIndex);
		boolean bool = false;
		
//		System.out.println(itemToInsert);
		if (index instanceof IndexBTS) {
			IndexBTS indexType = (IndexBTS) schema.getItem(containingIndex);
			bool = indexType.insert(itemToInsert);
		} else if (index instanceof IndexAVL) {
			IndexAVL indexType = (IndexAVL) schema.getItem(containingIndex);
			bool = indexType.insert(itemToInsert);
		} else if (index instanceof IndexSplay) {
			IndexSplay indexType = (IndexSplay) schema.getItem(containingIndex);
			bool = indexType.insert(itemToInsert);
		}
		
		return bool; 
	}
	
	/**
	 * Deletes an element in a given index (starts in 1).
	 * 
	 * @param containingIndex
	 * @param itemToRemove
	 * @return boolean
	 */
	public boolean deleteInIndex(int containingIndex, T itemToRemove) {
		Index index;
		boolean bool = false;
		index = schema.getItem(containingIndex);
		if (index instanceof IndexBTS) {
			IndexBTS indexType = (IndexBTS) schema.getItem(containingIndex);
			bool = indexType.delete(itemToRemove);
		} else if (index instanceof IndexAVL) {
			IndexAVL indexType = (IndexAVL) schema.getItem(containingIndex);
			AVLTree indexTree = indexType.getTree();	
			bool = indexType.delete(itemToRemove);		
		} else if (index instanceof IndexSplay) {
			IndexSplay indexType = (IndexSplay) schema.getItem(containingIndex);
			bool = indexType.delete(itemToRemove);
		}
		
		return bool; 
	}
	
	/**
	 * Creates a folder when creating a schema.
	 * 
	 * @param path
	 */
	private void createFolder(String path) {
		// Create a directory; all non-existent ancestor directories are
		// automatically created
		boolean success = (new File(path)).mkdirs();
		if (!success) {
			System.out.println("Folder already exists");
		} else {
			System.out.println("Folder created succesfully");
		}
	}
	
	/**
	 * Gets the data in a given line
	 * Not working for join tables
	 * @param lineNumber
	 */
	public void getLine(int lineNumber) {
		DoubleLinkedList line = new DoubleLinkedList();

		for (int i = 1; i < schema.getLength(); i++) {
			Index index = schema.getItem(i);
			if (index instanceof IndexBTS) {
				IndexBTS indexType = (IndexBTS) schema.getItem(i);
				BinarySearchTree indexTree = indexType.getTree();
				line.insertEnd(indexTree.keyBST.searchKeyReturnValue(lineNumber));
			} else if (index instanceof IndexAVL) {
				IndexAVL indexType = (IndexAVL) schema.getItem(i);
				AVLTree indexTree = indexType.getTree();	
				line.insertEnd(indexTree.keyAVL.searchKeyReturnValue(lineNumber));
			} else if (index instanceof IndexSplay) {
				IndexSplay indexType = (IndexSplay) schema.getItem(i);
				SplayTree indexTree = (SplayTree) indexType.getTree();
				System.out.println("Not implemented for Splay tree");
//				line.insertEnd(indexTree.keySP.searchKeyReturnValue(lineNumber));

			}
			
		}
		line.print();
	}
	
	public void deleteLine(int lineNumber) {
		
		DoubleLinkedList line = new DoubleLinkedList();

		for (int i = 1; i < schema.getLength(); i++) {
			Index index = schema.getItem(i);
			if (index instanceof IndexBTS) {
				IndexBTS indexType = (IndexBTS) schema.getItem(i);
				BinarySearchTree indexTree = indexType.getTree();
				indexTree.remove(indexTree.keyBST.searchKeyReturnValue(lineNumber));
			} else if (index instanceof IndexAVL) {
				IndexAVL indexType = (IndexAVL) schema.getItem(i);
				AVLTree indexTree = indexType.getTree();	
				indexTree.remove(indexTree.keyAVL.searchKeyReturnValue(lineNumber));
			} else if (index instanceof IndexSplay) {
				IndexSplay indexType = (IndexSplay) schema.getItem(i);
				SplayTree indexTree = (SplayTree) indexType.getTree();
				System.out.println("Not implemented for Splay tree");
			}
			
		}
	}
	
	public int getItemPos(T element) {
		int pos = 0;
		for (int i = 1; i < schema.getLength(); i++) {
			Index index = schema.getItem(i);
			if (index instanceof IndexBTS) {
				IndexBTS indexType = (IndexBTS) schema.getItem(i);
				BinarySearchTree indexTree = indexType.getTree();
				pos = (indexTree.SearchKeyOfValue(element));
				System.out.println("position" + pos);
			} else if (index instanceof IndexAVL) {
				IndexAVL indexType = (IndexAVL) schema.getItem(i);
				AVLTree indexTree = indexType.getTree();	
				pos = (indexTree.SearchKeyOfValue(element));
			} else if (index instanceof IndexSplay) {
				IndexSplay indexType = (IndexSplay) schema.getItem(i);
				SplayTree indexTree = (SplayTree) indexType.getTree();
				System.out.println("Item in position: ");
				pos = (indexTree.SearchKeyOfValue(element));
//				line.insertEnd(indexTree.keySP.searchKeyReturnValue(lineNumber));

			} else {
				System.out.println("item not found");
				pos = -1;
			}
			
		}
		return pos;
	}
	
	public String getSchemaLocation() {
		return folderLocation;
	}
}
