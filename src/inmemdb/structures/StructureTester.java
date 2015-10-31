package inmemdb.structures;

public class StructureTester {

	public static void main(String[] args) {
		
		AVLTree AVL = new AVLTree();
		
		System.out.println("AVL TREE ");
		
		System.out.println(" ");
		System.out.println(" ");
		
		AVL.insert("aa");
		AVL.insert("bb");
		AVL.insert("cc");
		AVL.insert("dd");
		AVL.insert("ee");
		AVL.insert("ff");
		AVL.insert("gg");
		AVL.insert("hh");
		AVL.insert("ii");
		
		AVL.inorder();
		
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("keyAVL Tree");
		
		AVL.keyAVL.inorder();
		
		System.out.println(" ");
		System.out.println(" ");
		
		System.out.println(AVL.keyAVL.search(7));
		System.out.println("hey");
		System.out.println(AVL.SearchKeyOfValue("gg"));
		System.out.println(AVL.keyAVL.search(10));
		
		
		System.out.println(" ");
		System.out.println(" ");
		
		System.out.println(AVL.keyAVL.searchKeyReturnValue(7));
		System.out.println(AVL.keyAVL.searchKeyReturnValue(10));
		
		System.out.println(" ");
		System.out.println(" ");
		
		AVL.remove("dd");
		
		AVL.inorder();
		
		System.out.println(" ");
		System.out.println(" ");
		
		AVL.keyAVL.inorder();
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		
		
		System.out.println("Binary Search Tree");
		
		System.out.println(" ");
		System.out.println(" ");
		
		BinarySearchTree BST = new BinarySearchTree();
		
		BST.addNode("aa");
		BST.addNode("bb");
		BST.addNode("cc");
		BST.addNode("dd");
		BST.addNode("ee");
		BST.addNode("ff");
		BST.addNode("gg");
		BST.addNode("hh");
		BST.addNode("ii");
		BST.addNode("jj");
		
		BST.inOrderTraversal();
		
		System.out.println(" ");
		System.out.println(" ");
		
		BST.keyBST.inOrderTraversal();
		
		System.out.println(" ");
		System.out.println(" ");
		
		BST.remove("ee");
		
		BST.inOrderTraversal();
		
		System.out.println(" ");
		System.out.println(" ");
		
		BST.keyBST.inOrderTraversal();


		System.out.println(" ");
		System.out.println(" ");
		
		System.out.println(" ");
		System.out.println(" ");
		
		System.out.println("SPTree");
		System.out.println(" ");
		
		SplayTree SP = new SplayTree();
		
		SP.insert("aa");
		SP.insert("bb");
		SP.insert("cc");
		SP.insert("dd");
		SP.insert("ee");
		SP.insert("ff");
		SP.insert("gg");
		SP.insert("hh");
		SP.insert("ii");
		
		SP.inOrderTraversal();
		
		
		System.out.println(" ");
		System.out.println("key SP");
		
		SP.keySP.inOrderTraversal();
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("REMOVE");
		
		System.out.println(" ");
		System.out.println(" ");
		
		SP.delete("cc");
		
		SP.inOrderTraversal();
		System.out.println(" ");
		System.out.println(" ");
		
		SP.keySP.inOrderTraversal();
	}

}
