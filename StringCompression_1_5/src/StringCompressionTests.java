import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class StringCompressionTests {
   
	private StringCompression sc;
	
	@Before
	public void setUp() throws Exception {
		this.sc = new StringCompression();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void compressEmptyString() {
		assertEquals("",sc.compressString(""));
	}
	
	@Test
	public void compressionBiggerThanInputString()
	{
		assertEquals("aab",sc.compressString("aab"));
	}
	
	@Test
	public void compressEqualToInputString()
	{
		assertEquals("ss",sc.compressString("ss"));
	}
	
	@Test
	public  void compressStringWithNoDuplicates()
	{
		assertEquals("kbaCxZ",sc.compressString("kbaCxZ"));
	} 
	
	@Test
	public void compressStringWithOneDuplicateChar()
	{
		assertEquals("h3",sc.compressString("hhh"));
	}
	
	@Test
	public void compressDuplicatesOfSameCharInDifferentSlice()
	{
		assertEquals("K1c1d2e2f1T1e10G1d2",sc.compressString("KcddeefTeeeeeeeeeeGdd"));
	} 
}
