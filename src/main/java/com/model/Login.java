package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import com.model.Admin;


@Data
@Entity
public class Login{
	
	@Id
	@GeneratedValue
	private int loginId;
	
	private String email;

	@NotEmpty(message = "Please enter your password")
	private String password;
	
	private String role;
	
	@JsonIgnore
	private boolean isLoggedIn = false;
	
	@JsonIgnore
	@OneToOne(mappedBy="login")
	private Admin admin;

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", isLoggedIn=" + isLoggedIn + ", admin=" + admin + "]";
	}
	
	
	
		
}