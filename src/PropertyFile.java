
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropertyFile {

	public static void main(String[] args) throws IOException {
	      Properties prop = new Properties();
	      OutputStream os=new FileOutputStream("data.config.Properties");
	      
	      prop.setProperty("xml.path","C:\\Users\\aagrawal112\\workspace\\XmlParsingTutorial\\Demo.xml");
	  prop.store(os,null);
	         
	   }
}
