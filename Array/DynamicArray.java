public class DynamicArray {
	private String[] array;
	private final int DEFAULT_CAPACITY = 10;
	private int exist = 0;
	private int arrayLength;

	public static void main(String[] args) {
		DynamicArray da = new DynamicArray();

		System.out.println(da.size());
		System.out.println(da.isEmpty());

		for(int i = 0; i < 10; i++) {
			da.add("Supri");
		}

		System.out.println(da.get(9));
		System.out.println(da.indexOf("Supri"));
		System.out.println(da.toString());
	}

	public DynamicArray() {
		array = new String[DEFAULT_CAPACITY];
		arrayLength = array.length;
	}
	
	// Menambah data
	public void add(String val) {
		if(isFull()) {
			upCapacity();
		}
		array[exist++] = val;
	}

	// Untuk membuat array baru dengan ukuran lebih
	private void upCapacity() {
		int newCapacity = (arrayLength + DEFAULT_CAPACITY);
		String[] newArray = new String[newCapacity];
		for(int i = 0; i < arrayLength; i++) {
			newArray[i] = array[i];
		}
		arrayLength = newCapacity;
		array = newArray;
	}

	// Jika data array sudah penuh
	private boolean isFull() {
		if(size() == arrayLength) {
			return true;
		}
		return false;
	}

	public boolean isEmpty() {
		return exist == 0;
	}

	// Mengambil data array dengan index
	public String get(int index) {
		if(isEmpty()) {
			throw new RuntimeException("Dynamic Array is empty");
		}
		return array[index];
	}

	// Mengambil nilai index dari data
	public int indexOf(String val) {
		if(isEmpty()) {
			throw new RuntimeException("Dynamic Array is empty");
		}
		for(int i = 0; i < size(); i++) {
			if(array[i] == val) {
				return i;
			}
		}
		return -1;
	}

	// Hapus data array dengan index
	public void remove(int index) {
		
	}

	// Konversi ke string
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < exist; i++) {
			sb.append(String.format("%s, ",array[i]));
		}
		String result = String.format("[%s]", sb.toString().substring(0, sb.length()-2));
		return result;
	}

	public int size() {
		return arrayLength;
	}
}