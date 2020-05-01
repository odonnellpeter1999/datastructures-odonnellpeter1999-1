package projectCode20280;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayStackTest {

	@Test
	void testSize() {
		
		ArrayStack<Integer> stack = new ArrayStack<Integer>();
		
		stack.push(1);
		stack.push(2);
		
		assertEquals(2, stack.size(),"stack.size() should return the size (2)");
		
		stack.push(3);
		stack.push(4);
		
		assertEquals(4, stack.size(),"stack.size() should return the size (4)");
		
		
	}

	@Test
	void testIsEmpty() {	
		
		ArrayStack<Integer> stack = new ArrayStack<Integer>();
		
		assertEquals(stack.isEmpty(),true,"isEmpty must return true at Intialization of SinglyLinkedstack");
		stack.push(1);
		assertEquals(stack.isEmpty(),false,"isEmpty must return false when elements exist in stack");
		
	}

	@Test
	void testPushandPop() {
		ArrayStack<Integer> q = new ArrayStack<Integer>();
		
		//Testing adding them normally
		q.push(1);	
		q.push(2);
		q.push(3);
		q.push(4);
		
		assertEquals(4,q.pop(),"q.push(1) should place 1 at the index 0" );
		assertEquals(3,q.pop(),"q.push(2) should place 2 at the index 1" );
		assertEquals(2,q.pop(),"q.push(3) should place 3 at the index 2" );
		assertEquals(1,q.pop(),"q.push(4) should place 4 at the index 3" );
	}

	@Test
	void testTop() {
		ArrayStack<Integer> q = new ArrayStack<Integer>();
		
		q.push(1);	
		q.push(2);
		q.push(3);
		q.push(4);
		
		assertEquals(4,q.top(),"q.push(1) should place 1 at the index 0" );
		q.pop();
		assertEquals(3,q.top(),"q.push(2) should place 2 at the index 1" );
		q.pop();
		assertEquals(2,q.top(),"q.push(3) should place 3 at the index 2" );
		q.pop();
		assertEquals(1,q.top(),"q.push(4) should place 4 at the index 3" );
		
	}


	@Test
	void testToString() {
		
		ArrayStack<Integer> q = new ArrayStack<Integer>();
		
		q.push(1);	
		q.push(2);
		q.push(3);
		q.push(4);
		
		assertEquals("[1, 2, 3, 4 ]", q.toString());
	}

}
