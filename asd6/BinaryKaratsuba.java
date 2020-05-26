package asd6;

public class BinaryKaratsuba {
	
	public static long multiply(long i, long j) {
		boolean[] a = getBinary(i);
		boolean[] b = getBinary(j);
		boolean[] multi = multiply(a, b);
		return getInt(multi);
	}
	
	public static boolean[] multiply(boolean[] i, boolean[] j) {
		if (i.length == 1 || j.length == 1) {
			int a = getInt(i);
			int b = getInt(j);
			//System.out.println(a*b);
			return getBinary(a*b);
		}
		
		int n = i.length;
		int halfN = (int) Math.round((double)n/2.0);
		
		boolean[] x1 = getRight(i, halfN);
		boolean[] x0 = getLeft(i, halfN);
		
		boolean[] y1 = getRight(j, halfN);
		boolean[] y0 = getLeft(j, halfN);
	
		boolean[] first = multiply(x1, y1);
		boolean[] second = multiply(sum(x1, x0), sum(y1, y0)); // 4
		boolean[] third = multiply(x0, y0);
		//System.out.println(getInt(third));
		
		second = subtract(second, first);
		second = subtract(second, third);
		second = move(second, halfN);
		first = move(first, n);
		
		return sum(sum(first, second), third);
	}
	
	public static boolean[] sum(boolean[] arr1, boolean[] arr2) {
		if (arr1.length < arr2.length) {
			arr1 = addNulls(arr1, arr2.length - arr1.length);
		} else if (arr2.length < arr1.length) {
			arr2 = addNulls(arr2, arr1.length - arr2.length);
		}
		
		boolean[] sum = new boolean[arr1.length + 1];
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] & arr2[i]) {
				sum[i + 1] = true;
			}
			else if (arr1[i] & !arr2[i]) {
				if (sum[i]) {
					sum[i + 1] = true;
					sum[i] = false;
				} else {
					sum[i] = true;
				}
			}
			else if (!arr1[i] & arr2[i]) {
				if (sum[i]) {
					sum[i + 1] = true;
					sum[i] = false;
				} else {
					sum[i] = true;
				}
			}
		}
		if (!sum[sum.length - 1]) {
			sum = getLeft(sum, sum.length - 1);
		}
		return sum;
	}
	
	public static boolean[] subtract(boolean[] arr1, boolean[] arr2) {
		if (arr2.length < arr1.length) {
			arr2 = addNulls(arr2, arr1.length - arr2.length);
		}
		boolean[] subtract = new boolean[arr1.length];
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] & arr2[i]) {
				if (subtract[i]) {
					subtract[i] = false;
					subtract[i + 1] = true;
				}
			}
			else if (arr1[i] & !arr2[i]) {
				if (subtract[i]) {
					subtract[i] = false;
				} else {
					subtract[i] = true;
				}
			}
			else if (!arr1[i] & arr2[i]) {
				if (subtract[i]) {
					subtract[i + 1] = true;
					subtract[i] = false;
				} else {
					subtract[i = 1] = true;
					subtract[i] = true;
					
				}
			}
		}
		int cursor = 0;
		for (int i = subtract.length - 1; i >= 0; i--) {
			if (subtract[i]) {
				break;
			}
			else {
				cursor++;
			}
		}
		return getLeft(subtract, cursor);
	}
	
	public static boolean[] getLeft(boolean[] arr, int n) {
		boolean[] newArr = new boolean[n];
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = arr[i];
		}
		return newArr;
	}
	
	public static boolean[] getRight(boolean[] arr, int n) {
		boolean[] newArr = new boolean[arr.length - n];
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = arr[n];
			n++;
		}
		return newArr;
	}
	
	public static boolean[] move(boolean[] arr, int n) {
		boolean[] newArr = new boolean[arr.length + n];
		for (int i = 0; i < arr.length; i++) {
			newArr[n] = arr[i];
			n++;
		}
		return newArr;
	}
	
	public static boolean[] addNulls(boolean[] arr, int n) {
		boolean[] newArr = new boolean[arr.length + n];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		return newArr;
	}
	
	public static boolean[] getBinary(long n) {
		String binary = Long.toBinaryString(n);
		int lenght = binary.length();
		boolean[] arr = new boolean[lenght];
		for (int i = 0; i < lenght; i++) {
			if (binary.charAt(lenght - i - 1) == '1') {
				arr[i] = true;
			}
		}
		return arr;
	}
	
	public static int getInt(boolean[] arr) {
		int n = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]) {
				n += Math.pow(2, i);
			}
		}
		return n;
	}
	
	public static void print(boolean[] arr) {
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i]) {
				System.out.print(1);
			} else {
				System.out.print(0);
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int n = 3;
		int m = 3;
		
		boolean[] arr1 = getBinary(n);
		boolean[] arr2 = getBinary(m);
		//sum(arr1, arr2);
		System.out.println(multiply(n, m));
		//int k = (int) Math.round((double)5/2.0); // == 3
	}
}
