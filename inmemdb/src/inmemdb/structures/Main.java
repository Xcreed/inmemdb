package inmemdb.structures;

public class Main {

	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree();
		
		bt.insert(10);
		bt.insert(11);
		bt.insert(9);
		BinaryNode a = new BinaryNode(10);
		BinaryNode b = new BinaryNode(9);
		
		System.out.println(bt.getRoot());
		System.out.println("Dere" + bt.getRoot().getHder());
		System.out.println("Izq" + bt.getRoot().getHizq());
		System.out.println(a.compareTo(b));
	}
}
