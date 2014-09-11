package mytest.factory;

import mytest.file.FileManagerInterface;
import mytest.http.HttpClientInterface;
import mytest.json.JsonParserInterface;

public interface MyTestAbstractFactory {

	HttpClientInterface createHTTPClient(String url);
	
	HttpClientInterface createHTTPClient(String url, String proxyHost, int proxyPort);
	
	JsonParserInterface createJasonParser();
	
	FileManagerInterface createFileManager(String path);
	
	
}
