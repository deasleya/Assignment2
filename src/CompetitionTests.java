import static org.junit.Assert.*;
//import java.io.*;

import org.junit.Test;

public class CompetitionTests {
	
	String file1 = "C:\\Users\\Owner\\Documents\\2nd Year\\CS2010\\Assignment2\\src\\tinyEWD.txt";
	String file2 = "C:\\Users\\Owner\\Documents\\2nd Year\\CS2010\\Assignment2\\1000EWD.txt";
	
    @Test
    public void testDijkstraConstructor() {
    	CompetitionDijkstra acm = new CompetitionDijkstra(file1, 60,70,84);
    	System.out.println(acm.filename);
    	assertEquals(acm.slowestWalkingSpeed, 60);
    	System.out.println(acm.timeRequiredforCompetition());
    	System.out.println(acm.numberOfIntersections);
    	System.out.println(acm.numberOfStreets);
  
    	acm = new CompetitionDijkstra(file1, 70,60,84);
    	assertEquals(acm.slowestWalkingSpeed, 60);
    	System.out.println(acm.timeRequiredforCompetition());
    	
    	acm = new CompetitionDijkstra(file1, 90,60,50);
    	assertEquals(acm.slowestWalkingSpeed, 50);
    	System.out.println(acm.timeRequiredforCompetition());
    	
    	acm = new CompetitionDijkstra(file1, 70,60,84);
    	assertEquals(acm.validFile, false);
    	System.out.println(acm.timeRequiredforCompetition());
    	
    	acm = new CompetitionDijkstra(file1, 70,60,84);
    	assertEquals(acm.validFile, false);
    	System.out.println(acm.timeRequiredforCompetition());
    	
    }
    
    
    @Test 
    public void testDijkstra() {
    	CompetitionDijkstra acm = new CompetitionDijkstra(file1, 60,70,84);
    	assertEquals(acm.slowestWalkingSpeed, 60);
    	System.out.println(acm.timeRequiredforCompetition());
  
    	acm = new CompetitionDijkstra(file1, 70,60,84);
    	assertEquals(acm.slowestWalkingSpeed, 60);
    	System.out.println(acm.timeRequiredforCompetition());
    	
    	acm = new CompetitionDijkstra(file1, 90,60,50);
    	assertEquals(acm.slowestWalkingSpeed, 50);
    	System.out.println(acm.timeRequiredforCompetition());
    }
    

    @Test
    public void testFWConstructor() {

    	CompetitionFloydWarshall acm = new CompetitionFloydWarshall(file1, 60,70,84);
    	assertEquals(acm.slowestWalkingSpeed, 60);
    	System.out.println(acm.timeRequiredforCompetition());
  
    	acm = new CompetitionFloydWarshall(file1, 70,60,84);
    	assertEquals(acm.slowestWalkingSpeed, 60);
    	System.out.println(acm.timeRequiredforCompetition());
    	
    	acm = new CompetitionFloydWarshall(file1, 90,60,50);
    	assertEquals(acm.slowestWalkingSpeed, 50);
    	System.out.println(acm.timeRequiredforCompetition());
    	
    	acm = new CompetitionFloydWarshall(file1, 70,60,84);
    	assertEquals(acm.validFile, false);
    	System.out.println(acm.timeRequiredforCompetition());
    	
    	acm = new CompetitionFloydWarshall(file1, 70,60,84);
    	assertEquals(acm.validFile, false);
    	System.out.println(acm.timeRequiredforCompetition());
    }


    @Test
    public void testFW() {
    	CompetitionFloydWarshall acm = new CompetitionFloydWarshall(file1, 60,70,84);
    	assertEquals(acm.slowestWalkingSpeed, 60);
    	acm.timeRequiredforCompetition();
  
    	acm = new CompetitionFloydWarshall(file1, 70,60,84);
    	assertEquals(acm.slowestWalkingSpeed, 60);
    	
    	acm = new CompetitionFloydWarshall(file1, 90,60,50);
    	assertEquals(acm.slowestWalkingSpeed, 50);
    }
    
}
