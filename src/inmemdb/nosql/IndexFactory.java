package inmemdb.nosql;


import inmemdb.structures.Tree;

public class IndexFactory {

	private Index newIndex;
	
	/**
	 * 
	 * protected Tree<?> tree;
	 * protected String type;
	 * protected int length;
	 * 
	 * public Index(String type, String name, int length) {
		this.type = type;
		this.length = length;
		this.name = name;
	}
	 *public Guns makeGun(String gunType){
		
		newGun = null;
		
		if(gunType.equals("S")){
			return new Sword();
		}else if (gunType.equals("P")){
			return new Pistol();
		}else if(gunType.equals("C")){
			return new Cannon();
		}else{
			return null;
		}
		
	]
	  */
	public Index makeIndex(String treeType, String indexType, String indexName, int length){
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
