package asd2;

public class BubbleSortR {
	private int[] arr;
	
	public BubbleSortR(int[] arr) {
		this.arr = arr;
	}
	
	public void sort() {
		for (int j = 1; j < arr.length; j++) {
			for (int i = 0; i < arr.length - j; i++) {
				if (arr[i] > arr[i + 1]) {
					int n = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = n;
					if (checkSort()) {
						break;
					}
				}
			} 
		}
	}
	
	public boolean checkSort() {
		for (int i = 0; i < arr.length - 1;i++) {
			if (arr[i] > arr[i + 1]) {
				return false;
			}
		}
		return true;
	}
	
	public void printNumbers() {
		for (int el: arr) {
			System.out.print(el + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{7, 1, 6, 5, 9, 8, 2, 4, 3};
		BubbleSortR bs = new BubbleSortR(arr);
		bs.printNumbers();
		bs.sort();
		bs.printNumbers();
	}
}
