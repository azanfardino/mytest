package mytest;

import mytest.exception.AbstractMyTestException;
import mytest.file.FileManagerInterface;
import mytest.file.impl.FileManagerImpl;
import mytest.http.HttpClientInterface;
import mytest.http.impl.ApacheHttpClient;
import mytest.json.JsonParserInterface;
import mytest.json.impl.GoogleJsonSimpleParser;

public class MyTest {

	private static final String FILE_PATH = "result.csv";
	
	private static final String BASE_URL = "http://api.goeuro.com/api/v2/position/suggest/en/";

	public void start(String[] args){
		
		try{
		
			String res = getResource(args);			
			
			res = parseResource(res);
			
			storeResource(res);
			
		} catch(AbstractMyTestException e){
			
			System.out.println("Unable to execute test");
			
			e.printStackTrace();
		} 
		
	}

	


	private String getResource(String[] args) throws AbstractMyTestException{
		
		HttpClientInterface httpClient;
		
		String url = BASE_URL + args[0];
		
		if (args.length == 1){
			httpClient = new ApacheHttpClient(url);
		}else{
			httpClient = new ApacheHttpClient(url, args[1], args[2]);
		}
		
		
		return httpClient.get();
		
	}
	
	
	private String parseResource(String resource)  throws AbstractMyTestException {
		
		JsonParserInterface jsonParser = new GoogleJsonSimpleParser();
		
		return jsonParser.parseToCSV(resource);
	}
	
	

	private void storeResource(String res)  throws AbstractMyTestException{
			
		FileManagerInterface fileManager = new FileManagerImpl(FILE_PATH);
		
		fileManager.writeFile(res);
		
	}


}
