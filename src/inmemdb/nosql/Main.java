package inmemdb.nosql;

import java.io.IOException;

import inmemdb.controller.JSONProtocol;
import inmemdb.structures.AVLTree;
import inmemdb.structures.BinarySearchTree;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		//Creates a regular schema and Join type in the desired folder
		Schema s = new Schema("Estudiantes","C:\\Users\\Xcreed\\Desktop\\com\\idk\\ac\\cr");

		SchemaJoin j = new SchemaJoin("Notas","C:\\Users\\Xcreed\\Desktop\\com\\idk\\ac\\cr");

		//Creates an index in the regular schema
		s.createIndex("bts", "string", "Nombre", 10);
		s.createIndex("bts", "number", "año", 4);
		j.joinSchema(s);
		j.createJoinedIndex("avl", "number", "Notas", 2);
		
		s.insertToIndex(1, "JP");
		s.insertToIndex(1, "Randy");
		s.insertToIndex(1, "Alejandra");
		s.insertToIndex(2, 1996);
		s.insertToIndex(2, 1995);
		s.insertToIndex(2, 1997);
		

		IndexBTS index = (IndexBTS) s.schema.getItem(1);
		BinarySearchTree t = (BinarySearchTree) index.tree;
		t.inOrderTraversal();
		
		IndexBTS index2 = (IndexBTS) s.schema.getItem(2);
		BinarySearchTree t2 = (BinarySearchTree) index2.tree;
		System.out.println("bts2 order");
		t2.inOrderTraversal();
		
		j.insertToIndex(1, 80);
		j.insertToIndex(1, 82);
		j.insertToIndex(1, 78);
		
//		
//		System.out.println(t.root);
//		System.out.println("Hijo dere " + t.root.rightChild);
//		System.out.println("Hijo izq " + t.root.leftChild);
		
//		
		System.out.println(j.joinedSearch(80));
//		System.out.println(j.deleteInJoinedIndex(1,"Hello"));
//		System.out.println(j.joinedSearch("Hello"));
		
//		System.out.println(s.search("JP"));
//		System.out.println(s.deleteInIndex(1,"JP"));
//		System.out.println(s.search("JP"));
		
		t.inOrderTraversal();
		
		System.out.println("Getting line 1");
		s.getLine(1);
		
		//Deletes an index in the schema
//		s.schema.print();
//		s.deleteIndex(2);
//		s.schema.print();
		
// ***********Activate Separately**********
		
//		s.createIndex("bts", "video", "Videos", 0);
//		s.insertToIndex(1, "SchemaExtraFiles/Trike Drifting.mp4");
//		
//		s.createIndex("bts", "image", "Images", 0);
//		s.insertToIndex(2, "SchemaExtraFiles/1st.jpg");
		
//	***************************************
		
		JSONProtocol json = new JSONProtocol();
		json.writeSchema(s);
		
		
		
	}

}
