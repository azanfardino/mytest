package mytest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyTestJUnit {
	
	
	private boolean useProxy;
	
	private String host;
	
	private String port;
	
	
	
	
	
	@Before
	public void initProxy(){

	//TODO uncomment  if you need to use an http proxy	
//		useProxy = true;
//		
//		host = "xxx.xxx.xxx.xxx";
//		
//		port = "8080";
		
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void checkNoArguments(){		
		Main.main(new String[0]);
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void check2Arguments(){		
		Main.main(new String[]{"Arg1", "Arg2"});
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void check4Arguments(){		
		Main.main(new String[]{"Arg1", "Arg2", "Arg3" , "Arg4"});
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void checkInvalidPort(){		
		Main.main(new String[]{"Arg1", "Arg2", "InvalidPort"});
	}
	
	@Test
	public void checkSuccessfullScenario(){	
		String queryString = "Potsdam";
		
		String[][] expectedResult = new String[][] {
				new String[] {"377078","Potsdam","location","52.39886","13.06566"},
				new String[] {"410978","Potsdam","location","44.66978","-74.98131"}};
		
		
		if (useProxy){
			Main.main(new String[]{queryString, host, port});
		}else{
			Main.main(new String[]{queryString});
		}
		
		checkFile(expectedResult);		
	}
	
	
	@Test
	public void checkEmptyResult(){	
		String queryString = "BlaBla";
		
		String[][] expectedResult = new String[][] {
				new String[] {},
				new String[] {}};
		
		
		if (useProxy){
			Main.main(new String[]{queryString, host, port});
		}else{
			Main.main(new String[]{queryString});
		}
		
		checkFile(expectedResult);		
	}
	
	
	
	@Test
	public void checkInvalidQueryString(){	
		String queryString = "Bla Bla Bla";
		
		String[][] expectedResult = new String[][] {
				new String[] {},
				new String[] {}};
		
		
		if (useProxy){
			Main.main(new String[]{queryString, host, port});
		}else{
			Main.main(new String[]{queryString});
		}
		
		checkFile(expectedResult);		
	}
	


	private void checkFile(String[][] expectedResult) {
		BufferedReader br = null;
		String line = "";
		String separator = ",";
		int count = 0;
	 
		try {
	 
			br = new BufferedReader(new FileReader(MyTest.FILE_PATH));
			while ((line = br.readLine()) != null) {
	 
			        // use comma as separator
				String[] values = line.split(separator);
	 
				Assert.assertArrayEquals(expectedResult[count++], values);
	 
			}
	 
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	

}
