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

//Created text file invalidFile to test case where there are 0  intersections

//@author Aine Deasley

import static org.junit.Assert.*;

import org.junit.Test;

public class CompetitionTests {

	String file1 = "C:\\Users\\Owner\\Documents\\2nd Year\\CS2010\\tinyEWD.txt";
	String file2 = "C:\\Users\\Owner\\Documents\\2nd Year\\CS2010\\1000EWD.txt";
	int result;
	int expectedResult;
	int sA, sB, sC;
	
   
    @Test 
    public void testDijkstra() {

    	//Valid file, valid input
    	sA=60;
    	sB=80;
    	sC=75;
    	CompetitionDijkstra acm = new CompetitionDijkstra("tinyEWD.txt", sA,sB,sC);
    	assertEquals(60, acm.slowestWalkingSpeed);
    	assertEquals(true, acm.validFile);
    	expectedResult = 31;
    	result = acm.timeRequiredforCompetition();
    	assertEquals(expectedResult, result);
    	
    	//Valid file, invalid input (sA < 50)
    	sA=40;
    	sB=80;
    	sC=50;
    	acm = new CompetitionDijkstra("tinyEWD.txt", sA,sB,sC);
    	assertEquals(40, acm.slowestWalkingSpeed);
    	assertEquals(true, acm.validFile);
    	expectedResult = -1;
    	result = acm.timeRequiredforCompetition();
    	assertEquals(expectedResult, result);
    	
    	//Invalid file
    	sA=90;
    	sB=80;
    	sC=50;
    	acm = new CompetitionDijkstra("invalidFile.txt", sA,sB,sC);
    	assertEquals(50, acm.slowestWalkingSpeed);
    	assertEquals(false, acm.validFile);
    	expectedResult = -1;
    	result = acm.timeRequiredforCompetition();
    	assertEquals(expectedResult, result);

    }



    @Test

    public void testFloydWarshall() {

    	//Valid file, valid input
    	sA=90;
    	sB=80;
    	sC=50;
    	CompetitionFloydWarshall acm = new CompetitionFloydWarshall("tinyEWD.txt", sA,sB,sC);
    	assertEquals(50, acm.slowestWalkingSpeed);
    	result = acm.timeRequiredforCompetition();
    	expectedResult = 38;
    	result = acm.timeRequiredforCompetition();
    	assertEquals(expectedResult, result);
    	
    	//Valid file, invalid input (sA < 50)
    	sA=40;
    	sB=80;
    	sC=50;
    	acm = new CompetitionFloydWarshall("tinyEWD.txt", sA,sB,sC);
    	assertEquals(40, acm.slowestWalkingSpeed);
    	assertEquals(true, acm.validFile);
    	expectedResult = -1;
    	result = acm.timeRequiredforCompetition();
    	assertEquals(expectedResult, result);
    	
    	//invalid file
    	sA=90;
    	sB=80;
    	sC=50;
    	acm = new CompetitionFloydWarshall("invalidFile.txt", sA,sB,sC);
    	assertEquals(50, acm.slowestWalkingSpeed);
    	assertEquals(false, acm.validFile);
    	expectedResult = -1;
    	result = acm.timeRequiredforCompetition();
    	assertEquals(expectedResult, result);

    }
    
}
    
    
    