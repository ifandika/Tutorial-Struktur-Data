public class MyArray {
	
	public static void main(String[] args) {
		
		int[] array = new int[5];
		
		array[0] = 10;
		array[1] = 5;
		array[2] = 7;
		
		// Array di java untuk nilai panjang adalah address penutup
		//  0	1	2	3	4
		// 10	5	9	7	address null sebagai penutup data array
		// size = 5
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
	}
	
}