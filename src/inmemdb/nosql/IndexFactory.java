package inmemdb.nosql;


import inmemdb.structures.Tree;

public class IndexFactory {

	private Index newIndex;
	
	public Index makeIndex(String treeType, String indexType, String indexName, int length){
		
		if (treeType.equals("bts")){
			IndexBTS bts = new IndexBTS(indexType, indexName, length);
			insertIndex(bts);
			return bts;
		}else if (treeType.equals("avl")){
			IndexAVL avl = new IndexAVL(indexType, indexName, length);
			insertIndex(avl);
			return avl;
		}else if (treeType.equals("splay")){
			IndexSplay splay = new IndexSplay(indexType, indexName, length);
			insertIndex(splay);
			return splay;
//		}else if (treeType.equals("b")){
//			IndexBTS bt = new IndexBTS(indexType, length);
//			insertIndex(bt);
//			return bt;
		}else{
			System.out.println("Parameters invalid.");
			return null;
		}
	}
}
