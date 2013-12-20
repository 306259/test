package p20_2;

import java.util.LinkedList;

public class P20_2 {

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
		
		reverse(staffs);
		
		for(String staff : staffs)
			System.out.println(staff);
	}
	
	public static void reverse(LinkedList<String> staff)
	{
		for(int i = 0; i < staff.size()/2; i++)
		{
			String temp = staff.get(i);
			
			staff.set(i, staff.get(staff.size() - 1 - i));
			staff.set(staff.size() - 1 - i, temp);
		}
	}

}
