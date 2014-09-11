package mytest;

import mytest.exception.AbstractMyTestException;
import mytest.factory.MyTestAbstractFactory;
import mytest.factory.impl.MyTestAbstractFactoryImpl;
import mytest.file.FileManagerInterface;
import mytest.http.HttpClientInterface;
import mytest.json.JsonParserInterface;

public class MyTest {

	public static final String FILE_PATH = "result.csv";
	
	private static final String BASE_URL = "http://api.goeuro.com/api/v2/position/suggest/en/";
	
	private MyTestAbstractFactory abstractFactory;
	
	private HttpClientInterface httpClient;
	
	private JsonParserInterface jsonParser;
	
	private FileManagerInterface fileManager;
	
	
	
	public MyTest() {
		init();
	}
	
	
	private void init() {
		abstractFactory = new MyTestAbstractFactoryImpl();	
		
		jsonParser = abstractFactory.createJasonParser();
		
		fileManager = abstractFactory.createFileManager(FILE_PATH);
	}


	public void start(String[] args){
		
		try{
			clean();
			
			String res = getResource(args);			
			
			res = parseResource(res);
			
			storeResource(res);
			
		} catch(AbstractMyTestException e){
			
			System.out.println("Error executing test");
			
			e.printStackTrace();
			
		} catch(Exception e){
			
			System.out.println("Unexpected error executing test");
			
			e.printStackTrace();
		} 
		
	}

	


	private String getResource(String[] args) throws AbstractMyTestException{		
		
		String url = BASE_URL + args[0];
		
		if (args.length == 1){
			httpClient = abstractFactory.createHTTPClient(url);
		}else{
			httpClient = abstractFactory.createHTTPClient(url, args[1], Integer.parseInt(args[2]));
		}
		
		return httpClient.get();
		
	}
	
	
	private String parseResource(String resource)  throws AbstractMyTestException {
		
		return jsonParser.parseToCSV(resource);
	}
	
	

	private void storeResource(String res)  throws AbstractMyTestException{
		
		fileManager.writeFile(res);
		
	}
	
	
	private void clean()  throws AbstractMyTestException{
		
		fileManager.cleanFile();
		
	}


}
