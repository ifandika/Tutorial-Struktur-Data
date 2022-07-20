/**
 * @Author	Maulana Ifandika
 * 
 * | Linked List
 * 
 * - Struktur data yang terdiri dari Node/Simpul yang saling terhubung.
 *   Setiap node berisi Data dan Address Node selanjutnya. Linked List 
 *   bisa di implementasikan di berbagai Struktur Data.
 * 
 *    Head				  Tail
 *   [Node] -> [Node] -> [Node] -> null
 * 
 *   [Node] -> [Node.next] -> [Node.next.next] -> null
 * 
 *  - Type Linked List
 *    - Single Linked List
 *    - Double Linked List
 *    - Circular Linked List
 */
class Node {
	public String data;
	public Node next;
	
	public Node(String data) {
		this.data = data;
		this.next = null;
	}
}
// Contoh Linked List dari Queue
public class MyQueueLL {
	
	private Node head;
	private Node tail;
	private int size = 0;
	
	public MyQueueLL() {}
	
	public void add(String data) {
		Node node = new Node(data);
		if(isEmpty()) {
			// head|tail
			//  [node]
			this.head = node;
			this.tail = node;
		}
		else {
			//nodeBaru	  Tail		Head
			// [node] <- [node] <- [node]
			this.tail.next = node;
			//  Tail    nodeBaru    Head
			// [node] <- [node] <- [node]
			this.tail = node;
		}
		size++;
	}
	
	public String remove() {
		if(isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		String data = this.head.data;
		//  Tail    nodeBaru    Head  ->  Tail		Head
		// [node] <- [node] <- [node] -> [node] <- [node] <- null
		this.head = this.head.next;
		size--;
		return data;
	}
	
	public boolean removeWithValue(String data) {
		if(isEmpty()) {
			return false;
		}
		else if(this.head.data.equals(data)) {
			// Hapus Objek
			this.head = null;
			// Ganti Pointer Head
			this.head = this.head.next;
		}
		else {
			Node buffer = head;
			check: while(buffer.next != null) {
				if(buffer.next.data.equals(data)) {
					buffer.next = buffer.next.next;
					break check;
				}
				buffer = buffer.next; 
			}
		}
		size--;
		return true;
	}
	
	public void display() {
		Node buffer = head;
		while(buffer != null) {
			System.out.print(buffer.data+" ");
			buffer = buffer.next;
		}
		System.out.println();
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	public static void main(String[] args) {
		
		QueueLL queueLL = new QueueLL();
		
		queueLL.add("Jurpi");
		queueLL.add("Paijo");
		queueLL.add("Kipli");
		queueLL.add("Oni");
		queueLL.add("Jowo");
		queueLL.add("Slebew");
		
		queueLL.display();
		
		System.out.println("remove: "+queueLL.remove());
		System.out.println("remove: "+queueLL.remove());
		System.out.println("remove with value: "+queueLL.removeWithValue("Jowo"));
		System.out.println("remove with value: "+queueLL.removeWithValue("Slebew"));
		System.out.println("size: "+queueLL.size());
		System.out.println("isEmpty: "+queueLL.isEmpty());
		
		queueLL.display();
	}
	
}