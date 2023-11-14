
class Node {
	String s;
	Node next;

	public Node(String val) {
		s = val;
	}

	public Node(String val, Node n) {
		s = val;
		next = n;
	}
}

public class ImplSingleLL {
	private Node head, tail;
	private int exists;

	public ImplSingleLL() {

	}

	public void add(String val) {
		Node newNode = new Node(val);
		if(head == null) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = tail.next;
		}
		exists++;
	}

	public void remove() {
		if(empty()) {
			// error
		}
		String value = 
	}
	
	public boolean empty() {
		return (head == null);
	}
}