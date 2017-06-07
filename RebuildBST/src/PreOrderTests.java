import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class PreOrderTests {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void oneNodeBST() {
		int[] list = {5};
		PreOrder po = new PreOrder(list);
		Node answerRoot = new Node(5);
		checkResults(list, answerRoot);
	} 

	@Test
	public void twoNodeBSTLeftTree()
	{
		int[] list = {5,4};
		Node answerRoot = new Node(5);
		answerRoot.left = new Node(4);
		checkResults(list, answerRoot);	
	}
	
	@Test
	public void twoNodeBSTRightTree()
	{
		int[] list = {4,5};
		PreOrder po = new PreOrder(list);
		Node answerRoot = new Node(4);
		answerRoot.right = new Node(5);
		checkResults(list, answerRoot);	 
	} 
	
	@Test
	public void threeNodeBSTBalanced()
	{
		int[] list = {3,2,4};
		PreOrder po = new PreOrder(list);
		Node answerRoot = new Node(3);
		answerRoot.right = new Node(4);
		answerRoot.left = new Node(2);
		checkResults(list, answerRoot);		
	}
	
	@Test
	public void exampleInput()
	{
		int[] list = {10,5,1,7,40,50};
		PreOrder po = new PreOrder(list);
		Node answerRoot = new Node(10);
		answerRoot.right = new Node(40);
		answerRoot.right.right = new Node(50);
		answerRoot.left = new Node(5);
		answerRoot.left.left = new Node(1);
		answerRoot.left.right = new Node(7);
		checkResults(list, answerRoot);			
	}
	
	private void checkResults(int [] list, Node answerRoot) {
		PreOrder po = new PreOrder(list);
		int [] expectedResult = po.constructBST().check();
		assert(Arrays.equals(answerRoot.check(), expectedResult));
	} 
	
	
}
