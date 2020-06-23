package io.spandiar;

public class GenericClass {
	
	public static void main(String[] args) {
		
		Add<Integer> item1 = new Add<Integer>(10);
		Add<Integer> item2 = new Add<Integer>(15);
		Add<Integer> item3 = new Add<Integer>();
		
		Add<String> str1 = new Add<String>("Hello");
		Add<String> str2 = new Add<String>("World!!!");
		
		System.out.println("Sum of the numbers is: " + (item1.getItem() + item2.getItem()));
		System.out.println("Concatenation of Strings is: " + (str1.getItem() + " " + str2.getItem()));
		
		
		System.out.println("Compare Method returns: " + item3.compareItems("Karthi", "Sankar"));

	}

}

class Add<T>{
	
	private T item;

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public Add(T item) {
		super();
		this.item = item;
	}
	
	public Add() {
		
	}

	public <T extends Comparable, Number> T compareItems(T item1, T item2) {
		
		return (item1.compareTo(item2) < 0) ? item1: item2;
		
	}
	
}
