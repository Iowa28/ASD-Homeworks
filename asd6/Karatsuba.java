package asd6;

public class Karatsuba {
	
	public static long multiply(long i, long j) {
		if (i < 10 || j < 10) {
			return i*j;
		}
		
		int n = Long.toString(i).length();
		
		long x1 = (long) (i/Math.pow(10, Math.floor(n/2d)));
		long x0 = (long) (i%Math.pow(10, Math.floor(n/2d)));
		long y1 = (long) (j/Math.pow(10, Math.floor(n/2d)));
		long y0 = (long) (j%Math.pow(10, Math.floor(n/2d)));
		
		long first = multiply(x1, y1);
		long second = multiply(x1 + x0, y1 + y0);
		long third = multiply(x0, y0);
		
		return (long) (first*Math.pow(10, Math.floor(n/2d)*2) + (second - first - third)*Math.pow(10, Math.floor(n/2)) + third);
	}
	
	
	
	public static void main(String[] args) {
		long b = 122;
		long a = 100;
		System.out.println(multiply(a, b));
	}
}
