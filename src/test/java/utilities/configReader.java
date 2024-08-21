package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReader {
	
	private Properties prop;
	
	//this method is uesd to load the properties from config.properties file and @return prpperties prop object
	
	public Properties init_prop() {
		prop = new Properties();
		
		try {
			FileInputStream ip = new FileInputStream("./src/main/java/Config/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return prop;
	}

}
