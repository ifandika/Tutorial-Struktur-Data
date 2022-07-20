/**
 * @Author	Maulana Ifandika
 * 
 * | Stack
 * 
 * - Struktur data tumpukan, menggunakan prinsip LIFO(Last In First Out) 
 *   untuk menyimpan elemen.
 * 
 * - Metode dasar
 *   - push		Menambahkan data
 *   - pop		Menghapus data
 *   - size		Jumlah data pada stack
 */
public class MyStack {
	
	private Integer[] dataStack;
	private int top;
	private int capacity;
	
	public MyStack(int size) {
		this.dataStack = new Integer[size];
		this.top = -1;
		this.capacity = size;
	}
	
	public boolean push(int data) {
		if(isFull()) {
			throw new RuntimeException("Stack is full");
		}
		dataStack[++top] = data;
		return true;
	}
	
	public boolean pop() {
		if(isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		dataStack[top--] = null;
		return true;
	}
	
	public Integer size() {
		return top;
	}
	
	public Boolean isFull() {
		return this.top == capacity -1;
	}
	
	public Boolean isEmpty() {
		return this.top == -1;
	}
	
	public void display() {
		for(int lop = 0; lop <= top; lop++) {
			System.out.print(dataStack[lop]+" ");
		}
		System.out.println();
	}
	
	// Test
	public Integer getMin() {
		int[] dataMin = new int[size()/2];
		int buffer, indx = 0;
		for(int lop = 0; lop < size()-1; lop++) {
			if(dataStack[lop] < dataStack[lop+1]) {
				dataMin[indx] = dataStack[lop];
				indx++;
			}
		}
		for(int lop = 0; lop < (dataMin.length-1); lop++) {
			if(dataMin[lop] > dataMin[lop+1]) {
				buffer = dataMin[lop];
				dataMin[lop] = dataMin[lop+1];
				dataMin[lop+1] = buffer;
			}
		}
		return dataMin[0];
	}
	
	// Test
	public Integer getMax() {
		int[] dataMin = new int[size()/2];
		int buffer, indx = 0;
		for(int lop = 0; lop < size()-1; lop++) {
			if(dataStack[lop] < dataStack[lop+1]) {
				dataMin[indx] = dataStack[lop+1];
				indx++;
			}
		}
		for(int lop = 0; lop < (dataMin.length-1); lop++) {
			if(dataMin[lop] < dataMin[lop+1]) {
				buffer = dataMin[lop];
				dataMin[lop] = dataMin[lop+1];
				dataMin[lop+1] = buffer;
			}
		}
		return dataMin[0];
	}
	
	public static void main(String[] args) {
		
		ThisStack stack = new ThisStack(10);
		
		System.out.println(stack.push(10));
		System.out.println(stack.push(5));
		System.out.println(stack.push(1));
		System.out.println(stack.push(20));
		System.out.println(stack.push(15));
		System.out.println(stack.push(70));
		System.out.println(stack.push(50));
		
		System.out.println("Min: "+stack.getMin());
		System.out.println("Max: "+stack.getMax());
		
		stack.display();
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		stack.display();
		
		System.out.println(stack.size());
		System.out.println(stack.isEmpty());
		System.out.println(stack.isFull());
		
	}
	
}