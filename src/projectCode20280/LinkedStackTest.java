package projectCode20280;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedStackTest {

	@Test
	void testSize() {
		
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		
		stack.push(1);
		stack.push(2);
		
		assertEquals(2, stack.size(),"stack.size() should return the size (2)");
		
		stack.push(3);
		stack.push(4);
		
		assertEquals(4, stack.size(),"stack.size() should return the size (4)");
		
		
	}

	@Test
	void testIsEmpty() {	
		
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		
		assertEquals(stack.isEmpty(),true,"isEmpty must return true at Intialization of SinglyLinkedstack");
		stack.push(1);
		assertEquals(stack.isEmpty(),false,"isEmpty must return false when elements exist in stack");
		
	}

	@Test
	void testPushandPop() {
		
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		
		//Testing adding them normally
		stack.push(1);	
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		assertEquals(4,stack.pop(),"q.push(1) should place 1 at the index 0" );
		assertEquals(3,stack.pop(),"q.push(2) should place 2 at the index 1" );
		assertEquals(2,stack.pop(),"q.push(3) should place 3 at the index 2" );
		assertEquals(1,stack.pop(),"q.push(4) should place 4 at the index 3" );
	}

	@Test
	void testTop() {
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		
		stack.push(1);	
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		assertEquals(4,stack.top(),"q.push(1) should place 1 at the index 0" );
		stack.pop();
		assertEquals(3,stack.top(),"q.push(2) should place 2 at the index 1" );
		stack.pop();
		assertEquals(2,stack.top(),"q.push(3) should place 3 at the index 2" );
		stack.pop();
		assertEquals(1,stack.top(),"q.push(4) should place 4 at the index 3" );
		
	}


	@Test
	void testToString() {
		
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		
		stack.push(1);	
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		assertEquals("[4, 3, 2, 1, ]", stack.toString());
	}

}
