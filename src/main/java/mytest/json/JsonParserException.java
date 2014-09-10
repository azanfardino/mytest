package mytest.json;

import mytest.exception.AbstractMyTestException;


public class JsonParserException extends AbstractMyTestException{

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
