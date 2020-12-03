package file.reader;

import java.io.BufferedReader;

/**
 * Palindromic text file reader class that extends methods of TextFileReader.
 * This class allows to read a text file with a variant.
 */
public class PalindromeReader extends TextFileReader {
	
	/**
	 * Set the values of properties using the constructor parent
	 */
	public PalindromeReader(String fileName) {
		super(fileName);
	}
	
	@Override
	public void readFile(String fileName) {
		System.out.println(palindromeTextFile(reader));
	}
	
	/**
	 * Convert the content of the BufferReader (attribute: @param reader) into a palindromic form.
	 */
	public String palindromeTextFile(BufferedReader reader) {
		
		//We read the bufferReader content using a parent method. 
		//We create a StringBuilder with the file content, and another empty to fill with the reversed file content.
		String fileContent = readTextFile(reader);
		StringBuilder fileContentB = new StringBuilder(fileContent);
		StringBuilder sB = new StringBuilder();
		
		//The last char of the text becomes the first one. Then we remove it. We repeat while there is a content into the StringBuilder.
		while (fileContentB.length()>0) {
			char lastChar = fileContentB.charAt(fileContentB.length()-1);				
			sB.append(lastChar);
			fileContentB.deleteCharAt(fileContentB.length()-1);
		}	
		
		String reverseFileContent = sB.toString();
		return fileContent+" "+reverseFileContent;
	}
}
