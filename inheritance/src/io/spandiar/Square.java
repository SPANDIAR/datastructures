package io.spandiar;

public class Square extends Shapes {
	
	private float side;
	
	public float area (float side) {
		return (side * side * side);
	}
	

	public static void main(String[] args) {
		
		Shapes square = new Square();
		
		System.out.println("Area of circle is: " + square.area(5));
		System.out.println();

	}

}
