package hw8;

import java.util.*;

import javax.lang.model.element.Element;

import org.w3c.dom.Node;

public class TwoStackQueue<E> implements MyQueue<E> {
	private MyStack<E> out;
	private MyStack<E> in;
	private E data;
	private TwoStackQueue<E> next;

	public TwoStackQueue(E element, TwoStackQueue<E> nextNode) {
		out = new ArrayStack<>();
		in = new ArrayStack<E>();
	}

	public TwoStackQueue() {
		out = null;
		in = null;
	}

	/**
	 * Returns <tt>true</tt> if this queue no elements.
	 * 
	 * @return <tt>true</tt> if this queue is empty, <tt>false</tt> otherwise.
	 */
	public boolean isEmpty() {
		return (out.isEmpty() && in.isEmpty());
		// throw new UnsupportedOperationException("remove this line");
	}

	/**
	 * Adds the specified element to the end of the queue.
	 * 
	 * @param The
	 *            element to add on to the end of the queue.
	 */
	public void enqueue(E element) {
		in.push(element);
	}

	/**
	 * Removes and returns the element at the front of this queue.
	 * 
	 * @return The element removed from the front of this queue.
	 * @throws NoSuchElementException
	 *             if the queue is empty.
	 */
	public E dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else if (!out.isEmpty()) {
			return out.pop();
		} else {
			while (!in.isEmpty()) {
				out.push(in.pop());
			}
			return out.pop();
		}
	}

	/**
	 * Returns, but does not remove, the element at the front of this queue.
	 * 
	 * @return The element at the front of this queue.
	 * @throws NoSuchElementException
	 *             if the queue is empty.
	 */
	public E peek() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else if (!out.isEmpty()) {
			return out.peek();
		} else {
			while (!in.isEmpty()) {
				out.push(in.pop());
			}
			return out.peek();
		}
	}

	/**
	 * Returns a String representation of this queue. If the queue will dequeue
	 * values 6 7 8 in that order, and the out stack contains one value, the
	 * string will have following format.
	 * 
	 * front [ 6 | 7 8 ] back
	 */
	public String toString() {
		MyStack<E> temp = new ArrayStack<E>();
		StringBuffer sb = new StringBuffer();
		sb.append("front [ ");
	
		while (!out.isEmpty()) {

			sb.append(out.peek() + " ");
			temp.push(out.pop());
		}
		sb.append("| ");

		while (!temp.isEmpty()) {
			out.push(temp.pop());
		}

		while (!in.isEmpty()) {
			temp.push(in.pop());
		}

		while (!temp.isEmpty()) {
			sb.append(temp.peek() + " ");
			in.push(temp.pop());
		}
		sb.append("] back");

		return sb.toString();
	}
}