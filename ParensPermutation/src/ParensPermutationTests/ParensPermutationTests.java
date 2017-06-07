package ParensPermutationTests;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ParensPermutation.ParensPermutation;

public class ParensPermutationTests {

	@Before
	public void setUp() throws Exception 
	{
	}

	@After
	public void tearDown() throws Exception 
	{
	}

	@Test
	public void inputOneShouldReturnOneParens() 
	{
		compareParensLists(1,"()");
	}
	
	@Test
	public void inputTwoShouldReturnTwoParens()
	{
		compareParensLists(2,"()(),(())");
	}

	@Test
	public void inputThreeShouldReturnFiveParens()
	{
		compareParensLists(3,"()()(),(())(),()(()),((())),(()())");
	}
	
	@Test
	public void inputFourShouldReturn()
	{
		compareParensLists(4,"()()()(),(())()(),()(())(),()()(()),"
				+ "((()))(),(((()))),()((())),(())(())"
				+ "(()()()),((");
	}
	
	private void compareParensLists(int n, String items) {
		ParensPermutation pp = new ParensPermutation();
		List<String> result = pp.doParensPermutation(n);
		List<String> answer = Arrays.asList(items.split(","));
		Collections.sort(answer);
		Collections.sort(result);
		assertEquals(answer, result);
	}
	
	

}
