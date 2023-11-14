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
	
	public int getLevelNode(int data) {
		return getLevelNodeHelper(root, data, 1);
	}
	
	public int getLevelNodeHelper(Node root, int data, int level) {
		if(root == null) return 0;
		if(root.data == data) return level;
		int bufferLevel = getLevelNodeHelper(root.left, data, level+1);
		if(bufferLevel != 0) return bufferLevel;
		bufferLevel = getLevelNodeHelper(root.right, data, level+1);
		return bufferLevel;
	}
	
}

public class ExamGetLevelNode {

	public static void main(String... args) {

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
		
		System.out.println(bt.getLevelNode(8));
	}
}
