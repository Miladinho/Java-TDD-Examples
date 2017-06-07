import java.util.HashMap;

public class Paths {

	public int findPaths(int[][] input, int n) {
		HashMap<Integer,Integer> map = new HashMap<>();
		return search(input,0,0,n,map);
	}

	private int search(int[][] input, int i, int j, int n, HashMap<Integer, Integer> map) {
		if (!inRange(i,j,n)) {
			return 0;
		}
		if (input[i][j] == 0) {
			// path is blocked at row i, column j
			return 0;
		}
		if (atEndOfPath(i, j, n)) {
			return 1;
		}
		if (map.containsKey(getIndex(i,j,n))) {
			return map.get(getIndex(i,j,n));
		}
		int paths = 0;
		paths += search(input,i+1,j,n,map);
		paths += search(input,i,j+1,n,map);
		map.put(getIndex(i,j,n), paths);
		return paths;
	}

	private boolean atEndOfPath(int i, int j, int n) {
		return i == n-1 && j == n-1;
	}

	private int getIndex(int i, int j, int n) {
		return (i*n+j);
	}

	private boolean inRange(int i, int j, int n) {
		return i < n && j < n;
	}

}
