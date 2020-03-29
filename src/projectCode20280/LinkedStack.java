package projectCode20280;

public class LinkedStack<E> implements Stack<E> {
	
	private SinglyLinkedList<E> stack = new SinglyLinkedList<E>();

	public static void main(String[] args) {
		
		LinkedStack<String> as = new LinkedStack<String>();
		as.push("H");
		as.push("A");
		as.push("A");
		System.out.println(as.toString());
		System.out.print(as.pop());
		System.out.print(as.pop());
		System.out.print(as.pop());
		System.out.println(as.toString());
		
	}
	
	@Override
	public int size() {
		return stack.size();
	}

	@Override
	public boolean isEmpty() {
		if(stack.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void push(E e) {
		stack.addFirst(e);
		
	}

	@Override
	public E top() {
		return stack.get(0);
	}

	@Override
	public E pop() {
		return stack.removeFirst();
	}
	
	public String toString() {
		return stack.toString();
	}

}
