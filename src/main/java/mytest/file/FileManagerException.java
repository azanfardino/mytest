package test.file;

import test.exception.AbstractTestException;


public class FileManagerException extends AbstractTestException{

	private static final long serialVersionUID = 5238224160687935609L;


	public FileManagerException(String message){
		super(message);
	}
	
	
	public FileManagerException(Throwable t){
		super(t);
	}
	
	
	public FileManagerException(String message, Throwable t){
		super(message, t);
	}
}
