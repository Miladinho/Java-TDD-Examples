import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PathFinderTests {
	
	private PathFinder pf;
	
	@Before
	public void setUp() throws Exception {
		this.pf = new PathFinder();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void beginWordSimilarToEndWord()
	{
		String[] dictionary = {"COG"};
		int expectedLength = 2;
		String beginWord = "HIT";
		String endWord = "HAT";
		evalResult(dictionary, expectedLength, beginWord, endWord);		
	} 
	
	@Test
	public void dictionarySizeOneHasNoAnswer() { 
		String[] dictionary = {"COG"};
		int expectedLength = 0;
		String beginWord = "CUT";
		String endWord = "HAT";
		evalResult(dictionary, expectedLength, beginWord, endWord);
	}

	@Test
	public void dictionarySizeOneHasAnswer()
	{
		String [] dictionary = {"DOT"};
		evalResult(dictionary,3,"LOT","DOG");
	}
	
	@Test
	public void dictionaryCaseOneHasAnswer()
	{
		String[] dictionary = {"hot","dot","lot","log"}; // ,"dog"
		evalResult(dictionary,5,"hit","cog");
		
	}
	
	private void evalResult(String[] dictionary, int expectedLength, String beginWord, String endWord) {
		int actualLength = this.pf.findShortestPath(beginWord,endWord,dictionary);
		assertEquals(expectedLength,actualLength);
	}
}
