package inmemdb.structures;

public class keySPTree {
	SplayNode root;
	int size;
	int index; 
	

	public keySPTree(){
		this.root = null;
		this.size = 0;
		this.index = 0;
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	public void makeEmpty(){
		root = null;
	}
	
	public <T> void insert(T data, int key){
		SplayNode newNode = new SplayNode(data, key);
		if(root == null){
			this.root = newNode;
		}else{
			insert(newNode, this.root);
		}
	}
	

	public void insert(SplayNode newNode, SplayNode root){
		if(root.key < newNode.key){  ///newNode > root
			
			if(root.rightChild==null){
				newNode.parent = root;
				root.rightChild = newNode; 
			}else{
				insert(newNode, root.rightChild);
			}
		}else{
			if(root.leftChild==null){
				newNode.parent = root;
				root.leftChild = newNode; 
			}else{
				insert(newNode, root.leftChild);
			}
			
		}
		this.root=Splay(newNode);
		
	}
	

	public void delete(int key){
		if(root==null){
			return ;
		}
		SplayNode current = root;
		while(current.key!=key){
			if (key< current.key){
				current = current.leftChild;
			}else{
				current = current.rightChild;
			}
		}
		if (current.leftChild==null && current.rightChild==null){
			//SplayNode node2Splay = current.parent;
			if(current.parent==null){
				this.root=null;
			}else{
				if(current.parent.leftChild==current){
					current.parent.leftChild=null;
				}else{
					current.parent.rightChild=null;
				}
			}
			this.root= Splay(current.parent);
		}else if(current.rightChild== null){
			SplayNode newCurrent = current.leftChild;
			while(newCurrent.rightChild != null){
				newCurrent = newCurrent.rightChild; 
			}
			if(newCurrent.parent.leftChild==newCurrent){
				newCurrent.parent.leftChild=null;
			}else{
				newCurrent.parent.rightChild=null;
			}
			current.data = newCurrent.data;
			current.key = newCurrent.key;
			if(current.leftChild!=null){
				current.leftChild.parent=current;
			}
			if(current.parent.leftChild==current){
				current.parent.leftChild=current;
			}else{
				current.parent.rightChild=current;
			}
			if(current.leftChild!=null){
				current.leftChild.parent=current;
			}
			this.root = Splay(current);
			
		}else{
			SplayNode newCurrent = current.rightChild;
			while(newCurrent.leftChild != null){
				newCurrent = newCurrent.leftChild; 
			}
			if(newCurrent.parent.leftChild==newCurrent){
				newCurrent.parent.leftChild=null;
			}else{
				newCurrent.parent.rightChild=null;
			}
			current.data = newCurrent.data;
			current.key = newCurrent.key;
			if(current.rightChild!=null){
				current.rightChild.parent=current;
			}else if(current.leftChild!=null){
				current.leftChild.parent=current;
			}
			if(current.parent.leftChild==current){
				current.parent.leftChild=current;
			}else{
				current.parent.rightChild=current;
			}
			if(current.rightChild!=null){
				current.rightChild.parent=current;
			}else if(current.leftChild!=null){
				current.leftChild.parent=current;
			}
			this.root = Splay(current);
		}
	}

	public SplayNode zig(SplayNode node){
		
		
		SplayNode p = node.parent;
		SplayNode x = node;
		
		if (node.key>node.parent.key){  // node > node.parent
			x.parent = p.parent;
			p.parent=x;
			if(x.leftChild!=null){
				x.leftChild.parent = p;
				p.rightChild = x.leftChild;
			}else{
				p.rightChild = null; 
			}
			x.leftChild = p;
		}else{
			x.parent = p.parent;
			p.parent=x;
			if(x.rightChild!=null){
				x.rightChild.parent = p;
				p.leftChild = x.rightChild;
			}else{
				p.leftChild = null; 
			}
			x.rightChild = p; 
		}
		return x; 
	}
	
	public SplayNode zigzig(SplayNode node, boolean leftLeft){
		
		SplayNode x = node; 
		SplayNode p = node.parent;
		SplayNode g = node.parent.parent;
		
		if (leftLeft){
			if(g.parent!=null){
				if(g.parent.rightChild==g){
					g.parent.rightChild=x;
				}else{
					g.parent.leftChild = x;
				}
				x.parent = g.parent;
			}else{
				x.parent=null;
			}
			
			if (x.rightChild == null){
				p.leftChild = null;
			}else{
				p.leftChild = x.rightChild;
				x.rightChild.parent = p;
			}
			
			g.leftChild = p;
			p.parent = g;
			g.parent = x;
			x.rightChild = g;
			
			
		}else{  //right right 
			if(g.parent!=null){
				if(g.parent.leftChild==g){
					g.parent.leftChild=x;
				}else{
					g.parent.rightChild = x;
				}
				x.parent = g.parent;
			}else{
				x.parent=null;
			}
			
			if (x.leftChild == null){
				p.rightChild = null;
			}else{
				p.rightChild = x.leftChild;
				x.leftChild.parent = p;
			}
			
			g.rightChild = p;
			p.parent = g;
			g.parent = x;
			x.leftChild = g;
			
		}
		return x; 
	}
	
	public SplayNode zigzag(SplayNode node, boolean XRightCPLeftC){
		
		SplayNode x = node;
		SplayNode p = node.parent;
		SplayNode g = node.parent.parent;
		if(XRightCPLeftC){
			if(g.parent==null){
				x.parent = null;
			}else{
				if(g.parent.leftChild==g){
					g.parent.leftChild=x;
				}else{
					g.parent.rightChild=x;
				}
				x.parent=g.parent;
			}
			
			if(x.leftChild==null){
				g.rightChild = null;
			}else{
				g.rightChild = x.leftChild;
				x.leftChild.parent = g;
			}
			
			if(x.rightChild==null){
				p.leftChild = null;
			}else{
				p.leftChild = x.rightChild;
				x.rightChild.parent = p;
			}
			
			x.leftChild = g;
			g.parent = x;
			x.rightChild = p;
			p.parent = x;
			
		}else{
			if(g.parent==null){
				x.parent = null;
			}else{
				if(g.parent.leftChild==g){
					g.parent.leftChild=x;
				}else{
					g.parent.rightChild=x;
				}
				x.parent=g.parent;
			}
			
			if(x.rightChild==null){
				g.leftChild = null;
			}else{
				g.leftChild = x.rightChild;
				x.rightChild.parent = g;
			}
			
			if(x.leftChild==null){
				p.rightChild = null;
			}else{
				p.rightChild = x.leftChild;
				x.leftChild.parent = p;
			}
			
			x.rightChild = g;
			g.parent = x;
			x.leftChild = p;
			p.parent = x;
			
		}
		return x;
	}
	
	public SplayNode Splay(SplayNode node){
		if (node.parent==null){
			return node; 
		}else if (node.parent.parent==null){
			return zig(node);
		}else if (node.key<node.parent.key){   ////node < node.parent
			if(node.parent.parent.key > node.parent.key){  ////node.parent < node.parent.parent
				//zig zig x(lC) p(lC)
				node = zigzig(node, true);
			}else{
				//zig zag x(lC) p(rC)
				node = zigzag(node, false);
			}
			return Splay(node);
		}else{//(node.parent.compareTo(node)>0){  /// node > node.parent
			if(node.parent.parent.key > node.parent.key){   //// node.parent < node.parent.parent
				//zig zag x(rc) p(lc)
				node = zigzag(node, true);
			}else{
				//zig zig x(rC) p(rC)
				node = zigzig(node, false);
			}
			return Splay(node);
		}
	}
	

	public boolean search(int key){
		if(this.root==null){
			return false;
		}
		SplayNode current = root;
		while(current.key!=key){
			if(current.key < key){   //current.data < data
				if(current.rightChild==null){
					return false;
				}else{
					current = current.rightChild;
				}
			}else{
				if(current.leftChild==null){
					return false;
				}else{
					current = current.leftChild;
				}
			}
		}
		return true; 
	}
	
	
	public void inOrderTraversal(){
		System.out.println("In order traversal");
		inOrderTraversal(root);
	}
	
	public void inOrderTraversal(SplayNode current){
		if(current != null){
			inOrderTraversal(current.leftChild);
			System.out.println("Data: "+current+ "   Key: " + current.key);
			inOrderTraversal(current.rightChild);
		}
	}
	
}
