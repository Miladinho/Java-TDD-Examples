package MaxHeap.MaxHeapTests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import MaxHeap.MaxHeap;

public class MaxHeapifyTests {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	private void testEqualityOfHeapArrays(int[] inputArray, int[] resultArray) {
		MaxHeap mh = new MaxHeap(inputArray);
		assert(Arrays.equals(resultArray, mh.maxHeapify()));
	}
	
	@Test
	public void emptyArrayShouldReturnEmptyArray() {
		int[] inputArray = {};
		this.testEqualityOfHeapArrays(inputArray,inputArray);
	}
	
	@Test
	public void OneElementArrayShouldReturnSameArray() {
		int[] inputArray = {1};
		this.testEqualityOfHeapArrays(inputArray,inputArray);
	}
	
	@Test
	public void TwoElementArrayShouldBeSortedInDescendingOrder() {
		int[] inputArray = {1,2};
		int[] resultArray = {2,1};
		this.testEqualityOfHeapArrays(inputArray, resultArray);
	}
	
	@Test
	public void ThreeElementArrayShouldBeSortedInDescendingOrder() {
		int[] inputArray = {40,32,51};
		int[] resultArray = {51,40,32};
		this.testEqualityOfHeapArrays(inputArray, resultArray);
	}

}
