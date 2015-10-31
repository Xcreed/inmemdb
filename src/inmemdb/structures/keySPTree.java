package inmemdb.structures;

public class keySPTree<T> {
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
	
	/*
	 * Compare (T only)
	 */
	public int compareTo(T data, T b){
        String temp1 = data.toString();
        String temp2 = b.toString();
        return temp1.compareTo(temp2);
    }
	/**/
	

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
	
	public SplayNode findMax(SplayNode root){
		if (root.rightChild==null){
			return root;
		}else{
			return findMax(root.rightChild);
		}
	}

	public SplayNode findMin(SplayNode root){
		if (root.leftChild==null){
			return root;
		}else{
			return findMax(root.leftChild);
		}
	}
	
	public void setReplacementNull(SplayNode replacement, SplayNode root){
		SplayNode parent = root;
		if(replacement.rightChild==null && replacement.leftChild == null){
			if(parent.leftChild == replacement){
				parent.leftChild = null;
				if(parent.parent.leftChild == root){
					parent.parent.leftChild = parent;
				}else{
					parent.parent.rightChild = parent;
				}
			}else{
				parent.rightChild = null;
				if(parent.parent.leftChild == root){
					parent.parent.leftChild = parent;
				}else{
					parent.parent.rightChild = parent;
				}
			}
		}else if(replacement.rightChild != null){
			replacement.rightChild.parent = replacement.parent;
			if(parent.leftChild == replacement){
				parent.leftChild = replacement.rightChild;
				if(parent.parent.leftChild == root){
					parent.parent.leftChild = parent;
				}else{
					parent.parent.rightChild = parent;
				}
			}else{
				parent.rightChild = replacement.rightChild;
				if(parent.parent.leftChild == root){
					parent.parent.leftChild = parent;
				}else{
					parent.parent.rightChild = parent;
				}
			}
		}else if(replacement.leftChild != null){
			replacement.leftChild.parent = replacement.parent;
			if(parent.leftChild == replacement){
				parent.leftChild = replacement.leftChild;
				if(parent.parent.leftChild == root){
					parent.parent.leftChild = parent;
				}else{
					parent.parent.rightChild = parent;
				}
			}else{
				parent.rightChild = replacement.leftChild;
				if(parent.parent.leftChild == root){
					parent.parent.leftChild = parent;
				}else{
					parent.parent.rightChild = parent;
				}
			}
		}
	}
	
	
	public void delete(int key){
		if(root==null){
			return;
		}
		SplayNode current = root;
		while(current.key!=key && current!=null){
			if(key < current.key){
				current=current.leftChild;
			}else{
				current=current.rightChild;
			}
		}
		if(current.leftChild==null && current.rightChild==null){
			if(current==this.root){
				this.root=null;
			}
			else if(current.parent.leftChild==current){
				current.parent.leftChild = null;
			}else{
				current.parent.rightChild = null;
			}
		}else if(current.rightChild == null){
			SplayNode newCurrent;
			SplayNode replacement = findMax(current.leftChild);
			current.data = replacement.data;
			current.key = replacement.key;
			newCurrent = current;
			current.leftChild.parent = newCurrent;
			if(current.parent.leftChild == current){
				current.parent.leftChild = newCurrent;
			}else{
				current.parent.rightChild = newCurrent;
			}
			setReplacementNull(replacement, replacement.parent);
		}else if (current.leftChild == null){
			SplayNode newCurrent;
			SplayNode replacement = findMin(current.rightChild);
			System.out.println(replacement);
			System.out.println(replacement.rightChild);
			
			current.data = replacement.data;
			current.key = replacement.key;
			newCurrent = current;
			current.rightChild.parent = newCurrent;
			if(current.parent.leftChild == current){
				current.parent.leftChild = newCurrent;
			}else{
				current.parent.rightChild = newCurrent;
			}
			setReplacementNull(replacement, replacement.parent);
		}else{
			SplayNode newCurrent;
			SplayNode replacement = findMax(current.leftChild);
			current.data = replacement.data;
			current.key = replacement.key;
			newCurrent = current;
			current.leftChild.parent = newCurrent;
			current.rightChild.parent = newCurrent;
			if(current.parent.leftChild == current){
				current.parent.leftChild = newCurrent;
			}else{
				current.parent.rightChild = newCurrent;
			}
			setReplacementNull(replacement, replacement.parent);
		}
		
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
