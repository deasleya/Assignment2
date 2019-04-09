import static org.junit.Assert.*;

import org.junit.Test;

public class CompetitionTests {
	
    @Test
    public void testDijkstraConstructor() {

    	CompetitionDijkstra comp = new CompetitionDijkstra("1000EWD.txt", 60,70,84);
    	assertEquals("constructor failed with valid input", comp.slowestWalkingSpeed, 60);
  
    	comp = new CompetitionDijkstra("C:\\Users\\Owner\\Documents\\2nd Year\\CS2010\\Assignment2\\1000EWD.txt", 70,60,84);
    	assertEquals("constructor failed with valid input", comp.slowestWalkingSpeed, 60);
    	
    	comp = new CompetitionDijkstra("C:\\Users\\Owner\\Documents\\2nd Year\\CS2010\\Assignment2\\1000EWD.txt", 90,60,50);
    	assertEquals("constructor failed with valid input", comp.slowestWalkingSpeed, 50);
    	
    	comp = new CompetitionDijkstra("C:\\Users\\Owner\\Documents\\2nd Year\\CS2010\\Assignment2\\1000EWD.txt", 70,60,84);
    	assertEquals("constructor failed with valid input", comp.validFile, false);
    	
    	comp = new CompetitionDijkstra("C:\\Users\\Owner\\Documents\\2nd Year\\CS2010\\Assignment2\\1000EWD.txt", 70,60,84);
    	assertEquals("constructor failed with valid input", comp.validFile, false);
    	
    }
    
    
    @Test 
    public void testDijkstra() {
    	CompetitionDijkstra comp = new CompetitionDijkstra("input-I.txt", 60,70,84);
    	assertEquals("constructor failed with valid input", comp.slowestWalkingSpeed, 60);
    	comp.timeRequiredforCompetition();
  
    	comp = new CompetitionDijkstra("input-J.txt", 70,60,84);
    	assertEquals("constructor failed with valid input", comp.slowestWalkingSpeed, 60);
    	
    	comp = new CompetitionDijkstra("input-J.txt", 90,60,50);
    	assertEquals("constructor failed with valid input", comp.slowestWalkingSpeed, 50);
    }
    

    @Test
    public void testFWConstructor() {

    	CompetitionFloydWarshall comp = new CompetitionFloydWarshall("input-I.txt", 60,70,84);
    	assertEquals("constructor failed with valid input", comp.slowestWalkingSpeed, 60);
  
    	comp = new CompetitionFloydWarshall("input-J.txt", 70,60,84);
    	assertEquals("constructor failed with valid input", comp.slowestWalkingSpeed, 60);
    	
    	comp = new CompetitionFloydWarshall("input-J.txt", 90,60,50);
    	assertEquals("constructor failed with valid input", comp.slowestWalkingSpeed, 50);
    	
    	comp = new CompetitionFloydWarshall("notARealInputFile.txt", 70,60,84);
    	assertEquals("constructor failed with valid input", comp.validFile, false);
    	
    	comp = new CompetitionFloydWarshall("input-noStreets.txt", 70,60,84);
    	assertEquals("constructor failed with valid input", comp.validFile, false);
    }


    @Test
    public void testFW() {
    	CompetitionFloydWarshall comp = new CompetitionFloydWarshall("input-I.txt", 60,70,84);
    	assertEquals("constructor failed with valid input", comp.slowestWalkingSpeed, 60);
    	comp.timeRequiredforCompetition();
  
    	comp = new CompetitionFloydWarshall("input-J.txt", 70,60,84);
    	assertEquals("constructor failed with valid input", comp.slowestWalkingSpeed, 60);
    	
    	comp = new CompetitionFloydWarshall("input-J.txt", 90,60,50);
    	assertEquals("constructor failed with valid input", comp.slowestWalkingSpeed, 50);
    }
    
}
