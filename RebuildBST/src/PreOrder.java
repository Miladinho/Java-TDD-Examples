
public class PreOrder {
	
	private int[] list;
	
	public PreOrder(int[] list)
	{
		this.list = list;
	}
	
	public Node constructBST() {
		Node root = new Node(this.list[0]);
		Node tempLeft = root;
		Node tempRight = root;
		Node [] nodeList = new Node[this.list.length];
		nodeList[0] = root;
		int indexJ = 1;
		//System.out.println("Root = "+root.val);
		for (int i = 1; i < this.list.length; i++)
		{
			if (this.list[i] < tempLeft.val) 
			{
				tempLeft.left = new Node(this.list[i]);
				nodeList[i] = tempLeft.left;
				tempLeft = tempLeft.left;
				//System.out.println("Left = "+root.left.val);
			}
			else if (this.list[i] > tempRight.val)
			{
				// switch side of tree
				Node n = new Node(this.list[i]);
				nodeList[i] = n;
				tempRight.right = n;
				tempLeft = n;
				tempRight = n;
			}  
			else // right child 
			{ 
				Node n = new Node(this.list[i]);
				System.out.println("nodeList length = "+nodeList.length+ 
						" i = "+i+" indexJ = "+indexJ); 
				for (int j = indexJ; j < nodeList.length; j++)
				{
					System.out.println("Nulltest "+nodeList[j].val);
					if (this.list[i] > nodeList[j].val)
					{
						nodeList[j].right = n;
						nodeList[i] = n;
						tempLeft = n;
						indexJ = i; 
						break;
					} 
				}  
			}
		}
		return root;
	}
	
}
