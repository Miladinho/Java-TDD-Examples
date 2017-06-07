import java.util.ArrayList;

public class ZombieClusters {

	class Node {
		boolean visited = false;
		ArrayList<Integer> neighbors = new ArrayList<>();
	}
	
	public int findClusters(String[] zombies) {
		if (zombies == null) return 0;
		if (zombies.length == 0) return 0;
		
		int n = zombies.length;
		Node [] nodes = new Node[n];
		for (int i = 0; i < n; i++) {
			Node x = new Node();
			for (int j = 0; j < n; j++) {
				int val = Character.getNumericValue(zombies[i].charAt(j));
				//System.out.println(val);
				if (val == 1) {
					x.neighbors.add(j);
				}
			}
			nodes[i] = x;
		}

		int clusters = 0;
		for (int i = 0; i < n; i++) {
			Node x = nodes[i];
			if (x.visited == false) {
				search(nodes,i);
				clusters++;
			}
		}
		return clusters;
	}

	private void search(Node[] nodes, int idx) {
		Node n = nodes[idx];
		if (n.neighbors.isEmpty()) {
			return;
		}
		n.visited = true;
		for (int i = 0; i < n.neighbors.size(); i++) {
			if (nodes[n.neighbors.get(i)].visited != true) {
				search(nodes,n.neighbors.get(i));
			}
		}
	}

}
