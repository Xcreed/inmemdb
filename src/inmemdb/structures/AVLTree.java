package inmemdb.structures;

public class AVLTree <T>{
	boolean integer;
	private AVLNode root; 
	private intAVLNode rootInt;

	public AVLTree(){
		root=null;
		rootInt = null;
	}
	
	
	/*
	 * Empty
	 */
	public boolean isEmpty(){
		if (integer){
			return rootInt == null;
		}else{
			return root == null;
		}
	}
	
	public void makeEmpty(){
		if (integer){
			rootInt = null;
		}else{
			root = null;
		}
	}
	
	/*
	 * Height 
	 */
	
	// With T
	private int height(AVLNode node){
		if (node==null){
			return -1;    
		}else{
			return node.height;
		}
	}
	
	//With int
	
	private int height(intAVLNode node){
		if (node==null){
			return -1;    
		}else{
			return node.height;
		}
	}
	
	
	private int max (int leftNode, int rightNode){
		if (leftNode < rightNode){
			return rightNode;
		}else{
			return leftNode;
		}
	}
	
	/*
	 * Insertion 
	 */
	
	//With int
	public void insert(int data){
		if(rootInt == null){
			integer = true;
		}
		rootInt = insert(data, this.rootInt);
	}
	
	
	private intAVLNode insert(int data, intAVLNode node){
		if (node == null){
			node = new intAVLNode(data); 
		}else if (data < node.data){
			node.leftChild = insert(data, node.leftChild);
			if (height(node.leftChild) - height (node.rightChild)==2){
				if (data<node.leftChild.data){
					node = rotateWithLeftChild(node);
				}else{
					node = doubleWithLeftChild(node);
				}
			}
		}else if (data > node.data){
			node.rightChild = insert(data, node.rightChild);
			if (height(node.rightChild)-height(node.leftChild)==2){
				if (data > node.rightChild.data){
					node = rotateWithRightChild(node);
				}else{
					node = doubleWithRightChild(node);
				}
			}
		}else{}
		node.height = max(height(node.leftChild), height(node.rightChild)) + 1;
		return node; 
	}
	
	
	// With T 
	public void insert(T data){
		if(root==null){
			integer = false;
		}
		root = insert2(data, this.root);
	}
	

	
	private AVLNode<T> insert2(T data, AVLNode node){
		AVLNode newNode = new AVLNode(data);
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

	/*
	 * Rotations
	 */
	
	//With T
	private AVLNode rotateWithLeftChild(AVLNode k2){
		AVLNode k1 = k2.leftChild;
		k2.leftChild = k1.rightChild;
		k1.rightChild = k2;
		k2.height = max(height(k2.leftChild), height(k2.rightChild))+1;
		k1.height = max(height(k2.leftChild), k2.height)+1;
		return k1;
	}
	
	
	private AVLNode rotateWithRightChild(AVLNode k1){
        AVLNode k2 = k1.rightChild;
        k1.rightChild = k2.leftChild;
        k2.leftChild = k1;
        k1.height = max( height( k1.leftChild ), height( k1.rightChild ) ) + 1;
        k2.height = max( height( k2.rightChild ), k1.height ) + 1;
        return k2;
    }
	
	
	private AVLNode doubleWithLeftChild(AVLNode k3){
        k3.leftChild = rotateWithRightChild( k3.leftChild );
        return rotateWithLeftChild( k3 );
    }
	
	private AVLNode doubleWithRightChild(AVLNode k1)
    {
        k1.rightChild = rotateWithLeftChild( k1.rightChild );
        return rotateWithRightChild( k1 );
    }
	
	//With int 
	private intAVLNode rotateWithLeftChild(intAVLNode k2){
		intAVLNode k1 = k2.leftChild;
		k2.leftChild = k1.rightChild;
		k1.rightChild = k2;
		k2.height = max(height(k2.leftChild), height(k2.rightChild))+1;
		k1.height = max(height(k2.leftChild), k2.height)+1;
		return k1;
	}
	
	
	private intAVLNode rotateWithRightChild(intAVLNode k1){
        intAVLNode k2 = k1.rightChild;
        k1.rightChild = k2.leftChild;
        k2.leftChild = k1;
        k1.height = max( height( k1.leftChild ), height( k1.rightChild ) ) + 1;
        k2.height = max( height( k2.rightChild ), k1.height ) + 1;
        return k2;
    }
	
	
	private intAVLNode doubleWithLeftChild(intAVLNode k3){
        k3.leftChild = rotateWithRightChild( k3.leftChild );
        return rotateWithLeftChild( k3 );
    }
	
	private intAVLNode doubleWithRightChild(intAVLNode k1)
    {
        k1.rightChild = rotateWithLeftChild( k1.rightChild );
        return rotateWithRightChild( k1 );
    }
	
	/*
	 * Size
	 */
	public int size(){
		if(integer){
			return size(rootInt);
		}else{
			return size(root);
		}
	}
	
	//With T
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
	//With int
	public int size(intAVLNode root){
		if(root==null){
			return 0;
		} else {
			int counter = 1;
			counter+= size(root.leftChild);
			counter+= size(root.rightChild);
			return counter;
		}
	}
	
	
	/*
	 * Search 
	 */
	
	//With T
	public boolean search(T value){
		return search(root, value);
	}
	
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
	
	//With int
	public boolean search(int value){
		return search(rootInt, value);
	}
	
	public boolean search(intAVLNode rootInt, int value){
		boolean found = false; 
		while((rootInt!=null)&&!found){
			int rootvalue = rootInt.data;
			if (value < rootvalue){
				rootInt = rootInt.leftChild;
			}else if (value > rootvalue){
				rootInt = rootInt.rightChild;
			}else{
				found = true;
				break;
			}
			found = search (rootInt, value);
		}
		return found;
	}
	
	/*
	 * Compare (T only)
	 */
	public int compareTo(T a, T b){
        String temp1 = a.toString();
        String temp2 = b.toString();
        return temp1.compareTo(temp2);
    }
	
	/*
	 * Balance Factor
	 */
	//With T
	public int balanceFactor(AVLNode node){   		/// node can't be null 
		int LCHeight=0, RCHeight=0;
		if(node.leftChild!=null){
			LCHeight = node.leftChild.height;
		}if(node.rightChild!=null){
			RCHeight = node.rightChild.height;
		}
		return RCHeight-LCHeight;
	}
	
	//With int
	public int balanceFactor(intAVLNode node){   		/// node can't be null 
		int LCHeight=0, RCHeight=0;
		if(node.leftChild!=null){
			LCHeight = node.leftChild.height;
		}if(node.rightChild!=null){
			RCHeight = node.rightChild.height;
		}
		return RCHeight-LCHeight;
	}
	
	/*
	 * findMax
	 */
	//With T
	private AVLNode findMax( AVLNode node){
        if( node == null )
            return node;

        while( node.rightChild != null )
            node = node.rightChild;
        return node;
    }
	
	//With int
	private intAVLNode findMax( intAVLNode node){
        if( node == null )
            return node;

        while( node.rightChild != null )
            node = node.rightChild;
        return node;
    }
	
	
	
	
	/*
	 * Deletion
	 */
	
	//With T
	public boolean remove( T data ) {
	      root = remove(data, root);
	      if (root!=null){
	    	  return false;
	      }else{
	    	  return true; 
	      }
	}
	
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
	
	//With int
	public boolean remove( int data ) {
	      rootInt = remove(data, rootInt);
	      if (rootInt!=null){
	    	  return false;
	      }else{
	    	  return true; 
	      }
	}
	
	public intAVLNode remove(int value, intAVLNode node) {
		if (node==null)    {
			return null;
		}
	      
		if (value < node.data) {
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
		else if (value > node.data) {
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
			remove(node.data, node.leftChild);
	       
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


	/*
	 * Print
	 */
	public void inorder(){
		if(integer){
			inorder(rootInt);
		}else{
			inorder(root);
		}
	}
	
	public void inorder(AVLNode root){
		if(root != null){
			inorder(root.leftChild);
			System.out.println(root.data + "  ");
			inorder(root.rightChild);
		}
	}
	
	public void inorder(intAVLNode root){
		if(root != null){
			inorder(root.leftChild);
			System.out.println(root.data + "  ");
			inorder(root.rightChild);
		}
	}
	
	public void preorder(){
		if(integer){
			preorder(rootInt);
		}else{
			preorder(root);
		}
	}
	
	public void preorder(AVLNode root){
		if (root != null){
			System.out.println(root.data);
			preorder(root.leftChild);
			preorder(root.rightChild);
		}
	}
	
	public void preorder(intAVLNode root){
		if (root != null){
			System.out.println(root.data);
			preorder(root.leftChild);
			preorder(root.rightChild);
		}
	}
	
	public void postorder(){
		if(integer){
			postorder(rootInt);
		}else{
			postorder(root);
		}
	}
	
	public void postorder(AVLNode root){
		if (root != null){
			postorder(root.leftChild);
			postorder(root.rightChild);
			System.out.println(root.data);
		}
	}
	
	public void postorder(intAVLNode root){
		if (root != null){
			postorder(root.leftChild);
			postorder(root.rightChild);
			System.out.println(root.data);
		}
	}

}
