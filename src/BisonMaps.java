import java.util.*;
import java.sql.*;

/*************************************************************************
 *  Compilation:  javac BisonMaps.java
 *  Execution:    java BisonMaps mapfile < input.txt
 *  Dependencies: EuclideanGraph.java Dijkstra.java In.java StdIn.java
 *
 *  Reads in a map from a file, and repeatedly reads in two integers s
 *  and d from standard input, and prints the shortest path from s
 *  to d to standard output.
 *
 ****************************************************************************/


public class BisonMaps {

    public static void main(String[] args) {
		
    	System.out.println("1. Get Directions");
    	System.out.println("2. Find campus resources");
    	System.out.println("3. Display campus building names");
    	System.out.println("4. Display all campus resources");
    	System.out.println("5. Display all department locations");
    	System.out.println("6. Exit");
    	System.out.print("Enter (1 - 6): ");
    	
    	while(!StdIn.isEmpty()){
        	
    		int ans = StdIn.readInt();
    	
        	if(ans<1 || ans>6){
    			System.out.println("You input an incorrect value.");
    			System.out.println("The program will now terminate.");
    			return;
    		}

    		System.out.println("");
        	System.out.println("You chose "+ ans);
    		System.out.println("");
    		
			// read in the graph from a file
    		In graphin = new In(args[0]); //Declares new object graphin of type In and sets value to function In with arguments called with program
			EuclideanGraph G = new EuclideanGraph(graphin);//Declares object G of type EuclideanGraph and calls with file graphin
			    		
			Dijkstra dijkstra = new Dijkstra(G);
		
			switch(ans){
			case 1:
				
				//int s = StdIn.readInt();
				System.out.print("Enter starting location (Building): ");
				//int d = StdIn.readInt();
				
				// read in the s-d pairs from standard input
				//Declares new object dijkstra of type Dijkstra and sets value to result of calling Dijkstra with argument G
				//while(!StdIn.isEmpty()) {
					int s = StdIn.readInt();
					System.out.print("Enter destination location (Building): ");
					int d = StdIn.readInt();
					dijkstra.showPath(s, d);
					System.out.println("");
				//}
		       
				break;
			case 2:
				System.out.println("1. ATM");
				System.out.println("2. Vending Machine");
				System.out.println("3. Rest Room");
				System.out.println("4. Public Phone");
				System.out.println("5. Computer Lab");
				System.out.println("6. WiFi");
				System.out.println("7. Security Phone/Guard Station");
				System.out.println("8. Shuttle Bus Stop");
				System.out.println("9. Previous Menu");
				
				System.out.print("Enter option (1 - 9): ");
				int rqst = StdIn.readInt();
				
				if(rqst==9)
					break;
				
				System.out.print("Enter origin location (Building): ");
				int bldg = StdIn.readInt();
				
				double distance = 0.0;
				int dest = 0;
				String resource = "";
				
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
					
					String rsc = "";
					
					switch(rqst)
					{
					case 1:
						rsc = new String("ATM");
						resource = rsc;
						break;
					case 2:
						rsc = new String("Vending");
						resource = new String("vending machine");
						break;
					case 3:
						rsc = new String("RestRoom");
						resource = new String("rest room");
						break;
					case 4:
						rsc = new String("PublicPhone");
						resource = new String("public phone");
						break;
					case 5:
						rsc = new String("ComputerLab");
						resource = new String("computer lab");
						break;
					case 6:
						rsc = resource = new String("WiFi");
						break;
					case 7:
						rsc = new String("Security");
						resource = new String("Security Phone/Guard Station");
						break;
					case 8:
						rsc = new String("BusStop");
						resource = new String("shuttle bus stop");
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
						//String sid = rs2.getString("SID*");
						//
						//System.out.println(sid);
						
						//Integer dst = new Integer(rs2.getString("SID*"));
						
						if(dijkstra.distance(bldg, Integer.parseInt(rs2.getString("SID*")))<distance){
							distance = dijkstra.distance(bldg, Integer.parseInt(rs2.getString("SID*")));
							dest = Integer.parseInt(rs2.getString("SID*"));
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
				
				System.out.print("The closest " + resource + " from ");
				new DataConnect(bldg);
				System.out.print(" is located at ");
				new DataConnect(dest);
				System.out.println("");

				dijkstra.showPath(bldg, dest);
												
				break;
			case 3:
				new BuildingList();
				break;
			case 4:
				
				break;
			case 5:
				new DeptLoc();
				break;
			case 6:
				System.out.println("You have chosen to exit the program.");
				System.out.println("The program will now close.");
				return;		
			}
    		
			System.out.println("");
        	System.out.println("1. Get Directions");
        	System.out.println("2. Find campus resources");
        	System.out.println("3. Display campus building names");
        	System.out.println("4. Display all campus resources");
        	System.out.println("5. Display all department locations");
        	System.out.println("6. Exit");
        	System.out.print("Enter (1 - 6): ");
			
		}
	}
}
