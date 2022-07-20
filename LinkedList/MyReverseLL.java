
class Node<T> {
	public T data;
	public Node<T> next;
	
	public Node(T data) {
		this.data = data;
		this.next = null;
	}
}

public class MyReverseLL<T> {
	Node<T> head;
	
	public MyReverseLL() {}
	
	public void add(T data) {
		Node<T> newNode = new Node<>(data);
		if(this.head == null) {
			this.head = newNode;
		}
		else {
			Node<T> buffer = this.head;
			while(buffer != null) {
				if(buffer.next == null) {
					buffer.next = newNode;
					break;
				}
				buffer = buffer.next;
			}
		}
	}
	
	public void reverseLL(Node<T> data) {
		if(data.next == null) {
			this.head = data;
			return;
		}
		reverseLL(data.next);
		// Sebagai pointer node selanjutnya
		Node<T> bufferNext = data.next;
		// Ubah pointer ke node sebelumnya
		bufferNext.next = data;
		// Karena pointer sudah diganti maka kita hapus pointer sebelumnya
		data.next = null;
	}
	
	public void display() {
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
	
	public static void main(String[] args) {
		
		ReverseLL<String> reverse = new ReverseLL<>();
		
		reverse.add("Joni");
		reverse.add("Jpri");
		reverse.add("Janto");
		
		reverse.reverseLL(reverse.head);
		
		reverse.display();
		
		
	}
	
}