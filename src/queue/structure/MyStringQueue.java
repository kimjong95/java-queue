package queue.structure;

public interface MyStringQueue {
	//
	boolean offer(String element); 
	String peek(); 
	String poll(); 
	int size(); 
	boolean empty(); 
}
