package hw8;

public class StackQueueSolver {

	public static int lastCustomer(int numPersons, int numToBack) {
		MyQueue<Integer> queue = new ArrayQueue<Integer>();
		int count = 0;
		int size = numPersons;
		for (int i = 1; i <= numPersons; i++) {
			queue.enqueue(i);
		}

		while (size > 1) {
			for (int j = 0; j < numToBack; j++) {
				queue.enqueue(queue.dequeue());
				count++;
			}
			queue.dequeue();
			size--;
		}

		System.out.println("Person: " + numPersons + "  N: " + numToBack+ " Runtime: " + count);
		return queue.dequeue();
	}

	// Runtime O(n)
	public static <E> boolean areEqual(MyStack<E> stack1, MyStack<E> stack2) {
		if (stack1.equals(stack2)) {
			return true;
		}

		boolean flag = false;
		MyStack<String> temp = new ArrayStack<String>();

		while (!stack1.isEmpty() && !stack2.isEmpty()) {
			if (!stack1.peek().equals(stack2.peek())) {
				break;
			}
			temp.push((String) stack1.pop());
			temp.push((String) stack2.pop());
		}

		if (stack1.isEmpty() && stack2.isEmpty()) {
			flag = true;
		}

		while (!temp.isEmpty()) {
			stack2.push((E) temp.pop());
			stack1.push((E) temp.pop());
		}

		return flag;
	}

	// Runtime O(n)
	public static <E> MyStack<E> duplicateStack(MyStack<E> original) {
		MyStack<Integer> result = new ArrayStack<Integer>();
		MyQueue<Integer> temp = new ArrayQueue<Integer>();

		
		while (!original.isEmpty()) {
			temp.enqueue((Integer) original.pop());
		}
		while (!temp.isEmpty()) {
			original.push((E) temp.dequeue());
		}

	
		while (!original.isEmpty()) {
			result.push((Integer) original.peek());
			
			temp.enqueue((Integer) original.pop());
		}

		
		while (!temp.isEmpty()) {
			original.push((E) temp.dequeue());
		}

		return (MyStack<E>) result; 
	}
}