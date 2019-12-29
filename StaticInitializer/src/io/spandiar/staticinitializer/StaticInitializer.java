package io.spandiar.staticinitializer;

public class StaticInitializer {
	
	static int count;
	private String objName;
	
	static{
		// this is the static initializer. this is called when a class is loaded by the jvm
		System.out.println("Inside the Static Initializer");
		System.out.println("Value of count is: " + count);		
	}
	
	{
		// this is an instance initializer. this is called when an object is created
		// note: this is called even before a constructor gets called
		System.out.println("Inside the instance initializer ");
	}

	public StaticInitializer(String objName) {
		System.out.println("Inside the constructor");
		this.objName = objName;
		System.out.println("Object name is : " + objName);
		count++;
	}



	public static void main(String[] args) {
		
		System.out.println("Number of objects created is: " + StaticInitializer.count);
		
		StaticInitializer one = new StaticInitializer("one");
		StaticInitializer two = new StaticInitializer("two");
		StaticInitializer three = new StaticInitializer("three");
		//StaticInitializer four = new StaticInitializer();
		//StaticInitializer five = new StaticInitializer();
		
		System.out.println("Number of objects created is: " + StaticInitializer.count);
	}

}
