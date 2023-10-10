package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBC_TryCatch {

	public static void main(String[] args) throws SQLException {
		Connection con= null;
		try {
		Driver driverRef= new Driver();
		//Step 1: register the driver
		DriverManager.registerDriver(driverRef);
		
		//Step 2: get the connection
		con =DriverManager.getConnection("jdbc:mysql://localhost:3306/vedanta", "root", "TIGER");
		
		//Step 3: issue create statement
		Statement state= con.createStatement();
		
		//Step 4: execute a query
		String query = "insert into candidateinfo values ('Shubham',800,'IndiaBanglore');"; 
		int result= state.executeUpdate(query);
		if (result>=1)
		{
		System.out.println("data added");
		}}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Step 5: Close the Database
		finally {
			try {
				if(con!=null) {
					con.close();
				}
			}
				catch (SQLException e2) {
					e2.printStackTrace();
				}
		}
		}
}
	