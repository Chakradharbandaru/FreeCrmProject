package com.capgemini.parameters;
 
import java.io.FileReader;
import java.util.Properties;
 
public class PropertyReader {
	static String value;
	public static String getPropertyData(String propertyfilePath,String key) {
	try {
	FileReader propsfile=new FileReader(propertyfilePath);
	Properties properties=new Properties();
	properties.load(propsfile);
	value =properties.getProperty(key);
	}
	catch (Exception e) {
		System.out.println("Error reading properties file: "+ e.getMessage());
	}
	if(value==null) {
		System.out.println("Key not found in properties file: "+ key);
		return null;
	}else {
		return value;
	}
}
}















//The PropertyReader class is used to read key-value pairs from a .properties file. 
//These files are commonly used in Java projects to store configuration data like URLs, credentials, environment settings, etc.
//FileReader: Reads character files, used here to read the .properties file.
//Properties: A Java utility class that represents a persistent set of properties (key-value pairs).
