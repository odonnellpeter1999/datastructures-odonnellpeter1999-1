package projectCode20280;

public class ArrayQueue<E> implements Queue<E> {

public static final int CAPACITY = 5;
	
	private E[] data;
	private int front = -1;
	private int rear = -1;

	private int size = 0;
	
	public ArrayQueue() {
		this(CAPACITY);
	}

	
	@SuppressWarnings({"unchecked"})
	public ArrayQueue(int capacity) {
		data = (E[]) new Object[capacity];
	}
	
	

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return((size == 0));
	}

	@Override
	public void enqueue(E e) {
		
		if (size != CAPACITY) {
			if (rear == -1) {
				front++;
				rear++;
				data[rear] = e;
				size++;
			}
			else if (rear == CAPACITY - 1 && front != 0) {
				rear = 0;
				data[rear] = e;
				size++;
			} else {
				rear++;
				data[rear] = e;
				size++;
			}
			
		} else {
			throw new IllegalArgumentException("ERROR QUEUE IS AT FULL CAPACITY");
		}
		
		
		
		
		
		
	}

	@Override
	public E first() {
		return data[front];
	}

	@Override
	public E dequeue() {
		
		E result = data[front];
		data[front] = null;
		front++;
		if(front == CAPACITY) {
			front = 0;
		}
		size--;
		//System.out.println("DEQUEUE:FRONT=" + front + ":REAR=" + rear);
		return result;
		
		
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int i = front;
		
		sb.append("[");
		for(;i<=rear;i++) {
			
			sb.append(data[i] + ", ");
			
		}
		sb.append("]");
		
		
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		ArrayQueue<String> aq = new ArrayQueue<String>();
		
		System.out.println(aq.isEmpty());
		aq.enqueue("Hello");
		aq.enqueue("Maybe");
		aq.enqueue("Might");
		aq.enqueue("Whoops");
		aq.enqueue("WOW");
		System.out.println(aq.toString());
		aq.dequeue();
		aq.dequeue();
		System.out.println(aq.toString());
		aq.enqueue("Jesus");
		aq.enqueue("WonderKid");
		System.out.println(aq.toString());
//		aq.dequeue();
//		System.out.println(aq.toString());
//		System.out.println(aq.isEmpty());
//		aq.dequeue();
//		System.out.println(aq.toString());
		
	}

}
