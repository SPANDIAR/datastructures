package io.spandiar.fibonacci.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.spandiar.fibonacci.FibonacciSeries;

class FibonacciSeriesTest {
	
	FibonacciSeries fibo;
	int range = 15;
	
	@BeforeEach
	public void init() {
		fibo = new FibonacciSeries();
	}

	@Test
	void testFibonacciNative() {
		Assertions.assertEquals(610, fibo.fibonacciNative(range));
	}

	@Test
	void testFibonacciTuned() {
		Assertions.assertEquals(610, fibo.fibonacciTuned(range));
	}

}
