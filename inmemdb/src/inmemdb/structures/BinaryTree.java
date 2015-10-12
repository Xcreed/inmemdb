package inmemdb.structures;

@SuppressWarnings({"rawtypes","unchecked"})
public class BinaryTree <T> {
	
	private BinaryNode root = null;
	
    public BinaryTree() {
        //new BinaryTree();
    }
    /**
     * Returns the root of the tree
     * @return
     */
    public BinaryNode getRoot(){
    	return root;
    }
	/**
	 * Insert elements
	 * @param value to insert
	 */
	public void insert(T data) {
		
		BinaryNode toInsert = new BinaryNode(data);
		
		if (root == null) //Empty Tree
			root = toInsert;
		else 
			insertAux(toInsert, root);	
	}
	
	private void insertAux(BinaryNode node, BinaryNode root) {
		
		if (root.compareTo(node) > 0) { //Node is smaller than root
			
			if (root.getHizq() == null)
				root.setHizq(node);
			else
				insertAux(node, (BinaryNode) root.getHizq());
		}
		
		else {	//Node is greater than root
			
			if (node.getData() != root.getData()) {
				if (root.getHder() == null)
					root.setHder(node);
				else
					insertAux(node, (BinaryNode) root.getHder());
			}
		}
	}
	
	/**
	 * Padre del dato a encontrar
	 * @param Raiz del sub-arbol
	 * @param Dato a encontrar
	 * @param Padre del nodo
	 * @return
	 */
	private BinaryNode getParent(BinaryNode root, T value, BinaryNode parent) {
		BinaryNode child = new BinaryNode(value);

		if (root.compareTo(child) == 0 || root == null)
			return parent;
		if (root.compareTo(child) > 0)
			return getParent((BinaryNode) root.getHizq(), value, root);
		else
			return getParent((BinaryNode) root.getHder(), value, root);
	}
	
	/**
	 * Remove an element
	 * @param Value to remove
	 */
	public boolean remove(T value) {
		BinaryNode toRemove = new BinaryNode(value);

	    if (root == null)//Tree doesn't exist
	          return false;
	    else {
	          if (root.compareTo(toRemove) == 0) {//Remove root
	                BinaryNode auxRoot = new BinaryNode(0);
	                auxRoot.setHizq(root);
	                boolean result = root.remove(value, auxRoot);
	                root = (BinaryNode) auxRoot.getHizq();
	                return result;
	          } else {
	                return root.remove(value, null);
	          }
	    }
	}
	
	/**
	 * Biggest element in the smaller side
	 * @param sub-tree root
	 * @return biggest from the sub-tree
	 */
	@SuppressWarnings("unused")
	private BinaryNode maxMin(BinaryNode node) {
		if(node.getHder() == null)
			return null;
		if (((BinaryNode) node.getHder()).getHder() == null)
			return node;
		else
			return maxMin((BinaryNode) node.getHder());
	}
	
	/** 
	 * Height of the tree
	 * @return 
	 */
	public int getDeep() {
		
		if (root == null)//No tiene ningun elemento
			return -1;
		else 
			return getDeepAux(root, 0);
		
	}
	
	private int getDeepAux(BinaryNode node, int deep) {
		
		if (node.getHizq() == null && node.getHder() == null)//Nodo es una hoja
			return deep;
		else if (node.getHizq() == null)//No left child
			return getDeepAux((BinaryNode) node.getHder(), deep + 1);
		else if (node.getHder() == null)//No right child
			return getDeepAux((BinaryNode) node.getHizq(), deep + 1);
		else //Node has both children, needs to know which is more deep
			return Math.max(getDeepAux((BinaryNode) node.getHizq(), deep + 1), getDeepAux((BinaryNode) node.getHder(), deep + 1));
	}
	
	
	/**
	 * Sorts elements in tree
	 * @param root node
	 */
	public void inOrden(BinaryNode data) {
		
		if (data == null)
			return;
		if (data.getHizq() != null)
			inOrden((BinaryNode) data.getHizq());
		System.out.println(data.getData());
		if (data.getHder() != null)
			inOrden((BinaryNode) data.getHder());
	}
	
	/**
	 * Gets elements from the root (bottom to top)
	 * @param Tree's root
	 */
	public void Levels(BinaryNode Root) {
		
		GenQueue<BinaryNode> tmp = new GenQueue();
		
		if ( Root == null)
			return;
		else
			tmp.enqueue(Root);

		while(tmp.size() != 0) {
			BinaryNode tmpNode = (BinaryNode) tmp.dequeue();
			
			System.out.println(tmpNode.getData());
			
			if(tmpNode.getHizq() != null)
				tmp.enqueue((BinaryNode) tmpNode.getHizq());
			if(tmpNode.getHder() != null)
				tmp.enqueue((BinaryNode) tmpNode.getHder());
			
		}
	}
	
	/**
	 * Searches for an element
	 * @param data to be found
	 * @return boolean depending if the element is or not 
	 */
	public boolean find(T data) {
		BinaryNode toFind = new BinaryNode(data);
		if (root == null)//No existe arbol
			return false;
		
		if (root.compareTo(toFind) == 0) //La raiz es el dato
			return true;
		
		else
			return findAux(data, root);
	}
	
	public boolean findAux(T data, BinaryNode node) {
		BinaryNode toFind = new BinaryNode(data);

		if (node == null) //El nodo ya no existe por lo tanto no está el dato
			return false;
		
		if (node.compareTo(toFind) == 0) //El nodo presente tiene el dato
			return true;
		
		if (node.compareTo(toFind) < 0) //El dato es mayor de lo que tiene el nodo
			return findAux(data, (BinaryNode) node.getHder()); //Se usa el hijo derecho
		
		if (node.compareTo(toFind) > 0) //El dato es menor de lo que tiene el nodo
			return findAux(data, (BinaryNode) node.getHizq()); //Se usa el hijo izquierdo
		
		else 
			return false;
	}
	
}
