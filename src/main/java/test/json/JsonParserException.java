package test.json;

import test.exception.AbstractTestException;


public class JsonParserException extends AbstractTestException{

	private static final long serialVersionUID = 8489548574536858885L;


	public JsonParserException(String message){
		super(message);
	}
	
	
	public JsonParserException(Throwable t){
		super(t);
	}
	
	
	public JsonParserException(String message, Throwable t){
		super(message, t);
	}
}
