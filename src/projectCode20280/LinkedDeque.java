package projectCode20280;

/**
 * @author Peter O'Donnell
 *
 * LinkedDeque implementation using DoublyLinkedList implementation
 */
public class LinkedDeque<E> implements Deque<E> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	DoublyLinkedList<E> queue;
	
	
	
	LinkedDeque() {
		queue = new DoublyLinkedList<E>();
	}
	
	
	
	@Override
	public int size() {

		return  queue.size();
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return queue.isEmpty();
	}

	/**
	 *This method returns the first element in the queue without removing the element
	 *@return E element from head of queue
	 */
	@Override
	public E first() {
		return queue.get(0);
	}
	/**
	 *This method returns the last element in the queue without removing the element
	 *@return E element from end of queue
	 */
	@Override
	public E last() {
		return queue.get(queue.size()-1);
	}

	/**
	 *This method adds the element to the head of the queue
	 *@param E element to be added to head of queue
	 */
	@Override
	public void addFirst(E e) {
		queue.addFirst(e);
		
	}
	/**
	 *This method adds the element to the end of the queue
	 *@param E element to be added to end of queue
	 */
	@Override
	public void addLast(E e) {
		queue.addLast(e);
		
	}

	/**
	 *This method removes the element situated at the head of the queue and places the element at index 2 at the head of the queue
	 *@return element which use to situate the head of the queue
	 */
	@Override
	public E removeFirst() {
		return queue.removeFirst();
	}

	/**
	 *This method removes the last element of the queue
	 *@return element which use to sit at end of queue
	 */
	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		return queue.removeLast();
	}

}
