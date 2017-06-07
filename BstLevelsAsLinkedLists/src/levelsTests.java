import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class levelsTests {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void nullEntryReturnsEmptyResult() {
		ArrayList<LinkedList<Node>> result = Levels.getLevels(null);
		
	}
	
	public boolean assertArrayListsEqual(ArrayList<LinkedList<Node>> actualResult, ArrayList<LinkedList<Node>> expectedResult) {
		for (LinkedList<Node> array : actualResult) {
			for (Node node : array) {
				
				if (node.val != )
			}
		}
	}
}
