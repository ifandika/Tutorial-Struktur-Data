/**
 * @Author	Maulana Ifandika
 * 
 * | Linked List
 * 
 * - Struktur data yang terdiri dari Node/Simpul yang saling terhubung.
 *   Setiap node berisi Data dan Address Node selanjutnya/Next. Linked List 
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
// Contoh Linked List dari Stack
class MyStackLL {
	private Node top;
	private int size = 0;
	
	public MyStackLL() {}
	
	public void push(String data) {
		Node node = new Node(data);
		if(isEmpty()) {
			//  Top
			// [node]
			this.top = node;
		}
		else {
			//  Top		  node
			// [node] <- [node]
			node.next = this.top;
			//  node	  Top
			// [node] <- [node]
			this.top = node;
		}
		size++;
	}
	
	public String pop() {
		if(isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		String dataNode = this.top.data;
		//  node	  Top	->	Top
		// [node] <- [node]	-> [node] <- null
		this.top = this.top.next;
		size--;
		return dataNode;
	}
	
	public String peek() {
		return this.top.data;
	}
	
	public boolean isEmpty() {
		return this.top == null;
	}
	
	public int size() {
		return this.size;
	}
	
	public static void main(String[] args) {
		
		StackLL stack = new StackLL();
		
		stack.push("Joni");
		stack.push("Mansur");
		stack.push("Amet");
		stack.push("Kipli");
		
		System.out.println("peek: "+stack.peek());
		
		System.out.println("pop: "+stack.pop());
		System.out.println("pop: "+stack.pop());
		System.out.println("pop: "+stack.pop());
		
		System.out.println("isEmpty: "+stack.isEmpty());
		System.out.println("size: "+stack.size());
		
	}
	
}