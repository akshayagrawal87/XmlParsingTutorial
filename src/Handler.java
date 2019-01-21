
import java.sql.*;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;


import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Handler {

		public static void handleChannelTag(Document document) throws Exception,SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
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
			String name,title,email,phone;
			String id;
			PreparedStatement ps=conn.prepareStatement("insert into interns values(?,?,?,?,?)");
			PreparedStatement ps1=conn.prepareStatement("insert into employee values(?,?,?,?,?)");
			
			
			 
			 System.out.println("Company :" + document.getDocumentElement().getNodeName());
			 NodeList nList = document.getElementsByTagName("Interns");
			 NodeList nList1 = document.getElementsByTagName("Permanent");
	         for (int temp = 0; temp < nList.getLength(); temp++) {
	            Node nNode = nList.item(temp);
	            System.out.println("\nCurrent Element :" + nNode.getNodeName());
	            
	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		               Element eElement = (Element) nNode;
		               System.out.println("EMPLOYEE ID : " 
				                  + eElement
				                  .getElementsByTagName("id")
				                  .item(0)
				                  .getTextContent());
		               System.out.println("EMPLOYEE NAME : " 
				                  + eElement
				                  .getElementsByTagName("name")
				                  .item(0)
				                  .getTextContent());
		              
		               System.out.println("title : " 
		                  + eElement
		                  .getElementsByTagName("title")
		                  .item(0)
		                  .getTextContent());
		               
		               System.out.println("Email : " 
		                  + eElement
		                  .getElementsByTagName("email")
		                  .item(0)
		                  .getTextContent());
		              
		               System.out.println("Phone Number : " 
		                  + eElement
		                  .getElementsByTagName("phone")
		                  .item(0)
		                  .getTextContent());
		              
		               //writing in Database
		               id=eElement
				                  .getElementsByTagName("id")
				                  .item(0)
				                  .getTextContent();
		               name=eElement
				                  .getElementsByTagName("name")
				                  .item(0)
				                  .getTextContent();
		               title=eElement
				                  .getElementsByTagName("title")
				                  .item(0)
				                  .getTextContent();
		               email=eElement
				                  .getElementsByTagName("email")
				                  .item(0)
				                  .getTextContent();
		               phone=eElement
				                  .getElementsByTagName("phone")
				                  .item(0)
				                  .getTextContent();
		               ps.setString(1,id);
		   			ps.setString(2,name);
		   			ps.setString(3,title);
		   			ps.setString(4,email);
		   			ps.setString(5,phone);
		   			ps.executeUpdate();
		               
	            }
	         }
	         for (int temp = 0; temp < nList1.getLength(); temp++) {
		            Node nNode = nList1.item(temp);
		            System.out.println("\nCurrent Element :" + nNode.getNodeName());
		            
		            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			               Element eElement = (Element) nNode;
			               System.out.println("EMPLOYEE ID : " 
					                  + eElement
					                  .getElementsByTagName("id")
					                  .item(0)
					                  .getTextContent());
			               System.out.println("EMPLOYEE NAME : " 
					                  + eElement
					                  .getElementsByTagName("name")
					                  .item(0)
					                  .getTextContent());
			               System.out.println("designation : " 
			                  + eElement
			                  .getElementsByTagName("designation")
			                  .item(0)
			                  .getTextContent());
			               System.out.println("Email : " 
			                  + eElement
			                  .getElementsByTagName("email")
			                  .item(0)
			                  .getTextContent());
			               System.out.println("Phone Number : " 
			                  + eElement
			                  .getElementsByTagName("phone")
			                  .item(0)
			                  .getTextContent());
			               id=eElement
					                  .getElementsByTagName("id")
					                  .item(0)
					                  .getTextContent();
			               name=eElement
					                  .getElementsByTagName("name")
					                  .item(0)
					                  .getTextContent();
			               title=eElement
					                  .getElementsByTagName("designation")
					                  .item(0)
					                  .getTextContent();
			               email=eElement
					                  .getElementsByTagName("email")
					                  .item(0)
					                  .getTextContent();
			               phone=eElement
					                  .getElementsByTagName("phone")
					                  .item(0)
					                  .getTextContent();
			               ps1.setString(1,id);
			   			ps1.setString(2,name);
			   			ps1.setString(3,title);
			   			ps1.setString(4,email);
			   			ps1.setString(5,phone);
			   			ps1.executeUpdate();
		            }
	         }
	      }		
}
