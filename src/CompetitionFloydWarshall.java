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
 * This class implements the competition using Floyd-Warshall algorithm
 */

import java.io.*;


public class CompetitionFloydWarshall {
	
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
    CompetitionFloydWarshall (String filename, int sA, int sB, int sC){

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
    
    // initialise the array
 	private void initialiseArray() {
 		System.out.println(Integer.MAX_VALUE);   
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

		// run Floyd Warshall
		for (int k = 0; k < numberOfIntersections; k++)
			for (int i = 0; i < numberOfIntersections; i++)
				for (int j = 0; j < numberOfIntersections; j++)
					if (cityRoadNetwork[i][k] + cityRoadNetwork[k][j] < cityRoadNetwork[i][j])
						cityRoadNetwork[i][j] = cityRoadNetwork[i][k] + cityRoadNetwork[k][j];

		double max = getMax();
		if (max == INFINITY)
			return -1;
		max *= 1000; // convert to meters
		return (int) Math.ceil(max / slowestWalkingSpeed);
    }
    
 // gets the largest num in the array
 	private double getMax() {
 		double max = -1;
 		for (int i = 0; i < numberOfIntersections; i++)
 			for (int j = 0; j < numberOfIntersections; j++)
 				if(cityRoadNetwork[i][j] > max && i != j) 
 					max = cityRoadNetwork[i][j];
 		return max;
 	}

}