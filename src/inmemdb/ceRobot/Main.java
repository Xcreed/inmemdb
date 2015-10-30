package inmemdb.ceRobot;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Main  {

	private static CeRobot robot = new CeRobot();
	
	public static void main(String[] args) throws IOException {
		robot.openDir("PdfFiles/");
		robot.readFiles();
		System.out.println(robot.pdfSchema.search("age"));
	}

}
