package inmemdb.structures;

/**
 * Class for the SplayTree. 
 *
 * @param <T>
 */
public class SplayTree<T> extends Tree {
	SplayNode root;
	keySPTree keySP;
	int size;
	int index; 
	
	public SplayTree(){
		this.root = null;
		this.keySP = new keySPTree();
		this.size = 0;
		this.index = 0;
	}
	
	/**
	 * verify if the tree is empty.
	 * 
	 * @return boolean
	 */
	public boolean isEmpty(){
		return root == null;
	}
	/**
	 * Make the tree empty.
	 */
	public void makeEmpty(){
		root = null;
	}
	
	/**
	 * Compare (T only)
	 */
	public int compareTo(T a, T b){
        String temp1 = a.toString();
        String temp2 = b.toString();
        return temp1.compareTo(temp2);
    }
	
	/**
	 * Gine a data, it assign a key for the new
	 * node that will contain the data.
	 * @param data
	 */
	public void insert(T data){
		//System.out.println(data);
		if(search(data)){
			System.out.println("This node already exists ");
		}else{
			index++;
			keySP.insert(data, index);
			insert(data, index);
			
		}
	}

	
	/**
	 * Given a new data, insert its into a new node. 
	 * Calls insert() to insert the new node into 
	 * the tree. 
	 * 
	 * @param data
	 * @param key
	 */
	public void insert(T data, int key){
		SplayNode newNode = new SplayNode(data, key);
		if(root == null){
			this.root = newNode;
		}else{
			insert(newNode, this.root);
		}
	}
	
	/**
	 * Insert a new node into the tree.
	 * 
	 * @param newNode
	 * @param root
	 */
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
	
	public int SearchKeyOfValue(T value){
		if(root ==null){
			return -1;
		}else{
			return SearchKeyOfValue(root, value);
		}
	}
	
	public int SearchKeyOfValue(SplayNode root, T value){
		boolean found = false; 
		while((root!=null)&&!found){
			T rootvalue = (T) root.data;
			if (compareTo(value, rootvalue)>0){
				root = root.leftChild;
			}else if (compareTo(value, rootvalue)<0){
				root = root.rightChild;
			}else{
				found = true;
				break;
			}
		}
		if(found){
			return root.key;
		}else{
			return -1;
		}
		
	}
					
	/**
	 * Deletes the nodes that contains the given data.
	 * 
	 * @param data
	 */
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
	
	/**
	 *Zig operation.
	 * 
	 * @param node
	 * @return node
	 */
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
		return x; 
	}
	
	/**
	 * ZigZig rotation. 
	 * 
	 * @param node
	 * @param leftLeft
	 * @return node
	 */
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
	
	/**
	 * Zizag rotation.
	 * 
	 * @param node
	 * @param XRightCPLeftC
	 * @return Node
	 */
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
	
	/**
	 * Apply the splay operation into a given a
	 * node. 
	 * 
	 * @param node
	 * @return node
	 */
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
	/**
	 * Given a data, searches if it is contain
	 * by the tree.
	 * 
	 * @param data
	 * @return boolean
	 */
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
	
	/**
	 * Calls inOrderTraversal().
	 */
	public void inOrderTraversal(){
		System.out.println("In order traversal");
		inOrderTraversal(root);
	}
	
	/**
	 * 
	 * @param current
	 */
	public void inOrderTraversal(SplayNode current){
		if(current != null){
			inOrderTraversal(current.leftChild);
			System.out.println("Data: "+current+ "   Key: " + current.key);
			inOrderTraversal(current.rightChild);
		}
	}
	
	/**
	 * Calls preorderTraversal().
	 */
	public void preorderTraversal(){
		System.out.println("Preorder traversal");
		preorderTraversal(root);
	}
	
	/**
	 * 
	 * @param current
	 */
	public void preorderTraversal(SplayNode current){
		if(current != null){
			System.out.println(current);
			preorderTraversal(current.leftChild);
			preorderTraversal(current.rightChild);
		}
	}
	
	/**
	 * Calls postOrderTraversal().
	 */
	public void postorderTraversal(){
		System.out.println("Postorder traversal");
		postorderTraversal(root);
	}
	
	/**
	 * 
	 * @param current
	 */
	public void postorderTraversal(SplayNode current){
		if(current != null){
			postorderTraversal(current.leftChild);
			postorderTraversal(current.rightChild);
			System.out.println(current);
		}
	}
	/**
	 * Calls getDataStringAux().
	 * 
	 * @return String
	 */
	public String getDataString() {
		return getDataStringAux(root);
	}
	
	/**
	 * Returns the data of a given as a type String.
	 * 
	 * @return String
	 */
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
