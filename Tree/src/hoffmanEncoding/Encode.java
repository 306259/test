package hoffmanEncoding;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Encode
{
	public String eMessage;
	
	public Encode(HashMap<String, String> scheme, String message) throws IOException
	{
		
		File file = new File("C:\\Users\\Allan\\Documents\\huffmanTxt\\myMessageFinal.txt");


		file.createNewFile();


	FileWriter fw = new FileWriter(file.getAbsoluteFile());

	BufferedWriter bw = new BufferedWriter(fw);
		
		int i = 0;
		while(i < message.length())
		{
			bw.write(scheme.get("" + message.charAt(i)).substring(4));
			i++;

		}
		
		bw.close();
	}
	

}
