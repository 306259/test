package p20_6;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		LinkedList tester = new LinkedList();
		
		tester.addFirst("A");
		tester.addFirst("B");
		
		System.out.println(tester.currentSize());
		
		tester.removeFirst();
		
		System.out.println(tester.currentSize());
	}

}
