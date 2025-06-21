package com.capgemini.parameters;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonReader{
	public static String[] getJsonData(String jsonPath, String emailKey, String passwordKey){
		JSONParser parser = new JSONParser();
		try{
			FileReader jsonfile = new FileReader(jsonPath);
			Object obj = parser.parse(jsonfile);
			JSONObject jsonObject = (JSONObject) obj;
			String emailValue = (String) jsonObject.get(emailKey);
			String passwordValue = (String) jsonObject.get(passwordKey);

			if(emailValue == null || passwordValue == null) {
				System.out.println("Json object is null. Please check the file or content.");
				return null;
			} 
			else{
				return new String[]{emailValue, passwordValue};
			}
		}
		catch(Exception e) 
		{
			System.out.println("Error reading JSON file: " + e.getMessage());
			return null;
		}
	}
}











//The JsonReader class is designed to read specific values from a JSON file using the json-simple library.
//FileReader: Reads the JSON file from the file system.
//JSONParser: Parses the JSON content.
//JSONObject: Represents the parsed JSON object.
//jsonPath: Path to the JSON file.
//emailKey: Key for the email value in the JSON.
//passwordKey: Key for the password value in the JSON.
//Catches and prints any exceptions (e.g., file not found, parse error).
