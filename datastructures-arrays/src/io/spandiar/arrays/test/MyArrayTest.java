package io.spandiar.arrays.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.spandiar.arrays.MyArray;

class MyArrayTest {
	
	private MyArray myArray;
	
	@BeforeEach 
	public void initialize() {
		myArray = new MyArray<String>(5);
	}

	@Test
	void testAddElement() {
		
		myArray.set(0, "a");
		myArray.set(1, "c");
		myArray.set(2, "d");
		
		myArray.addElement(1, "b");
		Assertions.assertEquals("b", myArray.get(1));
		Assertions.assertEquals("c", myArray.get(2));
		Assertions.assertEquals(4, myArray.size());
	}

	@Test
	void testDeleteElement() {
		
		myArray.set(0, "a");
		myArray.set(1, "b");
		myArray.set(2, "b");
		myArray.set(3, "c");
		
		myArray.deleteElement(2);
		Assertions.assertEquals("c", myArray.get(2));
		
	}

	
	@Test
	void testGetAndSet() {
		
		myArray.set(0, "a");
		myArray.set(1, "b");
		myArray.set(2, "c");
		
		Assertions.assertEquals("b", myArray.get(1));
		Assertions.assertEquals("c", myArray.get(2));		
	}
	
	@Test
	void testContains() {
		
		myArray.set(0, "a");
		myArray.set(1, "b");
		myArray.set(2, "c");
		
		Assertions.assertEquals(true, myArray.contains("b"));
		Assertions.assertEquals(false, myArray.contains("d"));
		
	}

}
