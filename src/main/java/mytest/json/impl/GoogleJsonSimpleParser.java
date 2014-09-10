package test.json.impl;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import test.json.JsonParserException;
import test.json.JsonParserInterface;

public class GoogleJsonSimpleParser implements JsonParserInterface{

	private static final char SEPARATOR = ',';
	
	private static final String LINE_DELIMITER = System.getProperty("line.separator");
	

	public String parseToCSV(String json) throws JsonParserException{
		
		JSONObject jsonObject;
		
		JSONArray jsonArray;		
		
		JSONParser parser = new JSONParser();
		
		try {
			
			
			Object obj = parser.parse(json);
			
			jsonArray = (JSONArray) obj;
			
			StringBuilder builder = new StringBuilder();
			
			for(Iterator iter = jsonArray.iterator(); iter.hasNext(); ){
			
				jsonObject = (JSONObject) iter.next();				
				
				builder.append((Long) jsonObject.get("_id"));
				
				builder.append(SEPARATOR);
				
				builder.append((String) jsonObject.get("name"));
				
				builder.append(SEPARATOR);
				
				builder.append((String) jsonObject.get("type"));
				
				builder.append(SEPARATOR);
				
				jsonObject = (JSONObject) jsonObject.get("geo_position");
				
				builder.append((Double) jsonObject.get("latitude"));
					
				builder.append(SEPARATOR);
					
				builder.append((Double) jsonObject.get("longitude"));			
				
				if (iter.hasNext()){
					builder.append(LINE_DELIMITER);
				}
				
			}
			
			System.out.println("Json Parsed To CSV : ");
			
			System.out.println(builder.toString());
			
			return builder.toString();
			
			
		} catch (ParseException e) {
			throw new JsonParserException("Error parsing json ", e);
		}	
		
	}
	
}
