/**
 * B-Tree adalah self balancing search tree.
 * - Setiap node dapat menyimpan lebih dari 1 data/key
 * - Setiap node dapat memiliki lebih dari 2 childern/subnode
 */
public class IsBTree {
	// Sebagai batas jumlah data dan childern
	private static int max;
	// Sebagai root node
	private Node root;
	
	public static void main (String[] args) {
		
		IsBTree bTree = new IsBTree(3);
		
		bTree.insert(10);
		bTree.insert(5);
		bTree.insert(15);
		
		bTree.show();
		
	}
	
	private static class Node {
		int n;
		int[] key = new int[2 * max -1];
		Node[] child = new Node[2 * max];
		boolean leaf = true;
		
		// Fungsi mencari key
		public int find(int k) {
			for(int i = 0; i < key.length; i++) {
				if(key[i] == k) {
					return i;
				}
			}
			return -1;
		}
	};
	
	public IsBTree(int max) {
		this.max = max;
		this.root = new Node();
		this.root.n = 0;
		this.root.leaf = true;
	}
	
	// Fungsi tambah data
	public void insert(int key) {
		Node r = root;
		if (r.n == 2 * max - 1) {
			Node s = new Node();
			root = s;
			s.leaf = false;
			s.n = 0;
      s.child[0] = r;
      Split(s, 0, r);
      insertValue(s, key);
    } else {
      insertValue(r, key);
    }
	}
	
	final private void insertValue(Node x, int k) {
    if (x.leaf) {
      int i = 0;
      for (i = x.n - 1; i >= 0 && k < x.key[i]; i--) {
        x.key[i + 1] = x.key[i];
      }
      x.key[i + 1] = k;
      x.n = x.n + 1;
    } else {
      int i = 0;
      for (i = x.n - 1; i >= 0 && k < x.key[i]; i--) {}
      i++;
      Node tmp = x.child[i];
      if (tmp.n == 2 * max - 1) {
        Split(x, i, tmp);
        if (k > x.key[i]) {
          i++;
        }
      }
      insertValue(x.child[i], k);
    }
	}
	
	private void Split(Node x, int pos, Node y) {
    Node z = new Node();
    z.leaf = y.leaf;
    z.n = max - 1;
    for (int j = 0; j < max - 1; j++) {
      z.key[j] = y.key[j + max];
    }
    if (!y.leaf) {
      for (int j = 0; j < max; j++) {
        z.child[j] = y.child[j + max];
      }
    }
    y.n = max - 1;
    for (int j = x.n; j >= pos + 1; j--) {
      x.child[j + 1] = x.child[j];
    }
    x.child[pos + 1] = z;
    
    for (int j = x.n - 1; j >= pos; j--) {
      x.key[j + 1] = x.key[j];
    }
    x.key[pos] = y.key[max - 1];
    x.n = x.n + 1;
  }
	
	public void show() {
		show(this.root);
	}
	
	private void show(Node x) {
		// Keyword assert adalah deklarasi untuk sebuah kondisi
    assert (x == null);
    for (int i = 0; i < x.n; i++) {
      System.out.print(x.key[i] + " ");
    }
    if (!x.leaf) {
      for (int i = 0; i < x.n + 1; i++) {
        show(x.child[i]);
      }
    }
	}
	
}