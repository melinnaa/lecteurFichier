package file.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * TextFileComparator class is used to compare the content of two text files passed in the constructor.
 */
public class TextFileComparator implements IMyFileComparator {
	private static String fileName1;
	private static String fileName2;
	private static ArrayList <String> linesFile1 = new ArrayList<String>();	
	private static ArrayList <String> linesFile2 = new ArrayList<String>();	
	
	/**
	 * Constructor that initializes the statics strings fileName1 and fileName2
	 * Launch the method to compare both files
	 * @param f1
	 * @param f2
	 */
	public TextFileComparator(String f1, String  f2) {
		fileName1 = f1;
		fileName2 = f2;
		compareFiles();
	}
	
	/**
	 * Stock the lines of the file passed in parameter @param file into the ArrayList @param linesFile
	 */
	private void prepareLinesFile(String file, ArrayList<String> linesFile) {
		
		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader(file));
			try {
				 String line;
				 while ((line = reader.readLine()) != null) {
					linesFile.add(line);
				}
			} catch (IOException e) {
				e.printStackTrace();			
			}	
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}    
	}
	
	/**
	 * Compare both files line by line.
	 * Focus on the first file.
	 * Print lines of the first file to remove (-)
	 * Print lines of the second file to add into the first file (+)
	 */
	public void compareFiles() {
	    
		prepareLinesFile(fileName1, linesFile1);
		prepareLinesFile(fileName2, linesFile2);
		
		//If both files have the same number of lines then we compare each line
	    if (linesFile1.size() == linesFile2.size()) {
	   	    	for (int i = 0; i < linesFile1.size(); i++) {
	    		compareLines(i);				
			}
	    }
	    
	    //Otherwise
	    else {
	    	//We distinguish the files by their number of lines
	    	final ArrayList<String> linesLongerFile;
	    	final ArrayList<String> linesShorterFile;
	    	
	    	
	    	if (linesFile1.size() > linesFile2.size()) {
	    		linesLongerFile = linesFile1;
	    		linesShorterFile = linesFile2;
	    	}
	    	
	    	else {
	    		linesLongerFile = linesFile2;
	    		linesShorterFile = linesFile1;
	    	}
	    	
	    	int counter = 0;
	    	//We compare each line a number of times equals to the number of the shortest file lines
	    	for (int i = 0; i < linesShorterFile.size(); i++) {
	    		compareLines(i);
	    		counter = i;
	    	}
	    	
	    	//We show the remaining lines to add into the first file
	    	for (int i = counter+1; i < linesLongerFile.size(); i++) {
	    		
	    		//If the second file is the longest then we show the remaining lines to add into the first file
	    		if (linesLongerFile.size() ==  linesFile2.size()) {
	    			System.out.println("+ "+linesLongerFile.get(i));
	    		}
	    		
	    		//If the first file is the longest then we show the remaining lines to delete 
	    		else {
	    			System.out.println("- "+linesLongerFile.get(i));
	    		}
	    		
	    	}
	    }		
	}
		
	/**
	 * Compare the line i of the first file with the line i of the second file
	 * @param lineNb
	 */
	private void compareLines(int lineNb) {
		String currLine1 = linesFile1.get(lineNb);
		String currLine2 = linesFile2.get(lineNb);
		
		//If both lines are equals then we print the content
		if (currLine1.equals(currLine2)) {
			System.out.println(currLine1);
		}
		
		//Otherwise we show the line of the 1rst file to replace (-: content to delete; +: content to add)
		else if (!currLine1.equals(currLine2)) {
			System.out.println("- "+currLine1);
			System.out.println("+ "+currLine2);
		}
	}
}
