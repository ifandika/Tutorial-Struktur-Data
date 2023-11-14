/**
 * Tipe Binary Tree yang dimana tinggi(height) dari subtree sisi kiri & kanan
 * tidak lebih dari 1. Untuk mencari tinggi gunakan deth-first-
 * Contoh:
 *		Tinggi subtree kiri = 3
 *		Tinggi subtree kanan = 2
 *		
 */
public class ExamBalancedBinaryTree {
	static int leftHeight = 0, rightHeight = 0, height = 0;
	
	static boolean checkHeightBalance(Node root, Height height) {

    // Check for emptiness
    if (root == null) {
      height.height = 0;
      return true;
    }

    Height leftHeighteight = new Height(), rightHeighteight = new Height();
    boolean l = checkHeightBalance(root.left, leftHeighteight);
    boolean r = checkHeightBalance(root.right, rightHeighteight);
    int leftHeight = leftHeighteight.height, rightHeight = rightHeighteight.height;

    height.height = (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;

    if ((leftHeight - rightHeight >= 2) || (rightHeight - leftHeight >= 2))
      return false;

    else
      return l && r;
  }
  
	public static boolean checkBalanced(Node root) {
		if(root == null) {
			height = 0;
			return true;
		}
		boolean left = checkBalanced(root.left),
				right = checkBalanced(root.right);
		height = ((leftHeight > rightHeight ? leftHeight : rightHeight) +1);
		if(((leftHeight - rightHeight) >= 2) || ((rightHeight - leftHeight) >= 2)) {
			return false;
		} else {
			return left && right;
		}
	}
	
	public static void main(String[] args) {
		/**
		 *					(10)
		 *				   /	\
		 *				(20)	(7)
		 *			   /    \
		 *			 (9)	(5)
		 */
		BalancedBinaryTree bbt = new BalancedBinaryTree();
		bbt.root = new Node(10);
		bbt.root.left = new Node(20);
		bbt.root.right = new Node(7);
		bbt.root.left.left = new Node(9);
		bbt.root.left.right = new Node(5);
		bbt.root.left.right.left = new Node(2);
		System.out.println("Is balanced: "+checkBalanced(bbt.root));
		//System.out.println("Is balanced: "+checkHeightBalance(bbt.root, new Height()));
	}
}

class Height {
	int height = 0;
}

class Node {
	int data;
	Node left, right;
	
	public Node(int val) {
		data = val;
	}
}

class BalancedBinaryTree {
	Node root;
	
	public BalancedBinaryTree() {}
}