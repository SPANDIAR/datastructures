package io.spandiar.arrays;

import java.util.Arrays;

public class MyArray<T> {
	
	private Object[] array, cloneArray;
	private int limit, size;
	
	public MyArray() {
	}
	
	public MyArray(int limit) {
		this.limit = limit;
		array = new Object[limit];
	}
	
	public String get(int index) {
		return (String) array[index];
	}
	
	public void set(int index, String value) {
		array[index] = value;
		size++;
	}
	

	public void addElement(int index, String value){
		
		if(size == limit) {
			resizeArray();
		}
		
		for(int i=size; i>=index; i--) {
			array[i] = array[i-1];
		}
		array[index] = value;
		size++;
	}
	
	public void deleteElement(int index) {
		
		for(int i=index; i<size-1; i++) {
			array[i] = array[i+1];
		}
		array[size-1] = null;
		size--;
	}
	
	public void resizeArray() {
		
		cloneArray = new Object[limit * 2];
		
		for(int i=0; i<array.length;i++) {
			cloneArray[i] = array[i];
		}
		array = cloneArray;
		limit = limit * 2;
		cloneArray = null;
	}
	
	public boolean contains(String value) {
		for(int i=0;i<size;i++) {
			if(array[i] == value) {
				return true;
			} 
		}
		return false;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public int size() {
		return size;
	}
	
	public void printArray() {
		for(Object value: array) {
			System.out.println("Element is: " + value);
		}
	}
	
	public static void main(String args[]) {
		
		MyArray myArray = new MyArray<String>(10);
		
		System.out.println("Is the array empty: " + myArray.isEmpty());
		
		myArray.set(0, "A");
		myArray.set(1, "B");
		myArray.set(2, "C");
		myArray.set(3, "E");
		myArray.set(4, "F");
		myArray.set(5, "H");
		myArray.set(6, "I");
		myArray.set(7, "J");
		 
		System.out.println("Is the array empty: " + myArray.isEmpty());
		
		// Before
		System.out.println("Before Inserts");
		System.out.println("Size of array is: " + myArray.size());
		
		myArray.printArray();
		
		  myArray.addElement(3, "D");
		  myArray.addElement(6, "G");
		  myArray.addElement(7, "G");
		  myArray.addElement(11, "K");
		 
		
		// After
		System.out.println("After Inserts");
		System.out.println("Size of array is: " + myArray.size());

		myArray.printArray();
		
		// After Delete
		myArray.deleteElement(7);
		System.out.println("After Deletes");
		System.out.println("Size of array is: " + myArray.size());
		
		myArray.printArray();
		
		// check contains
		System.out.println("Is F availale in the array: " + myArray.contains("F"));

	}

}
