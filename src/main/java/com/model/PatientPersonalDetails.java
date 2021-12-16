package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="patient")
public class PatientPersonalDetails {

	// fields
	@Id
	@GeneratedValue
	private int pId;
	@NotEmpty
	private String pName;
	private int pAge;
	private long phoneNo;
	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	private String gender;
	private String address;
	private String symptoms;

	// constructors
	public PatientPersonalDetails() {
	}

	public PatientPersonalDetails(int pId, String pName, int pAge, long phoneNo, String gender, String address) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pAge = pAge;
		this.phoneNo = phoneNo;
		this.gender = gender;
		this.address = address;
	}
    //Getters & Setters
	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpAge() {
		return pAge;
	}

	public void setpAge(int pAge) {
		this.pAge = pAge;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "PatientPersonalDetails [pId=" + pId + ", pName=" + pName + ", pAge=" + pAge + ", phoneNo=" + phoneNo
				+ ", gender=" + gender + ", address=" + address + "]";
	}
	

}