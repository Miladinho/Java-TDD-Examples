import java.util.ArrayList;

public class Node {
	public int val;
	public Node left;
	public Node right;
	
	public Node()
	{
		this.val = -1;
		this.left = null;
		this.right = null;
	}  
	
	public Node(int val)
	{
		this.val = val;
		this.left = null; 
		this.right = null;
	}

	public int[] check() {
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		bstCheck(this,arrayList);
		
		int [] list = new int[arrayList.size()];
		for(int i = 0; i < arrayList.size(); i++)
		{
			list[i] = arrayList.get(i);
			System.out.print(list[i]+",");
		}
		System.out.println();
		return list; 
	} 
	
	private void bstCheck(Node root, ArrayList<Integer> list)
	{
		if (root == null) return;
		
		list.add(root.val);
		bstCheck(root.left,list);
		bstCheck(root.right,list);
	}
	
}
