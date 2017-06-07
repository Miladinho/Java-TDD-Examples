package isBinaryTreeBST;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class isBSTTests {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void nullRootNodeReturnsTrue() {
		assertEquals(true,isBst(null));
	}
	
	@Test
	public void oneNodeReturnTrue() {
		assertEquals(true,isBst(new Node(5)));
	}

	@Test
	public void
	private Object isBst(Object object) {
		return true;
	}

}
