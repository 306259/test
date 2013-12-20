package p21_4;

import java.util.HashMap;
import java.util.Map;

public class Grades {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Map<String, String> grades = new HashMap<String, String>();
		
		grades.put("Alex", "B");
		grades.put("Allan", "B");
		
		for(String g: grades.keySet())
			System.out.println(g + " " + grades.get(g));
		
		System.out.println("After Midterm:");
		
		grades.put("Alex", "A");
		grades.put("Allan", "B");
		
		for(String g: grades.keySet())
			System.out.println(g + " " + grades.get(g));
	}

}
