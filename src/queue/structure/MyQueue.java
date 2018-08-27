package queue.structure;

public class MyQueue implements MyStringQueue {
	//
	private int head;
	private int tail;
	private String[] queueArray;

	public MyQueue() {
		//
		head = 0;
		tail = -1;
		this.queueArray = new String[10]; // array defualtSize = 10
	}

	public MyQueue(int size) {
		//
		head = 0;
		tail = -1;
		this.queueArray = new String[size];
	}

	@Override
	public boolean offer(String element) {
		// element를 queue에 삽입

		if (element.equals(null)) {
			throw new NullPointerException("null값을 추가할 수 없습니다.");
		}

		if(isFull()) { //배열이 가득 찼을 때
			queueArray = raisedArray(queueArray);
		}
		
		if(queueArray.length < head/2) {
			queueArray = arrayException(queueArray);
		}
		
		queueArray[++tail] = element;
		return true;
	}

	@Override
	public String peek() {
		// head위치의 element를 반환
		return queueArray[head];
	}

	@Override
	public String poll() {
		// head위치의 element를 반환한 후 queue에서 해당 데이터 삭제

		String findElement = peek();
		if (empty()) {
			return findElement;
		}

		head++;

		return findElement;
	}

	@Override
	public int size() {
		// 사이즈 반환
		return (tail - head) + 1;
	}

	@Override
	public boolean empty() {
		// queue가 비어있는지 확인 후 비어있으면 true / else false
		return (head == (tail + 1));
	}
	
	private String[] arrayException(String[] array) {
		// queue에 사용하는 배열의 앞부분이 낭비될 때 배열을 초기화 해줌
		String[] tempArray = new String[queueArray.length];
		int newIndex = 0;
		for(int i = 0; i < (tail-head)-1; i++) {
			tempArray[newIndex] = queueArray[i];
			newIndex++;
		}
		return tempArray;
	}
	private String[] raisedArray(String[] array) {
		// queue의 배열이 꽉 찼으면 크기를 2배로 늘려줌
		String[] tempArray = new String[queueArray.length * 2];
		for (int i = 0; i < queueArray.length; i++) {
			tempArray[i] = queueArray[i];
		}
		return tempArray;
	}
	
	private boolean isFull() {
		// 배열이 꽉 찼는지 금사
		boolean isFull = false;
		if(queueArray.length == (size()-1)) {
			isFull = true;
		}
		
		return isFull;
	}
}
