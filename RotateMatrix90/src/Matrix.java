
public class Matrix {

	public char[][] rotateNinety(char[][] input) {
		int size = input.length;
		//if (size == 1) return input;
		
		char[][] newMatrix = new char[size][size];
		
		int lastCol = size - 1;
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				swapRowContentsToColumn(input, newMatrix, lastCol, i, j);
			}
			lastCol--;
		}
		printMatrix(newMatrix);
		return newMatrix;
	}

	private void swapRowContentsToColumn(char[][] input, char[][] newMatrix, int lastCol, int i, int j) {
		newMatrix[j][lastCol] = input[i][j];
	}
	
	private void printMatrix(char[][] matrix)
	{
		for (int i = 0; i < matrix.length; i++)
		{
			System.out.println(new String(matrix[i]));
		}
	}
}
