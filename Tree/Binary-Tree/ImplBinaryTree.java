public class ImplBinaryTree {
	public Node root;
	private int exist = 0;

	public ImplBinaryTree()	{}

	public ImplBinaryTree(int data)	{
		root = new Node(data);
	}

	public void insert(int data) {
		root = insertHelper(root, data);
	}

	public Node insertHelper(Node node, int data) {
		if(node == null) {
			node = new Node(data);
			exist++;
		}
		else if(data < node.data) {
			node.left = insertHelper(node.left, data);
		}
		else if(data > node.data) {
			node.right = insertHelper(node.right, data);
		}
		return node;
	}

	public void remove(int data) {
		root = removeHelper(root, data);
	}

	public Node removeHelper(Node node, int data) {
		if(node == null) {return node;}
		else if(data < node.data) {
			node.left = removeHelper(node.left, data);
		}
		else if(data > node.data) {
			node.right = removeHelper(node.right, data);	
		}
		else {
			if(node.left != null && node.right == null) {
				node = node.left;
				return node;
			}
			else if(node.right != null && node.left == null) {
				node = node.right;
				return node;
			}
			else if(node.left == null) return node.right;
			else if(node.right == null) return node.left;	
		}
		return node;
	}

	public void display() {
		displayHelper(root);
	}

	public void displayHelper(Node node) {
		if(node != null) {
			displayHelper(node.left);
			System.out.println(node.data+" ");
			displayHelper(node.right);
		}
	}


	// public int height() {}
	
}