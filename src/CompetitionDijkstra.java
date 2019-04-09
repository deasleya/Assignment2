/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestantsâ€™
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *    (i) · Each contestant walks at a given estimated speed.
 *    (ii)· The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Dijkstra's algorithm
 */

import java.io.*;

public class CompetitionDijkstra {
	
	/*public static void main(String[] args){
		BufferedReader br;
		try {
			FileReader fr = new FileReader("C:\\Users\\Owner\\Documents\\2nd Year\\CS2010\\Assignment2\\src\\tinyEWD.txt");
			br = new BufferedReader(fr);
			String line = null;
			//line = br.readLine();
			int is = Integer.parseInt(br.readLine());
			int stre = Integer.parseInt(br.readLine());
			System.out.println(is + "\n" + stre);
			 while ((line=br.readLine()) != null) {
			   System.out.println(line);
			 }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}*/
	
	private static final double INFINITY = Integer.MAX_VALUE;
	
	String filename;
	int sA, sB, sC;
	int numberOfIntersections, numberOfStreets;
	boolean validFile = true;
	double[][] cityRoadNetwork;
	int slowestWalkingSpeed;
	
    /**
     * @param filename: A filename containing the details of the city road network
     * @param sA, sB, sC: speeds for 3 contestants
    */
    CompetitionDijkstra (String filename, int sA, int sB, int sC){

       this.filename = filename;
       this.sA = sA;
       this.sB = sB;
       this.sC = sC;
       
       initialiseArray();
       
       if (sA < sB && sA < sC)
			slowestWalkingSpeed = sA;
		else if (sB < sA && sB < sC)
			slowestWalkingSpeed = sB;
		else
			slowestWalkingSpeed = sC;
    }

 //create an array to implement Dijkstra shortest path algorithm
 	private void initialiseArray() {  
 		try {
 			FileReader fr = new FileReader(filename);
 			BufferedReader br = new BufferedReader(fr);
 			numberOfIntersections = Integer.parseInt(br.readLine());
 			numberOfStreets = Integer.parseInt(br.readLine());
 			if (numberOfIntersections == 0 || numberOfStreets == 0)
 				validFile = false;
 			else {
 				cityRoadNetwork = new double[numberOfIntersections][numberOfIntersections]; //initialise array
 				for (int i = 0; i < numberOfIntersections; i++)
 					for (int j = 0; j < numberOfIntersections; j++)
 						cityRoadNetwork[i][j] = INFINITY;  //Begin by setting all values in array to infinity

 				//read file and add to array
 				String line = br.readLine();
 				while (line != null) {
 					String[] linesInFile = line.split(" ");
 					cityRoadNetwork[Integer.parseInt(linesInFile[0])][Integer.parseInt(linesInFile[1])] = Double.parseDouble(linesInFile[2]);
 				}
 				br.close();
 			}
 		} catch (Exception e) {
 			validFile = false;
 		}

 		
 	}

    /**
    * @return int: minimum minutes that will pass before the three contestants can meet
     */
    public int timeRequiredforCompetition(){

    	if ((sA > 100 || sA < 50) || (sB > 100 || sB < 50) || (sC > 100 || sC < 50))
			return -1;
		if (!validFile)
			return -1;
		
		double worstCaseDistance = 0;
		for (int i = 0; i < numberOfIntersections; i++) {
			double[] distanceTo = new double[numberOfIntersections];
			boolean[] permanentNode = new boolean[numberOfIntersections];
			boolean[] beenReached = new boolean[numberOfIntersections];
			int activeNodes = 1;
			for (int m = 0; m < numberOfIntersections; m++) {
				distanceTo[m] = INFINITY;
				permanentNode[m] = false;
				beenReached[m] = false;
			}
			distanceTo[i] = 0;
			beenReached[i] = true;

			while (activeNodes > 0){
				int nextIntersection = getShortestPath(distanceTo, permanentNode);
				for (int j = 0; j < numberOfIntersections; j++) {
					if ((cityRoadNetwork[nextIntersection][j] + distanceTo[nextIntersection]) < distanceTo[j] && !permanentNode[j]) {
						distanceTo[j] = (cityRoadNetwork[nextIntersection][j] + distanceTo[nextIntersection]);
						activeNodes++;
						beenReached[j] = true;
					}
				}
				permanentNode[nextIntersection] = true;
				activeNodes--;
			} 
			double temp = getHighestValue(distanceTo);
			if (temp == INFINITY)
				return -1;
			if(temp > worstCaseDistance)
				worstCaseDistance = temp;
		}
		worstCaseDistance *= 1000; // convert to meters
		return (int) Math.ceil(worstCaseDistance / slowestWalkingSpeed);  //return worst case time
		
    }

    
    private int getShortestPath(double[] a, boolean[] permanent) {
		int lowest = 0;
		for (int i = 1; i < a.length; i++)
			if((a[i] < a[lowest] && !permanent[i]) || permanent[lowest]) 
				lowest = i;
		return lowest;
	}

	private double getHighestValue(double[] a) {
		double highest = 0;
		for (int i = 0; i < a.length; i++)
			if(a[i] > highest) 
				highest = a[i];
		return highest;
	}
}
