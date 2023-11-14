public class IsBinaryTree {
	
	public static void main(String[] args) {
		
		IsBinaryTree bt = new IsBinaryTree();
		
		bt.setComparison(10);
		bt.insert(1);
		bt.insert(5);
		bt.insert(20);
		bt.insert(15);
		
		bt.printInOrder();
		System.out.println(bt.contains(20));
	}
	
	private IsBinaryTree left;
	private IsBinaryTree right;
	private int data;
	// Sebagai pembanding
	private int comparison;
	
	public IsBinaryTree() {}
	
	public IsBinaryTree(int val) {
		data = val;
	}
	
	/**
	 * Tambah data dengan recursive. Menambah data dengan cara membandingkan
	 * data, jika data lebih kecil maka akan dimasukan ke sebelah kiri, jika
	 * data lebih besar maka akan dimasukan sebelah kanan.
	 * 
	 * Input: 7
	 * Pembanding: 5
	 * 
	 *						10 
	 *					/		\
	 *				3			 6
	 *			/	 \		
	 *		2			4
	 * 
	 * 10 -> root
	 * 3 -> root.left
	 * 6 -> root.right
	 * 2 -> root.left.left
	 * 4 -> root.left.right
	 * 
	 * • Membandingkan data dengan pembanding
	 * 7(Input) <= 5(pembanding) -> false
	 *						10
	 *					/		\
	 *				3			 6 if( 7(input) <= 5(pembanding) ) -> false
	 *			/	 \		/	\
	 *		2			4				7 (Data dimasukan ke sebelah kanan)
	 */
	public void insert(int val) {
		if(val <= comparison) {
			System.out.println("Insert left: "+val);
			if(left == null) {
				left = new IsBinaryTree(val);
			} else {
				left.insert(val);
			}
		} else {
			System.out.println("Insert right: "+val);
			if(right  == null) {
				right = new IsBinaryTree(val);
			} else {
				right.insert(val);
			}
		}
	}
	
	public void delete(int key) {
		
	}
	
	private void deleteHelper(int val) {
		
	}
	
	public void setComparison(int val) {
		comparison = val;
	}
	
	public boolean contains(int key) {
		if(key == data) {
			return true;
		} else if(key < comparison) {
			if(left == null) {
				return false;
			} else {
				return left.contains(key);
			}
		} else {
			if(right == null) {
				return false;
			} else {
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
	
}