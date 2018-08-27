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
		// element�� queue�� ����

		if (element.equals(null)) {
			throw new NullPointerException("null���� �߰��� �� �����ϴ�.");
		}

		if(isFull()) { //�迭�� ���� á�� ��
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
		// head��ġ�� element�� ��ȯ
		return queueArray[head];
	}

	@Override
	public String poll() {
		// head��ġ�� element�� ��ȯ�� �� queue���� �ش� ������ ����

		String findElement = peek();
		if (empty()) {
			return findElement;
		}

		head++;

		return findElement;
	}

	@Override
	public int size() {
		// ������ ��ȯ
		return (tail - head) + 1;
	}

	@Override
	public boolean empty() {
		// queue�� ����ִ��� Ȯ�� �� ��������� true / else false
		return (head == (tail + 1));
	}
	
	private String[] arrayException(String[] array) {
		// queue�� ����ϴ� �迭�� �պκ��� ����� �� �迭�� �ʱ�ȭ ����
		String[] tempArray = new String[queueArray.length];
		int newIndex = 0;
		for(int i = 0; i < (tail-head)-1; i++) {
			tempArray[newIndex] = queueArray[i];
			newIndex++;
		}
		return tempArray;
	}
	private String[] raisedArray(String[] array) {
		// queue�� �迭�� �� á���� ũ�⸦ 2��� �÷���
		String[] tempArray = new String[queueArray.length * 2];
		for (int i = 0; i < queueArray.length; i++) {
			tempArray[i] = queueArray[i];
		}
		return tempArray;
	}
	
	private boolean isFull() {
		// �迭�� �� á���� �ݻ�
		boolean isFull = false;
		if(queueArray.length == (size()-1)) {
			isFull = true;
		}
		
		return isFull;
	}
}
