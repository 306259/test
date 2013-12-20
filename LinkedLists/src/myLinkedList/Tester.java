package myLinkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		LinkedList a = new LinkedList();
		
		a.add("A");
		a.add("B");
		a.add("C");
		a.add("D");
		
		ListIterator test = (ListIterator) a.iterator();
		
		test.next();
		test.next();
		System.out.println(test.previous());
		System.out.println(test.next());
		System.out.println(test.next());
		

	}

}
