package inmemdb.structures;

/**
 * Class for the AVL Tree.
 *
 * @param <T>
 */
public class AVLTree <T> extends Tree{
	public AVLNode root; 
	public int index;

	public AVLTree(){
		root=null;
		index = 0;
	}
	
	
	/**
	 * Checks if the tree is empty. 
	 * @return boolean
	 */
	public boolean isEmpty(){
		return (root == null);
	}
	
	/**
	 * Makes the tree empty by appointing
	 * the root to null. 
	 */
	public void makeEmpty(){
		root=null;
	}
	
	/**
	 * Return the height of a given node
	 * of the tree. 
	 * 
	 * @param node
	 * @return int
	 */
	private int height(AVLNode node){
		if (node==null){
			return -1;    
		}else{
			return node.height;
		}
	}
	
	/**
	 * Given to sibling nodes, returns which
	 * has the bigger element.
	 * 
	 * @param leftNode
	 * @param rightNode
	 * @return int
	 */
	private int max (int leftNode, int rightNode){
		if (leftNode < rightNode){
			return rightNode;
		}else{
			return leftNode;
		}
	}
	
	/**
	 * Inserts data to the tree.
	 * (1) checks if the tree is empty,
	 * (2) checks if the given data exist,
	 * (3) calls insert2() to insert the data.
	 * 
	 * @param data
	 */
	public void insert(T data){
		if (this.root==null){
			return;
		}else if (search(data)){
			System.out.println("This value already exists in the tree.");
		}else{
			root = insert2(data, this.root);
			this.index++;
		}
		
	}
	
	/**
	 * Called by insert(). Inserts the data.
	 * 
	 * @param data
	 * @param node
	 * @return node
	 */
	
	private AVLNode<T> insert2(T data, AVLNode node){
		AVLNode newNode = new AVLNode(data, this.index+1);
		if (node==null){       
			node = newNode;
		}else if(newNode.compareTo(node)>0){
			node.leftChild = insert2(data, node.leftChild);
			if (height(node.leftChild) - height (node.rightChild)==2){
				if (newNode.compareTo(node.leftChild)>0){
					node = rotateWithLeftChild(node);
				}else{
					node = doubleWithLeftChild(node);
				}
			}
		}else if(newNode.compareTo(node)<0){
			node.rightChild = insert2(data, node.rightChild);
			if (height(node.rightChild)-height(node.leftChild)==2){
				if (newNode.compareTo(node.rightChild)<0){
					node = rotateWithRightChild(node);
				}else{
					node = doubleWithRightChild(node);
				}
			}
		}else{}
		node.height = max(height(node.leftChild), height(node.rightChild)) + 1;
		return node;
	}

	/**
	 * Makes a rotation with the left child
	 * of a given node. 
	 * 
	 * @param k2
	 * @return node
	 */
	private AVLNode rotateWithLeftChild(AVLNode k2){
		AVLNode k1 = k2.leftChild;
		k2.leftChild = k1.rightChild;
		k1.rightChild = k2;
		k2.height = max(height(k2.leftChild), height(k2.rightChild))+1;
		k1.height = max(height(k2.leftChild), k2.height)+1;
		return k1;
	}
	
	/**
	 * Makes a rotation with the right child
	 * of a given node.
	 * 
	 * @param k1
	 * @return node
	 */
	private AVLNode rotateWithRightChild(AVLNode k1){
        AVLNode k2 = k1.rightChild;
        k1.rightChild = k2.leftChild;
        k2.leftChild = k1;
        k1.height = max( height( k1.leftChild ), height( k1.rightChild ) ) + 1;
        k2.height = max( height( k2.rightChild ), k1.height ) + 1;
        return k2;
    }
	
	/**
	 * Makes a double rotation with the left child 
	 * of given node. 
	 * 
	 * @param k3
	 * @return node
	 */
	private AVLNode doubleWithLeftChild(AVLNode k3){
        k3.leftChild = rotateWithRightChild( k3.leftChild );
        return rotateWithLeftChild( k3 );
    }
	
	/**
	 * Makes a double rotation with the right child 
	 * of a given node. 
	 * @param k1
	 * @return node
	 */
	private AVLNode doubleWithRightChild(AVLNode k1)
    {
        k1.rightChild = rotateWithLeftChild( k1.rightChild );
        return rotateWithRightChild( k1 );
    }
	
	/**
	 * Returns the size of the tree. 
	 * Invoque size(root) for the number.
	 * @return int
	 */
	public int size(){
		return size(this.root);
	}
	
	/**
	 * Return the size of the tree by counting from 
	 * the root. 
	 * 
	 * @param root
	 * @return int
	 */
	public int size(AVLNode root){
		if(root==null){
			return 0;
		} else {
			int counter = 1;
			counter+= size(root.leftChild);
			counter+= size(root.rightChild);
			return counter;
		}
	}
	
	/**
	 * Searches inside the tree the given data, 
	 * invoque search(data, root) for the boolean.
	 * 
	 * @param value
	 * @return boolean
	 */
	public boolean search(T value){
		if(root ==null){
			return false;
		}else{
			return search(root, value);
		}
	}
	
