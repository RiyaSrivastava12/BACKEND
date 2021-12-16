package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name="admin")
public class Admin { 
	
	

	//Fields
	@Id
	@GeneratedValue
	private int adminId;
	
	@Column(name="fullname")
	@NotEmpty
	@Size(min=3, message="student fullname should have atleast 3 char")
	private String fullName;
	
	private String contactNo;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="login")
	private Login login;
	
	
	public Admin() {
	}

	public int getAdminId() {
		return adminId;
	}


	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getContactNo() {
		return contactNo;
	}


	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	public Login getLogin() {
		return login;
	}


	public void setLogin(Login login) {
		this.login = login;
	}


	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", fullName=" + fullName + ", contactNo=" + contactNo + ", login=" + login
				+ "]";
	}
	
	
	
}