package file.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Text file reader class that extends methods of MyFileReaderImp.
 * This class implements methods that allows to read a text file.
 */
public class TextFileReader extends MyFileReaderImpl {
	
	String fileName;
	BufferedReader reader;
	
	/**
	 * Constructor initializes the attribute @fileName.
	 * Prepare the text file into a BufferReader
	 * @param fileName: file name inserted by the user
	 */
	public TextFileReader(String fileName) {
		this.fileName = fileName; 
		
		try {
			prepareTextFile(this.fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void readFile(String fileName) {	
		System.out.println(readTextFile(reader));
	}
	
	/**
	 * Create the BufferReader of a file by its name (attribute: @fileName)
	 * @throws FileNotFoundException when file is not found
	 */
	protected void prepareTextFile(String fileName) throws FileNotFoundException {
		reader = new BufferedReader(new FileReader(fileName));		
	}
	
	/**
	 * Read the text of the BufferReader (attribute: @param reader) line by line.
	 * @return the content string of the BufferReader
	 */
	protected String readTextFile(BufferedReader reader) {
	    StringBuilder content = new StringBuilder();
	    String line;

	    try {
			while ((line = reader.readLine()) != null) {
			    content.append(line);
			    content.append(System.lineSeparator());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	    return content.toString();
	}


}
