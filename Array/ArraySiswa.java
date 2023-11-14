
public class ArraySiswa {
	private String[] siswaKLS_A, siswaKLS_B;
	private int existsA, existsB, sizeA, sizeB;

	public static void main(String[] args) {
		
	}

	public ArraySiswa(int klsA, int klsB) {
		siswaKLS_A = new String[klsA];
		siswaKLS_B = new String[klsB];
		existsA = 0;
		existsB = 0;
		sizeA = klsA;
		sizeB = klsB;
	}

	public void tambah(String kls, String nama) {
		if(penuh(kls)) {
			// Error penuh
		}
		else {
			
		}
	}

	public boolean penuh(String kls) {
		if(kls.equals("A")) {
			if(existsA == sizeA) {
				return true;
			}
		}
		else if(kls.equals("B")) {
			if(existsB == sizeB) {
				return false;
			}
		}
		else {
			// Error
		}
		return false;
	}
}