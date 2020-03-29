package projectCode20280;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedBinaryTreeTest {

	@Test
	void testSize() {
		LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<Integer>();
		
		assertEquals(0,tree.size(),"tree.size() should return 0 when LinkedBinarytree is first intialized");
		tree.insert(100);
		tree.insert(50);
		tree.insert(150);
		tree.insert(25);
		tree.insert(75);
		tree.insert(125);
		tree.insert(175);
		
		assertEquals(7, tree.size(),"This should be equal to number of elements in the tree");
	}

	@Test
	void testRoot() {
		LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<Integer>();
		
		assertEquals(null, tree.root(),"tree.root() should return null when LinkedBinarytree is first intialized");
		tree.insert(100);
		tree.insert(50);
		tree.insert(150);
		tree.insert(25);
		tree.insert(75);
		tree.insert(125);
		tree.insert(175);
		
		assertEquals(100, tree.root().getElement(),"tree.root() should return element at root of tree");
		
	}

	@Test
	void testParent() {
		
		LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<Integer>();
		
		tree.insert(100);
		tree.insert(50);
		tree.insert(150);
		tree.insert(25);
		tree.insert(75);
		tree.insert(125);
		tree.insert(175);
		
		
		
		
	}

	@Test
	void testLeft() {
		LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<Integer>();
		
		tree.insert(100);
		tree.insert(50);
		tree.insert(150);
		tree.insert(25);
		tree.insert(75);
		tree.insert(125);
		tree.insert(175);
		
		assertEquals(50,tree.left(tree.root()).getElement(),"tree.left() should return left element of node" );
		assertEquals(25,tree.left(tree.left(tree.root())).getElement(),"tree.left() should return left element of node" );
	}

	@Test
	void testRight() {
		LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<Integer>();
		
		tree.insert(100);
		tree.insert(50);
		tree.insert(150);
		tree.insert(25);
		tree.insert(75);
		tree.insert(125);
		tree.insert(175);
		
		assertEquals(150,tree.right(tree.root()).getElement(),"tree.right() should return right element of node" );
		assertEquals(175,tree.right(tree.right(tree.root())).getElement(),"tree.right() should return right element of node" );
	}

	@Test
	void testAddRoot() {
		LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<Integer>();
		
		assertEquals(100, tree.addRoot(100).getElement(),"tree.addRoot(100) should assign the value 100 to the root ");
		
	}

	@Test
	void testInsert() {
		
		LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<Integer>();
		
		tree.insert(100);
		tree.insert(50);
		tree.insert(150);
		tree.insert(25);
		tree.insert(75);
		tree.insert(125);
		tree.insert(175);
		
		assertEquals(100,tree.root().getElement(),							"tree.insert(100) should add 100 to the root as its the first element added");
		assertEquals(50, tree.left(tree.root()).getElement(),				"tree.insert(50) should add 50 too left of the root");
		assertEquals(150, tree.right(tree.root()).getElement(),				"tree.insert(150) should add 150 too left of the root");
		assertEquals(25, tree.left(tree.left(tree.root())).getElement(),	"tree.insert(25) should add 25 too left of the root");
		assertEquals(75, tree.right(tree.left(tree.root())).getElement(),	"tree.insert(75) should add 75 too left of the root");
		assertEquals(125, tree.left(tree.right(tree.root())).getElement(),	"tree.insert(125) should add 125 too left of the root");
		assertEquals(175, tree.right(tree.right(tree.root())).getElement(),	"tree.insert(175) should add 175 too left of the root");
		
		
	}

	@Test
	void testAddLeft() {
		LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<Integer>();
		tree.insert(100);
		
		assertEquals(30,tree.addLeft(tree.root(), 30).getElement(),							"tree.addleft(tree.root(),30) should create a child node of the root containing 30 as its element");
		assertEquals(15,tree.addLeft(tree.left(tree.root()), 15).getElement(),				"tree.addleft(tree.root(),15) should create a child node of the root containing 15 as its element");
		assertEquals(10,tree.addLeft(tree.left(tree.left(tree.root())),10).getElement(),	"tree.addleft(tree.root(),10) should create a child node of the root containing 10 as its element");
		
	}

	@Test
	void testAddRight() {
		LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<Integer>();
		tree.insert(100);
		
		assertEquals(30,tree.addRight(tree.root(), 30).getElement(),							"tree.addRight(tree.root(),30) should create a child node of the root containing 30 as its element");
		assertEquals(15,tree.addRight(tree.right(tree.root()), 15).getElement(),				"tree.addRight(tree.root(),15) should create a child node of the root containing 15 as its element");
		assertEquals(10,tree.addRight(tree.right(tree.right(tree.root())),10).getElement(),		"tree.addRight(tree.root(),10) should create a child node of the root containing 10 as its element");
	}

	@Test
	void testSet() {
		LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<Integer>();
		
		tree.insert(100);
		tree.insert(50);
		tree.insert(150);
		tree.insert(25);
		tree.insert(75);
		tree.insert(125);
		tree.insert(175);
		
		assertEquals(50, tree.set(tree.left(tree.root()), 65),"tree.set() should return the element which the new element has replaced");
		assertEquals(65, tree.left(tree.root()).getElement(), "tree.set() should replace the element at the specified posiiton");
	}

	@Test
	void testAttach() {
		LinkedBinaryTree<Integer> tree1 = new LinkedBinaryTree<Integer>();
		LinkedBinaryTree<Integer> tree2 = new LinkedBinaryTree<Integer>();
		
		tree1.insert(100);
		tree1.insert(50);
		tree1.insert(150);
		tree1.insert(25);
		tree1.insert(75);
		tree1.insert(125);
		tree1.insert(175);
		
		tree2.insert(100);
		tree2.insert(50);
		tree2.insert(150);
		tree2.insert(25);
		tree2.insert(75);
		tree2.insert(125);
		tree2.insert(175);
		
		Position<Integer> p = tree1.right(tree1.right(tree1.root())); //leaf of tree 1 
		
		tree1.attach(p, tree1, tree2);
		
		assertEquals(100,tree1.left(p).getElement(),							"tree1.attach should attach the complete replicate of t1 to the left of p");
		assertEquals(50, tree1.left(tree1.left(p)).getElement(),				"tree1.attach should attach the complete replicate of t1 to the left of p");
		assertEquals(150, tree1.right(tree1.left(p)).getElement(),				"tree1.attach should attach the complete replicate of t1 to the left of p");
		assertEquals(25, tree1.left(tree1.left(tree1.left(p))).getElement(),	"tree1.attach should attach the complete replicate of t1 to the left of p");
		assertEquals(75, tree1.right(tree1.left(tree1.left(p))).getElement(),	"tree1.attach should attach the complete replicate of t1 to the left of p");
		assertEquals(125, tree1.left(tree1.right(tree1.left(p))).getElement(),	"tree1.attach should attach the complete replicate of t1 to the left of p");
		assertEquals(175, tree1.right(tree1.right(tree1.left(p))).getElement(),	"tree1.attach should attach the complete replicate of t1 to the left of p");
		
		assertEquals(100,tree1.right(p).getElement(),							"tree1.attach should attach the complete replicate of t2 to the right of p");
		assertEquals(50, tree1.left(tree1.right(p)).getElement(),				"tree1.attach should attach the complete replicate of t2 to the right of p");
		assertEquals(150, tree1.right(tree1.right(p)).getElement(),				"tree1.attach should attach the complete replicate of t2 to the right of p");
		assertEquals(25, tree1.left(tree1.left(tree1.right(p))).getElement(),	"tree1.attach should attach the complete replicate of t2 to the right of p");
		assertEquals(75, tree1.right(tree1.left(tree1.right(p))).getElement(),	"tree1.attach should attach the complete replicate of t2 to the right of p");
		assertEquals(125, tree1.left(tree1.right(tree1.right(p))).getElement(),	"tree1.attach should attach the complete replicate of t2 to the right of p");
		assertEquals(175, tree1.right(tree1.right(tree1.right(p))).getElement(),"tree1.attach should attach the complete replicate of t2 to the right of p");
		
	}

	@Test
	void testRemove() {
		
		LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<Integer>();
		LinkedBinaryTree<Integer> tree2 = new LinkedBinaryTree<Integer>();
		
		tree.insert(100);
		tree.insert(50);
		tree.insert(150);
		tree.insert(25);
		tree.insert(75);
		tree.insert(125);
		tree.insert(175);
		
		tree2.insert(100);
		tree2.insert(200);
		tree2.insert(300);
		
		
		//testing removing node with one child
		assertEquals(200,tree2.remove(tree2.right(tree2.root())),"tree.remove should when removing a node with one child should attach child to parent");
		assertEquals(300,tree2.right(tree2.root()).getElement(),"tree.remove should remove element");
		
		//testing removing root should throw error
		try {
		assertEquals(100,tree.remove(tree.root()),"tree.remove should return the root of the tree");
		assertEquals(null, tree.root(),"tree.remove when called on the root should make the root null");
		} catch (IllegalArgumentException e)  {
			
		}
		
		
	}

	@Test
	void testToString() {
		LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<Integer>();
		
		tree.insert(100);
		tree.insert(50);
		tree.insert(150);
		tree.insert(25);
		tree.insert(75);
		tree.insert(125);
		tree.insert(175);
		
		assertEquals("[25, 50, 75, 100, 125, 150, 175, ]",tree.toString(),"String does not match template");
	}

}
