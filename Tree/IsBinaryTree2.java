
public class IsBinaryTree2 {
	
	public static void main(String[] args) {
		
		IsBinaryTree2 bt = new IsBinaryTree2();
		
		bt.insert(1);
		bt.insert(5);
		bt.insert(10);
		bt.insert(6);
		bt.insert(4);
		bt.insert(2);
		bt.insert(3);
		bt.insert(1);
		
		//bt.printInorder();
		
		bt.delete(6);
		// System.out.println(bt.root.right.right.left.val);
		
		System.out.println();
		bt.printInorder();
	}
	
	private Node root;
	
	private static class Node extends IsBinaryTree2 {
		private int val;
		private Node left, right;
		
		public Node() {}
		
		public Node(int val) {
			this.val = val;
		}
	}
	
	// Fungsi utama hapus data
	public void delete(int key) {
		root = deleteHelper(root, key);
	}
	
	/**
	 * Fungsi menghapus data dengan cara mencari data yang dicari. Jika sampai pada data
	 * yang dicari maka ubah pointer dari node data yang dicari ke node yang tidak kosong
	 * 
	 */
	private Node deleteHelper(Node node, int key) {
		if(node == null) return node;
		if(key > node.val) {
			node.right = deleteHelper(node.right, key);
		} else if(key < node.val) {
			node.left = deleteHelper(node.left, key);
		} else {
			if(node.right != null && node.left == null) {
				node = node.right;
				return node;
			} else if(node.left != null && node.right == null) {
				node = node.left;
				return node;
			} else if(node.right == null) return node.right;
				else if(node.left == null) return node.left;
			node.val = minValue(node.right);
			node = deleteHelper(node.right, node.val);
		}
		return node;
	}
	
	private int minValue(Node node) {
		int minVal = node.val;
		while(node.left != null) {
			minVal = node.left.val;
			node = node.left;
		}
		return minVal;
	}
	
	// Fungsi utama tambah data
	public void insert(int val) {
		root = insertHelper(root, val);
	}
	
	/**
	 * Fungsi pembantu tambah data, menggunakan rekursif untuk cek node.
	 * Menambah data dengan kondisi jika data lebih besar dari data node root,
	 * maka data akan di alirkan ke bagian kanan, jika tidak maka ke sebelah
	 * kiri.
	 */
	private Node insertHelper(Node root, int val) {
		if(root == null) {
			root = new Node(val);
		} else if(val > root.val) {
			root.right = insertHelper(root.right, val);
		} else {
			root.left = insertHelper(root.left, val);
		}
		return root;
	}
	
	public int getMaxDepth() {
		if(root == null) return -1;
		int max = maxDepth(root);
		return max;
	}
	
	private int maxDepth(Node root) {
		if(root == null) return 0;
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
	
	// Fungsi utama 
	public void printInorder() {
		printInorderHelper(root);
	}
	
	/**
	 * Menampilkan data dengan teknik inorder(Kiri, Tengah, Kanan). Lakukan
	 * pengecekan hingga sampai node kiri kosong maka data di tampilkan lalu
	 * kembali ke node sebelumnya lalu cek node kanan jika tidak kosong, maka
	 * ditampilkan, jika kosong maka kembali ke node sebelumnya data seterusnya
	 * sampai node paling atas, lalu pindah ke sebelah kanan.
	 */
	private void printInorderHelper(Node root) {
		if(root.left != null) {
			printInorderHelper(root.left);
		}
		System.out.println(root.val+", ");
		if(root.right != null) {
			printInorderHelper(root.right);
		}
	}
	
	public void printPreorder() {
		printPreorderHelper(root);
	}
	
	private void printPreorderHelper(Node root) {
		if(root == null) return;
		System.out.println(root.val+", ");
		printPreorderHelper(root.left);
		printPreorderHelper(root.right);
	}
	
	public void printPostorder() {
		printPostorderHelper(root);
	}
	
	private void printPostorderHelper(Node root) {
		if(root == null) return;
		printPostorderHelper(root.left);
		printPostorderHelper(root.right);
		System.out.println(root.val+", ");
	}
	
}