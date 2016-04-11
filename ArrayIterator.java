import java.util.*;

public class ArrayIterator<E> implements java.util.Iterator<E> {

	E[] array;
	int next;

	/**
	 * Constructs an iterator for the specified array.
	 * 
	 * @param array
	 *            The array over which to iterate.
	 */
	public ArrayIterator(E[] arr) {	
		array = arr;
		// throw new
		// UnsupportedOperationException("remove this line when done");
	}

	/**
	 * Return <tt>true</tt> is the iteration has more elements. (In other words,
	 * returns <tt>true</tt> if <tt>next</tt> would return an element rather
	 * than throwing an exception.)
	 * 
	 * @return <tt>true</tt> if there is another element.
	 */
	public boolean hasNext() {
		return next < array.length;
		// throw new
		// UnsupportedOperationException("remove this line when done");
	}

	/**
	 * Returns the next element in the iteration.
	 * 
	 * @return the next element in the iteration.
	 * @throws <tt>NoSuchElementException</tt> if iteration has no more
	 *         elements.
	 * 
	 */
	public E next() {
		if (hasNext()) {
			return array[next++];
		} else {
			throw new UnsupportedOperationException("remove this line when done");
		}
	}

	/**
	 * The remove operation is not supported by this implementation of
	 * <tt>Iterator</tt>.
	 * 
	 * @throws <tt>UnsupportedOperationException</tt> if this method is invoked.
	 */
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
