package hw8;

import java.util.*;

public class ArrayQueue<E> implements MyQueue<E> {

	private E[] dataArray;
	private int front; 
	private int back; 
	private int numElements; 

	public ArrayQueue() {
	}

	/**
	 * Returns <tt>true</tt> if this queue no elements.
	 * 
	 * @return <tt>true</tt> if this queue is empty, <tt>false</tt> otherwise.
	 */
	public boolean isEmpty() {
		return (numElements == 0);

	}

	/**
	 * Adds the specified element to the back of this queue.
	 * 
	 * @param element
	 *            to add on to the back of this queue.
	 */
	public void enqueue(E element) {
		if (numElements == dataArray.length) {
			E[] temp = (E[]) new Object[dataArray.length * 2];

			int i, j;
			for (i = front, j = 0; i < front + numElements; i++, j++) {
				temp[j] = dataArray[i % numElements];
			}

			
			front = 0;
			back = dataArray.length - 1;

			dataArray = temp;
			dataArray[++back] = element;
			numElements++;
		} else {
			if (back == dataArray.length - 1) {
				back = -1;
			}
			dataArray[++back] = element;
			numElements++;
		}
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
		} else {
			E e = dataArray[front++];
			
			
			if (front == dataArray.length) {
				front = 0;
			}
			numElements--;
			return e;
		}
	}

	/**
	 * Returns, but does not remove, the element at the front of this queue.
	 * 
	 * @return The element at the front of this queue.
	 * @throws NoSuchElementException if the queue is empty.
	 */
	public E peek() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			System.out.println("not empty");
			return dataArray[front];
		}

	}

	/**
	 * Returns a String representation of this queue in the following format:
	 * 
	 * front: 3 back: 1 front [ 6 7 8 ] back
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append("front: " + front + " back: " + back + "\n");

		sb.append("front [ ");
		for (int i = front; i < dataArray.length && dataArray[i] != null; i++) {
			sb.append(dataArray[i] + " ");
		}

		if (front > back) {
			for (int j = 0; j <= back; j++) {
				sb.append(dataArray[j] + " ");
			}
		}

		sb.append("] back");

		return sb.toString();
	}

}