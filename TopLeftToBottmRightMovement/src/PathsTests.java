import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PathsTests {

	Paths paths;
	@Before
	public void setUp() throws Exception {
		this.paths = new Paths();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	private void runTest(int n, int[] matrix, int expectedOutput) {
		int [][] input = setupMatrix(matrix,n);
		int actualOutput = this.paths.findPaths(input,n);
		assertEquals(expectedOutput, actualOutput);
	}
	 
	private int[][] setupMatrix(int[] matrix, int n) {
		int [][] input = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				input[i][j] = matrix[i*n+j];
			}
		}
		return input;
	}
	
	@Test
	public void testMatrixSetupMethod() {
		int n = 2;
		String expected = "0110";
		int[] matrix = {0,1,1,0};
		int[][] actual = setupMatrix(matrix,2);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n*n; i++) {
			sb.append(actual[i/n][i%n]);
		}
		assertEquals(expected,sb.toString());
	}

	@Test
	public void oneByOneMatrixOnePath() {
		int n = 1;
		int[] matrix = {1};
		int expectedOutput = 1; 
		this.runTest(n, matrix, expectedOutput);
	}
	
	@Test 
	public void oneByOneMatrixNoPath() {
		int n = 1;
		int[] matrix = {0};
		int expectedOutput = 0;
		this.runTest(n, matrix, expectedOutput);
	}
	
	@Test
	public void twoByTwoMatrixTwoPaths() {
		int n = 2;
		int[] matrix = {1,1,1,1};
		int expectedOutput = 2;
		this.runTest(n, matrix, expectedOutput);
	}
	
	@Test
	public void twoByTwoMatrixOnePath() {
		int n = 2;
		int[] matrix = {1,1,0,1};
		int expectedOutput = 1;
		this.runTest(n, matrix, expectedOutput);
		int[] matrix2 = {1,0,1,1};
		this.runTest(n, matrix2, expectedOutput);
	}
	
	@Test
	public void twoByTwoMatrixNoPaths() {
		int n = 2;
		int[] matrix = {0,0,0,0};
		int expectedOutput = 0;
		this.runTest(n, matrix, expectedOutput);
		int[] matrix2 = {0,1,0,1};
		this.runTest(n, matrix2, expectedOutput);
	}
	
	@Test 
	public void threeByThreeMatrixSixPaths() {
		int n = 3;
		int[] matrix = {1,1,1,1,1,1,1,1,1};
		int expectedOutput = 6;
		this.runTest(n, matrix, expectedOutput);
	}
	
	@Test
	public void threeByThreeMatrixFivePaths() {
		int n = 3;
		int[] matrix = {1,1,0,1,1,1,1,1,1,};
		int expectedOutput = 5;
		this.runTest(n, matrix, expectedOutput);
	}
}
