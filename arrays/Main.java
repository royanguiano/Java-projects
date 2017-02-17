package hw8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main<E> extends TwoStackQueue<E> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack s = new Stack();

		s.push("A");
		s.push("Sunny");
		s.push("Day");

		System.out.println(s.pop());
		System.out.println(s.pop());

		String str = (String) s.peek();

		if (s.isEmpty()) {
			System.out.println("Empty stack");
		} else {
			System.out.println("Stack not empty, " + str + " on top.");
		}

		s = new Stack<>();
		if (s.isEmpty()) {
			System.out.println("Empty stack");
		} else {
			System.out.println("Stack not empty, " + s.peek() + " on top");
		}

		System.out.println();
		System.out.println("Using queue now");

		Queue<String> q = new LinkedList<String>();
		String st = "gklhi";
		for (int i = 0; i < st.length(); i++) {
			q.isEmpty();
		}

		System.out.println(q);

		q.add("R");
		q.add("o");
		q.add("y");
		System.out.println(q);
		String str1 = q.peek();

	}
}
