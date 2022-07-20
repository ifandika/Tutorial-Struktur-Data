
class Node<T> {
	public T data;
	public Node<T> next;
	public Node<T> previous;
	
	public Node(T data) {
		this.data = data;
		this.next = null;
		this.previous = null;
	}
}

public class MyDoubleLL<T> {
	private Node<T> head;
	private int size = 0;
	
	public MyDoubleLL() {}
	
	public void addNext(T data) {
		Node<T> newNode = new Node<>(data);
		if(isEmpty()) {
			this.head = newNode;
		}
		else {
			// Sebagai pointer
			Node<T> buffer = this.head;
			// Cek hingga paling ujung
			while(buffer != null) {
				// Data paling akhir karena pointer next null
				if(buffer.next == null) {
					// Ubah pointer ke node baru
					buffer.next = newNode;
					// Pointer prev menunjuk data terakhir
					newNode.previous = buffer;
					break;
				}
				buffer = buffer.next;
			}
		}
		this.size++;
	}
	
	public void addPrev(T data) {
		Node<T> newNode = new Node<>(data);
		if(isEmpty()) {
			this.head = newNode;
		}
		else {
			// Ubah pointer prev ke node baru
			this.head.previous = newNode;
			// Pointer next node baru menunjuk head
			newNode.next = this.head;
			// Ganti head
			this.head = newNode;
		}
		this.size++;
	}
	
	public void addWithIndx(int indx, T data) {
		if(isEmpty()) {
			throw new RuntimeException("Linked List is empty");
		}
		if(indx > size()) {
			throw new RuntimeException("Index lebih besar dari ukuran");
		}
		// Pada contoh ini index pada head dimulai dari 1
		Node<T> bufferHead = this.head;
		Node<T> newNode = new Node<>(data);
		// Menggunakan indx untuk menuju node yang dituju
		while(--indx > 0) {
			bufferHead = bufferHead.next;
		}
		// Sebagai buffer node selanjutnya
		Node<T> bufferNext = bufferHead.next;
		// Ubah pointer node sebelumnya ke node baru
		bufferHead.next = newNode;
		// Ubah pointer prev node baru ke node sebelumnya
		newNode.previous = bufferHead;
		// Ubah pointer next node baru ke node sesudahnya
		newNode.next = bufferNext;
		// Ubah pointer prev node sesudahnya ke node baru
		bufferNext.previous = newNode;
		this.size++;
	}
	
	public boolean removeWithIndx(int indx) {
		if(isEmpty()) {
			throw new RuntimeException("Linked List is empty");
		}
		if(indx < 1) {
			throw new IllegalArgumentException("Input wrong");
		}
		Node<T> bufferHead = this.head;
		while(--indx > 0) {
			bufferHead = bufferHead.next;
		}
		// Buffer node selanjutnya
		Node<T> nodeNext = bufferHead.next;
		// Buffer node sebelumnya
		Node<T> nodePrev = bufferHead.previous;
		bufferHead = null;
		// Ubah pointer
		nodePrev.next = nodeNext;
		nodeNext.previous = nodePrev;
		this.size--;
		return true;
	}
	
	public boolean removeNext() {
		if(isEmpty()) {
			throw new RuntimeException("Linked List is empty");
		}
		Node<T> buffer = this.head.next;
		this.head = null;
		this.head = buffer;
		this.size--;
		return true;
	}
	
	public boolean removePrev() {
		if(isEmpty()) {
			throw new RuntimeException("Linked List is empty");
		}
		Node<T> buffer = this.head;
		while(buffer != null) {
			if(buffer.next.next == null) {
				buffer.next = null;
				break;
			}
			buffer = buffer.next;
		}
		this.size--;
		return true;
	}
	
	public void display() {
		if(isEmpty()) {
			throw new RuntimeException("Linked List is empty");
		}
		Node<T> buffer = this.head;
		System.out.print("[");
		while(buffer != null) {
			System.out.print(buffer.data);
			if(buffer.next != null) {
				System.out.print(", ");
			}
			buffer = buffer.next;
		}
		System.out.print("]\n");
	}
	
	public T peek() {
		if(isEmpty()) {
			throw new RuntimeException("Linked List is empty");
		}
		return this.head.data;
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	public int size() {
		return this.size;
	}
	
	public static void main(String[] args) {
		
		DoubleLL<String> doubleLL = new DoubleLL<>();
		
		doubleLL.addNext("Jupri");
		doubleLL.addNext("Amet");
		doubleLL.addNext("Kipli");
		doubleLL.addNext("Supri");
		
		doubleLL.display();
		
		doubleLL.addWithIndx(2, "Slebew");
		
		doubleLL.display();
		
		doubleLL.addPrev("Tatang");
		doubleLL.addPrev("Dungu");
		
		doubleLL.display();
		
		System.out.println("removeWithIndx: "+doubleLL.removeWithIndx(3));
		
		doubleLL.display();
		
		System.out.println("peek: "+doubleLL.peek());
		
		System.out.println("removeNext: "+doubleLL.removeNext());
		System.out.println("removePrev: "+doubleLL.removePrev());
		
		doubleLL.display();
		
		System.out.println("size: "+doubleLL.size());
		System.out.println("isEmpty: "+doubleLL.isEmpty());
		
	}
	
}