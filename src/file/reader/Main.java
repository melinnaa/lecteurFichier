package file.reader;

import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * 
 * Main class displays the menu to know which program the user wants to open.
 *
 */
public class Main {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[]args) throws IOException {
		
		//Main menu
		System.out.println("Welcome in the file reader! What do you want to do ?");
		System.out.println("1-READ A FILE  2-COMPARE 2 FILES");
		
		String str1 = sc.nextLine();
		
		//The user makes his choice
		while (true) {
			if (str1.equals("1")) {
				//Open file reader and stop the loop
				openFileReader();
				break;
			}
			
			if (str1.equals("2")) {
				//Open file comparator and stop the loop
				openFileComparator();
				break;
			}
			
			else {
				System.out.println("Select the option 1 or 2");
			}
		}			
	}
	
	/**
	 * 
	 */
	private static void openFileComparator() {
		System.out.print("Input the first file: (try with mytextfile.txt) ");
		
		String input1 = sc.nextLine();
		
		//Continue if the first input is a text file
		if (isTextFile(input1)) {
			
			System.out.print("Input the second file: (try with one_different_line.txt OR one_less_line.txt)");	
			String input2 = sc.nextLine();
			
			//Enable the file comparator if the second input is a text file
			if (isTextFile(input2)) {
				new TextFileComparator(input1, input2);						
			}
			
			else {
				System.out.println("Your input is not a text file");
			}
		}
		
		//We can add other types of file comparator (for example: images, xml,..)
		else {
			System.out.println("For the moment, we don't have a reader related to this type of file.");
		}
	}
	
	
	private static void openFileReader() {
		
		System.out.print("Enter a file: (try with mytextfile.txt) ");
		
		String input = sc.nextLine();
		
		File userFile = new File(input);
		System.out.println("File name: "+readFileName(userFile)+" --- File name reversed: "+reverseFileName(userFile));
		
		//If file exists then detect file type
		if (fileExists(userFile)) {
			String mimeType = URLConnection.guessContentTypeFromName(userFile.getName());
			System.out.println("Your file type: "+mimeType);
			
			//If file type is text then enable text file reader
			if (mimeType.equals("text/plain")) {
				System.out.println("Your text file reader is opening..");
			
				//Loading mock up 
				charge();
				
				//Display the sub menu while the user doesn't make a correct choice
				while (true) {
					System.out.println("Select a display mode for your text file: ");
					System.out.println("1-NORMAL 2-REVERSED 3-PALINDROMIC");
					
					String str2 = sc.nextLine();
					
					if (str2.equals("1")) {
						TextFileReader textFileReader = new TextFileReader(readFileName(userFile));
						textFileReader.readFile(readFileName(userFile));
						break;
					}
					
					else if (str2.equals("2")) {
						ReverseReader reverseReader = new ReverseReader(readFileName(userFile));
						reverseReader.readFile(readFileName(userFile));
						break;					
					}
					
					else if (str2.equals("3")) {
						PalindromeReader palindromeReader = new PalindromeReader(readFileName(userFile));
						palindromeReader.readFile(readFileName(userFile));
						break;
					}
					
					System.out.println("Select option 1 2 or 3.");
				}
			}	
			
			//We can add other types of file reader (for example: images, xml,..)
			else {
				System.out.println("We don't have a reader related to this type of file.");
			}
		}
		
		else {
			System.out.println("File not found. Input a file and not a directory.");
		}
	}
	
	/**
	 * Read the name of the file
	 * @param file: file input
	 * @return the string name of the file
	 */
	private static String readFileName(File file) {
		String fileName = file.getName();
		return fileName;
	}
	
	/**
	 * Reverse the file name using the readFileName method.
	 * @param file: file input
	 * @return the reverse string name of the file
	 */
	private static String reverseFileName(File file) {
		String fileName = readFileName(file);
		String reverseFileName= new StringBuilder(fileName).reverse().toString();
		return reverseFileName;
	}
	
	/**
	 * Verify if the input file exists and if it isn't a directory
	 * @param file
	 * @return true if the file exists
	 */
	private static boolean fileExists(File file) {
		if (file.exists() && !file.isDirectory()) {
			return true;
		}
		return false;
	}
		
	/**
	 * Verify if the input is a file and also if its type is text
	 * @param input
	 * @return true if it is a text file
	 */
	private static boolean isTextFile(String input) {
		File currFile = new File(input);
		//If the file exists then check its mime type
		if (fileExists(currFile)) {
			String mimeType = URLConnection.guessContentTypeFromName(currFile.getName());
			//if it's a text then return true
			if (mimeType.equals("text/plain")) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Mock up a loading: stop 3s before continuing the program
	 */
	private static void charge() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
