package projectCode20280;

import java.util.Iterator;


public class DoublyLinkedList<E> implements List<E>{
	
	
	private Node<E> head;
	private int size;

	private static class Node<E> {

		private E element;

		private Node<E> next;
		
		private Node<E> previous;

		public Node(E e, Node<E> n,Node<E> p) {
			element = e;
			next = n;
			previous = p;
		}

		public E getElement() {
			return element;
		}

		public Node<E> getNext() {
			return next;
		}
		
		public Node<E> getPrevious() {
			return previous;
		}

		public void setNext(Node<E> n) {
			next = n;
		}
		
		public void setPrevious(Node<E> p) {
			previous = p;
		}

	}
	
	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		
		Node<E> currentNode = head;
		
		if(predecessor !=  null && successor != null) {
		
			for(int j = 1;j<size-1;j++ ) {
				
				if(currentNode == predecessor && currentNode.next == successor) {
					
					currentNode.next = new Node<E>(e, successor, predecessor);
					predecessor.previous = currentNode.next;
				} else {
					currentNode = currentNode.next;
				}
			}
			
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	public boolean isEmpty() {

		if (size == 0) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public E get(int i) {

		Node<E> currentNode = head;

		if (i < size && i >= 0) {
			for (int j = 0; j < size; j++) {
				if (j == i) {
					return currentNode.getElement();
				} else {
					currentNode = currentNode.getNext();
				}
			}

		} else {
			currentNode = null;
		}

		return currentNode.getElement();

	}

	@Override
	public void add(int i, E e) {

		Node<E> currentNode = head;

		if (i >= 0 && i <= size || size == 0) {

			if (size == 0) {
				head = new Node<E>(e, null, null);
				size++;
			} else if (i == 0) {
				this.addFirst(e);
			}

			else {
				for (int j = 0; j < size; j++) {
					if (j == i - 1) {
						currentNode.setNext(new Node<E>(e, currentNode.next, currentNode));
						size++;
					} else {
						currentNode = currentNode.next;
					}
				}
			}

		} else {
			throw new IllegalArgumentException("OUT OF BOUNDS:add()");
		}
	}

	@Override
	public E remove(int i) {
		Node<E> previousNode;
		Node<E> currentNode = head;
		Node<E> temp;

		if (i >= 0 && i < size) {

			if (size == 1) {
				temp = head;
				head = null;
				size--;
				return temp.getElement();
				
			} else if (i == 0) {
				temp = head;
				head = head.getNext();
				size--;
				return head.getElement();
			} else {
				
				previousNode = currentNode;
				currentNode = currentNode.getNext();

				for (int j = 1; j < size; j++) {
					if (i== j) {
						temp = currentNode;
						previousNode.next = currentNode.getNext();
						size--;
						return currentNode.getElement();
					} else {
						previousNode = currentNode;
						currentNode = currentNode.getNext();	
					}
				}
			}

		} 
			throw new IllegalArgumentException("OUT OF BOUNDS:remove()");
		

	}

	public Iterator<E> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<E> {
		Node curr;

		public ListIterator() {
			curr = head;

		}

		public boolean hasNext() {
			return curr != null;
		}

		@Override
		public E next() {
			E res = (E) curr.getElement();
			curr = curr.getNext();
			return res;
		}
	}

	@Override
	public int size() {

		return size;
	}

	@Override
	public E removeFirst() {
		Node<E> result = head;
		head = head.next;
		size--;

		return result.getElement();

	}

	@Override
	public E removeLast() {
		return this.remove(size - 1);
	}

	@Override
	public void addFirst(E e) {
		if (size != 0) {
			head = new Node<E>(e, head,null);
			size++;
		} else {
			head = new Node<E>(e, null,null);
			size++;
		}

	}

	@Override
	public void addLast(E e) {
		this.add(size, e);

	}

	public String toString() {

		Node<E> currentNode = head;
		String result = null;
		for (int i = 0; i < size; i++) {

			if (i == 0) {
				result = currentNode.getElement().toString();
			} else {
				result = result + currentNode.getElement();
			}
			currentNode = currentNode.next;

		}

		return result;
	}
	
	
	
	public static void main(String[] args) {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<Integer>();

		for (int i = 0; i < 5; i++) {
			ll.add(0, 1);
		}
		for (int i = 0; i < 5; i++) {
			ll.addFirst(i);
		}
		for (int i = 0; i < 5; i++) {
			ll.addLast(i);
		}

		System.out.println();

		for (int i = 0; i < 5; i++) {
			System.out.println(ll.get(i));
		}

		for (int i = 0; i < 5; i++) {
			System.out.println(ll.get(i));
		}

		System.out.println(ll.isEmpty());

		System.out.println(ll.toString());


		while(ll.size() != 0) {
		ll.removeFirst();
		System.out.println(ll.size());
		System.out.println(ll.toString());
		}
		
	}

	
}
