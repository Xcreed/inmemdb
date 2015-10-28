package inmemdb.structures;

public class SplayTree<T> extends Tree {
	SplayNode root;
	int size;
	int index; 

	
	public boolean isEmpty(){
		return root == null;
	}
	
	public void makeEmpty(){
		root = null;
	}
	
	
	/*
	 * Compare (T only)
	 */
	public int compareTo(T a, T b){
        String temp1 = a.toString();
        String temp2 = b.toString();
        return temp1.compareTo(temp2);
    }
	/**/
	
	public void insert(T data){
		//System.out.println(data);
		if(search(data)){
			System.out.println("This node already exists ");
		}else{
			index++;
			insert(data, index);
		}
	}
	public void insert(T data, int key){
		System.out.println(data);
		SplayNode newNode = new SplayNode(data, key);
		if(root == null){
			this.root = newNode;
		}else{
			insert(newNode, this.root);
		}
	}
	
	public void insert(SplayNode newNode, SplayNode root){
		if(newNode.compareTo(root)<0){  ///newNode > root
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
	
	
	public void delete(T data){
		if(root==null){
			return ;
		}
		SplayNode current = root;
		while(current.data!=data){
			if (compareTo((T) current.data, data)<0){
				current = current.leftChild;
			}else{
				current = current.rightChild;
			}
		}
		if (current.leftChild==null && current.rightChild==null){
			SplayNode node2Splay = current.parent;
			current = null; 
			this.root= Splay(current.parent);
		}else if(current.rightChild== null){
			SplayNode newCurrent = current.leftChild;
			while(newCurrent.rightChild != null){
				newCurrent = newCurrent.rightChild; 
			}
			current.data = newCurrent.data;
			newCurrent = null;
			this.root = Splay(current);
		}else{
			SplayNode newCurrent = current.rightChild;
			while(newCurrent.leftChild != null){
				newCurrent = newCurrent.leftChild; 
			}
			current.data = newCurrent.data;
			newCurrent = null;
			this.root = Splay(current);
		}
	}
	
	public SplayNode zig(SplayNode node){
		SplayNode p = node.parent;
		SplayNode x = node;
		if (node.compareTo(node.parent)<0){  // node > node.parent
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
		return node; 
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
		}else if (node.parent.compareTo(node)<0){   ////node < node.parent
			if(node.parent.parent.compareTo(node.parent)<0){  ////node.parent < node.parent.parent
				//zig zig x(lC) p(lC)
				node = zigzig(node, true);
			}else{
				//zig zag x(lC) p(rC)
				node = zigzag(node, false);
			}
			return Splay(node);
		}else{//(node.parent.compareTo(node)>0){  /// node > node.parent
			if(node.parent.parent.compareTo(node.parent)<0){   //// node.parent < node.parent.parent
				//zig zag x(rc) p(lc)
				node = zigzag(node, true);
			}else{
				//zig zig x(rC) p(rC)
				node = zigzig(node, false);
			}
			return Splay(node);
		}
	}
	
	public boolean search(T data){
		if(this.root==null){
			return false;
		}
		SplayNode current = root;
		while(current.data!=data){
			if(compareTo(data, (T) current.data)<0){   //current.data < data
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
	
	public void preorderTraversal(){
		System.out.println("Preorder traversal");
		preorderTraversal(root);
	}
	
	public void preorderTraversal(SplayNode current){
		if(current != null){
			System.out.println(current);
			preorderTraversal(current.leftChild);
			preorderTraversal(current.rightChild);
		}
	}
	
	public void postorderTraversal(){
		System.out.println("Postorder traversal");
		postorderTraversal(root);
	}
	
	public void postorderTraversal(SplayNode current){
		if(current != null){
			postorderTraversal(current.leftChild);
			postorderTraversal(current.rightChild);
			System.out.println(current);
		}
	}
	
	public String getDataString() {
		return getDataStringAux(root);
	}
	
	private String getDataStringAux(SplayNode current) {
		StringBuilder list = new StringBuilder();
		
		if(current != null){
			getDataStringAux(current.leftChild);
			list.append("Data: "+current+"--Key: "+current.key);
			getDataStringAux(current.rightChild);
		} 
		System.out.println(list);
		return list.toString();
	}
	
	
}
