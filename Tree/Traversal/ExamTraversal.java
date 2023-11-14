class Node {
	int data;
	Node left, right;
	
	public Node(int data) {
		this.data = data;
	}
}

class BinaryTree {
	Node root;
	
	public BinaryTree() {
		root = new Node(0);
	}
	
	public void printInorder(Node root) {
		if(root == null) return;
		if(root != null) {
			printInorder(root.left);
			System.out.print(root.data+" ");
			printInorder(root.right);
		}
	}
	
	public void printPreorder(Node root) {
		if(root == null) return;
		if(root != null) {
			System.out.print(root.data+" ");
			printPreorder(root.left);
			printPreorder(root.right);
		}
	}
	
	public void printPostorder(Node root) {
		if(root == null) return;
		printPreorder(root.left);
		printPreorder(root.right);
		System.out.print(root.data+" ");
	}
}

public class ExamTraversal {
	
	public static void main(String[] args) {
		/**
		 *					10
		 *				  /	   \
		 *				5		15
		 *			  /   \		  \
		 *			1		8	   20
		 */
		BinaryTree bt = new BinaryTree();
		bt.root.data = 10;
		bt.root.left = new Node(5);
		bt.root.left.left = new Node(1);
		bt.root.left.right = new Node(8);
		bt.root.right = new Node(15);
		bt.root.right.right = new Node(20);
		
		// bt.printInorder(bt.root);
		// bt.printPreorder(bt.root);
		bt.printPostorder(bt.root);
	}
}