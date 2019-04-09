import static org.junit.Assert.*;

import org.junit.Test;

public class CompetitionTests {
	
    @Test
    public void testDijkstraConstructor() {

    	CompetitionDijkstra acm = new CompetitionDijkstra("\\tinyEWD.txt", 60,70,84);
    	assertEquals(acm.slowestWalkingSpeed, 60);
  
    	acm = new CompetitionDijkstra("\\tinyEWD.txt", 70,60,84);
    	assertEquals(acm.slowestWalkingSpeed, 60);
    	
    	acm = new CompetitionDijkstra("\\tinyEWD.txt", 90,60,50);
    	assertEquals(acm.slowestWalkingSpeed, 50);
    	
    	acm = new CompetitionDijkstra("\\tinyEWD.txt", 70,60,84);
    	assertEquals(acm.validFile, false);
    	
    	acm = new CompetitionDijkstra("\\tinyEWD.txt", 70,60,84);
    	assertEquals(acm.validFile, false);
    	
    }
    
    
    @Test 
    public void testDijkstra() {
    	CompetitionDijkstra acm = new CompetitionDijkstra("\\1000EWD.txt", 60,70,84);
    	assertEquals(acm.slowestWalkingSpeed, 60);
    	acm.timeRequiredforCompetition();
  
    	acm = new CompetitionDijkstra("\\1000EWD.txt", 70,60,84);
    	assertEquals(acm.slowestWalkingSpeed, 60);
    	
    	acm = new CompetitionDijkstra("\\1000EWD.txt", 90,60,50);
    	assertEquals(acm.slowestWalkingSpeed, 50);
    }
    

    @Test
    public void testFWConstructor() {

    	CompetitionFloydWarshall acm = new CompetitionFloydWarshall("\\1000EWD.txt", 60,70,84);
    	assertEquals(acm.slowestWalkingSpeed, 60);
  
    	acm = new CompetitionFloydWarshall("\\1000EWD.txt", 70,60,84);
    	assertEquals(acm.slowestWalkingSpeed, 60);
    	
    	acm = new CompetitionFloydWarshall("\\1000EWD.txt", 90,60,50);
    	assertEquals(acm.slowestWalkingSpeed, 50);
    	
    	acm = new CompetitionFloydWarshall("\\1000EWD.txt", 70,60,84);
    	assertEquals(acm.validFile, false);
    	
    	acm = new CompetitionFloydWarshall("\\1000EWD.txt", 70,60,84);
    	assertEquals(acm.validFile, false);
    }


    @Test
    public void testFW() {
    	CompetitionFloydWarshall acm = new CompetitionFloydWarshall("\\1000EWD.txt", 60,70,84);
    	assertEquals(acm.slowestWalkingSpeed, 60);
    	acm.timeRequiredforCompetition();
  
    	acm = new CompetitionFloydWarshall("\\1000EWD.txt", 70,60,84);
    	assertEquals(acm.slowestWalkingSpeed, 60);
    	
    	acm = new CompetitionFloydWarshall("\\1000EWD.txt", 90,60,50);
    	assertEquals(acm.slowestWalkingSpeed, 50);
    }
    
}
