import java.io.File; 
import java.sql.SQLException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document; 
public class FileDemo {
	
	 public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception {
		 //getting path	 
		 String Path = FileConstants.XML_File_Path;
	    	 
		 System.out.println(Path);
		 
		 File inputFile = new File(Path);
	     
		 DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	     
		 DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	     
		 Document doc = dBuilder.parse(inputFile);
	     
		 doc.getDocumentElement().normalize(); 
	     
		 Handler.handleChannelTag(doc);
	         
	   }   
	}
	
