package inmemdb.structures;

public class BPages {
	
	int nodesAmount;
	int childrenAmount;
	BPages[] children;
	BNode node1;
	BPages parent;
	
	
	public BPages (int m){
		this.parent = null; 
		this.children = new BPages[m];
		this.node1 = null;
		this.childrenAmount=0;
		int i = 0;
		while(i<m){
			children[i]= null; 
		}
		
	}
}
