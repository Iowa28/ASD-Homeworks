package asd2;

import java.util.Arrays;

public class SetR<T> {
	private T[] data;
	
	public SetR() {
		this.data = (T[]) new Object[0];
	}
	
	public SetR(T[] arr) {
		this.data = arr;
	}

	public void add(T obj) {
		if (!has(obj)) {
			T[] newArr = (T[]) new Object[data.length + 1];
			for (int i = 0; i < data.length; i++) {
				newArr[i] = data[i];
			}
			newArr[data.length] = obj;
			data = newArr;
		}
	}
	
	public boolean has(T obj) {
		for (T element: data) {
			if (element.equals(obj)) {
				return true;
			}
		} return false;
	}
	
	public int size() {
		return data.length;
	}
	
	public void remove(T obj) {
		if (has(obj)) {
			T[] newArr = data;
			int j = 0;
			data = (T[]) new Object[newArr.length - 1];
			for (int i = 0; i < newArr.length; i++) {
				if (!newArr[i].equals(obj)) {
					data[j] = newArr[i];
					j++;
				}
			}
		}
	}
	
	public SetR merge(SetR<T> setR) {
		T[] newArr = (T[]) new Object[data.length + setR.size()];
		for(int i = 0; i < data.length; i++) {
			newArr[i] = data[i];
		}
		
		int n = newArr.length;
		T[] otherArr = (T[]) setR.getData();
		for (int i = 0; i < otherArr.length; i++) {
			newArr[n] = otherArr[i];
		}
		return new SetR<T>(newArr);
	}
	
	public boolean contains(SetR osr) {
		int n = osr.data.length;
		int m = n;
		for (int j = 0; j < osr.data.length; j++) {
			for (int i = 0; i < this.data.length; i++) {
				if (osr.data[j].equals(this.data[i])) {
					m--;
				}
			} if (m == n) {
				return false;
			} n--;
		}
		return true;
	}
	
	public T[] getData() {
		return data;
	}

	public void setData(T[] arr) {
		this.data = arr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(data);
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
		SetR other = (SetR) obj;
		if (!Arrays.deepEquals(data, other.data))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "SetR [data=" + Arrays.toString(data) + "]";
	}

	public static void main(String[] args) {
		SetR<String> a = new SetR<>(new String[] {"1","2","3","4","5","6"});
		SetR<String> b = new SetR<>(new String[] {"1","2","3"});
		System.out.println(a.contains(b));
		
	}
}
