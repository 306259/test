package p20_6;

import java.util.ListIterator;
import java.util.NoSuchElementException;

	/**
	   A linked list is a sequence of nodes with efficient
	   element insertion and removal. This class 
	   contains a subset of the methods of the standard
	   java.util.LinkedList class.
	*/
	public class LinkedList
	{  
	   /** 
	      Constructs an empty linked list.
	   */
	   public LinkedList()
	   {  
	      first = null;
	   }
	   
	   /**
	      Returns the first element in the linked list.
	      @return the first element in the linked list
	   */
	   public Object getFirst()
	   {  
	      if (first == null) 
	         throw new NoSuchElementException();
	      return first.data;
	   }

	   /**
	      Removes the first element in the linked list.
	      @return the removed element
	   */
	   public Object removeFirst()
	   {  
	      if (first == null) 
	         throw new NoSuchElementException();
	      Object element = first.data;
	      first = first.next;
	      size --;
	      return element;
	      
	      
	   }

	   /**
	      Adds an element to the front of the linked list.
	      @param element the element to add
	   */
	   public void addFirst(Object element)
	   {  
	      Node newNode = new Node();
	      newNode.data = element;
	      newNode.next = first;
	      first = newNode;
	      
	      size ++;
	   }
	   public void reverse()
	   {
		   LinkedList list = new LinkedList();
		   while (first != null)
		   {

			   list.addFirst(getFirst());
			   removeFirst();
			  
			    
		   }
		   first = list.first;
		   
	   }
	   public int currentSize()
	   {
		   return size;
	   }
	   
	   /**
	      Returns an iterator for iterating through this list.
	      @return an iterator for iterating through this list
	   */

	   private Node first;
	   private int size;
	   
	   private class Node
	   {  
	      public Object data;
	      public Node next;
	   }

	   
	}



