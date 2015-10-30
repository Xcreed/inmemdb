package inmemdb.structures;


public class keyAVLTree <T>{
	AVLNode root;
	int index;
	
	
	public keyAVLTree(){
		root=null;
		index = 0;
	}
	
	public boolean isEmpty(){
		return root==null;
	}
	
	public void makeEmpty(){
		root=null;
	}
	
	private int height(AVLNode node){
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
	public void insert(T data){
		root = insert(data , this.root);
		this.index++;
	}
	
	
	
	private AVLNode<T> insert(T data, AVLNode node){
		AVLNode newNode = new AVLNode(data, this.index+1);
		if (node==null){       
			node = newNode;
		}else if(newNode.key < node.key){
			node.leftChild = insert(data, node.leftChild);
			if (height(node.leftChild) - height (node.rightChild)==2){
				if (newNode.key<node.leftChild.key){
					node = rotateWithLeftChild(node);
				}else{
					node = doubleWithLeftChild(node);
				}
			}
		}else if(newNode.key > node.key){
			node.rightChild = insert(data, node.rightChild);
			if (height(node.rightChild)-height(node.leftChild)==2){
				if (newNode.key>node.rightChild.key){
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
	
	
	
	/*
	 * Search 
	 */
	
	//Search boolean
	
	public boolean search(int key ){
		if(root ==null){
			return false;
		}else{
			return search(root, key );
		}
	}
	
	public boolean search(AVLNode root, int key){
		boolean found = false; 
		while((root!=null)&&!found){
			int rootkey = root.key;
			if (key < rootkey){
				root = root.leftChild;
			}else if (key > rootkey){
				root = root.rightChild;
			}else{
				found = true;
				break;
			}
			found = search (root, key);
		}
		return found;
	}
	
	//Search returns a value 
	public T searchKeyReturnValue(int key ){
		if(root ==null){
			return null;
		}else{
			return searchKeyReturnValue(root, key);
		}
	}
	
	public T searchKeyReturnValue(AVLNode root, int key){
		boolean found = false; 
		while((root!=null)&&!found){
			T rootvalue = (T) root.data;
			if (key < root.key){
				root = root.leftChild;
			}else if (key > root.key){
				root = root.rightChild;
			}else{
				found = true;
				break;
			}
		}
		if(found){
			return (T) root.data;
		}else{
			return null;
		}
	}
	
	
	/*
	 * findMax
	 */
	
	private AVLNode findMax( AVLNode node){
        if( node == null )
            return node;

        while( node.rightChild != null )
            node = node.rightChild;
        return node;
    }
	
	
	/*
	 * Deletion
	 */
	public boolean remove( int key ) {
	      root = remove(key , root);
	      if (root!=null){
	    	  return false;
	      }else{
	    	  return true; 
	      }
	}
	
	public AVLNode remove(int key, AVLNode node) {    //T value-> int key  
		if (node==null)    {
			return null;
		}
		
		if (key < node.key) {    //value < node.data
			node.leftChild = remove(key,node.leftChild);
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
		else if (key > node.key) {         //value > node.data
			node.rightChild = remove(key,node.rightChild);
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
		
		else if(node.leftChild != null) {                  //value == node.data
			node.data = findMax(node.leftChild).data;
			node.key = findMax(node.leftChild).key;
			remove(node.key, node.leftChild);         ////////////////
	       
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
		inorder(root);
	}
	
	public void inorder(AVLNode root){
		if(root != null){
			inorder(root.leftChild);
			System.out.println("Data: "+root.data + "  Key: "+ root.key);
			inorder(root.rightChild);
		}
	}
	
}
