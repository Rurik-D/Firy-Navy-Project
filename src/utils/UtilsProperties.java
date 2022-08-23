package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class UtilsProperties {

	private static UtilsProperties singleItem = null;
	private  Properties props = null;
	
	public static UtilsProperties getInstance() {
		if (singleItem == null) {
			singleItem = new UtilsProperties();
			 try (InputStream input = UtilsProperties.class.getClassLoader().getResourceAsStream("utils/file/setImages.properties")) {
				 Properties propsTmp = new Properties();
		         // load a properties file
				 propsTmp.load(input);
				 singleItem.props = propsTmp;
			 }
			 catch (Exception  ex) {
				 System.out.println(ex.getMessage());
			 }
		}
		return singleItem;
	}
	
	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}
	
}
