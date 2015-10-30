package inmemdb.structures;

public class BinarySearchTree <T> extends Tree{
	
	public keyBSTree keyBST;
	public BSTNode root;
	int index;

	public BinarySearchTree (){
		root = null;
		index = 0;
		keyBST = new keyBSTree ();
	}
	
	/*
	 * Compare (T only)
	 */
	public <T> int compareTo(T a, T b){
        String temp1 = a.toString();
        String temp2 = b.toString();
        return temp1.compareTo(temp2);
    }
	
	
	
	public <T> void addNode(T data){
		//BSTNode newNode = new BSTNode(data, name);
		keyBST.addNode(data);
		BSTNode newNode = new BSTNode(data, this.index+1);
		
		if (root == null){
			root = newNode;
			this.index++;
		}else{
			BSTNode current = root;
			BSTNode parent; 
			
			while(true){
				parent = current;
				if(compareTo(data, current.data)>0){
					current = current.leftChild;
					if(current == null){
						parent.leftChild = newNode;
						this.index++;
						return; 
					}
				}else{
					current = current.rightChild;
					if(current==null){
						parent.rightChild = newNode;
						this.index++;
						return;
					}
				}
			}
		}
	}
	
	public <T> boolean findNode(T data){
		if(root==null){
			return false;
		}
		BSTNode current = root;
		while (current.data != data){
			if (compareTo(data, current.data)>0){
				current = current.leftChild;
			}else{
				current = current.rightChild;
			}
			if (current == null){
				return false;
			}
		}
		return true;
	}
	
	public <T> int SearchKeyOfValue(T data){
		if(root==null){
			return -1;
		}
		BSTNode current = root;
		while (current.data != data){
			if (compareTo(data, current.data)>0){
				current = current.leftChild;
			}else{
				current = current.rightChild;
			}
			if (current == null){
				return -1;
			}
		}
		return current.key;
		
		
		
	}

	public BSTNode getReplacementNode(BSTNode replacedNode){
		BSTNode replacementParent = replacedNode;
		BSTNode replacement  = replacedNode;
		BSTNode current = replacedNode.rightChild;
		while(current != null){
			replacementParent = replacement;
			replacement = current;
			current = current.leftChild;
		}
		if(replacement!= replacedNode.rightChild){
			replacementParent.leftChild = replacement.rightChild;
			replacement.rightChild = replacedNode.rightChild;
		}
		return replacement;
	}
	
	
	
	
	public <T> boolean remove(T data){
		keyBST.remove(SearchKeyOfValue(data));
		System.out.println("here");
		System.out.println("remove from BiSeTr");
		
		BSTNode current = root;
		BSTNode parent = root;
		
		if(root == null){
			return false;
		}
		
		boolean isItALeftChild = true;
		while(current.data != data){
			parent = current;
			if(compareTo(data, current.data)>0){
				isItALeftChild = true;
				current = current.leftChild;
			}else{
				isItALeftChild = false;
				current = current.rightChild;
			}if(current == null){
				return false;
			}
		}
		if (current.leftChild==null && current.rightChild==null){
			if(current == root){
				root = null; 
			}else if (isItALeftChild){
				parent.leftChild = null;
			}else{
				parent.rightChild=null;
			}
		}
		else if (current.rightChild==null){
			if(current == root){
				root = current.leftChild;
			}else if(isItALeftChild){
				parent.leftChild = current.leftChild;
			}else{
				parent.rightChild = current.leftChild;
			}
		}else if(current.leftChild == null){
			if(current == root){
				root = current.rightChild;
			}else if (isItALeftChild){
				parent.leftChild = current.rightChild;
			}else{
				parent.rightChild = current.rightChild;
			}
		}else{
			BSTNode replacement = getReplacementNode(current);
			if(current == root){
				root = replacement;
			}else if(isItALeftChild){
				parent.leftChild = replacement;
			}else{
				parent.rightChild = replacement;
			}
			replacement.leftChild = current.leftChild;
		}
		return true;
	}
	
	public String getDataString() {
		return getDataStringAux(root);
	}
	
	private String getDataStringAux(BSTNode current) {
		StringBuilder list = new StringBuilder();
		
		if(current != null){
			getDataStringAux(current.leftChild);
			list.append("Data: "+current+"--Key: "+current.key);
			getDataStringAux(current.rightChild);
		} 
		System.out.println(list);
		return list.toString();
	}
	
	
	public void inOrderTraversal(){
		System.out.println("In order traversal");
		inOrderTraversal(root);
	}
	
	private void inOrderTraversal(BSTNode current){
		if(current != null){
			inOrderTraversal(current.leftChild);
			System.out.println("Data: "+current+"    Key: "+current.key);
			inOrderTraversal(current.rightChild);
		}
	}
	
	public void preorderTraversal(){
		System.out.println("Preorder traversal");
		preorderTraversal(root);
	}
	
	private void preorderTraversal(BSTNode current){
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
	
	private void postorderTraversal(BSTNode current){
		if(current != null){
			postorderTraversal(current.leftChild);
			postorderTraversal(current.rightChild);
			System.out.println(current);
		}
	}
}
