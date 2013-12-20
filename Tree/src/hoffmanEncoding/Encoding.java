package hoffmanEncoding;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Encoding 
{
	private static String code;
	
	public static void main(String[] args) throws IOException
	{
		
		Scanner message = new Scanner(new File(args[0]));
		while(message.hasNext())
			code += message.next();
		message.close();
		
		int i=0;
		
		Frequency t = new Frequency();
		while(i<code.length())
		{
			t.add(code.substring(i, i+1));
			i++;
			
		}
		
		Tree tree = new Tree(t.map);
		Scheme s = new Scheme(tree);
		s.buildScheme();
		s.writeFile();
		
		Encode m = new Encode(s.scheme,code);
		System.out.println(m.eMessage);
		
		
		
		
	}
}
