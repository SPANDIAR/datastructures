package io.spandiar.hashcodes;

public class Hashing {

	public static void main(String[] args) {
		
		String dad, mom, daughter, spurs, gal;;
		
		dad="Sankar";
		mom="Karthika";
		daughter="Tanishka";
		spurs="Tottenham";
		gal="Galatasaray";
		
		System.out.println("Hashcode of dad is: " + dad.hashCode());
		System.out.println("Hashcode of mom is: " +mom.hashCode());
		System.out.println("Hashcode of daughter is: " +daughter.hashCode());
		
		System.out.println("");
		System.out.println("converting to +ve integer");
		System.out.println("");

		
		System.out.println("Hashcode of dad is: " +(dad.hashCode() & 0xFFFFFFF));
		System.out.println("Hashcode of mom is: " +(mom.hashCode() & 0xFFFFFFF));
		System.out.println("Hashcode of daughter is: " +(daughter.hashCode() & 0xFFFFFFF));
		
		System.out.println("");
		System.out.println("hashing them for the table");
		System.out.println("");
		
		System.out.println("Hashcode of dad is: " +(dad.hashCode() & 0xFFFFFFF)%16);
		System.out.println("Hashcode of mom is: " +(mom.hashCode() & 0xFFFFFFF)%16);
		System.out.println("Hashcode of daughter is: " +(daughter.hashCode() & 0xFFFFFFF)%16);
		System.out.println("Hashcode of Tottenham is: " +(spurs.hashCode() & 0xFFFFFFF)%16);
		System.out.println("Hashcode of Galatasaray is: " +(gal.hashCode() & 0xFFFFFFF)%16);

		
	}
}
