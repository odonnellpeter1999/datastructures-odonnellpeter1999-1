package projectCode20280;

public class LinkedQueue<E> implements Queue<E> {
	
	SinglyLinkedList<E> ll = new SinglyLinkedList<E>();

	public static void main(String[] args) {

		
		LinkedQueue<String> lq = new LinkedQueue<String>();
		
		System.out.println(lq.isEmpty());
		lq.enqueue("Hello");
		lq.enqueue("Maybe");
		lq.enqueue("Might");
		lq.enqueue("Whoops");
		lq.enqueue("WOW");
		System.out.println(lq.toString());
		lq.dequeue();
		lq.dequeue();
		System.out.println(lq.toString());
		lq.enqueue("Jesus");
		lq.enqueue("WonderKid");
		System.out.println(lq.toString());
		lq.dequeue();
		System.out.println(lq.toString());
		System.out.println(lq.isEmpty());
		lq.dequeue();
		System.out.println(lq.toString());
		System.out.println(lq.first());

	}

	@Override
	public int size() {
		return ll.size();
	}

	@Override
	public boolean isEmpty() {
		
		return ll.isEmpty();
	}

	@Override
	public void enqueue(E e) {
		ll.addLast(e);
		
	}

	@Override
	public E first() {
		
		return ll.get(0);
	}

	@Override
	public E dequeue() {
		
		return ll.removeFirst();
	}
	
	@Override 
	public String toString() {
		return ll.toString();
	}

}
