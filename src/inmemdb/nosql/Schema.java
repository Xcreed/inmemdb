package inmemdb.nosql;

import java.io.File;
import java.lang.reflect.ParameterizedType;

import inmemdb.structures.AVLTree;
import inmemdb.structures.BinarySearchTree;
import inmemdb.structures.DoubleLinkedList;
import inmemdb.structures.SplayTree;

public class Schema<T> {
	
	public String name;
	public DoubleLinkedList<Index> schema = new DoubleLinkedList<Index>();
	protected byte[] sharedSecret;
	protected ParameterizedType indexType;
	protected String newFolderLoc;
	
	/**
	 * Creates a new schema
	 * Missing folder creation, sharedSecret
	 * abstract factory implementation
	 * @param name
	 */
	public Schema(String name) {
		this.name = name;
		//createFolder()
		System.out.println(name + " table created.");
		//generateSharedSecret()
	}
	
	public Schema(String name, String path) {
		this.name = name;
		createFolder(path);
	}
	
	/**
	 * ***Missing B trees***
	 * Creates an index in the schema
	 * @param treeType bts, avl, splay, b
	 * @param indexType char, string, number, image, video, binary
	 * @param length
	 * @return
	 */
	public boolean createIndex(String treeType, String indexType, String indexName, int length) {
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
//			IndexBTS bts = new IndexBTS(indexType, length);
//			insertIndex(bts);
			return true;
		} else {
			System.out.println("Parameters invalid.");
			return false;
		}
	}
	
	/**
	 * Adds an index to the schema
	 */
	public <U extends Index> boolean insertIndex(U index) {
		schema.insertEnd(index);
		return true;
	}
	
	/**
	 * Delete schema
	 * --Implement delete won't delete joined schema
	 * @throws Throwable 
	 */
	public boolean delete() throws Throwable {
		schema = null;
		this.finalize();
		return false;
	}
	
	/**
	 * Delete an index inside the schema
	 * @param Index
	 */
	public boolean deleteIndex(int index) {
		schema.deleteByIndex(index);

		return true;
	}
	
	/**
	 * Searches an item in all the schema
	 * --Missing Btree
	 * @param searchItem
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean search(T searchItem) {
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
	 * Inserts an element in a given index structure
	 * @param element
	 */
	@SuppressWarnings("rawtypes")
	public boolean insertToIndex(int containingIndex, T itemToInsert) {
		Index index = schema.getItem(containingIndex);
		boolean bool = false;
		
		System.out.println(itemToInsert);
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
	 * Deletes an element in a given index (Starts in 1)
	 * @param containingIndex
	 * @param itemToRemove
	 * @return
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
	 * Creates a folder when creating a schema
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

}
