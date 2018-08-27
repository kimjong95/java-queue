package queue.structure;

import java.util.Queue;

public class QueueTest {
	
	public static void main(String args[]) {
		//
		MyQueue queue = new MyQueue();
		
		queue.offer("Test1");
		queue.offer("Test2");
		queue.offer("Test3");
		
		System.out.println(queue.peek());
		System.out.println(queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.size());
		
	}
}
