package io.spandiar;

public class Shapes {
	
	private float length, width, radius, side;
	
	public float area(float length, float width) {
		return (length * width);
	}
	
	public  float area (float side) {
		return (side * side);
	}
	
	/*
	 * public float area(float radius) { return (radius * radius * Math.PI); }
	 */

}
