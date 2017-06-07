package coder1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SolutionTests {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void fiveZeros() {
		assertEquals(0,counting("00000"));
	}
	
	@Test 
	public void fiveOnes() {
		assertEquals(0,counting("11111"));
	}
		
	@Test 
	public void caseOne() {
		assertEquals(3,counting("00110"));
	}
	
	@Test 
	public void caseTwo() {
		assertEquals(2,counting("10001"));
	}
	
	@Test
	public void caseThree() {
		assertEquals(4,counting("10101"));
	}
	
	static int counting(String s) {
		int zeroCount = 0;
		int oneCount = 0;
		int subStrings = 0;
		boolean roll = false;
		int curr = s.charAt(0);
		if (curr == '1') oneCount++;
		else zeroCount++;
		//System.out.println("0 ones = "+oneCount+" zeros = "+zeroCount+" roll = "+roll+" substrings = "+subStrings);
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) != curr) {
				// border case
				subStrings++;
				if (roll) {
					if (zeroCount != 1 && oneCount != 1) {
						if (zeroCount == oneCount) subStrings++;
					}
					roll = false;
					zeroCount = 0;
					oneCount = 0;
				} else {
					roll = true;
				}
			}
			
			curr = s.charAt(i);
			if (curr == '1') oneCount++;
			else zeroCount++;
			//System.out.println(i+" ones = "+oneCount+" zeros = "+zeroCount+" roll = "+roll+" substrings = "+subStrings);

		}
		//System.out.println();
		return subStrings;
	}
	
    static int counting1(String s) {
		int zeroCount = 0;
		int oneCount = 0;
		int subStrings = 0;
		boolean roll = false;
		int curr = s.charAt(0);
		if (curr == '1') oneCount++;
		else zeroCount++;
		System.out.println("0 ones = "+oneCount+" zeros = "+zeroCount+" roll = "+roll+" substrings = "+subStrings);
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				if (curr == '1') {
					oneCount++;
				} else {
					curr = s.charAt(i);
					oneCount++;
					// at border
					subStrings++;
					if (roll) {
						roll = false;
						if (zeroCount == oneCount) subStrings++;
						oneCount = 1;
						zeroCount = 0;
					} else {
						roll = true;
					}
				}
			} else {
				if (curr == '0') {
					zeroCount++;
				} else {
					curr = s.charAt(i);
					zeroCount++;
					// at border
					subStrings++;
					if (roll) {
						roll = false;
						if (zeroCount == oneCount) subStrings++;
						oneCount = 0;
						zeroCount = 1;
					} else {
						roll = true;
					}
				}
			}
			System.out.println(i+" ones = "+oneCount+" zeros = "+zeroCount+" roll = "+roll+" substrings = "+subStrings);
		}
		System.out.println();
    	return subStrings;
    }
}
