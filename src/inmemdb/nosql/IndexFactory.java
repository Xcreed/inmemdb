//package inmemdb.nosql;
//
//import inmemdb.structures.Tree;
//import inmemdb.nosql.Schema;
//
///**
// * Factory class for creating Indexes.
// */
//public class IndexFactory {
//
//	private Index newIndex; //newIndex 
//	
//	/**
//	 * Constructor of the different type of indexes. 
//	 * The parameters most be enter by the client. 
//	 * @param treeType
//	 * @param indexType
//	 * @param indexName
//	 * @param length
//	 * @return Index
//	 */
//	public Index makeIndex(String treeType, String indexType, String indexName, int length){
//		
//		newIndex = null;
//		Schema activeSchema = this;
//		
//		if (treeType.equals("bts")){
//			IndexBTS bts = new IndexBTS(indexType, indexName, length);
//			activeSchema.insertIndex(bts);
//			return bts;
//		}else if (treeType.equals("avl")){
//			IndexAVL avl = new IndexAVL(indexType, indexName, length);
//			activeSchema.insertIndex(avl);
//			return avl;
//		}else if (treeType.equals("splay")){
//			IndexSplay splay = new IndexSplay(indexType, indexName, length);
//			activeSchema.insertIndex(splay);
//			return splay;
//		}else if (treeType.equals("b")){
//			IndexBTS bt = new IndexBTS(indexType, length);
//			insertIndex(bt);
//			return bt;
//		}else{
//			System.out.println("Parameters invalid.");
//			return null;
//		}
//	}
//}
