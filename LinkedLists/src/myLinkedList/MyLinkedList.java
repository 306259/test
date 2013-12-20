package myLinkedList;


public class MyLinkedList <E>{

	private ListNode<E> head = new ListNode<E>((E)"head");
	private ListNode<E> tail = new ListNode<E>((E)"tail");
	private int size = 0;
	
	 public MyLinkedList()
	    {
		 head.next = tail;
	    	tail.prev = head;
	    }

    public MyLinkedList(ListNode<E> e)
    {
    	head.next = e;
    	tail.prev = e;
    	e.prev = head;
    	e.next = tail;
    }
    
    public boolean add(E o)
    {
        add(size, o);
        
        return(this.get(size - 1) != null);   	
    }
    public void add(int index, E element)
    {	
    	if(isEmpty())
    		addFirst(element);
    	
    	else
    	{
    		size++;
    		
    		ListNode<E> after = head;
    		
    		for(int x  =0; x < index; x++)
    			after = after.next;
    		
    		ListNode<E> before = after.prev;
    		ListNode<E> node = new ListNode<E>(element);
    		
    		node.next = after;
    		node.prev = before;
    		
    		after.prev = node;
    		before.next = node;
    	}
    }

    
    public void addFirst(E o)
    {
    	ListNode<E> node = new ListNode<E>(o);
    	ListNode<E> old = head.next;
    	
    	head.next = node;
    	
    	node.prev = head;
    	node.next = old;
    	size++;
    }
    
    
    public void addLast(E o)
    {
    	ListNode<E> node = new ListNode<E>(o);
    	ListNode<E> prev = tail.prev;
    	tail.prev = node;
    	node.prev = prev;
    	size++;
    }
    
    public E getFirst()
    {
    	return (E)head.next;
    }
    
    public E getLast()
    {
    	return (E)tail.prev;
    }
    
    public E removeFirst()
    {
    	ListNode<E> first = head.next;
    	head.next = first.next.next;
    	
    	size--;
    	
    	return first.value;
    }
    
    public E removeLast()
    {
    	ListNode<E> last = tail.prev;
    	tail.prev = last.prev.prev;
    	
    	size--;
    	
    	return last.value;
    }
    
    public void clear()
    {
        head.next = this.tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
    }
    
    public E get(int index)
    {
    	if(index < 0 || index >= size)
    	{
    		System.err.println("Out of bounds Index");
    		throw new IllegalArgumentException();
    	}
    	
    	index++; 
        
    	ListNode<E> reference = head;
    	
        for(int x=0;x<index;x++)
        	reference = reference.next;
       
        return reference.value;
    }
    
    public boolean isEmpty()
    {
        return(size == 0);
    }
    
    public E remove()
    {
    	ListNode<E> objectRemoved = head.next;
    	remove(0);
    	
    	return (E) objectRemoved;
    }
    
    public E remove(int index)
    {
    	  ListNode<E> reference = head.next;
          
    	  for(int x = 1; x < index; x++)
          	reference = reference.next;
    	  
    	  reference.prev.next = reference.next;
    	  reference.next.prev = reference.prev;

    	 size--;
    	 
    	  return reference.value;
    }
    
    public E set(int index, E element)
    {
        add(index, element);
        
        E elementReplaced = get(index + 1);
        remove(index + 1);
       
        return elementReplaced;
    }
    
    public int size()
    {
        return size;
    }
    
    public String toString()
    {
        String string = "";
        ListNode<E> next = head;
        
        for(int x = 0; x < size; x++)
        {
        	next = next.next;
        	string = string + ", " + next.value;
        }
        return string;
    }
    
    private class ListNode<E>
    {
        public E value;
        public ListNode<E> prev;
        public ListNode<E> next;
    
        public ListNode(E initValue)
        {
            value = initValue;
            prev = null;
            next = null;
        }
    
        public ListNode(E initValue, ListNode<E> initPrev, ListNode<E> initNext)
        {
            value = initValue;
            prev = initPrev;
            next = initNext;
        }
    }
}