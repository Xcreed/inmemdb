package inmemdb.nosql;

import java.io.IOException;

import inmemdb.structures.BinarySearchTree;

public class Main {

	public static void main(String[] args) throws IOException {

		Schema s = new Schema("T","C:\\Users\\Xcreed\\Desktop\\com\\idk\\ac\\cr" );
		SchemaJoin j = new SchemaJoin("F");
		IndexBTS bts = new IndexBTS();
		IndexBTS btss = new IndexBTS();
		
		
		//System.out.println(s.getFileType("C:\\Users\\Xcreed\\Desktop\\test\\1st.jpg"));
		/*
		TypeImage ti = new TypeImage();
		s.insertIndex(bts);
		bts.insert(ti.check(null), null); //Needs to call the check method, otherwise it'll use check() from abstract class
		*/
		
		TypeString ts = new TypeString(5);
		bts.setType(ts);
		btss.setType(ts);
		s.insertIndex(bts);
		j.joinSchema(s);

		j.insertJoinedIndex(btss);
		String a = "Hello";
		String b = "Hell";
		String c = "Mello";
		System.out.println(bts.getType().getClass());
		bts.insert(ts.check(a), a);
		bts.insert(ts.check(b), b);
		bts.insert(ts.check(c), c);
		btss.insert(ts.check(a), a);
		btss.insert(ts.check(b), b);
		btss.insert(ts.check(c), c);
		System.out.println(bts.tree.root);
		System.out.println(bts.tree.root.rightChild);
		System.out.println(bts.tree.root.leftChild);
//		BinarySearchTree t = new BinarySearchTree();
//		t.addNode(a);
//		System.out.println(t.findNode("ello"));
		System.out.println(j.joinedSearch("Hello"));
		System.out.println(j.deleteInJoinedIndex(1,"Hello"));
		System.out.println(j.joinedSearch("Hello"));
//		System.out.println(s.search("Hell"));
//		System.out.println(s.deleteInIndex(1,"Hell"));
//		System.out.println(s.search("Hell"));
		
		
		//TypeBinary tb = new TypeBinary(5);
		
		
		
	}

}
