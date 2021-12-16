package com.dto;
import lombok.Data;

@Data
public class AdminInputDto {
	private String fullName;
	private String contactNo;
	private String email;
	private String role;
	private String password;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AdminInputDto [fullName=" + fullName + ", contactNo=" + contactNo + ", email=" + email + ", role="
				+ role + ", password=" + password + "]";
	}
	
	
	
}
