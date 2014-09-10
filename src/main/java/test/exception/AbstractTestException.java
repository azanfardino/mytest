package test.exception;


public abstract class AbstractTestException extends Exception{

	
	private static final long serialVersionUID = 7984261499344796604L;


	protected AbstractTestException(String message){
		super(message);
	}
	
	
	protected AbstractTestException(Throwable t){
		super(t);
	}
	
	
	protected AbstractTestException(String message, Throwable t){
		super(message, t);
	}
	
	
}