	/**
	 * Given a data, searches it inside the tree
	 * starting by the root.
	 * 
	 * @param root
	 * @param value
	 * @return boolean
	 */
	public boolean search(AVLNode root, T value){
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
			found = search (root, value);
		}
		return found;
	}
	
	/**
	 * Given two data values, changes them
	 * into string to compare them.
	 * 
	 * @param a
	 * @param b
	 * @return int
	 */
	public int compareTo(T a, T b){
        String temp1 = a.toString();
        String temp2 = b.toString();
        return temp1.compareTo(temp2);
    }
	
	/**
	 * Returns the balance factor of the tree. 
	 * @param node
	 * @return int
	 */
	public int balanceFactor(AVLNode node){   		/// node can't be null 
		int LCHeight=0, RCHeight=0;
		if(node.leftChild!=null){
			LCHeight = node.leftChild.height;
		}if(node.rightChild!=null){
			RCHeight = node.rightChild.height;
		}
		return RCHeight-LCHeight;
	}
	
	private AVLNode findMax( AVLNode node){
        if( node == null )
            return node;

        while( node.rightChild != null )
            node = node.rightChild;
        return node;
    }
	
	/**
	 * Removes an element of the tree. Invoque
	 * remove(value, node).
	 * @param data
	 * @return boolean
	 */
	public boolean remove( T data ) {
	      root = remove(data, root);
	      if (root!=null){
	    	  return false;
	      }else{
	    	  return true; 
	      }
	}
	
	/**
	 * Searches for the element inside the tree for 
	 * deletion. Starts from the root.
	 * 
	 * @param value
	 * @param node
	 * @return node
	 */
	public AVLNode remove(T value, AVLNode node) {
		if (node==null)    {
			return null;
		}
	      
		if (value.toString().compareTo(node.toString())>0) {
			node.leftChild = remove(value,node.leftChild);
			int l = node.leftChild != null ? node.leftChild.height : 0;
	  
			if((node.rightChild != null) && (node.rightChild.height - l >= 2)) {
				int rightHeight = node.rightChild.rightChild != null ? node.rightChild.rightChild.height : 0;
				int leftHeight = node.rightChild.leftChild != null ? node.rightChild.leftChild.height : 0;
	  
				if(rightHeight >= leftHeight)
					node = rotateWithLeftChild(node);            
				else
					node = doubleWithRightChild(node);
			}
		}
		else if (value.toString().compareTo(node.toString())<0) {
			node.rightChild = remove(value,node.rightChild);
			int r = node.rightChild != null ? node.rightChild.height : 0;
			if((node.leftChild != null) && (node.leftChild.height - r >= 2)) {
				int leftHeight = node.leftChild.leftChild != null ? node.leftChild.leftChild.height : 0;
				int rightHeight = node.leftChild.rightChild != null ? node.leftChild.rightChild.height : 0;
				if(leftHeight >= rightHeight)
					node = rotateWithRightChild(node);               
				else
					node = doubleWithLeftChild(node);
			}
		}
		
		else if(node.leftChild != null) {
			node.data = findMax(node.leftChild).data;
			remove((T) node.data, node.leftChild);
	       
			if((node.rightChild != null) && (node.rightChild.height - node.leftChild.height >= 2)) {
				int rightHeight = node.rightChild.rightChild != null ? node.rightChild.rightChild.height : 0;
				int leftHeight = node.rightChild.leftChild != null ? node.rightChild.leftChild.height : 0;
	       
				if(rightHeight >= leftHeight)
					node = rotateWithLeftChild(node);            
				else
					node = doubleWithRightChild(node);
			}
		}
	       
		else
			node = (node.leftChild != null) ? node.leftChild : node.rightChild;
	       
		if(node != null) {
			int leftHeight = node.leftChild != null ? node.leftChild.height : 0;
			int rightHeight = node.rightChild!= null ? node.rightChild.height : 0;
			node.height = Math.max(leftHeight,rightHeight) + 1;
		}
		return node;
	  		
	}
	
	/**
	 * Calls inorder().
	 */
	public void inorder(){
		inorder(root);
	}
	
	/**
	 * Prints the order of the nodes. 
	 * @param root
	 */
	public void inorder(AVLNode root){
		if(root != null){
			inorder(root.leftChild);
			System.out.println("Data: "+root.data + "  Key: "+ root.key);
			inorder(root.rightChild);
		}
	}
	
	/**
	 * Calls inorder2().
	 */
	public void inorder2(){
		inorder2(root);
	}
	
	/**
	 * Prints the order of the nodes. 
	 * 
	 * @param root
	 */
	public void inorder2(AVLNode root){
		if(root != null){
			inorder(root.rightChild);
			System.out.println("Data: "+root.data + "  Key: "+ root.key);
			inorder(root.leftChild);
		}
	}
	
	/**
	 * Calls Preorder().
	 */
	public void preorder(){
		preorder(root);
	}
	
	/**
	 * 
	 * @param root
	 */
	public void preorder(AVLNode root){
		if (root != null){
			System.out.println("Data: "+root.data + "  Key: "+ root.key);
			preorder(root.leftChild);
			preorder(root.rightChild);
		}
	}
	
	/**
	 * Calls postorder().
	 */
	public void postorder(){
		postorder(root);
	}
	
	public void postorder(AVLNode root){
		if (root != null){
			postorder(root.leftChild);
			postorder(root.rightChild);
			System.out.println("Data: "+root.data + "  Key: "+ root.key);
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
	 * Returns the data of the given node as a String. 
	 * 
	 * @param current
	 * @return String 
	 */
	private String getDataStringAux(AVLNode current) {
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
