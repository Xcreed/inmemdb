package inmemdb.ceSearch;

import inmemdb.ceRobot.CeRobot;
import inmemdb.nosql.Index;
import inmemdb.nosql.Schema;
import inmemdb.structures.DoubleLinkedList;

public class CeSearch <T> {

	public CeRobot robot = new CeRobot();
	public Schema pdfSchema = robot.pdfSchema;
	
	public void search(T element) {
		DoubleLinkedList pdfs = new DoubleLinkedList();
		for (int i = 0; i < pdfSchema.schema.getLength(); i++) {
			if (pdfSchema.search(element)) {
				System.out.println(pdfSchema.search(element));
				Index index = (Index) pdfSchema.schema.getItem(i);
				System.out.println(index.getName());
				pdfs.insertEnd(index.getName());
			} else {
				System.out.println("Element not found");
			}
		}
		System.out.println(element + " inside the pdfs:");
		pdfs.print();
		System.out.println(pdfs);
	}
}
