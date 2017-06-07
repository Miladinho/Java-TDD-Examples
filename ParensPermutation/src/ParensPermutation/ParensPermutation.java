package ParensPermutation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParensPermutation {
	
	private Set<String> uniqueParens = new HashSet<String>();
	
	public List<String> doParensPermutation(int n)
	{	
		List<String> perms = new ArrayList<String>();
		if (n == 1)
		{
			perms.add("()");
			this.uniqueParens.add("()");
			return perms;
		}
		
		List<String> returnedParens = doParensPermutation(n-1);

		for (String paren : returnedParens)
		{
			System.out.println("For n = "+n+" paren = "+paren);
			String p = "()"+paren;
			if (!this.uniqueParens.contains(p))
			{
				perms.add(p);
				this.uniqueParens.add(p);
			}
			
			String pp = "("+paren+")";
			perms.add(pp);
			this.uniqueParens.add(pp);
			
			String ppp = paren+"()";
			if (!this.uniqueParens.contains(ppp))
			{
				perms.add(ppp);
				this.uniqueParens.add(ppp);
			}
		}
		
		return perms;
	}
	
	public static void main(String args[])
	{
		ParensPermutation pp = new ParensPermutation();
		List<String> res = pp.doParensPermutation(6);
		int count = 0;
		for (String r : res)
		{
			count++;
			//System.out.println(r+"\n");
		}
		System.out.println(count++);
	}

}
