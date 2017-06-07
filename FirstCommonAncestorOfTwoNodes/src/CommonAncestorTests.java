import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CommonAncestorTests {
	Tree t;
	
	@Before
	public void setUp() throws Exception {
		t = new Tree();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void GraphSizeLessThanThree_NoAncestor() {
		Node a = new Node(1);
		Node b = new Node(3);
		Node result = t.findCommonAncestor(a,b);
		assertEquals(result,null);
	}
	
	@Test
	public void GraphSizeGreaterThanThree_NoAncestor() {
		Node a = new Node(2);
		Node b = new Node(5);
		Node p = new Node(9);
		p.left = a;
		p.right = b;
		t.root = p;
		Node result = t.findCommonAncestor(a, b)
	}

}

