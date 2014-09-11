package mytest.file;

public interface FileManagerInterface {

	void writeFile(String content) throws FileManagerException;
	
	void cleanFile() throws FileManagerException;
}
