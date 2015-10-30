package inmemdb.structures;


public class BTree <T>{
	BPages root;
	int index;
	int m;
	
	
	public BTree(int order){
		index=0;
		root = null;
		m = order;     //m must be >= 3
	}
	
	public boolean search(T data){
		if(this.root == null){
			return false;
		}else{
			BNode node = new BNode(data);
			return search(node, this.root.node1);
		}
	}
	
	
	public boolean search(BNode node, BNode current){
		if(current==null){
			if (current.leftChild==null){
				return false;
			}else{
				return search(node, current.leftChild.node1);
			}
		}else if(current.compareTo(node)==0){
			return true;
		}else if(current.compareTo(node)<0){       //node < current 
			if(current.leftChild == null){
				return false;
			}else{
				return search(node, current.leftChild.node1);
			}
		}else{            //node > current 
			if(current.next==null){
				if(current.rightChild==null){
					return false;
				}else{
					return search(node, current.rightChild.node1);
				}
			}else{
				return search(node, current.next);
			}
		}
	}
	
	public void insert(T data){
		if(search(data)){
			System.out.println("This element already exists in the tree");
		}else{
			index++;
			BNode node = new BNode(data, index);
			insert(node, root, root.node1);
		}
	}
	
	public BNode getMid(BPages page){
		BNode current = page.node1;
		int i=1;
		int x;
		if(m%2!=0){
			x = m/2+1;
		}else{
			x = m/2;
		}
		while(i!=x){
			current = current.next;
			i++;
		}
		return current;
	}
	
	public int getNodesAmount(BPages page){
		BNode current = page.node1;
		int amount = 1;
		while(current!=null){
			current= current.next;
			amount++;
		}
		return amount; 
	}
	
	public void evaluate(BPages page){
		
	}
	
	public void insert(BNode node, BPages page, BNode current){
		if(page.childrenAmount==0){    //It's a leaf
			while(current.compareTo(node)>0){     //node > current
				if(current.next==null){
					current.next=node;
					node.prev=current;
					page.nodesAmount++;
					evaluate(page);
					return;
				}else{
					current = current.next;
				}
			}
			//now node < current
			if(current.prev==null){
				current.prev = node;
				node.next = current;
				page.nodesAmount++;
				evaluate(page);
			}else{
				current.prev.next = node;
				node.prev = current.prev;
				current.prev = node;
				node.next = current;
				page.nodesAmount++;
				evaluate(page);
			}
		}else{
			if(current.compareTo(node)<0){               // node < current
				insert(node, current.leftChild, current.leftChild.node1);
			}else if (current.next == null){    // node > current   && current.next == null 
				insert(node, current.rightChild, current.rightChild.node1);
			}else{     //node > current   &&  current.next != null 
				insert(node, page, current.next);
			}
		}

	}
	
}