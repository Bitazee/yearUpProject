package com.yearup;

public class Student {
	private String name;
	private String cohortName;
	private String track;
	private String internShip;
	private String converted;
	private String email;
	
	
	public Student(String name, String cohortName, String track, String internShip, String converted, String email) {
		super();
		this.name = name;
		this.cohortName = cohortName;
		this.track = track;
		this.internShip = internShip;
		this.converted = converted;
		this.email = email;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCohortName() {
		return cohortName;
	}
	public void setCohortName(String cohortName) {
		this.cohortName = cohortName;
	}
	public String getTrack() {
		return track;
	}
	public void setTrack(String track) {
		this.track = track;
	}
	public String getInternShip() {
		return internShip;
	}
	public void setInternShip(String internShip) {
		this.internShip = internShip;
	}
	public String isConverted() {
		return converted;
	}
	public void setConverted(String converted) {
		this.converted = converted;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
