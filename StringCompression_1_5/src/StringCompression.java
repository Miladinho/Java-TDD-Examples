

public class StringCompression {
	
	private StringBuilder builder;
	
	public String compressString(String input) {
		int count = 0;
		char lastChar = initLastChar(input);
		this.builder = new StringBuilder();
		
		for (int i = 0; i < input.length(); i++)
		{
			if (input.charAt(i) == lastChar)
			{
				count++;
			}
			else
			{
				appendCompressionToBuilder(count, lastChar);
				count = 1;
				lastChar = input.charAt(i);
			} 
		} 
	
		appendCompressionToBuilder(count, lastChar);
		
		return isInputSizeLessThanCompString(input) ? input : this.builder.toString();   
	} 
	
	private boolean isInputSizeLessThanCompString(String input) {
		return input.length() <= this.builder.length();
	}

	private char initLastChar(String input) {
		return input.length() == 0 ? 0 : input.charAt(0);
	}
	
	private void appendCompressionToBuilder(int count, char lastChar) {
		this.builder.append(lastChar);
		this.builder.append(count);
	}
	
}
