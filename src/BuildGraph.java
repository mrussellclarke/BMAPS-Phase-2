import java.util.*;
import java.sql.*;

public class BuildGraph {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int total = Builder();
		
		//System.out.println(Builder());
	}

	public int Outline(String param) {
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
			String query = "SELECT COUNT(*) AS \"N1\" FROM \"" + param + "\"";
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
			rs2.next();
			
			int count = rs2.getInt("N1");
			
			//******************************************************

			// close the database connection

			conn.close();
			
			return count;
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		return -1;
	}
			
	public int PointId(int ID) {
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
			String query = "SELECT * FROM \"NodeLocation\" WHERE \"SID*\" = " + ID;
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
			
			int point = 0;
			
			while(rs2.next()) {
				//
				//String sid = rs2.getString("SID*");
				//
				point = rs2.getInt("SID*");
			}
			//******************************************************

			// close the database connection

			conn.close();
			
			return point;
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		return -1;
		
	}
	
	public int PointX(int ID) {
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
			String query = "SELECT * FROM \"NodeLocation\" WHERE \"X\" = " + ID;
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
			
			int x = 0;
			
			while(rs2.next()) {
				//
				//String sid = rs2.getString("SID*");
				//
				x = rs2.getInt("SID*");
			}
			//******************************************************

			// close the database connection

			conn.close();
			
			return x;
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		return -1;
		
	}
	
	public int PointY(int ID) {
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
			String query = "SELECT * FROM \"NodeLocation\" WHERE \"Y\" = " + ID;
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
			
			int y = 0;
			
			while(rs2.next()) {
				//
				//String sid = rs2.getString("SID*");
				//
				y = rs2.getInt("SID*");
			}
			//******************************************************

			// close the database connection

			conn.close();
			
			return y;
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		return -1;
		
	}

	public int Start(int i) {
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
			String query = "SELECT * FROM \"Graph\" WHERE \"ID\" = " + i;
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
			
			int v = 0;
			
			while(rs2.next()) {
				//
				//String sid = rs2.getString("SID*");
				//
				v = rs2.getInt("SID");
			}
			//******************************************************

			// close the database connection

			conn.close();
			
			return v;
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		return -1;
	}
	
	public int Dest(int i) {
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
			String query = "SELECT * FROM \"Graph\" WHERE \"ID\" = " + i;
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
			
			int w = 0;
			
			while(rs2.next()) {
				//
				//String sid = rs2.getString("SID*");
				//
				w = rs2.getInt("DID");
			}
			//******************************************************

			// close the database connection

			conn.close();
			
			return w;
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		return -1;
	}
}