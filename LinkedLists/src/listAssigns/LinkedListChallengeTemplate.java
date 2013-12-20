package listAssigns;

public class LinkedListChallengeTemplate<E>
{
    private ListNode<E> first, last;
    int size;

    /*
     * precondition: 0 <= i <= size && newList.size > 0
     */
    public void insert(int i, LinkedListChallengeTemplate<E> newList)
    {
    	ListNode<E> beginning = first;
    	while(i > 0)
    	{
    		beginning = beginning.next;
    		i --;
    	}
    	
    	ListNode<E> end = beginning.next;
    	
    	first.next = newList.first;
    	newList.first.prev = first;
    	
    	newList.last.next = end;
    	end.prev = newList.last;
    	
    	
        	
    }

    // precondition: 0 <= i < size && j >= i
    public void removeSublist(int i, int j)
    {
        int a = j - i;
        
        ListNode<E> a = 
    }

    // precondition: 0 <= i < size && j >= i
    public ListNode<E> getSublist(int i, int j)
    {
        ListNode<E> begin = first;
        
        while(i > 0)
        {	
        	begin = begin.next;
        	i --;
        
        }
        
        int a = j - i;
        ListNode<E> end = begin;
        
        while(a > 0)
        
        
    }

    private class ListNode<F>
    {
        public F value;
        public ListNode<F> prev;
        public ListNode<F> next;
    
        public ListNode(F initValue)
        {
            value = initValue;
            prev = null;
            next = null;
        }
    
        public ListNode(F initValue, ListNode<F> initPrev, ListNode<F> initNext)
        {
            value = initValue;
            prev = initPrev;
            next = initNext;
        }
    }
}