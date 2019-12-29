import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class ReadandWriteActions {
	
	public void writeIntoFile(String fileContents) throws IOException {
		
		File file = new File("sampleFile.txt");
		FileOutputStream fop = new FileOutputStream(file);
		DataOutputStream  dop = new DataOutputStream(fop);
		dop.writeUTF(fileContents);
	}
	
	public String readFromFile() throws IOException {
		
		File file = new File("sampleFile.txt");
		FileInputStream fip = new FileInputStream(file);
		DataInputStream dip = new DataInputStream(fip);
		
		return dip.readUTF();
		
	}

	public static void main(String[] args) throws IOException {
		
		ReadandWriteActions rwa = new ReadandWriteActions();
		String fileContentsOriginal = "Hello there!!! Do you see this...This is real";
		String fileContentsRead;
		
		rwa.writeIntoFile(fileContentsOriginal);
		fileContentsRead = rwa.readFromFile();
		
		System.out.println("Original Text is: " + fileContentsOriginal);
		System.out.println("Data in the file is: " + fileContentsRead);
		
	}

}
