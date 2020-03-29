package projectCode20280;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CircularlyLinkedListTest {

	@Test
	void testIsEmpty() {	
		
		CircularlyLinkedList<Integer> list = new CircularlyLinkedList<Integer>();
		
		assertEquals(list.isEmpty(),true,"isEmpty must return true at Intialization of CircularlyLinkedList");
		list.add(0,1);
		assertEquals(list.isEmpty(),false,"isEmpty must return false when elements exist in list");
		
	}

	@Test
	void testGet() {
		
		CircularlyLinkedList<Integer> list = new CircularlyLinkedList<Integer>();
		
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		
		assertEquals(1,list.get(0),"list.get(0) should get first element(1) in the list");
		assertEquals(2,list.get(1),2,"list.get(1) should get second element(2) in the list");
		assertEquals(3,list.get(2),3,"list.get(2) should get third element(3) in the list");
		assertEquals(4,list.get(3),4,"list.get(3) should get forth element(4) in the list");
		
	}

	
	
	@Test
	void testAdd() {
		
		CircularlyLinkedList<Integer> list = new CircularlyLinkedList<Integer>();
		
		//Testing adding them normally
		list.add(0, 1);
		list.add(1, 2);
		
		list.add(2, 3);
		list.add(3, 4);
		
		assertEquals(1,list.get(0),"list.add(0,1) should place 1 at the index 0" );
		assertEquals(2,list.get(1),"list.add(1,2) should place 2 at the index 1" );
		assertEquals(3,list.get(2),"list.add(2,3) should place 3 at the index 2" );
		assertEquals(4,list.get(3),"list.add(3,4) should place 4 at the index 3" );
		
		//Testing adding between existing elements
		
		list.add(1, 10);
		assertEquals(10,list.get(1),"list.add(1,10) should place 10 at the index 1");
		assertEquals(2,list.get(2),"after list.add(1,10) the previous element(2) should be at index 2");
		
		

	}

	@Test
	void testRemove() {
		
		CircularlyLinkedList<Integer> list = new CircularlyLinkedList<Integer>();
		
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, 3);
		list.add(3, 4);
		
		//testing if the correct elements are returned
		assertEquals(1,list.remove(0),"list.remove(0) should return element(1) from the index (0) ");
		assertEquals(2,list.remove(0),"list.remove(1) should return element(2) from the index (1)");
		//testing if remove breaks list indexing
		assertEquals(3, list.get(0),"list.remove should decrement the next element of lists idex");
	}

	@Test
	void testSize() {
		
		CircularlyLinkedList<Integer> list = new CircularlyLinkedList<Integer>();
		
		list.add(0, 1);
		list.add(1, 2);
		
		assertEquals(2, list.size(),"list.size() should return the size (2)");
		list.add(2, 3);
		list.add(3, 4);
		assertEquals(4, list.size(),"list.size() should return the size (4)");
		
		
	}

	@Test
	void testRemoveFirst() {
		
		CircularlyLinkedList<Integer> list = new CircularlyLinkedList<Integer>();
		
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, 3);
		list.add(3, 4);
		
		assertEquals(1,list.removeFirst(),"list.removeFirst() should return the first element (1)");
		assertEquals(2,list.removeFirst(),"list.removeFirst() should return the first element (2)");
		
		
		
	}

	@Test
	void testRemoveLast() {
		
		CircularlyLinkedList<Integer> list = new CircularlyLinkedList<Integer>();
		
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, 3);
		list.add(3, 4);
		
		assertEquals(4, list.removeLast(),"list.removeLast() should return the last element (4)");
		assertEquals(3, list.removeLast(),"list.removeLast() should return the last element (3)");
		assertEquals(2, list.removeLast(),"list.removeLast() should return the last element (2)");
		assertEquals(1, list.removeLast(),"list.removeLast() should return the last element (1)");
		
	}

	@Test
	void testAddFirst() {
		CircularlyLinkedList<Integer> list = new CircularlyLinkedList<Integer>();
		
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addFirst(4);
		
		assertEquals(4, list.get(0),"list.addFirst(4) should add 4 to the head of the list");
		assertEquals(3, list.get(1),"list.addFirst(3) should add 3 to the head of the list");
		assertEquals(2, list.get(2),"list.addFirst(2) should add 2 to the head of the list");
		assertEquals(1, list.get(3),"list.addFirst(1) should add 1 to the head of the list");
		
	}

	@Test
	void testAddLast() {
		CircularlyLinkedList<Integer> list = new CircularlyLinkedList<Integer>();
		
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		
		assertEquals(4,list.get(list.size()-1),"list.addLast(4) should dd element 4 to end of list");
	
	}

	@Test
	void testToString() {
		CircularlyLinkedList<Integer> list = new CircularlyLinkedList<Integer>();
		
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		
		assertEquals("[1, 2, 3, 4, ]", list.toString());
		
	}

}
