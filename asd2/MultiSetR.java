package asd2;

public class MultiSetR<T> {
	private T[] elArr;
	private int[] numArr;
	private int numberOfElements;
	
	public MultiSetR() {
		this.elArr = (T[]) new Object[0];
		this.numberOfElements = 0;
		this.numArr = new int[10];
	}
	
	public void add(T obj) {
		if (!has(obj)) {
			T[] newElArr = (T[]) new Object[elArr.length + 1];
			for (int i = 0; i < elArr.length; i++) {
				newElArr[i] = elArr[i];
			}
			newElArr[elArr.length] = obj;
			elArr = newElArr;
			
			numArr[numberOfElements] = 1;
			numberOfElements++;
			if (numberOfElements >= numArr.length) {
				expansionNumArr(numArr);
			}
		} else {
			for (int i = 0; i < elArr.length; i++) {
				if (elArr[i].equals(obj)) {
					numArr[i]++;
				}
			}
		}
	}
	
	public void expansionNumArr(int[] numArr) {
		int[] newNumArr = new int[numArr.length*2];
		for (int i = 0; i < numArr.length; i++) {
			newNumArr[i] = numArr[i];
		}
		numArr = newNumArr;
	}
	
	public boolean has(T obj) {
		for (T element: elArr) {
			if (element.equals(obj)) {
				return true;
			}
		} return false;
	}
	
	public int elementsHas(T obj) {
		for (int i = 0; i < elArr.length; i++) {
			if (elArr[i].equals(obj)) {
				return numArr[i];
			}
		}
		return 0;
	}
	
	public int size() {
		return elArr.length;
	}
	
	public void remove(T obj) {
		if (has(obj)) {
			if (elementsHas(obj) == 1) {
				T[] newArr = elArr;
				int j = 0;
				elArr = (T[]) new Object[newArr.length - 1];
				for (int i = 0; i < newArr.length; i++) {
					if (!newArr[i].equals(obj)) {
						elArr[j] = newArr[i];
						j++;
					}
				}
			} else {
				for (int i = 0; i < elArr.length; i++) {
					if (elArr[i].equals(obj)) {
						numArr[i]--;
					}
				}
			}
		}
	}

	public T[] getElArr() {
		return elArr;
	}

	public void setElArr(T[] elArr) {
		this.elArr = elArr;
	}

	public int[] getNumArr() {
		return numArr;
	}

	public void setNumArr(int[] numArr) {
		this.numArr = numArr;
	}

	public int getNumberOfElements() {
		return numberOfElements;
	}

	public void setNumberOfElements(int number) {
		this.numberOfElements = number;
	}
	
	public static void main(String[] args) {
		MultiSetR<String> data = new MultiSetR<>();
		data.add("pog");
		data.add("monkey");
		data.add("pog");
		data.add("pog");
		System.out.println(data.elementsHas("pog"));
		data.remove("pog");
		System.out.println(data.elementsHas("pog"));
	}
}
