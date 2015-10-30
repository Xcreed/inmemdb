package inmemdb.structures;


public class keyBSTree {
	
	public BSTNode root;
	int index;
	
	public keyBSTree (){
		root = null;
		index = 0;
	}
	
	public <T> void addNode(T data){
		//BSTNode newNode = new BSTNode(data, name);
		BSTNode newNode = new BSTNode(data, this.index+1);
		if (root == null){
			root = newNode;
			this.index++;
		}else{
			BSTNode current = root;
			BSTNode parent; 
			
			while(true){
				parent = current;
				if(newNode.key < current.key){
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
	
	public <T> boolean findNode(int key){
		if(root==null){
			return false;
		}
		BSTNode current = root;
		while (current.key != key){
			if (key < current.key){
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
	
	public <T> T searchKeyReturnValue(int key){
		if(root==null){
			return null;
		}
		BSTNode current = root;
		while (current.key != key){
			if (key < current.key){
				current = current.leftChild;
			}else{
				current = current.rightChild;
			}
			if (current == null){
				return null;
			}
		}
		return (T) current.data;
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
	 
	public <T> boolean remove(int key){
		BSTNode current = root;
		BSTNode parent = root;
		
		
		if(root == null){
			return false;
		}
		
		boolean isItALeftChild = true;
		while(current.key != key){
			parent = current;
			if(key < current.key){
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

}
