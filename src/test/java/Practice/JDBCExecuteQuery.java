package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCExecuteQuery {

	public static void main(String[] args) throws SQLException {
		
		 Driver driverref= new Driver();
		 // Step 1: Register the driver;  
		 DriverManager.registerDriver(driverref);
		
		 // Step 2 : Connect to DB
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vedanta", "root", "TIGER");
		
		 // Step 3: Issue create statement
		 Statement state = con.createStatement();
		 
		 // Step 4: Execute a query
		 ResultSet result = state.executeQuery("select name from candidateinfo;");
		
		 while(result.next()) {
			  System.out.println(result.getString(1)); //Customizing output here before hand.
		     }
		  
		  //Step 5:  Close the Data` Base
	      con.close();
	      System.out.println("DATA BASE closed");
	}

}
