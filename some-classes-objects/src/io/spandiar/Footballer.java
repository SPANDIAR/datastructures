package io.spandiar;

public class Footballer {
	
	private int squadNumber;
	private String position;
	private String name;
	private String currentClub;
	private String nationality;
	
	
	public Footballer(int squadNumber, String position, String name, String currentClub, String nationality) {
		super();
		this.squadNumber = squadNumber;
		this.position = position;
		this.name = name;
		this.currentClub = currentClub;
		this.nationality = nationality;
	}


	public Footballer() {
		
	}
	

	public int getSquadNumber() {
		return squadNumber;
	}



	public void setSquadNumber(int squadNumber) {
		this.squadNumber = squadNumber;
	}



	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCurrentClub() {
		return currentClub;
	}



	public void setCurrentClub(String currentClub) {
		this.currentClub = currentClub;
	}



	public String getNationality() {
		return nationality;
	}



	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Footballer [squadNumber=");
		builder.append(squadNumber);
		builder.append(", position=");
		builder.append(position);
		builder.append(", name=");
		builder.append(name);
		builder.append(", currentClub=");
		builder.append(currentClub);
		builder.append(", nationality=");
		builder.append(nationality);
		builder.append("]");
		return builder.toString();
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currentClub == null) ? 0 : currentClub.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nationality == null) ? 0 : nationality.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + squadNumber;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Footballer other = (Footballer) obj;
		if (currentClub == null) {
			if (other.currentClub != null)
				return false;
		} else if (!currentClub.equals(other.currentClub))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nationality == null) {
			if (other.nationality != null)
				return false;
		} else if (!nationality.equals(other.nationality))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (squadNumber != other.squadNumber)
			return false;
		return true;
	}



	public static void main(String[] args) {
		
		Footballer mesutOzil = new Footballer(10, "Midfield", "Mezut Ozil", "Arsenal FC", "Germany");
		Footballer cescFabergas = new Footballer(4, "Midfield", "Cesc Fabergas", "Monaco FC", "Spain");
		Footballer ozil = mesutOzil;
		Footballer koscielny = new Footballer();
		
		
		System.out.println("Mezut Ozil is " + mesutOzil.toString() + " Its hashCode is " + mesutOzil.hashCode());
		System.out.println("Cesc Fabergas is " + cescFabergas.toString() + " Its hashCode is " + cescFabergas.hashCode());
		
		System.out.println("Is Ozil and Fabergas Equal: " + mesutOzil.equals(cescFabergas));
		System.out.println("Is Ozil and ozil Equal: " + mesutOzil.equals(ozil) + " ozil's Hashcode is " + ozil.hashCode());

		System.out.println("Ozil is an object of class: " + mesutOzil.getClass());
		
//System.out.println("Is Koscielny a member of Footballer " + koscielny instanceof io.spandiar.Footballer);

		
	}

}
