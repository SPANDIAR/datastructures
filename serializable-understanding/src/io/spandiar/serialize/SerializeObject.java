package io.spandiar.serialize;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeObject implements Serializable{
	
	int age;
	String name;
	
	
	
public SerializeObject() {
		super();
		System.out.println("Inside the constructor");
	}

@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SerializeObject [age=");
		builder.append(age);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

public void writeIntoFile(Object obj) throws IOException {
		
		File file = new File("serializedObject.txt");
		FileOutputStream fop = new FileOutputStream(file);
		ObjectOutputStream  oop = new ObjectOutputStream(fop);
		oop.writeObject(obj);
		oop.close();
	}
	
	public Object readFromFile() throws IOException, ClassNotFoundException {
		
		File file = new File("serializedObject.txt");
		FileInputStream fip = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fip);
		
		return ois.readObject();
		
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		SerializeObject so1 = new SerializeObject();
		//SerializeObject so2 = new SerializeObject();
		
		so1.age = 38;
		so1.name = "Sankar Pandiarajan";
		
		so1.writeIntoFile(so1);
		
		SerializeObject so2 = (SerializeObject) so1.readFromFile();
		
		System.out.println("Value of the read object is: " + so2.toString());
	}

}
