package inmemdb.nosql;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		Schema s = new Schema("T");
		IndexBTS bts = new IndexBTS();
		
		
		//System.out.println(s.getFileType("C:\\Users\\Xcreed\\Desktop\\test\\1st.jpg"));
		/*
		TypeImage ti = new TypeImage();
		s.insertIndex(bts);
		bts.insert(ti.check(null), null); //Needs to call the check method, otherwise it'll use check() from abstract class
		*/
		/*
		 * TypeString ts = new TypeString(5);
		 * bts.setType(ts);
		String a = "Hello";
		String b = "Hell";
		String c = "Mello";
		bts.insert(ts.check(a), a);
		bts.insert(ts.check(b), b);
		bts.insert(ts.check(c), c);
		System.out.println(bts.tree.root);
		System.out.println(bts.tree.root.rightChild);
		System.out.println(bts.tree.root.leftChild);
		*/
		
		TypeBinary tb = new TypeBinary(5);
		
		
	}

}
