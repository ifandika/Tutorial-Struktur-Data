/**
 * Objek untuk menyimpan data, berisi data yg akan disimpan dan pointer data selanjutnya.
 */
class Node {
	public String data;
	public Node next;
	
	public Node(String data) {
		this.data = data;
		this.next = null;
	}
}

/**
 * Single Linked List hanya bisa 
 */
class SingleLinkedList {
	// Head berada di data pertama, untuk pointer menghapus data.
	private Node head;
	// Tail berada di data terbaru, untuk pointer menambah data.
	private Node tail;
	// Untuk jumlah data
	private int size = 0;
	
	/**
	 * Constructor linked list ada yg kosong/berisi set ukuran dll.
	 */
	public SingleLinkedList() {}
	
	/**
	 * Fungsi tambah data, buat node untuk simpan data yg akan ditambahkan {@code Node newNode = new} 
	 * Node(data) }, cek jika head kosong { if(this.head == null) } set head dan tail ke newNode,
	 * { this.head = newNode, this.tail = newNode } jika head tidak kosong ubah pointer next taio 
	 * ke newNode dan set tail ke newNode { this.tail.next = newNode, this.tail = newNode } lalu
	 * kembalikan size + 1.
	 */
	public void add(String data) {
		Node newNode = new Node(data);
		if(this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		}
		else {
			this.tail.next = newNode;
			this.tail = newNode;
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
	public void addWithIndex(int indx, String data) {
		if(isEmpty()) {
			throw new RuntimeException("Linked List is empty");
		}
		Node bufferHead = this.head;
		while(--indx > 0) {
			bufferHead = bufferHead.next;
		}
		Node newNode = new Node(data);
		Node bufferTail = bufferHead.next;
		bufferHead.next = newNode;
		newNode.next = bufferTail;
		this.size++;
	}
	
	/**
	 * Fungsi hapus data, cek jika masih kosong maka eror, jioa tidak buta var baru 'buffer'
	 * untuk simpan data yang akan dihapus dari pointer 'head', lalu ubah 'head' ke node
	 * selanjutnya { head = head.next }, lalu kurangi 'size' dan kembalikan 'buffer'.
	 */
	public String remove() {
		if(isEmpty()) {
			throw new RuntimeException("Linked List is empty");
		}
		String buffer = this.head.data;
		this.head = this.head.next;
		this.size--;
		return buffer;
	}
	
	/**
	 * Fungsi ambil data seperti get.
	 */
	public String peek() {
		return this.tail.data;
	}
	
	/**
	 * Cek jika LL masih kosong jika pointer 'head' masih kosong.
	 */
	public boolean isEmpty() {
		return this.head == null;
	}
	
	/**
	 * Fungsi ambil jumlah ukuran data.
	 */
	public int size() {
		return this.size;
	}
	
	public void display() {
		Node buffer = this.head;
		while(buffer != null) {
			System.out.print(buffer.data+" ");
			buffer = buffer.next;
		}
		System.out.println();
	}
}

public class MySingleLL {
	public static void main(String[] args) {
		
		SingleLinkedList single = new SingleLinkedList();
		
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