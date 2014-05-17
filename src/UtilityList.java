import java.util.*;
import java.sql.*;

public class UtilityList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UtilityList();

	}

	public UtilityList() {
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
			for(int rqst=1; rqst<9; rqst++){
				
				String rsc = "";
				
				switch(rqst)
				{
				case 1:
					rsc = new String("ATM");
					break;
				case 2:
					rsc = new String("Vending");
					break;
				case 3:
					rsc = new String("RestRoom");
					break;
				case 4:
					rsc = new String("PublicPhone");
					break;
				case 5:
					rsc = new String("ComputerLab");
					break;
				case 6:
					rsc = new String("WiFi");
					break;
				case 7:
					rsc = new String("Security");
					break;
				case 8:
					rsc = new String("BusStop");
					break;					
				}
				
				String query = "SELECT * FROM \"NodeLayer\" WHERE \"" + rsc + "\" = 1";
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
					String sid = rs2.getString("SID*");
					switch(rqst){
					case 1:
						System.out.print("There is an ATM at the location with the ID ");
						break;
					case 2:
						System.out.println("There is a vending machine at the location with the ID ");
						break;
					case 3:
						System.out.println("There is a restroom at the location with the ID ");
						break;
					case 4:
						System.out.println("There is a public phone at the location with the ID ");
						break;
					case 5:
						System.out.println("There is a computer lab at the location with the ID ");
						break;
					case 6:
						System.out.println("There is WiFi at the location with the ID ");
						break;
					case 7:
						System.out.println("There is a security guard at the location with the ID ");
						break;
					case 8:
						System.out.println("There is a shuttle bus stop at the location with the ID ");
						break;
					}
					
					System.out.println(sid);
					
				}
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

