package projectCode20280;

import java.util.Iterator;
import java.util.LinkedList;

public class SinglyLinkedList<E> implements List<E> {

	private Node<E> head;
	private Node<E> tail;
	private int size = 0;

	//Node class
	private static class Node<E> {

		//Object which is held in the node
		private E element;

		//Pointer to next node
		private Node<E> next;

		
		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}

		
		/**	This method returns element from node
		 * @return Element stored in Node
		 */
		public E getElement() {
			return element;
		}

		/** This method adds element to Node
		 * @param element to be set in Node 
		 */
		public void setElement(E element) {
			this.element = element;
		}

		/** This method gets Node which variable next is pointing to
		 * @return Node which next is pointing to
		 */
		public Node<E> getNext() {
			return next;
		}

		/** This method sets the Node which variable next is pointing to
		 * @param Node to be set at variable next within current node
		 */
		public void setNext(Node<E> n) {
			next = n;
		}

	}

	
	/**
	 *@return returns true if empty and false if not empty
	 */
	@Override
	public boolean isEmpty() {

		return(size <= 0);
	}

	/**
	 * This method returns the element currently placed at given index i without removing the element
	 * @param index i of element in list you wish to get
	 * @return element placed at index i or null if element does not exist
	 */
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

	/**
	 *This method adds the given element e to the LinkedList at index i
	 *@param index i of the place you wish to place element e
	 *@param element e which you wish to add to the linkedlist
	 *
	 */
	@Override
	public void add(int i, E e) {

		Node<E> currentNode = head;

		if (i >= 0 && i <= size || size == 0) {

			if (size == 0) {
				head = new Node<E>(e, null);
				size++;
			} else if (i == 0) {
				this.addFirst(e);
			}

			else {
				for (int j = 0; j < size; j++) {
					if (j == i - 1) {
						currentNode.setNext(new Node<E>(e, currentNode.next));
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

	/**
	 *This method adds the given element e to the LinkedList at index i
	 *@param index i of the place you wish to remove element e
	 *@return element which was removed from list
	 *
	 */
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
				return temp.getElement();
			} else {
				
				previousNode = currentNode;
				currentNode = currentNode.getNext();

				for (int j = 1; j < size; j++) {
					if (i== j) {
						temp = currentNode;
						previousNode.next= currentNode.getNext();
						size--;
						return temp.getElement();
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
			head = new Node<E>(e, head);
			size++;
		} else {
			head = new Node<E>(e, null);
			size++;
		}

	}
	
	public E first() {
		if(head != null)
		return head.getElement(); else {
			return null;
		}
		}
	
	public E last() {
		if(size > 0) {
			return get(size-1);
		} else {
			return null;
		}
	}
	
	@Override
	public void addLast(E e) {
		this.add(size, e);

	}

	public String toString() {

		Node<E> currentNode = head;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < size; i++) {

			if (i == 0) {
				sb.append("[" + currentNode.getElement().toString() + ", ");
			} else {
				sb.append(currentNode.getElement() + ", ");
			}
			currentNode = currentNode.next;

		}
		sb.delete(sb.lastIndexOf(", "),sb.lastIndexOf(", ") + 2);
		sb.append("]");

		return sb.toString();
	}
	

	
	
	
}
