package metier;

import java.sql.Connection;
import java.sql.DriverManager;

public class Myconnection {


	private static Connection myconnection;
	
	static{
		  
		try{
		Class.forName("com.mysql.jdbc.Driver");
		myconnection=DriverManager.getConnection
				         ("jdbc:mysql://localhost:3306/databaseshop","root","");
		}
		catch(Exception e)
		   {
			e.printStackTrace();
		   }
		
		
	  }
	
	public static Connection getMyconnection() {
		return myconnection;
	}

}
