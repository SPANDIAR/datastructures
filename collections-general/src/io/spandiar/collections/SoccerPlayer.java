package io.spandiar.collections;

public class SoccerPlayer {
	
	private int squadNumber;
	private String position;
	private String name;
	private String currentClub;
	private String nationality;
	
	
	
	public SoccerPlayer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SoccerPlayer(int squadNumber, String position, String name, String currentClub, String nationality) {
		super();
		this.squadNumber = squadNumber;
		this.position = position;
		this.name = name;
		this.currentClub = currentClub;
		this.nationality = nationality;
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

}