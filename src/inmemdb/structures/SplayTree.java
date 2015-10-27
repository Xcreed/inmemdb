package inmemdb.structures;

public class SplayTree<T> extends Tree {
	
	public SplayNode root;
    private int count = 0;
    
    public SplayTree(){
        root = null;
    }
    
    public boolean isEmpty(){
        return root == null;
    }
    
    public void makeEmpty()
    {
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
    
    
    public void insert(T ele)
    {
        SplayNode node1 = root;
        SplayNode node2 = null;
        while (node1 != null)
        {
            node2 = node1;
            if (compareTo(ele, (T) node2.data)>0)
                node1 = node1.rightChild;
            else
                node1 = node1.leftChild;
        }
        node1 = new SplayNode();
        node1.data = ele;
        node1.parent = node2;
        if (node2 == null)
            root = node1;
        else if (compareTo(ele, (T) node2.data)>0)
            node2.rightChild= node1;
        else
            node2.leftChild = node1;
        Splay(node1);
        count++;
    }
    
    public void makeLeftChildParent(SplayNode child, SplayNode parent)
    {
        if ((child == null) || (parent == null) || (parent.leftChild != child) || (child.parent != parent))
            throw new RuntimeException("WRONG");

        if (parent.parent != null)
        {
            if (parent == parent.parent.leftChild)
                parent.parent.leftChild = child;
            else 
                parent.parent.rightChild= child;
        }
        if (child.rightChild!= null)
            child.rightChild.parent = parent;

        child.parent = parent.parent;
        parent.parent = child;
        parent.leftChild = child.rightChild;
        child.rightChild= parent;
    }

    public void makeRightChildParent(SplayNode child, SplayNode parent)
    {
        if ((child == null) || (parent == null) || (parent.rightChild!= child) || (child.parent != parent))
            throw new RuntimeException("WRONG");
        if (parent.parent != null)
        {
            if (parent == parent.parent.leftChild)
                parent.parent.leftChild = child;
            else
                parent.parent.rightChild= child;
        }
        if (child.leftChild != null)
            child.leftChild.parent = parent;
        child.parent = parent.parent;
        parent.parent = child;
        parent.rightChild= child.leftChild;
        child.leftChild = parent;
    }


    private void Splay(SplayNode node)
    {
        while (node.parent != null)
        {
            SplayNode Parent = node.parent;
            SplayNode GrandParent = Parent.parent;
            if (GrandParent == null)
            {
                if (node == Parent.leftChild)
                    makeLeftChildParent(node, Parent);
                else
                    makeRightChildParent(node, Parent);                 
            } 
            else
            {
                if (node == Parent.leftChild)
                {
                    if (Parent == GrandParent.leftChild)
                    {
                        makeLeftChildParent(Parent, GrandParent);
                        makeLeftChildParent(node, Parent);
                    }
                    else 
                    {
                        makeLeftChildParent(node, node.parent);
                        makeRightChildParent(node, node.parent);
                    }
                }
                else 
                {
                    if (Parent == GrandParent.leftChild)
                    {
                        makeRightChildParent(node, node.parent);
                        makeLeftChildParent(node, node.parent);
                    } 
                    else 
                    {
                        makeRightChildParent(Parent, GrandParent);
                        makeRightChildParent(node, Parent);
                    }
                }
            }
        }
        root = node;
    }
    

    public boolean remove(T value)
    {
        SplayNode node = findNode(value);
        return remove(node);
    }
    

    private boolean remove(SplayNode node)
    {
        if (node == null)
            return false;

        Splay(node);
        if( (node.leftChild != null) && (node.rightChild!=null))
        { 
            SplayNode min = node.leftChild;
            while(min.rightChild!=null)
                min = min.rightChild;

            min.rightChild= node.rightChild;
            node.rightChild.parent = min;
            node.leftChild.parent = null;
            root = node.leftChild;
        }
        else if (node.rightChild!= null)
        {
            node.rightChild.parent = null;
            root = node.rightChild;
        } 
        else if( node.leftChild !=null)
        {
            node.leftChild.parent = null;
            root = node.leftChild;
        }
        else
        {
            root = null;
        }
        node.parent = null;
        node.leftChild = null;
        node.rightChild= null;
        node = null;
        count--;
        return true;
    }
    

    public int size(){
        return count;
    }
    

    public boolean search(T value)
    {
        return findNode(value) != null;
    }

    private SplayNode findNode(T value)
    {
        SplayNode currentNode = root;
        while (currentNode != null)
        {
        	if (compareTo(value, (T) currentNode.rightChild)>0)
                currentNode = currentNode.rightChild;
            else if (compareTo(value, (T) currentNode.data)<0)
                currentNode = currentNode.leftChild;
            else
                return currentNode;
        }
        return null;
    }
    
	public void inorder(){
		inorder(root);
	}
	
	public void inorder(SplayNode root){
		if(root != null){
			inorder(root.leftChild);
			System.out.println(root.data + "  ");
			inorder(root.rightChild);
		}
	}
	
	public void preorder(){
		preorder(root);
	}
	
	public void preorder(SplayNode root){
		if (root != null){
			System.out.println(root.data);
			preorder(root.leftChild);
			preorder(root.rightChild);
		}
	}
	
	public void postorder(){
		postorder(root);
	}
	
	public void postorder(SplayNode root){
		if (root != null){
			postorder(root.leftChild);
			postorder(root.rightChild);
			System.out.println(root.data);
		}
	}

}

