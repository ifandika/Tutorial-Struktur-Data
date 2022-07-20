import java.util.Map;
import java.util.HashMap;

public class MyHashMap {
	
	public static void main (String[] args) {
		
		Map<Integer, String> hm = new HashMap<>();
		// HashMap<Integer, String> hm = new HashMap<>();
		
		// Add Key and Data
		hm.put(101, "Joni");
		hm.put(333, "Kipli");
		hm.put(151, "Tatang");
		
		System.out.println(hm);
		// With method forEach() and Lambda Expression
		hm.forEach((key, value) -> {
			System.out.print(key+"="+value+" ");
		});
		System.out.println();
		
	}
	
}