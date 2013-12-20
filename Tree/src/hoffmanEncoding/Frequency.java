package hoffmanEncoding;

import java.util.HashMap;
import java.util.Set;

public class Frequency
{
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	
	public void add(String s)
	{
		if(map.containsKey(s))
		{
			map.put(s, map.get(s)+1);
			
		}
		else
			map.put(s,1);
	}
	
	public String print()
	{
		String s= "";
		Set<String> set= map.keySet();
		for(String a: set)
		{
			s = s + a +" : "+ + map.get(a)+ "\n";
		}
		return s; 
	}

}
