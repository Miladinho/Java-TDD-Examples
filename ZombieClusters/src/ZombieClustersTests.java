import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ZombieClustersTests {
	
	ZombieClusters zc;
	
	@Before
	public void setUp() throws Exception {
		this.zc = new ZombieClusters();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	private void run (String matrix, int expectedOutput) {
		String[] input = matrix.split(",");
		int actualOutput = zc.findClusters(input);
		assertEquals(expectedOutput,actualOutput);
	}
	
	@Test
	public void noZombies() {
		String[] input = new String[0];
		int expectedOutput = 0;
		int actualOutput = zc.findClusters(input);
		assertEquals(expectedOutput, actualOutput);
		assertEquals(0,zc.findClusters(null));
	}
	
	@Test 
	public void oneZombieOneCluster() {
		String matrix = "1";
		int expectedOutput = 1;
		this.run(matrix, expectedOutput);
	}
	
	@Test
	public void twoZombiesOneCluster() {
		String matrix = "11,11";
		int expectedOutput = 1;
		this.run(matrix, expectedOutput);
	}
	
	@Test
	public void twoZombiesTwoClusters() {
		String matrix = "10,01";
		int expectedOutput = 2;
		this.run(matrix, expectedOutput);
	}
	
	@Test
	public void threeZombiesThreeClusters() {
		String matrix = "100,010,001";
		int expectedOutput = 3;
		this.run(matrix, expectedOutput);
	}
	
	@Test
	public void threeZombiesTwoClusters() {
		String matrix = "110,110,001";
		int expectedOutput = 2;
		this.run(matrix, expectedOutput);
		matrix = "100,011,011";
		this.run(matrix, expectedOutput);
	}
	
	@Test
	public void threeZombiesOneClusters() {
		String matrix = "111,111,111";
		int expectedOutput = 1;
		this.run(matrix, expectedOutput);
		matrix = "110,111,011";
		this.run(matrix, expectedOutput);
	}
	

}
