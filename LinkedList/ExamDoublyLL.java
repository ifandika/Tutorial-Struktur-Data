
class Node {
	public String data;
	public Node next;
	public Node previous;
	
	public Node(String data) {
		this.data = data;
		this.next = null;
		this.previous = null;
	}
}

/**
 * Doubly Linked List adalah linked list yg dimana node punya pointer data sebelum/kiri
 * dan selanjutnya/kanan.
 */
class DoublyLinkedList {
	// Head untuk data pertama.
	private Node head;
	private int size = 0;
	
	public DoublyLinkedList() {}
	
	public void addNext(String data) {
		Node newNode = new Node(data);
		if(isEmpty()) {
			this.head = newNode;
		}
		else {
			// Sebagai pointer
			Node buffer = this.head;
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
	
	public void addPrev(String data) {
		Node newNode = new Node(data);
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
	
	public void addWithIndx(int indx, String data) {
		if(isEmpty()) {
			throw new RuntimeException("Linked List is empty");
		}
		if(indx > size()) {
			throw new RuntimeException("Index lebih besar dari ukuran");
		}
		// Pada contoh ini index pada head dimulai dari 1
		Node bufferHead = this.head;
		Node newNode = new Node(data);
		// Menggunakan indx untuk menuju node yang dituju
		while(--indx > 0) {
			bufferHead = bufferHead.next;
		}
		// Sebagai buffer node selanjutnya
		Node bufferNext = bufferHead.next;
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
		Node bufferHead = this.head;
		while(--indx > 0) {
			bufferHead = bufferHead.next;
		}
		// Buffer node selanjutnya
		Node nodeNext = bufferHead.next;
		// Buffer node sebelumnya
		Node nodePrev = bufferHead.previous;
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
		Node buffer = this.head.next;
		this.head = null;
		this.head = buffer;
		this.size--;
		return true;
	}
	
	public boolean removePrev() {
		if(isEmpty()) {
			throw new RuntimeException("Linked List is empty");
		}
		Node buffer = this.head;
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
		Node buffer = this.head;
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
	
	public String peek() {
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
	
}

public class ExamDoublyLL {
	
	public static void main(String[] args) {
		
		DoublyLinkedList doubleLL = new DoublyLinkedList();
		
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