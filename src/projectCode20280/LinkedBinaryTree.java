package projectCode20280;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Concrete implementation of a binary tree using a node-based, linked
 * structure.
 */
public class LinkedBinaryTree<E extends Comparable<E>> extends AbstractBinaryTree<E> {

	/** Nested static class for a binary tree node. */
	protected static class Node<E> implements Position<E> {
		private E element;
		private Node<E> parent;
		private Node<E> left;
		private Node<E> right;

		public Node(E element, Node<E> parent, Node<E> left, Node<E> right) {
			super();
			this.element = element;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}
		
		@Override
		public E getElement() {
			return element;
		}

		public void setElement(E element) {
			this.element = element;
		}

		public Node<E> getParent() {
			return parent;
		}

		public void setParent(Node<E> parent) {
			this.parent = parent;
		}

		public Node<E> getLeft() {
			return left;
		}

		public void setLeft(Node<E> left) {
			this.left = left;
		}

		public Node<E> getRight() {
			return right;
		}

		public void setRight(Node<E> right) {
			this.right = right;
		}

	}

	/** Factory function to create a new node storing element e. */
	public Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
		return new Node<E>(e, parent, left, right);
	}
	
	// LinkedBinaryTree instance variables
	/** The root of the binary tree */
	private Node<E> root = null; // root of the tree

	/** The number of nodes in the binary tree */
	private int size = 0; // number of nodes in the tree

	// constructor
	/** Constructs an empty binary tree. */
	public LinkedBinaryTree() {

	} // constructs an empty binary tree

	// nonpublic utility
	/**
	 * Verifies that a Position belongs to the appropriate class, and is not one
	 * that has been previously removed. Note that our current implementation does
	 * not actually verify that the position belongs to this particular list
	 * instance.
	 *
	 * @param p a Position (that should belong to this tree)
	 * @return the underlying Node instance for the position
	 * @throws IllegalArgumentException if an invalid position is detected
	 */
	protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if (!(p instanceof Node))
			throw new IllegalArgumentException("Not valid position type");
		Node<E> node = (Node<E>) p; // safe cast
		if (node.getParent() == node) // our convention for defunct node
			throw new IllegalArgumentException("p is no longer in the tree");
		return node;
	}

	// accessor methods (not already implemented in AbstractBinaryTree)
	/**
	 * Returns the number of nodes in the tree.
	 * 
	 * @return number of nodes in the tree
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Returns the root Position of the tree (or null if tree is empty).
	 * 
	 * @return root Position of the tree (or null if tree is empty)
	 */
	@Override
	public Position<E> root() {
		if (root != null) {
			return root;
		} else {
			return null;
		}
	}

	/**
	 * Returns the Position of p's parent (or null if p is root).
	 *
	 * @param p A valid Position within the tree
	 * @return Position of p's parent (or null if p is root)
	 * @throws IllegalArgumentException if p is not a valid Position for this tree.
	 */
	@Override
	public Position<E> parent(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getParent();
	}

	/**
	 * Returns the Position of p's left child (or null if no child exists).
	 *
	 * @param p A valid Position within the tree
	 * @return the Position of the left child (or null if no child exists)
	 * @throws IllegalArgumentException if p is not a valid Position for this tree
	 */

	public Position<E> left(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		if (node.getLeft() == null) {
			return null;
		} else {
			return node.getLeft();
		}
	}

	/**
	 * Returns the Position of p's right child (or null if no child exists).
	 *
	 * @param p A valid Position within the tree
	 * @return the Position of the right child (or null if no child exists)
	 * @throws IllegalArgumentException if p is not a valid Position for this tree
	 */

	public Position<E> right(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getRight();
	}

	// update methods supported by this class
	/**
	 * Places element e at the root of an empty tree and returns its new Position.
	 *
	 * @param e the new element
	 * @return the Position of the new element
	 * @throws IllegalStateException if the tree is not empty
	 */
	public Position<E> addRoot(E e) throws IllegalStateException {
		if(root != null) {
			throw new IllegalArgumentException("tree is not empty");
		} else {
			root = createNode(e, null, null, null);
			return root;
		}
		
	}

	public void insert(E e) {
		// recursively add from root
		root = addRecursive(root, e);
		++size;
	}

	// recursively add Nodes to binary tree in proper position
	private Node<E> addRecursive(Node<E> p, E e) {

		if (p == null) {
			p = createNode(e, null, null, null);
			return p;
		}

		if (p.getElement().compareTo(e) > 0) {
			p.setLeft(addRecursive(p.getLeft(), e));
			p.getLeft().setParent(p);
		} else if (p.getElement().compareTo(e) < 0) {
			p.setRight(addRecursive(p.getRight(), e));
			p.getRight().setParent(p);
		}

		return p;
	}

	/**
	 * Creates a new left child of Position p storing element e and returns its
	 * Position.
	 *
	 * @param p the Position to the left of which the new element is inserted
	 * @param e the new element
	 * @return the Position of the new element
	 * @throws IllegalArgumentException if p is not a valid Position for this tree
	 * @throws IllegalArgumentException if p already has a left child
	 */
	public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> parent = validate(p);
		if (parent.getLeft() != null)
			throw new IllegalArgumentException("p already has a left child");
		Node<E> child = createNode(e, parent, null, null);
		parent.setLeft(child);
		size++;
		return child;
	}

	/**
	 * Creates a new right child of Position p storing element e and returns its
	 * Position.
	 *
	 * @param p the Position to the right of which the new element is inserted
	 * @param e the new element
	 * @return the Position of the new element
	 * @throws IllegalArgumentException if p is not a valid Position for this tree.
	 * @throws IllegalArgumentException if p already has a right child
	 */
	public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> parent = validate(p);
		if (parent.getRight() != null)
			throw new IllegalArgumentException("p already has a left child");
		Node<E> child = createNode(e, parent, null, null);
		parent.setRight(child);
		size++;
		return child;
	}

	/**
	 * Replaces the element at Position p with element e and returns the replaced
	 * element.
	 *
	 * @param p the relevant Position
	 * @param e the new element
	 * @return the replaced element
	 * @throws IllegalArgumentException if p is not a valid Position for this tree.
	 */
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E result = node.getElement();
		node.setElement(e);
		return result;
	}

	/**
	 * Attaches trees t1 and t2, respectively, as the left and right subtree of the
	 * leaf Position p. As a side effect, t1 and t2 are set to empty trees.
	 *
	 * @param p  a leaf of the tree
	 * @param t1 an independent tree whose structure becomes the left child of p
	 * @param t2 an independent tree whose structure becomes the right child of p
	 * @throws IllegalArgumentException if p is not a valid Position for this tree
	 * @throws IllegalArgumentException if p is not a leaf
	 */
	public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
		Node<E> node = validate(p);
		if (node.getLeft() == null && node.getRight() == null) {
			node.setLeft(t1.root);
			node.setRight(t2.root);
		} else {
			throw new IllegalArgumentException("P is not a leaf of this tree");
		}
	}

	/**
	 * Removes the node at Position p and replaces it with its child, if any.
	 *
	 * @param p the relevant Position
	 * @return element that was removed
	 * @throws IllegalArgumentException if p is not a valid Position for this tree.
	 * @throws IllegalArgumentException if p has two children.
	 */
	public E remove(Position<E> p) throws IllegalArgumentException {

		if(p == null) {
			throw new IllegalArgumentException("Cannot remove a null psoition");
		}
		
		E result = p.getElement();

		Node<E> node = validate(p);
		if (node.getLeft() != null && node.getRight() != null) {
			throw new IllegalArgumentException("Position has two children");
		} else if (node.getLeft() == null) {
			node.getParent().setElement(node.getRight().getElement());
			node.getParent().setRight(node.getRight());

		} else {
			node.getParent().setElement(node.getLeft().getElement());
			node.getParent().setLeft(node.getLeft());
		}

		return result;
	}

	public void maxHeap(Node<E> node) {

		if (node != null) {

			if (node.getLeft() != null) {
				if (node.getElement().compareTo(node.getLeft().getElement()) < 0) {
					swapNode(node.getLeft());
					maxHeap(node.getLeft());
					return;

				}
			} else if (node.getRight() != null) {

				if (node.getElement().compareTo(node.getRight().getElement()) < 0) {
					swapNode(node.getRight());
					maxHeap(node.getRight());
					return;

				}
			}

			if (node.getParent().getLeft() != null)
				maxHeap(node.getLeft());

			if (node.getParent().getRight() != null)
				maxHeap(node.getRight());

		} else {return;}
	}

	public void swapNode(Node<E> node) {

		if (node == null) {
			throw new IllegalArgumentException("Node is Null cannot swap");
		} else if (node.getParent() == null) {
			throw new IllegalArgumentException("Node has no parent Node cannot swap");
		}

		Node<E> parent = node.getParent();
		Node<E> lefttemp = node.getLeft();
		Node<E> righttemp = node.getRight();

		if (node == parent.getLeft()) {

			node.setLeft(parent);
			node.setRight(parent.getRight());
		} else if (node == parent.getRight()) {

			node.setRight(parent);
			node.setLeft(parent.getLeft());
		}

		if (parent != root)
			if (parent == parent.getParent().getLeft()) {
				parent.getParent().setLeft(node);

			} else if (parent == parent.getParent().getRight()) {
				parent.getParent().setRight(node);

			}

		parent.setLeft(lefttemp);
		// System.out.println(parent.getLeft().getElement());
		parent.setRight(righttemp);

		if (parent == root) {
			root = node;
		}

		// swapping parent nodes
		node.setParent(parent.getParent());
		parent.setParent(node);

	}

	public LinkedList<E> heapSort(LinkedList<E> list) {

		LinkedBinaryTree<E> tree = new LinkedBinaryTree<E>();

		if (list.isEmpty()) {
			return null;
		}

		for (int i = 0; i < list.size(); i++) {
			tree.insert(list.get(i));
		}

		System.out.println("List in Heapsort Before: " + tree.toString());
		tree.maxHeap(root);
		System.out.println("List in Heapsort After: " + tree.toString());

		return list;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (Position<E> p : positions()) {
			sb.append(p.getElement());
			sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}

	public static void main(String[] args) {
		LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<Integer>();

		int[] arr = { 12, 25, 31, 58, 36, 42, 90, 62, 75 };
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			 bt.insert(arr[i]);
		}
		
		System.out.println(bt);


	}
}
