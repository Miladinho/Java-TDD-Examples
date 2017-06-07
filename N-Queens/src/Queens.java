
public class Queens {
	private int size;
	private int[] columnList;
	
	public int solve(int n) {
		this.size = n;
		this.columnList = new int[n];

		return backTrack(0,n);
	}
	
	
	private int backTrack(int row, int n) {
		int combinations = 0; 
		
		for (int col = 0; col < n; col++)
		{
			// place queen if possible using col and row
				// if last row, print/process result
				// else recurse row+1
			if (canPlaceQueen(row,col))
			{
				this.columnList[row] = col;
				if (row == n-1)
				{
					return 1;
				}
				else
				{
					combinations += backTrack(row+1,n);
					
				}
			}
		}
		
		return combinations; 
	}
	
	private boolean canPlaceQueen(int row, int col)
	{
		for (int r = row; r >= 0; r--)
		{
			int c = this.columnList[r];
			if ( c == col || row-r == col-c || r-row == c-col)
			{
				return false;
			}
		}
		return true;
	}

}
