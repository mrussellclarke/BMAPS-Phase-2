import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    	BufferedReader bred = new BufferedReader(new InputStreamReader(System.in));
    	int ans;
    	
    	System.out.println("1. Get Directions");
    	System.out.println("2. Find campus resources");
    	System.out.println("3. Display campus building names");
    	System.out.println("4. Display all campus resources");
    	System.out.println("5. Display all department locations");
    	System.out.println("6. Exit");
    	System.out.print("Enter (1 - 6): ");

		ans = StdIn.readInt();
	
    	if(ans>=1 && ans<=6){
    		System.out.println("You chose "+ ans);
    		System.out.println();
    		switch(ans){
    		case 1:
					
    			// read in the graph from a file
    			In graphin = new In(args[0]); //Declares new object graphin of type In and sets value to function In with arguments called with program
    			EuclideanGraph G = new EuclideanGraph(graphin);//Declares object G of type EuclideanGraph and calls with file graphin
    			//System.err.println("Done reading the graph " + args[0]);
    			//System.err.println("Enter query pairs from stdin");
    			System.out.println("Enter starting location (Building): ");
    			//int srt = StdIn.readInt();
    			System.out.println("Enter destination location (Building): ");
				//int fin = StdIn.readInt();
    			
    			// read in the s-d pairs from standard input
    			Dijkstra dijkstra = new Dijkstra(G);
    			//Declares new object dijkstra of type Dijkstra and sets value to result of calling Dijkstra with argument G
    			while(!StdIn.isEmpty()) {
    				int s = StdIn.readInt();
    				int d = StdIn.readInt();
    				dijkstra.showPath(s, d);
    				System.out.println();
    			}
		       
    			break;
    		case 2:
    			System.out.println("1. ATM");
    			System.out.println("2. Public Phone");
    			System.out.println("3. WiFi Hot Spot");
    			System.out.println("4. Security Phone/Guard Station");
    			System.out.println("5. Vending Machine");
    			System.out.println("6. Rest Room");
    			System.out.println("7. Shuttle Bus Stop");
    			System.out.println("8. Computer Lab");
    			System.out.println("9. Previous Menu");
    			
    			System.out.print("Enter resource (1 - 9):");
    			int rsc = StdIn.readInt();
    			System.out.print("Enter origin location (Building):");
    			int bldg = StdIn.readInt();
    			
    			
    			
    			break;
    		case 3:

				break;
			case 4:
			
				break;
			case 5:
			
				break;
			case 6:
			
				break;		
			}
    	}
		else{
			System.out.println("You input an incorrect value.");
		}
		
/*
        // read in the graph from a file
        In graphin = new In(args[0]); //Declares new object graphin of type In and sets value to function In with arguments called with program 
        EuclideanGraph G = new EuclideanGraph(graphin);//Declares object G of type EuclideanGraph and calls with file graphin
        System.err.println("Done reading the graph " + args[0]);
        System.err.println("Enter query pairs from stdin");

        // read in the s-d pairs from standard input
        Dijkstra dijkstra = new Dijkstra(G);//Declares new object dijkstra of type Dijkstra and sets value to result of calling Dijkstra with argument G
        while(!StdIn.isEmpty()) {
            int s = StdIn.readInt();
            int d = StdIn.readInt();
            dijkstra.showPath(s, d);
            System.out.println();
        }
*/
    }
}
