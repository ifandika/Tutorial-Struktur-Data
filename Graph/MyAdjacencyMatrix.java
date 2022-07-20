public class MyAdjacencyMatrix {
	private boolean[][] data;
	private int sizeData;
	
	public MyAdjacencyMatrix(int value) {
		this.sizeData = value;
		this.data = new boolean[sizeData][sizeData];
	}
	
	/**
	 * @k	Kolom
	 * @b	Baris
	 */
	public void addEdge(int k, int b) {
		data[k][b] = true;
		data[b][k] = true;
	}
	
	public void removeEdge(int k, int b) {
		data[k][b] = false;
		data[b][k] = false;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int lop = 0; lop < this.sizeData; lop++) {
			sb.append(lop+": ");
			for(boolean buffer : data[lop]) {
				sb.append((buffer ? 1 : 0)+" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		AdjacencyMatrix am = new AdjacencyMatrix(4);
		
		am.addEdge(0, 1);
		am.addEdge(2, 1);
		am.addEdge(1, 2);
		
		System.out.println(am.toString());
		
		am.removeEdge(0, 1);
		am.removeEdge(1, 1);
		
		System.out.println(am.toString());
		
	}
	
}