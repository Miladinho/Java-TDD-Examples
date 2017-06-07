
public class Concat {

	public char[] concatenate(char[] input, int trueSize) {
		if (input.length == trueSize) return input;
		int idx = input.length - 1;
		for (int i = trueSize-1; i >= 0; i--)
		{
			// add %20
			input[i] = '%';
			input[i+1] = '2';
			input[i+2] = '0';
		}
		return input;
	}

}
