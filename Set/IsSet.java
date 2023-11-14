public class IsSet {
	private int dataTotal = 0, maxSize = -1;
	private String[] data;
	
	public static void main(String[] args) {
		
		IsSet set = new IsSet(5);
		
		set.add("Joni");
		set.add("Amet");
		set.add("Jupri");
		set.add("Tatang");
		
		System.out.println("size: "+set.size());
		System.out.println("maxSize: "+set.getMaxSize());
		System.out.println("empty: "+set.empty());
		System.out.println("contains: "+set.contains("Amet"));
		System.out.println("indexOf: "+set.indexOf("Tatang"));
		
		set.remove("Amet");
		set.remove("Jupri");
		
		System.out.println("size: "+set.size());
		
		set.add("Amir");
		set.add("Yanto");
		set.add("Sopo");
		set.add("Basna"); // addCapacity
		
		System.out.println("getLast: "+set.getLast());
		System.out.println("getFirst: "+set.getFirst());
		System.out.println("getWithIndex: "+set.getWithIndex(4));
		System.out.println("size: "+set.size());
	}
	
	public IsSet() {
		this.data = new String[5];
	}
	
	public IsSet(int max) {
		this.data = new String[max];
		this.maxSize = max;
	}
	
	/**
	 * Fungsi tambah data, pertama cek apakah ada data yang sama jika ada
	 * maka eror. Jika tidak maka data dimasukan. fungsi addCapacity() 
	 * sebagai pembantu jika data sudah lebih dari batas maka akan membuat
	 * data baru.
	 */
	public void add(String value) {
		if(contains(value)) throw new RuntimeException("Data exist");
		addCapacity();
		data[dataTotal++] = value;
	}
	
	/**
	 * Fungsi ini sebagai pembantu untuk jumlah data yg melebihi batas maka
	 * akan dibuatkan data baru dengan kapasitas yang lebih besar. Kondisi 
	 * pertama untuk cek apakah jumlah data saat ini melebihi bataa yang 
	 * dideklarasi.
	 * Kondisi kedua sebagai pemindahan data sekligus menambah kapasitas.
	 */
	private void addCapacity() {
		if(getMaxSize() != -1 && size() > getMaxSize())
			throw new RuntimeException("Data full");
		if(size() > data.length-1) {
			String[] temp = new String[size() + 5];
			for(int i = 0; i < size(); i++) {
				temp[i] = data[i];
			}
			data = temp;
		}
	}
	
	public boolean contains(String value) {
		if(empty()) return false;
		return indexOf(value) != -1;
	}
	
	public int indexOf(String value) {
		if(empty()) return -1;
		for(int i = 0; i < size(); i++) {
			if(value.equals(data[i])) {
				return i;
			}
		}
		return -1;
	}
	
	public int getMaxSize() {
		if(this.maxSize == -1) {
			return -1;
		}
		else {
			return this.maxSize;
		}
		// Dengan unary
		// return this.maxSize != -1 ? this.maxSize : -1;
	}
	
	public String getFirst() {
		if(empty()) throw new RuntimeException("Set empty");
		return data[0];
	}
	
	public String getLast() {
		if(empty()) throw new RuntimeException("Set empty");
		return data[dataResult-1];
	}
	
	public String getWithIndex(int value) {
		if(empty()) throw new RuntimeException("Set empty");
		for(int i = 0; i < size(); i++) {
			if(value == i) {
				return data[i];
			}
		}
		return null;
	}
	
	public boolean remove(String value) {
		if(empty()) return false;
		for(int i = indexOf(value); i < size(); i++) {
			data[i] = data[i+1];
		}
		this.dataResult--;
		return true;
	}
	
	public boolean empty() {
		return size() == 0;
	}
	
	public int size() {
		return this.dataResult;
	}
	
}