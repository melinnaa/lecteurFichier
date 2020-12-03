package file.reader;

import java.io.BufferedReader;

/**
 * Reverse text file reader class that extends methods of TextFileReader.
 * This class allows to read a text file with a variant.
 */
public class ReverseReader extends TextFileReader {
	
	/**
	 * Set the values of properties using the constructor parent
	 */
	public ReverseReader(String fileName) {
		super(fileName);
	}
	
	@Override
	public void readFile(String fileName) {		
		reverseTextFile(reader);
	}
	
	/**
	 * Reverse lines of the BufferReader (attribute: @param reader)
	 */
	public void reverseTextFile(BufferedReader reader) {
		
		String fileContent = readTextFile(reader);
		String[]lines = fileContent.split("\\n");
		
		for (int i = 0; i < lines.length; i++) {
			System.out.println(lines[lines.length-i-1]);
		}
	}
}
