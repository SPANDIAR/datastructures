package io.spandiar;

/* Circle inherits Shapes and both the base class and sub class have the same signature for Area
 * If area method is invoked, based on the Object, the corresponding method gets invoked
 * This is Polymorphism
 * */

public class Circle extends Shapes {

	private float radius;

	
	  public float area(float radius) { 
		  
		  return (float) (radius * radius * Math.PI);
	  }
	 
	
	public float circumference(float radius) {
		return (float) (2 * Math.PI * radius);
	}

	public static void main(String args[]) {

		Shapes circle = new Circle();
		
		System.out.println("Area of circle is: " + circle.area(5));
	}

}
