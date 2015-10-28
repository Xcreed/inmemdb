package inmemdb.structures;

public class Tests {

	public static void main(String[] args){
		System.out.println("START AVL");
		AVLTree AVL = new AVLTree();
		AVL.insert("aa");
		AVL.insert("pp");
		AVL.insert("cc");
		AVL.insert("zz");
		AVL.insert("xx");
		AVL.insert("ss");
		AVL.insert("dd");
		AVL.insert("gg");
		AVL.insert("hh");
		AVL.insert("ll");
		
		AVL.inorder();
	}
}
