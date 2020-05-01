package projectCode20280;

import java.util.Iterator;
import java.util.Queue;



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

  /** Nested static class for a binary tree node. */
  

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
		
		public String toString() {
			
			return new StringBuilder("(").append(element).append(")").toString();
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
			size++;
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
			throw new IllegalArgumentException("Cannot remove a null position");
		}
		
		E result = p.getElement();

		Node<E> node = validate(p);
		
		if (node.getLeft() != null && node.getRight() != null) {
			throw new IllegalArgumentException("Position has two children");
		}

		if(node != root)
		if(node.getParent().getLeft() == node ) {
			
			if(node.getLeft() == null && node.getRight() != null) {
				node.getParent().setLeft(node.getRight());
			}
			
			if(node.getLeft() != null && node.getRight() == null) {
				node.getParent().setLeft(node.getLeft());
			}
			
		}
		
		if(node != root)
		if(node.getParent().getRight() == node ) {
			
			if(node.getLeft() == null && node.getRight() != null) {
				node.getParent().setRight(node.getRight());
			}
			
			if(node.getLeft() != null && node.getRight() == null) {
				node.getParent().setRight(node.getLeft());
			}
			
		}
		size--;
		

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

	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (Position<E> p : positions()) {
			sb.append(p.getElement());
			sb.append(", ");
		}
		sb.delete(sb.lastIndexOf(", "),sb.lastIndexOf(", ") + 2);
		sb.append("]");
		return sb.toString();
	}
	
	public void levelOrderInsert(E e) {
		
		
		LinkedQueue<Node> q = new LinkedQueue<Node>();
		
		if(root != null) {
		q.enqueue(root);
		} else {
			root = createNode(e, null, null, null);
			size++;
			return;
		}
		
		while(!q.isEmpty()) {
			Node node = q.dequeue();
			
			if(node.left == null) {
				node.left = createNode(e, node,null, null);
				size++;
				return;
			} else {
				q.enqueue(node.left);
			}
			
			if(node.right == null) {
				node.right = createNode(e, node,null, null);
				size++;
				return;
			} else {
				q.enqueue(node.right);
			}
		}
		
		
		
	}
	
	
	//testing function
	public void createLevelOrder(E[] arr) {
		
		for(int i = 0;i<arr.length;i++) {
		
			levelOrderInsert((E) arr[i]);
		}
		
		
	}
	
	//Assignment 2 Code------------------------------------------------------------------------------------- 
	public boolean isMirrored(Node a,Node b) {
		
		if(a == null || b == null)
			return true;
		
		
		return (a != null && b != null) && isMirrored(a.left,b.right) && isMirrored(a.right,b.left);
		
	}
	
	
	public boolean isMirrored(Node root) {
		return isMirrored(root.right, root.left);
	}
	
	
	public void mirror(Node root) {
		
		if(root == null) {
			return;
		} else {
			swapChildren(root);
			mirror(root.getLeft());
			mirror(root.getRight());
		}
		
	}

	public void swapChildren(Node root) {
		if(root != null) {
			Node temp = root.getRight();
			root.setRight(root.getLeft());
			root.setLeft(temp);
		} else {
			throw new IllegalArgumentException("Root is empty");
		}
	}
	
	public void mirror() {
		mirror(root);
	}
	
	
	public String calculateBinary(Node<E> number,Node<E> root) {
		
		
		StringBuilder sb = new StringBuilder("");
		if(root == null) {
			return "";
		}
		
		if(root.getElement() == number.getElement()) {
			return "";
		}
		
		if(root.getElement().compareTo(number.getElement()) < 0) {
			sb.append("1");
			sb.append(calculateBinary(number, root.getRight()));

		} else {
			sb.append("0");
			sb.append(calculateBinary(number, root.getLeft()));
		}
		
		return sb.toString();
		
	}
	
	public String calculateBinary(Position<E> number,Position<E> root) {
		Node <E>numberN = validate(number);
		Node <E> rootN = validate(root);
		
		return calculateBinary(numberN, rootN);
	}
	
	
	public int dist(Node<E> number1,Node<E> number2) {
		
		String s1 = calculateBinary(number1, root);
		String s2 = calculateBinary(number2, root);
		
		for(int i = 0;i<s1.length() && i < s2.length();i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				return (s1.length() -i) + (s2.length()-i);
			}
		}
		
		if(s1.length() == s2.length()) {
			return 0;
		} else if(s1.length() > s2.length()) {
			return s1.length() - s2.length(); 
		} else {
			return s2.length() - s2.length();
		}
	}
	
	
	public int dist(Position<E> number1,Position<E> number2) {
		Node <E>number1N = validate(number1);
		Node <E> number2N = validate(number2);
		
		return dist(number1N,number2N);
		
	}
	
	
	
			
		
	

	public static void main(String[] args) {
		LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<Integer>();

		int[] arr = { 44, 17,88, 8, 32,65 , 97, 28,54,82,93,21,29,76,80 };
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			 bt.insert(arr[i]);
		}
		
		System.out.println(bt);
		
//		bt.mirror();
//		
//		System.out.println(bt);
		
		System.out.println(bt.calculateBinary(bt.left(bt.left(bt.right(bt.root()))),bt.root()));
		System.out.println(bt.calculateBinary(bt.left(bt.right(bt.right(bt.root()))),bt.root()));
		
		System.out.println(bt.dist(bt.left(bt.left(bt.right(bt.root()))), bt.left(bt.right(bt.right(bt.root())))));
		
		System.out.println(bt.calculateBinary(bt.right(bt.left(bt.right(bt.left(bt.right(bt.root()))))), bt.root()));
		System.out.println(bt.calculateBinary(bt.left(bt.left(bt.right(bt.left(bt.root())))), bt.root()));
		
		System.out.println();
		
		System.out.println(bt.dist(bt.right(bt.left(bt.right(bt.left(bt.right(bt.root()))))), bt.left(bt.left(bt.right(bt.left(bt.root()))))));
		
	}
}
