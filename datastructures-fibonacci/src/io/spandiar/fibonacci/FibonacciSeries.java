package io.spandiar.fibonacci;

public class FibonacciSeries {
	
	private int[] fiboCache = new int[100];
	
	public int fibonacciNative(int range) {
		
		if (range <= 0) {
			return 0;
		} else if (range == 1) {
			return 1;
		} else
		{	
			return (fibonacciNative(range - 1) + fibonacciNative(range - 2));
		}
	}
	
	public int fibonacciTuned(int range) {
		
		if (range <= 0) {
			return 0;
		} else if (range == 1) {
			return 1;
		} else if(fiboCache[range] == 0)
		{	
			fiboCache[range] = (fibonacciTuned(range - 1) + fibonacciTuned(range - 2));
		}
		return fiboCache[range];
	}

	public static void main(String[] args) {
		
		int range = 15;
		
		FibonacciSeries fibo = new FibonacciSeries();
		
		/*
		 * System.out.println("Native Output"); for (int i=0; i<=range;i++) {
		 * System.out.print(fibo.fibonacciNative(i) + ", "); }
		 */
		 
		
		System.out.println("Tuned Output");
		for (int i=0; i<=range;i++) {
			System.out.print(fibo.fibonacciTuned(i) + ", ");
		}
	}

}
