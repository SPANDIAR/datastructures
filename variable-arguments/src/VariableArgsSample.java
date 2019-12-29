
public class VariableArgsSample {
	
	public static int sum(int...numbers) {
		int sum=0;
		for (int number:numbers) {
			sum+=number;
		}
		return sum;
	}

	public static void main(String[] args) {
		
		int sum = VariableArgsSample.sum(2,3,4,5,6);
		System.out.println("Sum of the values is : " + sum);

	}

}
