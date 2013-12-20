package p20_1;

import java.util.LinkedList;
import java.util.ListIterator;

public class P20_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		LinkedList<String> staffs = new LinkedList<String>();
		
		staffs.addLast("Bob");
		staffs.addLast("Sam");
		staffs.addLast("Amy");
		staffs.addLast("Ron");
		staffs.addLast("Harry");
		staffs.addLast("Percey");
//		staffs.addLast("John");
		
		downSize(staffs);
		
		for(String staff : staffs)
			System.out.println(staff);
	}
	
	public static void downSize(LinkedList<String> staff)
	{
		ListIterator<String> iterator = staff.listIterator();
		
		while(iterator.hasNext())
		{
			iterator.next();
			
			if(iterator.hasNext())
			{
				iterator.next();
				iterator.remove();
			}
			
			else
				return;
		}
	}

}
