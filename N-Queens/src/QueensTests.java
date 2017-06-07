import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class QueensTests {
	private Queens q;
	@Before
	public void setUp() throws Exception {
		this.q = new Queens();
	}

	@After
	public void tearDown() throws Exception {
	}

	
	public void zeroBoardTest() {
		validateResult(0, 0);
	}

	private void validateResult(int n, int expectedResult) {
		assertEquals(expectedResult,this.q.solve(n));
	}

	@Test
	public void oneByOneBoardTest()
	{
		validateResult(1, 1);		
	}
	
	@Test
	public void twoByTwoBoardTest()
	{
		validateResult(2,0);
	}
	
	@Test
	public void threeByThreeBoardTest()
	{
		validateResult(3, 0);
	}
	
	@Test
	public void fourByfourBoardTest()
	{
		validateResult(4,2);
	}
	
	@Test
	public void fiveByFiveBoardTest()
	{
		validateResult(5,10);
	}
	
}
