/**
 * Stack
 * 
 * - Struktur data tumpukan, menggunakan prinsip LIFO(Last In First Out) 
 *   untuk menyimpan elemen.
 * 
 * - Fungsi operasi dasar
 *   - push		Menambahkan data
 *   - pop		Menghapus data
 * 	 - peek 	Ambil data teratas
 *   - size		Jumlah data pada stack
 */
import java.util.*;

public class ExamStack {
	private int[] data;
	private int size, top;

	public static void main(String[] args) {
		
		ExamStack es = new ExamStack(5);

		// es.push(10);
		// es.push(20);
		// es.push(30);
		// es.push(40);
		// es.push(50);
		// es.push(60);

		es.pop();
		// es.pop();

		System.out.println(es.peek());
		// System.out.println(es.size());
		es.display();
	}

	public ExamStack(int capacity) {
		data = new int[capacity];
		size = 0;
		top = -1;
	}

	public void push(int value) {
		if(full()) {
			throw new RuntimeException("Stack is full");
		}
		data[++top] = value;
		size++;
	}

	public int pop() {
		if(empty()) {
			throw new RuntimeException("Stack is empty");
		}
		int temp = data[top];
		data[top--] = 0;
		size--;
		return temp;
	}

	public int peek() {
		if(empty()) {
			throw new RuntimeException("Stack is empty");
		}
		return data[top];
	}

	public boolean empty() {
		return (top == -1 ? true : false);
	}

	public boolean full() {
		if(size == data.length) {
			return true;
		}
		return false;
	}

	public int size() {
		return size;
	}

	public void display() {
		if(empty()) {
			throw new RuntimeException("Stack is empty");
		}
		for(var e : data) {
			System.out.print(e+" ");
		}
		System.out.println();
	}

}