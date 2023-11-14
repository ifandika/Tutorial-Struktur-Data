/**
 * Struktur data Queue
 * 
 */
public class MyQueue {
	private Integer[] dataQueue;
	private int front;
	private int end;
	private int size;
	
	public MyQueue(int size) {
		this.dataQueue = new Integer[size];
		this.front = -1;
		this.end = -1;
		this.size = size;
	}
	
	public Boolean enQueue(int data) {
		if(isFull()) {
			System.err.println("Queue is full");
			return false;
		}
		if(this.end == -1) {
			this.end = 0;
		}
		dataQueue[++front] = data;
		return true;
	}
	
	public Integer peek() {
		if(isEmpty()) {
			return -1;
		}
		int buffer = dataQueue[end];
		return buffer;
	}
	
	public Integer deQueue() {
		if(isEmpty()) {
			System.err.println("Queue is empty");
			return -1;
		}
		int buffer = this.dataQueue[end++];
		if(this.end > this.front) {
			this.front = -1;
			this.end = -1;
		}
		return buffer;
	}
	
	public void display() {
		for(int lop = end; lop <= front; lop++) {
			System.out.print(dataQueue[lop]+" ");
		}
		System.out.println();
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isFull() {
		return this.front == (size()-1) && this.end == 0;
	}
	
	public boolean isEmpty() {
		return this.front == -1 || this.end == size();
	}
	
	public static void main (String[] args) {
		
		MyQueue queue = new MyQueue(5);
		
		System.out.println(queue.enQueue(10));
		System.out.println(queue.enQueue(5));
		System.out.println(queue.enQueue(15));
		System.out.println(queue.enQueue(25));
		System.out.println(queue.enQueue(100));
		
		queue.display();
		
		System.out.println("dequeue: "+queue.deQueue());
		System.out.println("dequeue: "+queue.deQueue());
		System.out.println("dequeue: "+queue.deQueue());
		System.out.println("dequeue: "+queue.deQueue());
		System.out.println("dequeue: "+queue.deQueue());
		System.out.println(queue.enQueue(123));
		System.out.println("peek: "+queue.peek());
		System.out.println("size: "+queue.size());
		System.out.println("isEmpty: "+queue.isEmpty());
		System.out.println("isFull: "+queue.isFull());
	}
	
}