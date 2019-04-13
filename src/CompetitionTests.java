/*	
1. Justify the choice of the data structures used in CompetitionDijkstra and
CompetitionFloydWarshall
Array implementation is the optimal for dense graphs (and the easiest to implement), and given the likelihood of having to handle
a big city input, this is the implementation I feel is most suitable.
2. Explain theoretical differences in the performance of Dijkstra and Floyd-Warshall algorithms
in the given problem. Also explain how would their relative performance be affected by the
density of the graph. Which would you choose in which set of circumstances and why?
Dijkstra works from one node to one goal, and we would expect it to run in O(V^2)
Floyd-Warshall works with pairs and is more exhaustive. We would expect it to run in O(V^3), slower than Dijkstra, but given the nature of this problem, probably the more suitable approach.
*/ 

//@author Aine Deasley

import static org.junit.Assert.*;

import org.junit.Test;

public class CompetitionTests {

	String file1 = "C:\\Users\\Owner\\Documents\\2nd Year\\CS2010\\tinyEWD.txt";
	String file2 = "C:\\Users\\Owner\\Documents\\2nd Year\\CS2010\\1000EWD.txt";
	//String file2 = "C://Users//Owner//Documents//2nd Year//CS2010//Assignment2//1000EWD.txt";
	//String file1 = "tinyEWD.txt";
	//String file2 = "1000EWD.txt";
	int result;
	
    @Test
    public void testDijkstraConstructor() {
    	//String file1 = "C:\\Users\\Owner\\Documents\\2nd Year\\CS2010\\tinyEWD.txt";
    	int sA=60, sB=80, sC=50;
    	//System.out.println(file2);
    	CompetitionDijkstra acm = new CompetitionDijkstra(file2, sA,sB,sC);
    	assertEquals(50, acm.slowestWalkingSpeed);
    	result = acm.timeRequiredforCompetition();
    	System.out.println(result);
    }
 
/*
    @Test 
    public void testDijkstra() {

    	CompetitionDijkstra comp = new CompetitionDijkstra("input-I.txt", 60,70,84);

    	assertEquals("constructor failed with valid input", comp.slowest, 60);

    	comp.timeRequiredforCompetition();

  

    	comp = new CompetitionDijkstra("input-J.txt", 70,60,84);

    	assertEquals("constructor failed with valid input", comp.slowest, 60);

    	

    	comp = new CompetitionDijkstra("input-J.txt", 90,60,50);

    	assertEquals("constructor failed with valid input", comp.slowest, 50);

    }



    @Test

    public void testFWConstructor() {

    	CompetitionFloydWarshall comp = new CompetitionFloydWarshall("input-I.txt", 60,70,84);

    	assertEquals("constructor failed with valid input", comp.slowest, 60);

  

    	comp = new CompetitionFloydWarshall("input-J.txt", 70,60,84);

    	assertEquals("constructor failed with valid input", comp.slowest, 60);

    	

    	comp = new CompetitionFloydWarshall("input-J.txt", 90,60,50);

    	assertEquals("constructor failed with valid input", comp.slowest, 50);

    	

    	comp = new CompetitionFloydWarshall("notARealInputFile.txt", 70,60,84);

    	assertEquals("constructor failed with valid input", comp.fileInvalid, true);

    	

    	comp = new CompetitionFloydWarshall("input-noStreets.txt", 70,60,84);

    	assertEquals("constructor failed with valid input", comp.fileInvalid, true);

    }

    

    @Test

    public void testFW() {

    	CompetitionFloydWarshall comp = new CompetitionFloydWarshall("input-I.txt", 60,70,84);

    	assertEquals("constructor failed with valid input", comp.slowest, 60);

    	comp.timeRequiredforCompetition();

  

    	comp = new CompetitionFloydWarshall("input-J.txt", 70,60,84);

    	assertEquals("constructor failed with valid input", comp.slowest, 60);

    	

    	comp = new CompetitionFloydWarshall("input-J.txt", 90,60,50);

    	assertEquals("constructor failed with valid input", comp.slowest, 50);

    }*/
    
}
    
    
    