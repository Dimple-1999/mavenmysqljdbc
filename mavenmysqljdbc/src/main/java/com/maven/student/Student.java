package com.maven.student;

public class Student {

	public int sId;
	public String sName;
	public String sGroup;
	public String sCity;
	public Student(int sId, String sName, String sGroup, String sCity) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sGroup = sGroup;
		this.sCity = sCity;
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsGroup() {
		return sGroup;
	}
	public void setsGroup(String sGroup) {
		this.sGroup = sGroup;
	}
	public String getsCity() {
		return sCity;
	}
	public void setsCity(String sCity) {
		this.sCity = sCity;
	}

}
