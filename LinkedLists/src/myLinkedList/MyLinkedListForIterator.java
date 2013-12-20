package myLinkedList;

//import java.util.List;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

public class MyLinkedListForIterator<E> implements Iterable<E>
{
	private ListNode<E> first;
	private ListNode<E> last;
	private int size;
	private int modCount;

	public MyLinkedListForIterator()
	{
		first = null;
		last = null;
		size = 0;
		modCount = 0;
	}

	public boolean add(E o)
	{
		if (isEmpty())
		{
			first = new ListNode<E>(o);
			last = first;
		}
		else
		// list contains at least one element
		{
			ListNode<E> newNode = new ListNode<E>(o, last, null);
			last.next = newNode;
			last = newNode;
		}

		size++;
		modCount++;
		return true;
	}

	public void add(int index, E element)
	{
		if (index < 0 || index > size())
			throw new IndexOutOfBoundsException();
		else if (index == 0)
			addFirst(element);
		else if (index == size())
			addLast(element);
		else
		{
			ListNode<E> current = first;
			while (index > 0)
			{
				current = current.next;
				index--;
			}

			ListNode<E> newNode = new ListNode<E>(element, current.prev, current);
			current.prev.next = newNode;
			current.prev = newNode;
			size++;
			modCount++;
		}
	}

	public void addFirst(E o)
	{
		if (isEmpty())
		{
			first = new ListNode<E>(o);
			last = first;
		}
		else
		// list contains at least one element
		{
			ListNode<E> newNode = new ListNode<E>(o, null, first);
			first.prev = newNode;
			first = newNode;
		}

		size++;
		modCount++;
	}

	public void addLast(E o)
	{
		add(o);
	}

	public E getFirst()
	{
		if (isEmpty())
			throw new NoSuchElementException();
		else
			return first.data;
	}

	public E getLast()
	{
		if (isEmpty())
			throw new NoSuchElementException();
		else
			return last.data;
	}

	public E removeFirst()
	{
		return remove();
	}

	public E removeLast()
	{
		if (isEmpty())
			throw new NoSuchElementException();
		else
		{
			E oldData = last.data;
			last = last.prev;

			if (last == null) // there is no element before last
				first = null;
			else
				// there is an element before last
				last.next = null;

			size--;
			modCount++;
			return oldData;
		}
	}

	public void clear()
	{
		first = null;
		last = null;
		size = 0;
		modCount++;
	}

	/*
	 * public booleans contains(Object o) { }
	 */

	public E get(int index)
	{
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		else
		{
			ListNode<E> current = first;
			while (index > 0)
			{
				current = current.next;
				index--;
			}
			return current.data;
		}
	}

	/*
	 * public int hashCode() { }
	 */

	public boolean isEmpty()
	{
		return first == null;
	}

	public Iterator<E> iterator()
	{
		return listIterator();
	}

	public ListIterator<E> listIterator()
	{
		return new MyListIterator();
	}

	public E remove()
	{
		if (isEmpty())
			throw new NoSuchElementException();
		else
		{
			E oldData = first.data;
			first = first.next;

			if (first == null) // there is no second element
				last = null;
			else
				// there is a second element
				first.prev = null;

			size--;
			modCount++;
			return oldData;
		}
	}

	public E remove(int index)
	{
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		else if (index == 0) // index is first element
			return removeFirst();
		else if (index == size() - 1) // index is last element
			return removeLast();
		else
		{
			ListNode<E> current = first;
			while (index > 0)
			{
				current = current.next;
				index--;
			}

			E oldData = current.data;

			current.prev.next = current.next;
			current.next.prev = current.prev;

			size--;
			modCount++;
			return oldData;
		}
	}

	public E set(int index, E element)
	{
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		else
		{
			ListNode<E> current = first;
			while (index > 0)
			{
				current = current.next;
				index--;
			}

			E oldData = current.data;
			current.data = element;
			return oldData;
		}
	}

	public int size()
	{
		return size;
	}

	public String toString()
	{
		String myString = "[";
		ListNode<E> current = first;
		while (current != null)
		{
			if (current != first)
				myString += ", ";

			myString += current.data.toString();
			current = current.next;
		}
		myString += "]";
		return myString;
	}

	private class MyListIterator implements ListIterator<E>
	{
		private int cursorPos;
		private int iteratorModCount;
		private boolean isCalled = false;
		
		public MyListIterator()
		{
			cursorPos = 0;
		}

		private void verifyModCount()
		{
			if(iteratorModCount != modCount)
				throw new IllegalStateException();
		}

		public boolean hasNext()
		{
			return cursorPos != size();
		}

		public boolean hasPrevious()
		{
			return cursorPos != 0;
		}

		public int previousIndex()
		{
			return cursorPos - 1;
		}

		public int nextIndex()
		{
			return cursorPos;
		}

		public E previous()
		{
			if(!hasPrevious())
				throw new NoSuchElementException();
			
			int prevIndex = previousIndex();
			cursorPos --;
			return get(prevIndex);
		}

		public E next()
		{
			if(!hasNext())
				throw new NoSuchElementException();
			int nextIndex = nextIndex();
			cursorPos ++;
			return get(nextIndex);
		}

		public void add(E o)
		{
			MyLinkedListForIterator.this.add(cursorPos, o);
			iteratorModCount ++;
		}

		public void set(E o)
		{
			MyLinkedListForIterator.this.set(cursorPos, o);
		}

		public void remove()
		{
			MyLinkedListForIterator.this.remove(cursorPos);
		}
	}

	private class ListNode<E>
	{
		public E data;
		public ListNode<E> prev;
		public ListNode<E> next;

		public ListNode(E da)
		{
			data = da;
			prev = null;
			next = null;
		}

		private ListNode(E da, ListNode<E> pr, ListNode<E> ne)
		{
			data = da;
			prev = pr;
			next = ne;
		}
	}
}