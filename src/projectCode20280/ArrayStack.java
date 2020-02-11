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
	
	
	

	@Override
	public int size() {
		return top  + 1;
	}

	@Override
	public boolean isEmpty() {
		return (top == -1);
	}

	@Override
	public void push(E e) {
		data[top + 1] = e;
		top++;
		
		
	}

	@Override
	public E top() {
		return data[top];
	}

	@Override
	public E pop() {
		E temp = data[top];
		data[top] = null;
		top--;
		return temp;
		
	}
	@Override 
	public String toString() {
		String result = null;
		for(int i =0;i<top;i++) {
			
			if(result == null) {
				result = data[i].toString();
			} else {
				result = result + data[i].toString();
			}
			
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		ArrayStack<String> as = new ArrayStack<String>(1000);
		
		as.push("H");
		as.push("A");
		as.push("A");
		System.out.println(as.toString());
		System.out.print(as.pop());
		System.out.print(as.pop());
		System.out.print(as.pop());
		System.out.println(as.toString());

	}

}
