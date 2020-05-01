package projectCode20280;

public class ArrayStack<E> implements Stack<E> {
	public static final int CAPACITY = 1000;
	
	private E[] data;
	private int top = -1;
	
	public ArrayStack() {
		this(CAPACITY);
	}
	
	@SuppressWarnings({"unchecked"})
	public ArrayStack(int capacity) {
		data = (E[]) new Object[capacity];
	}
	
	

	/**
	 *This method returns size of stack
	 */
	@Override
	public int size() {
		return top  + 1;
	}

	/**
	 *This method returns true when stack is empty
	 */
	@Override
	public boolean isEmpty() {
		return (top == -1);
	}

	/**
	 *This method adds an element to the top of the stack
	 */
	@Override
	public void push(E e) {
		data[top + 1] = e;
		top++;
		
		
	}

	/**
	 * This method returns the element which is on top of the stack but does not remove element from stack
	 */
	@Override
	public E top() {
		return data[top];
	}
	

	/**
	 *This method removes and returns the element which was on top of stack
	 *@return Element which was in top position of stack
	 */
	@Override
	public E pop() {
		E temp = data[top];
		data[top] = null;
		top--;
		return temp;
		
	}
	
	/**
	 *This method returns the stack in string form
	 */
	@Override 
	public String toString() {
		
		if(data[0] == null) {
			return "STACK IS EMPTY";
		}
		
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		for(int i = 0;i < top + 1 ;i++) {
			sb.append(data[i] + ", ");
			
			}
		
	
		sb.delete(sb.lastIndexOf(", "),sb.lastIndexOf(", ") + 2);
		sb.append(" ]");
		
		return sb.toString();
	}
	

}
