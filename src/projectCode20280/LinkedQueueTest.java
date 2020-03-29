package projectCode20280;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedQueueTest {

	@Test
	void testSize() {
		
		LinkedQueue<Integer> q = new LinkedQueue<Integer>();
		
		q.enqueue(1);
		q.enqueue(2);
		assertEquals(2, q.size(),"q.size() should return the size (2)");
		q.enqueue(3);
		q.enqueue(4);
		assertEquals(4, q.size(),"q.size() should return the size (4)");
		
	}

	@Test
	void testIsEmpty() {	
		
		LinkedQueue<Integer> q = new LinkedQueue<Integer>();
		
		assertEquals(q.isEmpty(),true,"isEmpty must return true at Intialization of ArrayQueue");
		q.enqueue(1);
		assertEquals(q.isEmpty(),false,"isEmpty must return false when elements exist in q");
		
	}

	@Test
	void testEnqueueAndDeque() {
		LinkedQueue<Integer> q = new LinkedQueue<Integer>();
		
		//Testing adding them normally
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		
		assertEquals(1,q.dequeue(),"q.enqueue(1) should place 1 at the index 0" );
		assertEquals(2,q.dequeue(),"q.enqueue(2) should place 2 at the index 1" );
		assertEquals(3,q.dequeue(),"q.enqueue(3) should place 3 at the index 2" );
		assertEquals(4,q.dequeue(),"q.enqueue(4) should place 4 at the index 3" );
		
	}

	@Test
	void testFirst() {
		LinkedQueue<Integer> q = new LinkedQueue<Integer>();
		
		//Testing adding them normally
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		
		assertEquals(1, q.first(),"q.first() should return the first element in the queue");
		q.dequeue();
		assertEquals(2, q.first(),"q.first() should return the first element in the queue");
	}

	@Test
	void testToString() {
		LinkedQueue<Integer> q = new LinkedQueue<Integer>();
		
		//Testing adding them normally
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		
		assertEquals("[1, 2, 3, 4, ]", q.toString());
		
	}

}
