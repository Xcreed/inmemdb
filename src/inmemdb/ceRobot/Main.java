package inmemdb.ceRobot;

import java.io.IOException;

public class Main {

	private static CeRobot robot = new CeRobot();
	
	public static void main(String[] args) throws IOException {
		robot.openDir("C:\\Users\\Xcreed\\Desktop\\test");
		robot.readFiles();
	}

}
