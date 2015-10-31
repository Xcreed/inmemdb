package inmemdb.nosql;

import java.io.IOException;

import inmemdb.controller.JSONProtocol;
import inmemdb.structures.AVLTree;
import inmemdb.structures.BinarySearchTree;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		//Creates a regular schema and Join type in the desired folder
		Schema s = new Schema("Estudiantes","C:\\Users\\Randy\\Desktop\\com\\idk\\ac\\cr");

		SchemaJoin j = new SchemaJoin("Notas","C:\\Users\\Randy\\Desktop\\com\\idk\\ac\\cr");

		//Creates an index in the regular schema
		s.createIndex("bts", "string", "Nombre", 10);
		s.createIndex("avl", "number", "año", 4);
		s.createIndex("avl", "image", "Imagen", 0);
		j.joinSchema(s);
		j.createJoinedIndex("avl", "number", "Notas", 2);
		
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("Inserting I ");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------");
		s.insertToIndex(1, "JP");
		s.insertToIndex(1, "Randy");
		s.insertToIndex(1, "Alejandra");
//		s.insertToIndex(1, "Xcreed");
		s.insertToIndex(2, 1996);
		s.insertToIndex(2, 1995);
		s.insertToIndex(2, 1997);
		s.insertToIndex(3, "SchemaExtraFiles/2.jpg");
		s.insertToIndex(3, "SchemaExtraFiles/8.jpg");
		s.insertToIndex(3, "SchemaExtraFiles/4.jpg");
		
		IndexBTS index = (IndexBTS) s.schema.getItem(1);
		BinarySearchTree t = (BinarySearchTree) index.tree;
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("Traversal: 1");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------");
		t.inOrderTraversal();
		
		IndexAVL index2 = (IndexAVL) s.schema.getItem(2);
		AVLTree t2 = (AVLTree) index2.getTree();
		System.out.println("avl order");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("Traversal: 2");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------");

		t2.inorder();
		
		j.insertToIndex(1, 80);
		j.insertToIndex(1, 82);
		j.insertToIndex(1, 78);
		
//		
		
//		System.out.println(s.search("JP"));
//		System.out.println(s.deleteInIndex(1,"JP"));
//		System.out.println(s.search("JP"));
		
		System.out.println("Getting line 1");
		s.getLine(1);
//		s.deleteLine(1);
				
		j.joinedSearch(82);

		//Deletes an index in the schema
//		s.schema.print();
//		s.deleteIndex(1);
//		s.schema.print();
		
// ***********Activate Separately**********
		
//		s.createIndex("bts", "video", "Videos", 0);
//		s.insertToIndex(1, "SchemaExtraFiles/Trike Drifting.mp4");
		
//	***************************************
		
		JSONProtocol json = new JSONProtocol();
		json.writeSchema(s);
				
		
	}

}
