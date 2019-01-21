import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.Node;
import javax.lang.model.element.Element;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException; 
public class FileDemo {
	
	 public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception {
		 	  Properties p = new Properties();
	      	  InputStream is=new FileInputStream("data.config.Properties");
	      	  p.load(is);
		 	  String Path = p.getProperty("xml.path");
	    	  System.out.println(Path);
		 	  File inputFile = new File(Path);
	          DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	          DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	          Document doc = dBuilder.parse(inputFile);
	          doc.getDocumentElement().normalize(); 
	          Handler.handleChannelTag(doc);
	         
	   }   
	}
	
