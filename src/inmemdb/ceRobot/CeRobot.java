package inmemdb.ceRobot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Arrays;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;


@SuppressWarnings("deprecation")
public class CeRobot {

	private String path;
	private File directory;
	private File[] contents;
	private File text = new File("res/text.txt");
	private String arrayString[];
	
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
		
		for (File f : contents) {
			extractText(f.getAbsolutePath());
		}
		
        PrintWriter out = new PrintWriter(new FileOutputStream(text.getAbsolutePath(), false));
        out.flush();
        out.close();
		
	}
	
	/**
	 * Reads text in the pdf and copies it to a txt file
	 * @param pdfPath
	 * @throws IOException
	 */
	private void extractText(String pdfPath) throws IOException {
		
		PdfReader reader = new PdfReader(pdfPath);	
		PdfReaderContentParser parser = new PdfReaderContentParser(reader);
        PrintWriter out = new PrintWriter(new FileOutputStream(text.getAbsolutePath(), true));
		TextExtractionStrategy strategy;
        
		for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
            out.println(strategy.getResultantText());
            takeWords();
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
	private void takeWords() throws NullPointerException {
		
		try 
			(InputStream fis = new FileInputStream(text);
			InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
			BufferedReader br = new BufferedReader(isr)) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	arrayString = line.split("\\s+");
		    	//System.out.println(arrayString[0] +" " + arrayString[1]);
		    	System.out.println(Arrays.toString(arrayString));
		    }
		} catch (Exception e){ 
			System.out.println("Unsupported character");
			
		}
		
		
	}

}
