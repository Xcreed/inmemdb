package inmemdb.nosql;

import java.io.IOException;

import inmemdb.structures.BinarySearchTree;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//Creates a regular schema and Join type in the desired folder
		Schema s = new Schema("T","C:\\Users\\Xcreed\\Desktop\\com\\idk\\ac\\cr");
		SchemaJoin j = new SchemaJoin("F","C:\\Users\\Xcreed\\Desktop\\com\\idk\\ac\\cr");

		//Creates an index in the regular schema
		s.createIndex("bts", "string", 5);
		//Joins the schema to the regular one
		j.joinSchema(s);
		//Creates an index in both schemas
		j.createJoinedIndex("avl","number", 3);
		String a = "Hello";
		String b = "Hell";
		String c = "Mello";

		
		s.insertToIndex(1, a);
		s.insertToIndex(1, b);
		s.insertToIndex(1, c);
		j.insertToIndex(1, 243);
		
		IndexBTS index = (IndexBTS) s.schema.getItem(1);
		BinarySearchTree t = (BinarySearchTree) index.tree;
		System.out.println(t.root);
		System.out.println("Hijo dere " + t.root.rightChild);
		System.out.println("Hijo izq " + t.root.leftChild);
		
		s.schema.print();
		s.deleteIndex(2);
		s.schema.print();
		System.out.println(j.joinedSearch(243));
		System.out.println(j.deleteInJoinedIndex(1,"Hello"));
		System.out.println(j.joinedSearch("Hello"));
//		System.out.println(s.search("Hell"));
//		System.out.println(s.deleteInIndex(1,"Hell"));
//		System.out.println(s.search("Hell"));
		
		
		
		
		
	}

}
