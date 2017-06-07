import java.util.ArrayList;

public class Node {
	public String word;
	public ArrayList<Node> neighbors;
	public boolean visited;
	public int distance;
	
	
	public Node(String word,int distance)
	{
		this.word = word;
		this.neighbors = new ArrayList<Node>();
		this.distance = distance;
	}
}
