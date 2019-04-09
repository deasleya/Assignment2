/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestants’
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *     Each contestant walks at a given estimated speed.
 *     The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Dijkstra's algorithm
 */

import java.io.*;


public class CompetitionDijkstra {
	
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

 // initialise the array and get slowest person
 	private void initialiseArray() {  
 		try {
 			BufferedReader br = new BufferedReader(new FileReader(filename));
 			numberOfIntersections = Integer.parseInt(br.readLine());
 			numberOfStreets = Integer.parseInt(br.readLine());
 			if (numberOfIntersections == 0 || numberOfStreets == 0)
 				validFile = false;
 			else {
 				cityRoadNetwork = new double[numberOfIntersections][numberOfIntersections]; // create array
 				// init array values to infinite except for a
 				for (int i = 0; i < numberOfIntersections; i++)
 					for (int j = 0; j < numberOfIntersections; j++)
 						cityRoadNetwork[i][j] = INFINITY;

 				// read from file and write to array
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
		
		double longestShortest = 0;
		for (int i = 0; i < numberOfIntersections; i++) {
			double[] distance = new double[numberOfIntersections];
			boolean[] permanent = new boolean[numberOfIntersections];
			boolean[] reached = new boolean[numberOfIntersections];
			int numActive = 1;
			for (int m = 0; m < numberOfIntersections; m++) {
				distance[m] = INFINITY;
				permanent[m] = false;
				reached[m] = false;
			}
			distance[i] = 0;
			reached[i] = true;

			do {
				int currentLowestAddr = getLowestAddr(distance, permanent);
				for (int j = 0; j < numberOfIntersections; j++) {
					if ((cityRoadNetwork[currentLowestAddr][j] + distance[currentLowestAddr]) < distance[j] && !permanent[j]) {
						distance[j] = (cityRoadNetwork[currentLowestAddr][j] + distance[currentLowestAddr]);
						numActive++;
						reached[j] = true;
					}
				}
				permanent[currentLowestAddr] = true;
				numActive--;
			} while (numActive > 0);
			double tmpLS = getHighestValue(distance);
			if (tmpLS == INFINITY)
				return -1;
			longestShortest = (tmpLS > longestShortest) ? tmpLS : longestShortest;
		}
		longestShortest *= 1000; // convert to meters
		return (int) Math.ceil(longestShortest / slowestWalkingSpeed);
		
    }

    
    private int getLowestAddr(double[] arr, boolean[] perm) {
		int lowest = 0;
		for (int i = 1; i < arr.length; i++)
			if((arr[i] < arr[lowest] && !perm[i]) || perm[lowest]) 
				lowest = i;
		return lowest;
	}

	private double getHighestValue(double[] arr) {
		double highest = 0;
		for (int i = 0; i < arr.length; i++)
			if(arr[i] > highest) 
				highest = arr[i];
		return highest;
	}
}
