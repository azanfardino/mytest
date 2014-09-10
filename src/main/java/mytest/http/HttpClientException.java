package mytest.http;

import mytest.exception.AbstractMyTestException;


public class HttpClientException extends AbstractMyTestException{

	private static final long serialVersionUID = -2210534714310163702L;


	public HttpClientException(String message){
		super(message);
	}
	
	
	public HttpClientException(Throwable t){
		super(t);
	}
	
	
	public HttpClientException(String message, Throwable t){
		super(message, t);
	}
}
