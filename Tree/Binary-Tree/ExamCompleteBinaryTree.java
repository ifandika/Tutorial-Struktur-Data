/**
 * Complete Binary Tree = Tipe spesial binary tree, dimana setiap level harus terisi.
 */
public class ExamCompleteBinaryTree {
	
	/**
	 * Fungsi utama untuk cek complete binary tree.
	 */
	public static boolean checkComplete(Node root) {
		int nodeCount = countNode(root);
		return checkCompleteBT(root, 0, nodeCount);
	}
	
	/**
	 * "Untuk mencari jumalah banyak node."
	 * 
	 * - Cek jika root == kosong maka kita return 0
	 * - Return 1 + setiap recursive subtree kiri dan kanan.
	 */
	public static int countNode(Node root) {
		if(root == null)
			return 0;
		return (1 + countNode(root.left) + countNode(root.right));
	}
	
	/**
	 * "Untuk cek apakah complete binary tree."
	 * 
	 * Cek jika node saat ini kosong maka return true.
	 *  	if(root == null)
	 *			return true;
	 * Cek jika index >= jumlah node maka node tidak lengkap, return false.
	 *		if(index >= nodeCount)
	 *			return false;
	 * Lalu kita ulangi sisi kiri hingga selesai lalu sisi kanan. Untuk sisi kiri
	 * (index × 2 + 1), jika sisi kanan (index × 2 + 2). Bisa diubah, kiri (index × 2 + 2)
	 * lalu kanan (index × 2 + 1) sama saja.
	 *		return (checkCompleteBT(root.left, 2 * index + 1, nodeCount) &&
	 *				checkCompleteBT(root.right, 2 * index + 1, nodeCount));
	 * Kita ubah dengan ilustrasi array, jika salah satu bagian array kosong
	 * dan depannya masih ada data maka bisa kita simpulkan bukan complete.
	 * 
	 *			Not Balanced
	 *				(1)
	 *			   /	\
	 *			 (2)	 (3)
	 *		   /   \	 /	\
	 *		 (4)   (5)	(?)	(7)
	 * 
	 * Versi array:
	 * [1] | [2], [3] | [4], [5] | [null], [7] -> total node = 6
	 */
	public static boolean checkCompleteBT(Node root, int index, int nodeCount) {
		if(root == null) {
			return true;
		}
		if(index >= nodeCount) {
			return false;
		}
		// checkCompleteBT(root.left, ...) di eksekusi dulu hingga selesai, lalu sisi kanan.
		return (checkCompleteBT(root.left, 2 * index + 1, nodeCount) &&
				checkCompleteBT(root.right, 2 * index + 2, nodeCount));
	}
	
	public static void main(String[] args) {
		/**
		 *				(1)
		 *			   /	\
		 *			 (2)	 (3)
		 *		   /	\		\
		 *		 (4)	(5)		(7)
		 */
		CompleteBinaryTree cbt = new CompleteBinaryTree();
		
		cbt.root = new Node(1);
		cbt.root.left = new Node(2);
		cbt.root.right = new Node(3);
		cbt.root.left.left = new Node(4);
		cbt.root.left.right = new Node(5);
		//cbt.root.right.left = new Node(6);
		//cbt.root.right.right = new Node(7);
		
		System.out.println("Is Complete: "+checkComplete(cbt.root));
	}
}

class Node {
	int data;
	Node left, right;
	
	public Node(int val) {
		data = val;
	}
}

class CompleteBinaryTree {
	Node root;
	
	public CompleteBinaryTree() {}
}