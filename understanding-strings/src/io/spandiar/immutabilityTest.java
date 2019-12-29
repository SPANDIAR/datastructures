package io.spandiar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class immutabilityTest {

	@Test
	void testIncrementWithString() {
		immutability test = new immutability();
		test.incrementWithString();
	}

	@Test
	void testIncrementWithStringBuffer() {
		immutability test = new immutability();
		test.incrementWithString();
	}

}
