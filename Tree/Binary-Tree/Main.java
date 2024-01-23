public class Main {
	public static void main(String[] args) {

		ImplBinaryTree bt = new ImplBinaryTree();

		bt.insert(10);
		bt.insert(5);
		bt.insert(2);
		bt.insert(9);
		bt.insert(15);
		bt.insert(11);
		bt.insert(12);

		bt.remove(11);

		// bt.root.left = bt.root.left.left;
		// System.out.println(bt.root.data);
		
		bt.display();
	}
}