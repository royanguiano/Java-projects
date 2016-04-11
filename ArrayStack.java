package hw8;

import java.util.*;
import java.util.Stack;
import java.util.LinkedList;

public class ArrayStack<E> implements MyStack<E> {

	private E[] dataArray;
	private int top;

	/**
	 * Creates an empty stack.
	 */
	public ArrayStack() {
		this.dataArray = (E[]) new Object[10];
		this.top = -1; 
	}

	/**
	 * Determines if the stack is empty or not.
	 * 
	 * @return true if the stack is empty or false otherwise
	 */
	public boolean isEmpty() {
		return (top == -1);
	}

	/**
	 * Pushes the given element on this stack
	 * 
	 * @param element
	 *            The element of type E to push on the stack.
	 */
	public void push(E element) {
		
		if (top == dataArray.length - 1) {

			E[] temp = (E[]) new Object[dataArray.length * 2];
		
			for (int i = 0; i < dataArray.length; i++) {
				temp[i] = dataArray[i];
			}
			dataArray = temp;
		}

		dataArray[++top] = element;
	}

	/**
	 * Returns but does not remove the top element of the stack if the stack is
	 * not empty.
	 * 
	 * @return The top element of the stack
	 * @throws NoSuchElementException
	 *             if the stack is empty
	 */
	public E peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return dataArray[top - 1];

		// throw new UnsupportedOperationException("remove this line");
	}

	/**
	 * Returns and removes the top element of the stack if the stack is not
	 * empty.
	 * 
	 * @return The top element of the stack
	 * @throws NoSuchElementException
	 *             if the stack is empty
	 */
	public E pop() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			return dataArray[top--];
		}
	}

	/**
	 * Returns a String representation of the stack in the following format top
	 * [ 1 3 ] bottom
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[ ");
		for (int i = top; i >= 0; i--) {
			sb.append(dataArray[i] + " ");
		}
		sb.append("] bottom");

		return sb.toString();
	}
}