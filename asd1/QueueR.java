package asd1;

import java.util.Arrays;

public class QueueR<T> {
	private T[] arr;

	public QueueR() {
		this.arr = (T[]) new Object[0];
	}

	public void add(T obj) {
		T[] newArr = (T[]) new Object[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		newArr[arr.length] = obj;
		arr = newArr;
	}
	
	public T pop() {
		T[] newArr = arr;
		arr = (T[]) new Object[newArr.length - 1];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = newArr[i + 1];
		}
		return newArr[0];
	}
	
	public T peek() {
		return arr[0];
	}
	
	public int size() {
		return arr.length;
	}

	public T[] getArr() {
		return arr;
	}

	public void setArr(T[] arr) {
		this.arr = arr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(arr);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QueueR other = (QueueR) obj;
		if (!Arrays.deepEquals(arr, other.arr))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "QueueR [arr=" + Arrays.toString(arr) + "]";
	}

}