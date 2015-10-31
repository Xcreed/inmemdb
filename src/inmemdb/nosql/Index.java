package inmemdb.nosql;
	
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import inmemdb.structures.Tree;

@SuppressWarnings({ "rawtypes" })

/**
<<<<<<< HEAD
 * Asbtract class for the differents types of 
 * index. 
 * 
 * @param <T>
 */
public class Index <T> {
	
	protected Tree<?> tree;
	protected String type;
	protected int length;
	protected String name;
	
	/**
	 * Constructor.
	 * 
	 * @param type
	 * @param name
	 * @param length
	 */
	
	public Index(String type, String name, int length) {
		this.type = type;
		this.length = length;
		this.name = name;
	}
	
	/**
	 * As a type String returns the name.
	 * 
	 * @return name
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * Insert
	 */
	public void insert() {
	}
	
	 /**
	  *Remove 
	  */
	public void remove() {
	}
	
	/**
	 * Converts integer to binary
	 * @param toConvert
	 * @return
	 * 
	 * @param toConvert
	 * @return binaryNumber
	 */
	protected String toBinary(int toConvert) {
		String binaryNumber = Integer.toBinaryString(toConvert);
		return binaryNumber;
	}
	
	/**
	 * Returns index tree
	 * @return
	 * Returns the working tree.
	 * @return tree
	 */
	public Tree getTree() {
		return tree;
	}
	
	/**
	 * Checks if the element is of the desired type
	 * @param element
	 * @return
	 */
	public boolean check(T element) {
		boolean bool = false;
		if (type.equals("binary")){
			if (element instanceof Number && checkLength(element)) {
				System.out.println("Inserting...");
				bool = true;
			} else {
				System.out.println("Invalid type. Index type is " + type);
				bool = false;
			}
		} else if (type.equals("char")){
			if (element instanceof Number && checkLength(element)) {
				bool = true;
			} else {
				System.out.println("Invalid type. Index type is " + type);
				bool = false;
			}
			
		} else if (type.equals("string")){
			if (element instanceof String && checkLength(element)) {
				bool = true;
			} else if (!checkLength(element)) {
				bool = false;
			} else {
				System.out.println("Invalid type. Index type is " + type);
				bool = false;
			}
			
		} else if (type.equals("image")){
			if (element instanceof String && isImage((String) element)) {
				System.out.println("Inserting...");
				bool = true;
			} else {
				System.out.println("Invalid type. Index type is " + type);
				bool = false;
			}
			
		} else if (type.equals("number")){
			if (element instanceof Number && checkLength(element)) {
				System.out.println("Inserting...");
				bool = true;
			} else {
				System.out.println("Invalid type. Index type is " + type);
				bool = false;
			}
			
		} else if (type.equals("video")){
			if (element instanceof String && isVideo((String) element)) {
				System.out.println("Inserting...");
				bool = true;
			} else {
				System.out.println("Invalid type. Index type is " + type);
				bool = false;
			}
		}
		return bool;
	}
	
	/**
	 * Checks the length of the index.
	 * 
	 * @param element
	 * @return boolean
	 */
	private boolean checkLength(T element) {
		if (element.toString().length() <= length) {
			return true;
		} else {
			System.out.println("Invalid length. Length up to " + length + " characters."); 
			return false;
		}
	}
	
	/**
	 * Checks if the image in the indicated path 
	 * is format .jpeg.
	 * 
	 * @param imagePath
	 * @return
	 */
	private <T extends String> boolean isImage(T imagePath) {
		String fileType = getFileType(imagePath);
		if (fileType.equals("image/jpeg")){
			System.out.println("Valid image type");
			return true;
		}else{
			System.out.println("Only .jpeg images");
			return false;
		}
	}
	
	/**
	 * Checks if the image in the indicated path 
	 * is format .mp4.
	 * 
	 * @param imagePath
	 * @return boolean
	 */
	private <T extends String> boolean isVideo(T element) {
		String fileType = getFileType(element);
		if (fileType.equals("video/mp4")){
			System.out.println("Valid video type");
			return true;
		}else{
			System.out.println("Only .mp4 images");
			return false;
		}
	}
	
	/**
	 * Checks the type of file.
	 * Usable for image/video files.
	 * 
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
		}catch (IOException e){
			e.printStackTrace();
		}
		return fileType;
	}
	
	/**
	 * For inserting in a tree
	 * Letting know if the type is binary.
	 * 
	 * @return
	 */
	protected boolean isBinary() {
		if (type.equals("binary")) {
			return true;
		}else{
			return false;
		}
	}

}
