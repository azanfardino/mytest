package test;

import test.exception.AbstractTestException;
import test.file.FileManagerInterface;
import test.file.impl.FileManagerImpl;
import test.http.HttpClientInterface;
import test.http.impl.ApacheHttpClient;
import test.json.JsonParserInterface;
import test.json.impl.GoogleJsonSimpleParser;

public class Test {

	private static final String FILE_PATH = "result.csv";
	
	private static final String BASE_URL = "http://api.goeuro.com/api/v2/position/suggest/en/";

	public void start(String[] args){
		
		try{
		
			String res = getResource(args);			
			
			res = parseResource(res);
			
			storeResource(res);
			
		} catch(AbstractTestException e){
			
			System.out.println("Unable to execute test");
			
			e.printStackTrace();
		} 
		
	}

	


	private String getResource(String[] args) throws AbstractTestException{
		
		HttpClientInterface httpClient;
		
		String url = BASE_URL + args[0];
		
		if (args.length == 1){
			httpClient = new ApacheHttpClient(url);
		}else{
			httpClient = new ApacheHttpClient(url, args[1], args[2]);
		}
		
		
		return httpClient.get();
		
	}
	
	
	private String parseResource(String resource)  throws AbstractTestException {
		
		JsonParserInterface jsonParser = new GoogleJsonSimpleParser();
		
		return jsonParser.parseToCSV(resource);
	}
	
	

	private void storeResource(String res)  throws AbstractTestException{
			
		FileManagerInterface fileManager = new FileManagerImpl(FILE_PATH);
		
		fileManager.writeFile(res);
		
	}


}
