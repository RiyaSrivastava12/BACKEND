package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="admin")
public class Admin {

	//admin fields
	
		@Id
		@GeneratedValue
		@Column(name="id")
		private int id;
		@NotNull
		private String username;
		@NotNull
		@Size(min=8,message="password should have atleast 8 characters")
		private String password;
		
		@Pattern(regexp = "[a-zA-Z]{3,}@[a-zA-Z]{2,}.[a-zA-Z]{2,}", message = "Please Provide the valid format of email")
		private String email;
			
		private String role;
		
		@JsonIgnore
		private boolean isLoggedIn = false;

		//getters and setters
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
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

		public boolean isLoggedIn() {
			return isLoggedIn;
		}

		public void setLoggedIn(boolean isLoggedIn) {
			this.isLoggedIn = isLoggedIn;
		}

		
		//to string
		
		@Override
		public String toString() {
			return "Admin [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
					+ ", role=" + role + ", isLoggedIn=" + isLoggedIn + "]";
		}
		

}