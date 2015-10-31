package inmemdb.ceRobot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

import inmemdb.nosql.Index;
import inmemdb.nosql.Schema;
import inmemdb.structures.BinarySearchTree;


@SuppressWarnings("deprecation")
public class CeRobot {

	private String path;
	private File directory;
	private File[] contents;
	private File text = new File("res/text.txt");
	private File tmpWords = new File("res/tmpWords.txt");
	private String arrayString[];
	public Schema pdfSchema = new Schema("Pdf", "C:\\Users\\Xcreed\\Desktop\\com\\idk\\ac\\cr");
	
	/**
	 * Opens a folder
	 * use "\\" for a path in Windows
	 * @param path
	 */
	public void openDir(String path) {
		
		this.path = path;
		this.directory = new File(path);
		this.contents = directory.listFiles();
		
	}
	
	/**
	 * Reads the files inside the folder
	 * Only PDF's
	 * @throws IOException 
	 */
	public void readFiles() throws IOException {
		int i = 0;
		for (File f : contents) {
			System.out.println(f.getAbsolutePath());
			operations(f);
			extractText(f.getAbsolutePath(), i);
			i++;
		}
        PrintWriter out = new PrintWriter(new FileOutputStream(text.getAbsolutePath(), true));
        out.flush();
        out.close();
	}
	
	/**
	 * Creates an index for each pdf file in the folder
	 * Creates a Binary Search Tree with a limit to 5 letter words
	 * @param f
	 * @param guide
	 */
	public void operations(File f) {
		pdfSchema.createIndex("bts", "string", f.getName(), 6);

	}
	
	/**
	 * Reads text in the pdf and copies it to a txt file
	 * @param pdfPath
	 * @throws IOException
	 */
	private void extractText(String pdfPath, int number) throws IOException {
		PdfReader reader = new PdfReader(pdfPath);	
		PdfReaderContentParser parser = new PdfReaderContentParser(reader);
        PrintWriter out = new PrintWriter(new FileOutputStream(text.getAbsolutePath(), true));
		TextExtractionStrategy strategy;
		for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
            out.println(strategy.getResultantText());
            takeWords(number);
        }
		out.flush();
        out.close();
        System.out.println("Reading...");
        reader.close();
	}
	
	/**
	 * Takes the txt and separate the words into the right
	 * structure
	 */
	private void takeWords(int number) throws NullPointerException {
		try 
			(InputStream fis = new FileInputStream(text);
			InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
			BufferedReader br = new BufferedReader(isr)) {
		    String line;
		    BufferedWriter writer = new BufferedWriter(new FileWriter(tmpWords, false));
		    		    
		    while ((line = br.readLine()) != null) {
		    	
		    	arrayString = line.split("\\s+");
		    	writer.write(Arrays.toString(arrayString));
		    }
		    wordsToIndex(number);
//	    	System.out.println(Arrays.toString(arrayString));
		    writer.flush();
		    writer.close();
		} catch (Exception e){ 
			System.out.println("Unsupported character");
		}
	}
	
	public void wordsToIndex(int schemaIndex) {
		
		try 
		(InputStream fis = new FileInputStream(tmpWords);
		InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
		BufferedReader br = new BufferedReader(isr)) {
	    String line;
	    String wordsString[];
	    while ((line = br.readLine()) != null) {
	    	System.out.println("------------------------------------ Hye");
	    	
	    	wordsString = line.split(",");
	    	
	    	for (int i = 0; i < wordsString.length; i++) {
	    		pdfSchema.insertToIndex(schemaIndex, wordsString[i]);
	    	}
	    	
	    	Index index = (Index) pdfSchema.schema.getItem(schemaIndex);
	    	BinarySearchTree t = (BinarySearchTree) index.getTree();
	    	System.out.println("-------------------------");
	    	//t.inOrderTraversal();
	    	
	    	}
		}catch (Exception e){ 
			System.out.println("Unsupported character");
	    }
	}
}
