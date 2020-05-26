package asd1;

import java.util.Arrays;

public class StackR<T> {
	private T[] arr;
	
	public StackR() {
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
		int size = newArr.length - 1;
		arr = (T[]) new Object[size];
		for (int i = 0; i < size; i++) {
			arr[i] = newArr[i];
		}
		return newArr[size++];
	}
	
	public T peek() {
		return arr[arr.length - 1];
	}
	
	public int size() {
		return arr.length;
	}
	
	public boolean isEmpty() {
		if (arr.length == 0) {
			return true;
		}
		return false;
	}

	public T[] getArr() {
		return arr;
	}

	public void setArr(T[] arr) {
		this.arr = arr;
	}

}
