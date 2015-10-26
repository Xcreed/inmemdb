package inmemdb.nosql;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TypeVideo <T extends String> extends Type {

	public TypeVideo() {
		super(0);
	}
	
	/**
	 * Checks if the image in the indicated path 
	 * is format .mp4
	 * @param imagePath
	 * @return
	 */
	public boolean check(T videoPath) {
		String fileType = getFileType(videoPath);
		if (fileType.equals("video/mp4")){
			System.out.println("Valid image type");
			return true;
		} else {
			System.out.println("Only .mp4 images");
			return false;
		}
	}
	/**
	 * Checks the type of file
	 * Usable for image/video files
	 * @param fileName
	 * @return
	 * @throws IOException 
	 */
	private String getFileType(String fileName) {    
//		"video/mp4"
		Path filePath = Paths.get(fileName);
		String fileType = null;
		try {
			fileType = Files.probeContentType(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return fileType;
	}
	

}
