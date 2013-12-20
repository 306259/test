package miniheap;

import java.util.ArrayList;

/**
 * An unbounded min-heap. A MinHeap orders elements according to their natural
 * order.
 * 
 * Null elements are not permitted. All elements are required to be of the same
 * type.
 * 
 * A MinHeap is unbounded, but has an internal capacity governing the size of an
 * array used to store the elements. It is always at least as large as the heap
 * size. As elements are added, the capacity grows automatically. The details of
 * the growth policy are not specified.
 * 
 * Guarantees O(log n) run time for add() and remove(). Guarantees O(1) running
 * time for peek().
 */
public class MinHeap<E extends Comparable<E>> 
{
	private ArrayList<E> heapList;

	/**
	 * Creates a MinHeap with the default initial capacity (11).
	 */
	public MinHeap() 
	{

		heapList = new ArrayList<E>(11);
		heapList.add(null);
	}

	/**
	 * Creates a MinHeap with the specified initial capacity.
	 * 
	 * @parameter initialCapacity the initial capacity for this min-heap.
	 * @throws IllegalArgumentException
	 *             if initialCapacity is negative.
	 */
	public MinHeap(int initialCapacity) 
	{

		heapList = new ArrayList<E>(initialCapacity);
		heapList.add(null);
	}

	/**
	 * Adds the specified element to this min-heap.
	 * 
	 * @parameter obj the element.
	 * @throws NullPointerException
	 *             if the specified element is null.
	 */
	public void add(E obj) 
	{

		heapList.add(obj);
		moveUp(heapList.size() - 1);
	}

	/**
	 * moves Up an element if its location is not correct.
	 * @param childIndex
	 */
	private void moveUp(int childIndex) 
	{
		int parentIndex = getParentIndex(childIndex);
		
		if(parentIndex == 0)
			return;
		
		
		if (heapList.get(childIndex).compareTo(heapList.get(parentIndex)) < 0) 
		{
			swap(childIndex, parentIndex, null);
			moveUp(parentIndex);
		}

	}

	/**
	 * Retrieves and removes the minimum element from this min-heap, or null if
	 * this heap is empty.
	 */
	public E remove() 
	{
		E toBeRemoved = heapList.get(1);

		heapList.set(1, heapList.get(heapList.size() - 1));
		heapList.remove(heapList.size() - 1);
		fixHeap(1);

		return toBeRemoved;
	}

	/**
	 * Fixes a min-heap that is violated only by its root.
	 * 
	 * Preconditions: The (sub)heap rooted at rootIndex adheres to the min-heap
	 * property except for the element at rootIndex itself.
	 * 
	 * Postcondition: The (sub)heap rooted at rootIndex adheres to the min-heap
	 * property.
	 */
	private void fixHeap(int parentIndex) 
	{
		E parent = heapList.get(parentIndex);
		int leftChildIndex = getChildIndex(parentIndex, true);
		int rightChildIndex = getChildIndex(parentIndex, false);
		
		if(leftChildIndex >= heapList.size() || rightChildIndex >= heapList.size())
			return;
		
		E left = heapList.get(leftChildIndex);
		E right = heapList.get(rightChildIndex);
		
		if(parent.compareTo(left) > 0 || parent.compareTo(right) > 0)
		{
			if(left.compareTo(right) < 0)
			{
				swap(parentIndex, leftChildIndex, parent);
				fixHeap(leftChildIndex);
			}
			else
			{
				swap(parentIndex, rightChildIndex, parent);
				fixHeap(rightChildIndex);
			}
			
		}
//		
//		if (parent.compareTo(heapList.get(leftChildIndex)) > 0) 
//		{
//				swap(parentIndex, leftChildIndex, parent);
//				fixHeap(leftChildIndex);
//		}
//		
//			
//		if (parent.compareTo(heapList.get(rightChildIndex)) > 0) 
//		{
//
//			swap(parentIndex, rightChildIndex, parent);
//			fixHeap(rightChildIndex);
//
//		}
		
		
		
		
		
	}

	/**
	 * changes the location of two objects in the heapList
	 * 
	 * @param indexOne
	 * @param indexTwo
	 * @param obj at IndexOne
	 *            optional
	 */
	private void swap(int indexOne, int indexTwo, E obj) 
	{
		if (obj == null)
			obj = heapList.get(indexOne);

		heapList.set(indexOne, heapList.get(indexTwo));
		heapList.set(indexTwo, obj);
	}

	/**
	 * Retrieves, but does not remove, the minimum element from this min-heap,
	 * or null if this heap is empty.
	 */
	public E peek() 
	{
		return heapList.get(1);
	}

	private int getParentIndex(int childIndex) 
	{
		return childIndex / 2;
	}

	private int getChildIndex(int parentIndex, boolean left) 
	{
		if (left)
			return parentIndex * 2;

		else
			return parentIndex * 2 + 1;
	}
	
	public String printHeap()
	{
		String s = "";
		for(E a : heapList)
			s += a + " ";
		
		return s;
	}
}

