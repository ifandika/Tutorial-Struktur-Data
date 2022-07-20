public class MySet {
	private int dataResult = 0;
	private String[] data = new String[5];
	
	public MySet() {}
	
	public boolean add(String value) {
		if(contains(value)) return false;
		addCapacity();
		data[dataResult++] = value;
		return true;
	}
	
	private void addCapacity() {
		if(size() >= data.length) {
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
	
	public static void main(String[] args) {
		
		ThisSet set = new ThisSet();
		
		set.add("Joni");
		set.add("Amet");
		set.add("Jupri");
		set.add("Tatang");
		
		System.out.println("size: "+set.size());
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
	
}