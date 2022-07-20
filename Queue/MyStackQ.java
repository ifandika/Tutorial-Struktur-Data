public class MyStackQ {
	private String[] dataStack;
	private int top;
	private int size;
	private final int MAXSIZE;
	
	public MyStackQ(int valSize) {
		dataStack = new String[valSize];
		top = -1;
		MAXSIZE = valSize;
	}
	
	public void push(String data) {
		if(isFull()) throw new RuntimeException("Stack is full");
		dataStack[++top] = data;
		this.size++;
	}
	
	public boolean pop() {
		if(isEmpty()) throw new RuntimeException("Stack is empty");
		dataStack[top--] = null;
		this.size--;
		return true;
	}
	
	public String getTop() {
		return dataStack[top];
	}
	
	public int size() {return this.size;}
	
	public boolean isEmpty() {
		return this.top == -1;
	}
	
	public boolean isFull() {
		return this.top == this.MAXSIZE;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for(int i = 0; i < size(); i++) {
			if(i == size-1) {
				sb.append(dataStack[i]);
				break;
			}
			sb.append(dataStack[i]+", ");
		}
		sb.append("}\n");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		StackQ stack = new StackQ(5);
		
		stack.push("Joni");
		stack.push("Smite");
		stack.push("Tatang");
		
		System.out.println(stack.toString());
		
		stack.pop();
		stack.pop();
		
		System.out.println(stack.isFull());
		System.out.println(stack.isEmpty());
		System.out.println(stack.size());
		System.out.println(stack.getTop());
		
	}
	
}