package mytest.factory.impl;

import mytest.factory.MyTestAbstractFactory;
import mytest.file.FileManagerInterface;
import mytest.file.impl.FileManagerImpl;
import mytest.http.HttpClientInterface;
import mytest.http.impl.ApacheHttpClient;
import mytest.json.JsonParserInterface;
import mytest.json.impl.GoogleJsonSimpleParser;

public class MyTestAbstractFactoryImpl implements MyTestAbstractFactory{

	@Override
	public HttpClientInterface createHTTPClient(String url) {
		return new ApacheHttpClient(url);
	}

	@Override
	public HttpClientInterface createHTTPClient(String url, String proxyHost, int proxyPort) {
		return new ApacheHttpClient(url, proxyHost, proxyPort);
	}

	@Override
	public JsonParserInterface createJasonParser() {
		return new GoogleJsonSimpleParser();
	}

	@Override
	public FileManagerInterface createFileManager(String path) {
		return new FileManagerImpl(path);
	}

	

	
}
