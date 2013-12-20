package p20_3;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		LinkedList test = new LinkedList();
		
		test.addFirst("C");
		test.addFirst("B");
		test.addFirst("A");

		test.reverse();
		
		System.out.println(test.getFirst());
		test.removeFirst();
		System.out.println(test.getFirst());
		test.removeFirst();
		System.out.println(test.getFirst());
	}

}
