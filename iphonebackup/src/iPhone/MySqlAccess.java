package iPhone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

public class MySqlAccess {

	public static int insertintodb(String useraccount,String name,String number) {
	    	int userid=0;
	    	int newContact=0;
		 try {
		   	     Class.forName("com.mysql.jdbc.Driver");
		     } catch (ClassNotFoundException e) {
		           System.out.println("Where is your MySQL JDBC Driver?");
		           e.printStackTrace();
		          
		       }
	 
		        //System.out.println("MySQL JDBC Driver Registered!");
		      Connection connection = null;
	 
		 try {
			      connection = DriverManager
			      .getConnection("jdbc:mysql://localhost:3306/iphone","root", "root");
	 
		     } catch (SQLException e) {
			      System.out.println("Connection Failed! Check output console");
			      e.printStackTrace();
			     
		     }
	 
		 if (connection != null) {
			  //System.out.println("You made it, take control your database now!");
		 } else {
			System.out.println("Failed to make connection!");
		 }
		 try {
			
		           Statement st = (Statement) connection.createStatement(); 
//		st.executeUpdate("INSERT INTO usermaster (userid,username,password) " + "VALUES(\"1\",\"sourav\",\"garai\")");
		
		
		           String sql = "SELECT userid FROM usermaster where username=\""+useraccount+"\"";
//		 System.out.println(sql);
		           ResultSet rs = st.executeQuery(sql);
	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	               userid = rs.getInt("userid");
//	          System.out.println("Entry Found"+userid);
	  		
	         
	         //Display values
	         
	      }
	      rs.close();
		
		
		
		
		   if(!checkForDuplicateValue(userid, name, number)){
			    if(!number.contains("?")){
			            st.executeUpdate("INSERT INTO userdetail (userid,contactname,phonenumber) " + "VALUES(\""+userid+"\",\""+name+"\",\""+number+"\")");
			            System.out.println("Insert Sucessful!");
			            newContact=1;
			     }
		    }
		
		}catch(Exception e){
			System.out.println("Failed to Insert!");
			e.printStackTrace();
		}
		return newContact;
				
    }
	public static boolean checkForDuplicateValue(int userid, String name, String number){
		boolean duplicate = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
//			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			
		}
	 
//		//System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;
	 
		try {
			connection = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/iphone","root", "root");
	 
		} catch (SQLException e) {
//			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			
			
		}
	 
		if (connection != null) {
//			//System.out.println("You made it, take control your database now!");
		} else {
//			System.out.println("Failed to make connection!");
		}
		try{
			
		Statement st = (Statement) connection.createStatement(); 
//		st.executeUpdate("INSERT INTO usermaster (userid,username,password) " + "VALUES(\"1\",\"sourav\",\"garai\")");
		
		
		 String sql = "SELECT userid FROM userdetail where userid=\""+userid+"\" and contactname = \""+name+"\" and phonenumber=\""+number+"\"";
		 System.out.println(sql);
		 ResultSet rs = st.executeQuery(sql);
	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	    	  duplicate = true;
	          System.out.println("Entry Already Exists");
	  		
	         
	         //Display values
	      }
	      rs.close();
		}catch(Exception e){
			System.out.println("Duplicate exception");
			e.printStackTrace();
		}
	      
		
		return duplicate;
		
	}
	public static int createAccount(String user ,String pass){
		int flag=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
		}
	 
		//System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;
	 
		try {
			connection = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/iphone","root", "root");
	 
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
	 
		if (connection != null) {
			//System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		try{	
		Statement st = (Statement) connection.createStatement(); 
		String s1= "Select * from usermaster where username='"+user+"'";
		ResultSet r =null;
		
		r= st.executeQuery(s1); 
		//System.out.println("result set: "+r.toString());

		while(r.next()){
			flag=1;
			
		}
		if(flag!=0)
		{
			 
			System.out.println("AllReady Present....!");
		}
		
		else
		{
		  st.executeUpdate("INSERT INTO usermaster (userid,username,password) " + "VALUES(\""+Math.floor((Math.random()*10000)+1)+"\",\""+user+"\",\""+pass+"\")");
//		  st.executeUpdate("INSERT INTO userdetail (userid,phonenumber) " + "VALUES(\"1\",\""+number+"\")");
		  System.out.println("Insert Sucessful!");
		}
		}catch(Exception e){
			System.out.println("Failed to Insert!");
			e.printStackTrace();
		}
		return flag;
	}
	public static int checkLogin(String user, String pass) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			
		}
	 
		//System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;
	 
		try {
			connection = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/iphone","root", "root");
	 
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
	 
		if (connection != null) {
			//System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		try{
			 String sql = "SELECT * FROM usermaster";
			 Statement st = (Statement) connection.createStatement(); 
			 ResultSet rs = st.executeQuery(sql);
		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         String username  = rs.getString("username");
		         String password = rs.getString("password");
		         
		         if(username.equalsIgnoreCase(user)&&password.equalsIgnoreCase(pass)){
		        	 return 1;
		         }
		         //Display values
		         
		      }
		      rs.close();}
		catch(Exception e){
			System.out.println("Failed to Select!");
			e.printStackTrace();
		}
		
		return 0;
		
		
	}
	public static String getContacts(HttpSession session){
		
		
		
		String userid="";
		String name = "";
		String number = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
//			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			
		}
	 
		//System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;
	 
		try {
			connection = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/iphone","root", "root");
	 
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
	 
		if (connection != null) {
			//System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		try{
//			String sql = "SELECT userid FROM usermaster where username=\""+(String)session.getAttribute("username")+"\"";
			String sql = "SELECT userid FROM usermaster where username=\""+(String)session.getAttribute("username")+"\"";
//			    System.out.println(sql);
		    Statement st = (Statement) connection.createStatement(); 
			 ResultSet rs = st.executeQuery(sql);
			 while(rs.next()){
//				 System.out.print("Found");
		     userid=rs.getString("userid");
			 }
			
			  sql = "SELECT * FROM userdetail where userid ='"+userid+"'";
			  st = (Statement) connection.createStatement(); 
			  rs = st.executeQuery(sql);
		      //STEP 5: Extract data from result set
			 
		      while(rs.next()){
		         //Retrieve by column name
		    	  
		         name  += rs.getString("contactname")+"||||";
		         number += rs.getString("phonenumber")+"||||";
		         
		      }
		      System.out.println(name);
		      System.out.println(number);
		      
		      rs.close();
		      }
		
		catch(Exception e){
			System.out.println("Failed to Select!");
			e.printStackTrace();
		}
//		contacts[0]=name;
//		contacts[1]=number;
		return name+"&&&&"+number;
		
	}
	
}
