package vtiger.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
/**
 * This class exectues command in JDBC
 * @author kravi
 *
 */

public class DatabaseUtility {
	/**
	 * This method is for execute query in JDBC
	 * @param query
	 * @param tableName
	 * @throws SQLException
	 */

	public void executeQueryJDBC(String query, String tableName) throws SQLException {
	//create an object
	Driver driverref= new Driver();
	// Register the driver
	DriverManager.registerDriver(driverref);
	//Connect to DataBase
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vedanta", "root", "TIGER");
	//Issue create Statement
	Statement state = con.createStatement();
	// Execute a query
	String query_ =query; 
	int result = state.executeUpdate(query_);
	
	//Validation only one row is affected one query
	if(result >=1) {
		System.out.println(result+" "+"Updated");
	}
	
	String india=tableName;
	ResultSet res = state.executeQuery("select * from "+india+";");
	{
		for(int i=0;res.next();i++) {
			System.out.println(i);	
		}
	}
	
	while(res.next()) {
		for(int i=0;i<res.getInt(i);i++)
		System.out.print(res.getString(i)+" ");
	
	}
	//Close the DataBase
	con.close();
	System.out.println("Data Base closed");
	}
}
