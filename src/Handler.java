
import java.sql.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Handler {



public Connection DatabaseConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Connection conn = null;
		
		String url = "jdbc:mysql://localhost:3307/";
		
		String dbName = "altimetrik_employee";
		
		String driver = "com.mysql.jdbc.Driver";
		
		String userName = "root";
		
		String password = "root";
		
		
		Class.forName(driver).newInstance();
		
		conn = DriverManager.getConnection(url+dbName,userName,password);
		
		System.out.println("Connected to the database");
		
		return conn;
	}
	
	
	String[][] XmlParser(String s,PreparedStatement ps,Document document) throws SQLException
	{
		 String name,title = null,email,phone,designation = null;
		
		 String id;
 		
	     NodeList nList = document.getElementsByTagName(s);
	     String employeeData[][]=new String[ nList.getLength()][5];
	     
	     for (int temp = 0; temp < nList.getLength(); temp++) 
		{
	            
	    	Node nNode = nList.item(temp);
	        
	    	System.out.println("\nCurrent Element :" + nNode.getNodeName());
	            
	       if (nNode.getNodeType() == Node.ELEMENT_NODE)
	       {
		         
	         Element eElement = (Element) nNode;
		 
	         System.out.println("EMPLOYEE ID : " + eElement.getElementsByTagName("id").item(0).getTextContent());
		  
		     System.out.println("EMPLOYEE NAME : "+ eElement.getElementsByTagName("name").item(0).getTextContent());
		  
		       if("Interns".compareTo(s)==0)
		       {
		    	   
			   System.out.println("Title : " +eElement.getElementsByTagName("title").item(0).getTextContent());
		       
		       }
		       else
		      {
			  
		       System.out.println("Designation : "  + eElement.getElementsByTagName("designation").item(0).getTextContent());
		      
		      }
		     
		     System.out.println("Email : " + eElement.getElementsByTagName("email").item(0).getTextContent());
		              
		     System.out.println("Phone Number : "+ eElement.getElementsByTagName("phone").item(0).getTextContent());
		              
		  //writing in Database    	 
		
		 id=eElement.getElementsByTagName("id").item(0).getTextContent();		 
		 
		 name=eElement.getElementsByTagName("name").item(0).getTextContent();
		 
		 if("Interns".compareTo(s)==0)
		 {
		  
		  title=eElement.getElementsByTagName("title").item(0).getTextContent();
		 
		 }
		 
		 else
		 {
			 
	      designation=eElement.getElementsByTagName("designation").item(0).getTextContent();
		 
		 } 
		 
		 email=eElement.getElementsByTagName("email").item(0).getTextContent();
	     
		 phone=eElement.getElementsByTagName("phone").item(0).getTextContent();
		 
		 if("Interns".compareTo(s)==0)
		 {
		 
	     employeeData[temp][0]=id;
	     
	     employeeData[temp][1]=name;
		 
	     employeeData[temp][2]=title;
		 
	     employeeData[temp][3]=email;
		 
	     employeeData[temp][4]=phone;
		 
		 }
		 
		 else
		 {
			 employeeData[temp][0]=id;
			 
			 employeeData[temp][1]=name;
			 
			 employeeData[temp][2]=designation;
			 
			 employeeData[temp][3]=email;
			 
			 employeeData[temp][4]=phone;
		 }
		  
		 ps.setString(1,id);
		 
		 ps.setString(2,name);
		 
		 if("Interns".compareTo(s)==0)
		 {
			 
		   ps.setString(3,title);
		 
		 }
		 
		 else
		 {
			 
		   ps.setString(3,designation);
		 
		 }
		 
		 ps.setString(4,email);
		 
		 ps.setString(5,phone);
		 
		 ps.executeUpdate();
		 
		/*
		         */      
	            }
	       
	       }
	  
	     return employeeData;	
		
	}
	
	

	public static String[][][] handleChannelTag(Document document) throws Exception,SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
		{
		
		String employeeData[][][]=new String[2][3][5];
	
		Handler obj=new Handler();
		
		Connection conn= obj.DatabaseConnection();
		
		PreparedStatement ps=conn.prepareStatement("insert into interns values(?,?,?,?,?)");
		
		PreparedStatement ps1=conn.prepareStatement("insert into employee values(?,?,?,?,?)");
			
	    System.out.println("Company :" + document.getDocumentElement().getNodeName());
			 
		employeeData[0]=obj.XmlParser("Interns",ps,document);
			 
	    employeeData[1]=obj.XmlParser("Permanent",ps1,document);
	    
	    return employeeData;
	    	 	
	    }
	
}
