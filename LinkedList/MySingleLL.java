
class Node<T> {
	public T data;
	public Node<T> next;
	
	public Node(T data) {
		this.data = data;
		this.next = null;
	}
}

public class MySingleLL<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size = 0;
	
	public MySingleLL() {}
	
	public void add(T data) {
		Node<T> node = new Node<>(data);
		if(this.head == null) {
			this.head = node;
			this.tail = node;
		}
		else {
			this.tail.next = node;
			this.tail = node;
		}
		this.size++;
	}
	
	/**
	 * {@code bufferHead} Sebagai pointer. indx sebagai nomer Node keberapa
	 * yang akan diposisi itu akan ditambah Node baru. Dengan {@code --indx}
	 * maka akan sampai di titik Node yang diinginkan. {@code bufferTail} 
	 * Sebagai Pointer untuk Node selanjutnya. {@code bufferTail} Digunakan
	 * untuk Pointer next Node baru.
	 */
	public void addWithIndex(int indx, T data) {
		if(isEmpty()) {
			throw new RuntimeException("Linked List is empty");
		}
		Node<T> bufferHead = this.head;
		while(--indx > 0) {
			bufferHead = bufferHead.next;
		}
		Node<T> newNode = new Node<>(data);
		Node<T> bufferTail = bufferHead.next;
		bufferHead.next = newNode;
		newNode.next = bufferTail;
		this.size++;
	}
	
	public T remove() {
		if(isEmpty()) {
			throw new RuntimeException("Linked List is empty");
		}
		T buffer = this.head.data;
		this.head = this.head.next;
		this.size--;
		return buffer;
	}
	
	public T peek() {
		return this.tail.data;
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	public int size() {
		return this.size;
	}
	
	public void display() {
		Node<T> buffer = this.head;
		while(buffer != null) {
			System.out.print(buffer.data+" ");
			buffer = buffer.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		SingleLL<String> single = new SingleLL<>();
		
		single.add("Joni");
		single.add("Smite");
		single.add("Ahmed");
		single.add("Kipli");
		
		System.out.println("peek: "+single.peek());
		single.display();
		
		single.addWithIndex(2, "Mazehh");
		single.display();
		
		System.out.println("remove: "+single.remove());
		System.out.println("remove: "+single.remove());
		System.out.println("remove: "+single.remove());
		
		System.out.println("size: "+single.size());
		System.out.println("isEmpty: "+single.isEmpty());
		
		single.display();
	}
	
}