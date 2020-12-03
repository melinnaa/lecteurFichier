package file.reader;
/**
 * 
 * 
 * Abstract class that implements (or not) methods that must be used for every type of file reader
 *
 */
public abstract class MyFileReaderImpl implements IMyFileReader {
	
	abstract public void readFile(String fileName);
}
