package inmemdb.nosql;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SuppressWarnings("rawtypes")
public class TypeImage <T extends String> extends Type{

	/**
	 * No length limit
	 * 
	 */
	public TypeImage() {
		super(0);
	}
	
	/**
	 * Checks if the image in the indicated path 
	 * is format .jpeg
	 * @param imagePath
	 * @return
	 */
	public boolean check(T imagePath) {
		String fileType = getFileType(imagePath);
		System.out.println(fileType);
		if (fileType.equals("image/jpeg")){
			System.out.println("Valid image type");
			return true;
		} else {
			System.out.println("Only .jpeg images");
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
//		"image/jpeg"
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
