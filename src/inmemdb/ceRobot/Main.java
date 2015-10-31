package inmemdb.ceRobot;

import java.io.IOException;

import inmemdb.ceSearch.CeSearch;
import inmemdb.nosql.Index;
import inmemdb.structures.BinarySearchTree;

public class Main  {

	private static CeRobot robot = new CeRobot();
	private static CeSearch ce = new CeSearch();
	
	public static void main(String[] args) throws IOException {
		robot.openDir("PdfFiles/");
		robot.readFiles();
		System.out.println("length" + robot.pdfSchema.schema.getLength());
		System.out.println(" ");
		System.out.println(robot.pdfSchema.search("[At"));
		Index index = (Index) robot.pdfSchema.schema.getItem(3);
		
		BinarySearchTree t = (BinarySearchTree) index.getTree();
		
		String a = t.keyBST.searchKeyReturnValue(16);
		String b = t.keyBST.searchKeyReturnValue(21);
		String c = t.keyBST.searchKeyReturnValue(3);
		
		System.out.println(a);
//		System.out.println(robot.pdfSchema.search(a));
		
		ce.search(a);
		ce.search(b);
		ce.search(c);
		
	}

}
