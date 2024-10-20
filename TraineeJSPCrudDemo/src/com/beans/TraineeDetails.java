package com.beans;

import java.sql.Date;

public class TraineeDetails {
	
	private int empid;
	private String name;
	private String gender;
	private java.sql.Date dob;
	private String citizenshipstatus;
	
	public TraineeDetails(int empid, String name, String gender, Date dob, String citizenshipstatus) {
		super();
		this.empid = empid;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.citizenshipstatus = citizenshipstatus;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public java.sql.Date getDob() {
		return dob;
	}

	public void setDob(java.sql.Date dob) {
		this.dob = dob;
	}

	public String getCitizenshipstatus() {
		return citizenshipstatus;
	}

	public void setCitizenshipstatus(String citizenshipstatus) {
		this.citizenshipstatus = citizenshipstatus;
	}
	
}
