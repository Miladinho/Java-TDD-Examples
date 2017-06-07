import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BinaryTreeTests {
	
	private BinaryTree bt;
	
	@Before
	public void setUp() throws Exception {
		this.bt = new BinaryTree();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test(expected=NullPointerException.class)
	public void emptyTreeShouldReturnFalse() {
		bt.isBalanced(null);
	}
	
	@Test
	public void rootNodeTreeShouldReturnTrue()
	{
		Node root = new Node(5);
		checkTestResults(true,root);
	}
	
	@Test 
	public void bigLeftTreeShouldReturnFalse()
	{
		Node root = new Node(5);
		root.left = new Node(4);
		root.left.left = new Node(3);
		checkTestResults(false,root);
	}

	@Test
	public void bigRightTreeShouldReturnFalse()
	{
		Node root = new Node(5);
		root.left = new Node(4);
		root.right = new Node(3);
		root.right.right = new Node(10);
		root.right.right.right = new Node(2);
		root.right.right.left = new Node(0);
		checkTestResults(false,root);
	}
	
	private void checkTestResults(boolean expectedAnswer, Node root) {
		assertEquals(expectedAnswer,this.bt.isBalanced(root));
	}
	

}
