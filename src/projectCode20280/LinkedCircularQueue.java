package projectCode20280;

/**
 * Realization of a circular FIFO queue as an adaptation of a
 * CircularlyLinkedList. This provides one additional method not part of the
 * general Queue interface. A call to rotate() is a more efficient simulation of
 * the combination enqueue(dequeue()). All operations are performed in constant
 * time.
 */

public class LinkedCircularQueue<E> implements Queue<E> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	CircularlyLinkedList<E> queue;
	
	/**
	 * Constructor to initialize list 
	 */
	public LinkedCircularQueue() {
		
		queue = new CircularlyLinkedList<E>();
	}

	
	@Override
	public int size() {
		return queue.size();
	}
	
	
	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	/**
	 *Method adds element to the front of the queue
	 *@param E element to be added to front of queue
	 */
	@Override
	public void enqueue(E e) {
		queue.addLast(e); 
	}

	/**
	 *Method gets but does not remove first element in list
	 *@param E element at front of queue
	 */
	@Override
	public E first() {
		return queue.get(0);

	}

	/**
	 *Method removes and returns element at front of the queue
	 */
	@Override
	public E dequeue() {
		return queue.removeFirst(); }

}
