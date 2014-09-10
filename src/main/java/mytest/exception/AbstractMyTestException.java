package mytest.exception;


public abstract class AbstractMyTestException extends Exception{

	
	private static final long serialVersionUID = 7984261499344796604L;


	protected AbstractMyTestException(String message){
		super(message);
	}
	
	
	protected AbstractMyTestException(Throwable t){
		super(t);
	}
	
	
	protected AbstractMyTestException(String message, Throwable t){
		super(message, t);
	}
	
	
}
