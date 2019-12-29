package io.spandiar;

public class immutability {
	
	public void incrementWithString() {
		
		String append = "Initial";
		for (int i=1; i<=10000; i++) {
			append=append+i;
			//System.out.println("Appended value is " + append);
		}
	}
	
	public void incrementWithStringBuffer() {
		
		StringBuffer appendBuffer = new StringBuffer("Initial");
		for (int i=1; i<=10000; i++) {
			appendBuffer=appendBuffer.append(i);
			//System.out.println("Appended Buffer value is " + appendBuffer);
		}
	}

	public static void main(String args[]) {

		String firstName, lastName, fullName;
		

		firstName = "Sankar";
		String temp = firstName.concat(" Pandiarajan");
		lastName = "Pandiarajan";
		//lastName="Veerappan Natarajan " + lastName;
		fullName = firstName+ ' '+lastName;
		fullName = fullName.concat(" Karumpuli");

		System.out.println("First Name is " + firstName);
		System.out.println("Last Name is " + lastName);
		System.out.println("Full Name is " + fullName);
		System.out.println("Temp is " + temp);
		
	}

}
