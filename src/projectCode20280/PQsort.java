package projectCode20280;

import java.util.LinkedList;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PQsort {

	public static void fillRandom(SinglyLinkedList<Integer> ll,int n,int MAX ) {
		Random rnd = new Random();
		
		for(int i = 0;i< n;++i) {
			
			ll.addLast(rnd.nextInt() % MAX);
			
		}
	}
	
	public static Integer removeMin(SinglyLinkedList<Integer> arr) {
		
		 Integer smallest = arr.get(0);
		 int minindex = 0;
		
		for(int i = 0;i<arr.size();i++) {
			if(smallest > arr.get(i)) {
				smallest = arr.get(i);
				minindex = i;
			}
		}
		
		arr.remove(minindex);
		return smallest;
	}
	
	public static boolean isSorted(SinglyLinkedList<Integer> array, int length) {
	    if (array == null || length < 2) 
	        return true; 
	    if (array.get(length - 2) > array.get(length - 1))
	        return false;
	    return isSorted(array, length - 1);
	}
	
	public static void main(String[] args) {
		SinglyLinkedList<Integer> arr = new SinglyLinkedList<Integer>();
		SinglyLinkedList<Integer> pq = new SinglyLinkedList<Integer>();		
		
		int n = 10;
		
		while(n < 1000) {
		fillRandom(arr,n,1000);
		long startTime = System.nanoTime();
		
		while(!arr.isEmpty()) {
			pq.addLast(arr.removeFirst());
		}
		
		
		while(!pq.isEmpty()) {
			arr.addLast(removeMin(pq));
		}
		
		long endTime = System.nanoTime();
		long elaspedTime = endTime - startTime;
		
		
		n = (int) (n * 1.2);
		
		System.out.print( n + ", " + elaspedTime);
		System.out.println("  " + isSorted(arr, pq.size()));
		
	}
	}

	
		
		public static void frog(String[] args) {
			SinglyLinkedList<Integer> arr = new SinglyLinkedList<Integer>();
			HeapPriorityQueue<Integer,Integer> pq = new HeapPriorityQueue<Integer,Integer>();		
			
			int n = 10;
			
			while(n < 1000) {
			fillRandom(arr,n,1000);
			long startTime = System.nanoTime();
			
			while(!arr.isEmpty()) {
				int a = arr.removeFirst();
				pq.insert(a,a);
			}
			
			
			while(!pq.isEmpty()) {
				arr.addLast(pq.removeMin().getKey());
			}
			
			
			
			long endTime = System.nanoTime();
			long elaspedTime = endTime - startTime;
			
			
			n = (int) (n * 1.2);
			
			System.out.print( n + ", " + elaspedTime);
			System.out.println( " ," + isSorted(arr, pq.size()));
			
			
			
			
		}
		
	}
}
	


