package asd6;

public class MergeSorterR {
	private int[] arr;
	private int[] sortedArr;
	
	public MergeSorterR(int[] arr) {
		this.arr = arr;
		this.sortedArr = new int[arr.length];
	}
	
	public void sort() {
		mSort(0, arr.length - 1);
	}
	
	public void mSort(int s, int f) {
		if (s >= f) {
			return;
		}
		int m = (s + f)/2;
		mSort(s, m);
		mSort(m + 1, f);
		merge(s, m, f);
	}
	
	public void merge(int s, int m, int f) {
		int i = s, j = m + 1, k = s;
		while (i <= m && j <= f) {
			if (arr[i] < arr[j]) {
				sortedArr[k] = arr[i];
				i++;
				k++;
			} else {
				sortedArr[k] = arr[j];
				j++;
				k++;
			}
		}
		while (i <= m) {
			sortedArr[k] = arr[i];
			i++;
			k++;
		}
		while (j <= f) {
			sortedArr[k] = arr[j];
			j++;
			k++;
		}
		for (int index = 0; index <= f; index++) {
			arr[index] = sortedArr[index];
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 6, 8, 4, 9, 0, 3 , 5, 2, 7};
		MergeSorterR sorter = new MergeSorterR(arr);
		sorter.sort();
		for (int el: arr) {
			System.out.println(el);
		}
	}
}
