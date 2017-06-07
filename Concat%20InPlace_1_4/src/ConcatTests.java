import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConcatTests {

	private Concat cc;
	
	@Before
	public void setUp() throws Exception {
		this.cc = new Concat();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void concatEmptyArray() {
		char[] input = {};
		int trueSize = 0;
		assertEquals(input, cc.concatenate(input,trueSize));
	}
	
	@Test
	public void concatArrayWithNOSpaces()
	{
		char[] input = {'M','i','l','a','d'};
		int trueSize = 5;
		assertEquals(input, cc.concatenate(input,trueSize)); 
	}
	
	@Test
	public void concatOneSpaceAfter()
	{
		char [] input = {'a',' ',' ',' '};
		char [] expectedAnswer = {'a','%','2','0'};
		assertEquals(new String(expectedAnswer),new String(this.cc.concatenate(input, 2)));
	}
	
	@Test 
	public void concatOneSpaceBefore()
	{
		char [] input = {' ','a',' ',' '};
		char [] expectedAnswer = {'%','2','0','a'};
		assertEquals(new String(expectedAnswer),new String(this.cc.concatenate(input, 2)));
	}

}
