public class MyBinaryTree {
	private BinaryTree left;
	private BinaryTree right;
	private int data;
	
	public MyBinaryTree(int value) {this.data = value;}
	
	public void insert(int value) {
		if(value <= data) {
			if(left == null) {
				left = new BinaryTree(value);
			}
			else {
				left.insert(value);
			}
		}
		else {
			if(right  == null) {
				right = new BinaryTree(value);
			}
			else {
				right.insert(value);
			}
		}
	}
	
	public boolean contains(int key) {
		if(key == data) {
			return true;
		} 
		else if(key < data) {
			if(left == null) {
				return false;
			}
			else {
				return left.contains(key);
			}
		}
		else {
			if(right == null) {
				return false;
			}
			else {
				return right.contains(key);
			}
		}
	}
	
	public void printInOrder() {
		if(left != null) {
			left.printInOrder();
		}
			System.out.print(data+" ");
		if(right != null) {
			right.printInOrder();
		}
	}
	
	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree(100);
		
		bt.insert(10);
		bt.insert(5);
		bt.insert(20);
		bt.insert(15);
		
		bt.printInOrder();
		System.out.println(bt.contains(20));
		
	}
	
}