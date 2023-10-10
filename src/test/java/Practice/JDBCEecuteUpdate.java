package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class JDBCEecuteUpdate {

	public static void main(String[] args) throws SQLException {
		
		Driver driverref = new Driver(); // Create an object using which i will be interacting with others. mysql.cj.jdbc
		// Step 1: register the driver
		DriverManager.registerDriver(driverref);
		
		// Step 2: Connect to database

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vedanta", "root", "TIGER");
	
	
	    // Step 3: Issue create statement
		Statement state = con.createStatement();
	    
		// Step 4: Execute a query;
		String query="insert into candidateinfo values('Pankaj','1003009','Gumla'),('Minakshi','1003008','Hatma') ;";
		
		int result= state.executeUpdate(query);
		
		//Validation only one row is affected/ one query 
		if(result >=1) {
			System.out.println("Data Added");
		}
		
		ResultSet resultt = state.executeQuery("select * from candidateinfo;");
		
		while (resultt.next()) {
			System.out.println(resultt.getString(1)+" "+resultt.getString(2)+" "+resultt.getString(3));
		}
		
		// Step 5: close the Database
		con.close();
		System.out.println("DB Closed");
		
	
	}

}
