package miniheap;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		MinHeap<Integer> test = new MinHeap<Integer>();
		
		test.add(8);
		test.add(2);
		test.add(5);
		test.add(21);
		test.add(10);
		test.add(3);
		
		System.out.println(test.printHeap());
		
		test.remove();
		System.out.println(test.printHeap());
		test.remove();
		System.out.println(test.printHeap());
		test.remove();
		System.out.println(test.printHeap());
		test.remove();
		System.out.println(test.printHeap());


	}

}
