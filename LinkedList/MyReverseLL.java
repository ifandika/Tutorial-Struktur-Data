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
	
	/**
	 * Menggunakan rekursif untuk membalikan node.
	 * Lakukan penjelajahan sampai node terakhir(tai), jika sampai node terakhir
	 * maka ubah pointer head ke node terakhir, lalu kembali. Node {bufferNext} 
	 * sebagai buffer/pointer node saat ini. Ubah pointer {bufferNext} ke node.next.
	 * Lalu arahkan pointer next {bufferNext} ke node sebelumnya. Lalu hapus pointer
	 * next node sebelumnya.
	 * 
	 * == Ilustrasi ==
	 * 
	 * head = [1] -> [2] -> [3] -> null
	 * 
	 * node [1]
	 * data.next(node 2)
	 *		-> node [2]
	 *			 data.next(node 3)
	 *					-> node [3]
	 *						 data.next(null)
	 *								-> head = node [3]
	 *									 return
	 * 
	 * create Node buffer
	 * [1] -> [2] -> [3] -> null
	 * 
	 * buffer = node [3].next
	 * [1] -> [2] -> [3] -> buffer
	 * 
	 * buffer.next = node [3]
	 * [1] -> [2] -> [3] -> buffer | Sebelum
	 * [1] -> [2] -> [3] <-> buffer | Sesudah. 2 Pointer next, dari node [3] dan node buffer
	 * 
	 * Hapus pointer node [3]
	 * node [3].next = null
	 * [1] -> [2] -> [3] <- buffer
	 * 
	 * "Ulangi sampai paling kiri"
	 * 
	 * Hasil:
	 * null <- [1] <- [2] <- [3]
	 */
	public void reverseLL(Node<T> data) {
		if(data.next == null) {
			this.head = data;
			return;
		}
		reverseLL(data.next);
		Node<T> bufferNext = data.next;
		bufferNext.next = data;
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
		
		// Sebelum | ["Joni"] -> ["Jpri"] -> ["Janto"] -> null
		reverse.reverseLL(reverse.head);
		// Sesudah | null <- ["Joni"] <- ["Jpri"] <- ["Janto"]
		
		reverse.display();
	}
	
}