package inmemdb.nosql;

import java.io.IOException;

import inmemdb.structures.BinarySearchTree;

public class Main {

	public static void main(String[] args) throws IOException {

		Schema s = new Schema("T","C:\\Users\\Xcreed\\Desktop\\com\\idk\\ac\\cr" );
		SchemaJoin j = new SchemaJoin("F");
		IndexBTS bts = new IndexBTS("string", 5);
		
		
		
		//System.out.println(s.getFileType("C:\\Users\\Xcreed\\Desktop\\test\\1st.jpg"));
		/*
		TypeImage ti = new TypeImage();
		s.insertIndex(bts);
		bts.insert(ti.check(null), null); //Needs to call the check method, otherwise it'll use check() from abstract class
		*/
		
		s.insertIndex(bts);
//		j.joinSchema(s);
//
//		j.insertJoinedIndex(btss);
		String a = "Hello";
		String b = "Hell";
		String c = "Mello";
		System.out.println(bts.getType().getClass());
		bts.insert(a);
		bts.insert(b);
		bts.insert("Helloz");
		
		System.out.println(bts.tree.root);
		System.out.println(bts.tree.root.rightChild);
		System.out.println(bts.tree.root.leftChild);
		
//		System.out.println(j.joinedSearch("Hello"));
//		System.out.println(j.deleteInJoinedIndex(1,"Hello"));
//		System.out.println(j.joinedSearch("Hello"));
//		System.out.println(s.search("Hell"));
//		System.out.println(s.deleteInIndex(1,"Hell"));
//		System.out.println(s.search("Hell"));
		
		
		
		
		
	}

}
