import java.util.LinkedList;
import java.util.Queue;

public class Node {
	
	private int value;
	private Node[] outgoingConnections;
	private Node[] incomingConnections;
	private boolean visited;
	
	public boolean doesPathExist(Node start, Node finish)
	{
		Queue<Node> queue = new LinkedList<Node>();

		queue.add(start);
		while(queue.size() != 0)
		{
			Node n = queue.remove();
			for (int i = 0; i < n.getOutgoingConnectionsList().length; i++)
			{
				Node k = n.getOutgoingConnectionsList()[i];
				if (!k.visited)
				{
					k.visited = true;
					if (k == finish)
					{
						return true;
					}
					queue.add(k);
				}
			}
		} 
		return false;
	}
	
	private Node[] getOutgoingConnectionsList() {
		return this.outgoingConnections;
	}

	public Node(int i) {
		this.value = i;
		this.outgoingConnections = new Node[0];
		this.incomingConnections = new Node[0];
		this.visited = false;
	}

	public void addOutgoingConnections(Node[] outgoing) {
		this.outgoingConnections = outgoing;		
	}

	public void addIncomingList(Node[] incoming) {
		this.incomingConnections = 	incoming;	
	}
	

}
