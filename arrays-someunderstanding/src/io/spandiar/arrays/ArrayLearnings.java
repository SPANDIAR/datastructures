package io.spandiar.arrays;

public class ArrayLearnings {

	public static void main(String[] args) {
		
		String[] mySchools = new String[5];
		String[] tannusSchools = new String[5];
		String[] tannusSchoolsClone = new String[5];
		
		mySchools[0] = "LETA";
		mySchools[1] = "Montfort Preparatory";
		mySchools[2] = "Santhome Higher Secondary";
		
		
		for(String school: mySchools) {
			System.out.println("My School List: " + school);
		}
		
		tannusSchools[0] = "Small World Academy";
		//tannusSchools[1] = "Kids R Us";
		tannusSchools[1] = "Rainbow Montessori";
		tannusSchools[2] = "Fairwood Elementary";
		
		tannusSchools[1] = "Kids R Us";
		
		for(String school: tannusSchools) {
			System.out.println("Tannu's School List: " + school);
		}
		
		tannusSchoolsClone[0] = "Small World Academy";
		tannusSchoolsClone[1] = "Kids R Us";
		tannusSchoolsClone[2] = "Rainbow Montessori";
		tannusSchoolsClone[3] = "Fairwood Elementary";
		
		
		for(String school: tannusSchoolsClone) {
			System.out.println("Tannu's School Clone List: " + school);
		}
		
		// set clone to original
		
		tannusSchools = tannusSchoolsClone;
		
		// print original after copying the clone
		
		for(String school: tannusSchools) {
			System.out.println("Tannu's School List - Copy from Clone: " + school);
		}
		
	}

}
