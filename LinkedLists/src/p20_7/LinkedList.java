package p20_7;

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
	      last = null;
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
	      
	      if(size == 0)
	    	  last = null;
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
	      
	      if(size == 0)
	    	  last = newNode;
	      
	      first = newNode;
	      
	      size ++;
	   }
	   public void addLast(Object element)
	   {
		   Node newNode = new Node();
		      newNode.data = element;
		      last.next = newNode;
		      last = newNode;
		      size ++;
	   }
	   public void removeLast()
	   {
		  reverse();
		  if (first == null) 
		         throw new NoSuchElementException();
		  last = first.next;
		  reverse();
		  
		  
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
	   private Node last;
	   
	   private class Node
	   {  
	      public Object data;
	      public Node next;
	   }

	   
	}




