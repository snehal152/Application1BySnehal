package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileOperation {

	Properties prop;
	public PropertyFileOperation(String filePath) throws IOException
	{
		File file = new File(filePath);
		FileInputStream inputStream= new FileInputStream(file);
		 prop=new Properties();
		 prop.load(inputStream);
	}
	
	public String getValue(String key) 
	{
		
		return prop.getProperty(key);
	}
}
