import java.util.*;
import java.sql.*;

public class DataConnect {

	/**
	 * @param args
	 * @return 
	 */
/*	public static void main(String[] args) {
		
		//new DataConnect();

	}
*/
	
	public DataConnect(int num) {
		try
		{

			//*******************************************************
			//     CONNECT TO DATABASE
			//
			//
			// check for jdbc driver  

			Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql://ec2-54-83-199-115.compute-1.amazonaws.com:5432/d6dkcadllp047b";  
			
			Properties props = new Properties(); 
			props.setProperty("user", "qwfroulvkspmgi"); 
			props.setProperty("password", "ucTWno3ZkdnGvWmheG3OsU7K57"); 
			props.setProperty("ssl", "true");
			props.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
			//
			// connect to the database

			Connection conn = DriverManager.getConnection(url,props); 
			//
			//*******************************************************


			//*******************************************************
			// build the query and get result from result set
			//
			//
			
			//Loop to build strings for different queries
			//or different data connections for different queries?
			
			String query = "SELECT * FROM \"NodeDescription\" WHERE \"SID*\" = " + num;
			//			      
			//  	
			// create statement and execute query
			//
			//
			Statement stmt2 = conn.createStatement();
			//
			ResultSet rs2 = stmt2.executeQuery(query);  // return a result set
			//
			//
			//step through all records in the result set and print contents
			//
			//
			while(rs2.next()) {
				//
				String name = rs2.getString("Name");
				//
				System.out.print(name);
			}
			//******************************************************

			// close the database connection

			conn.close();

		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}

}

