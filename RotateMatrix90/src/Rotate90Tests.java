import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Rotate90Tests {
	
	private Matrix x;
	
	@Before
	public void setUp() throws Exception {
		this.x = new Matrix();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void rotateEmptyMatrix() {
		char [][] input = {{}};
		this.assertMatricesAreEqual(input,input);
	}
	
	@Test
	public void rotateOneByOneMatrix()
	{
		char[][] input = {{'a'}};
		this.assertMatricesAreEqual(input,input);
	}
	
	@Test
	public void rotateTwoByTwoMatrix()
	{
		char[][] input = {{'a','b'},{'c','d'}};
		char[][] expectedResult = {{'c','a'},{'d','b'}};
		this.assertMatricesAreEqual(input, expectedResult);
	}
	
	@Test
	public void rotateThreeByThreeMatrix()
	{
		char[][] input = {{'a','b','c'},{'d','e','f'},{'g','h','i'}};
		char[][] expectedResult = {{'g','d','a'},{'h','e','b'},{'i','f','c'}};
		this.assertMatricesAreEqual(input, expectedResult);
	}
	
	@Test
	public void rotateFourByFourMatrix()
	{
		char[][] input = { {'a','b','c','d'},{'e','f','g','h'},
						   {'i','j','k','l'},{'m','n','o','p'} };
		char[][] expectedResult = { {'m','i','e','a'},{'n','j','f','b'},
				  					{'o','k','g','c'},{'p','l','h','d'} };
		this.assertMatricesAreEqual(input, expectedResult);		
	}
	
	/* Helper methods*/
	
	private void assertMatricesAreEqual(char[][] input,char[][] expectedResult) {
		assertEquals(true,compareMatrices(expectedResult,this.x.rotateNinety(input)));
	}
	
	private boolean compareMatrices(char[][] first, char[][] second)
	{
		for (int i = 0; i < first.length; i++)
		{
			for (int j = 0; j < first[i].length; j++)
			{
				if (first[i][j] != second[i][j])
				{
					return false;
				}
			}
		}
		return true;
	}

}
