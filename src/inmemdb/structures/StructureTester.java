package inmemdb.structures;

public class StructureTester {

	public static void main(String[] args) {
		
		DoubleLinkedList<Integer> testList = new DoubleLinkedList<Integer>();
		
		testList.insertBeginning(3);
		testList.insertEnd(4);
		testList.insertEnd(5);
		testList.insertEnd(7);
		testList.insertEnd(6);
		testList.insertEnd(14);
		testList.insertEnd(9);
		testList.insertEnd(8);
		testList.insertBeginning(4);
		testList.print();
		testList.deleteBeginning();
		testList.print();
		testList.deleteEnd();
		testList.print();
		
		testList.deleteByIndex(3);
		
		
		
		
	}

}
