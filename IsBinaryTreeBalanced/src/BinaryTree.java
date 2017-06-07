
public class BinaryTree {

	public boolean isBalanced(Node root) throws NullPointerException
	{
		if (root == null)
		{
			throw new NullPointerException("Can't operate on non-existant tree!");
		}
		else if (checkBalance(root) == -1)
		{
			return false;
		} 
		else
		{
			return true; 
		}
	}

	private int checkBalance(Node root) {
		
		if (root == null) return 0;
		
		int left = checkBalance(root.left);
		int right = checkBalance(root.right);
		
		if (leftOrRightTreeImbalanced(left, right)) return -1;
		else if (isHeightDiffMoreThanOne(left,right)) return -1;
		else return heightOfBiggestSubTree(left,right); 
	}

	private boolean leftOrRightTreeImbalanced(int left, int right) 
	{
		return left == -1 || right == -1;
	}	
	
	private boolean isHeightDiffMoreThanOne(int left, int right)
	{
		return Math.abs(left-right) > 1;
	}
	
	private int heightOfBiggestSubTree(int left, int right)
	{
		return 1+Math.max(left, right);
	}

}
