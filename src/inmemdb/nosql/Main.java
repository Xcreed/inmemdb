package inmemdb.nosql;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		Schema s = new Schema("T");
		System.out.println(s.getFileType("C:\\Users\\Xcreed\\Desktop\\test\\1st.jpg"));
	}

}
