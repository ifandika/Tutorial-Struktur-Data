
public class IsStackSet {
	private Integer[] storage;
	private int maxSize = 0, top = 0;
	
	public static void main (String[] args) {
		
		IsStackSet stackSet = new IsStackSet();
		
		stackSet.add(100);
		stackSet.add(10);
		stackSet.add(160);
		
		System.out.println("size: "+stackSet.size());
		System.out.println("empty: "+stackSet.empty());
		System.out.println("contains: "+stackSet.contains(10));
		System.out.println("getFirst: "+stackSet.getFirst());
		System.out.println("getLast: "+stackSet.getLast());
		
		stackSet.remove();
		
		System.out.println("size: "+stackSet.size());
		System.out.println("empty: "+stackSet.empty());
		System.out.println("contains: "+stackSet.contains(10));
		System.out.println("getFirst: "+stackSet.getFirst());
		System.out.println("getLast: "+stackSet.getLast());
		
	}
	
	public IsStackSet() {
		this.storage = new Integer[5];
	}
	
	public IsStackSet(int maxSize) {
		this.storage = new Integer[maxSize];
		this.maxSize = maxSize;
	}
	
	public void add(int val) {
		if(!contains(val)) {
			storage[top++] = val;
		}
		else {
			throw new RuntimeException("Data sudah ada");
		}
	}
	
	public void remove() {
		if(!empty()) {
			this.storage[top-1] = null;
			top--;
		}
	}
	
	public boolean contains(int val) {
		if(!empty()) {
			for(int i = 0; i < size(); i++) {
				if(val == this.storage[i]) {
					return true;
				}
			}
		}
		return false;
	}
	
	// Data yang pertama dimasukan
	public int getFirst() {
		if(!empty()) {
			return this.storage[0];
		}
		else {
			return -1;
		}
	}
	
	// Data yang terakhir dimasukan
	public int getLast() {
		if(!empty()) {
			return this.storage[top-1];
		}
		else {
			return -1;
		}
	}
	
	public boolean empty() {
		return size() == 0;
	}
	
	public int size() {
		return this.top;
	}
	
}