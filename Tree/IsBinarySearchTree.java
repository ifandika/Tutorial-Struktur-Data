public class IsBinarySearchTree {
	
	public static void main(String[] args) {
		
		IsBinarySearchTree bst = new IsBinarySearchTree();
		
		/**
		 *         70
		 *        /    \
     *      40      80
     *    /   \       \
     *  10     50      90
     */
     
    bst.insert(70);
    bst.insert(80);
    bst.insert(40);
    bst.insert(50);
    bst.insert(10);
    bst.insert(90);
	}
	
	
	private static class Node {
		String data;
		Node left, right;
		
		public Node(String data) {
			this.data = data;
		}
	}
	private Node root;
	
	public void insert(int k) {
		root = oprtInsert(root, k);
	}
	
	public void delete(int k) {
		root = oprtDelete(root, k);
	}
	
	private Node oprtInsert(Node n, int k) {
		// Cek untuk pemasukan data awal
		if(n == null) return root = new Node(k);
		else if(k > n.key) {
			// Ulangi untuk bagain kanan
			root.right = oprtInsert(n.right, k);
		}
		else if(k < n.key) {
			// Ulangi untuk bagian kiri
			root.left = oprtInsert(n.left, k);
		}
	}
	
	private Node oprtDelete(Node n, int k) {
		if(n == null) return root;
		// Melakukan pencarian ke key yg dituju
		if(k < root.key) {
			root.left = oprtDelete(n.left, k);
		}
		else if(k > root.key) {
			root.right = oprtDelete(n.right, k);
		}
    // Jika sudah sampai ke node.key yang dituju
    else {
    	// Pengecekan node kiri/kanan
      // Jika node kiri kosong
      if(n.left == null) return n.right;
      // Jika node kanan kosong
      else if(n.right == null) return n.left;
      n.key = minVal(n.right, k);
      n.right = oprtDelete(n.right, n.key;
    }
    return n;
	}
	
	private int minVal(Node n) {
		// Simpan nilai n saat ini
    int tempVal = 0;
    // Cek node kiri apakah kosong
    while(n.left != null) {
    // Pindahkan nilai node saat ini ke node kiri
    tempVal = n.left.key;
    // Ganti node saat ini dengan node kiri
    n = n.left;
    }
    return tempVal;
	}
	
  /**
	* Fungsi untuk menampilkan nilai dari paling kiri bawah.
	* Pertama kita cek node apakah kosong, jika tidak maka ulangi fungsi dengan node kiri.
	* Jika sudah sampai ke node kiri paling bawah cek node kiri dan kanan, jika node kosong
  * maka kembali node sebelumnya. Lalu cek node kanan/kiri jika node ada maka kita tampilkan nilai,
  * hingga sampai paling atas, lalu pindah ke bagain kanan
  **/
  
  public void inorderRec(Node n) {
  	if(n != null) {
      inorderRec(n.left);
      System.out.print(n.key+", ");
      inorderRec(n.right);
  	}
  }
  
}