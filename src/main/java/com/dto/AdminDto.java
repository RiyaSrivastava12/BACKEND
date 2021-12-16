package com.dto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDto {
		private int adminId;
		private String fullName;
		private String contactNo;
		private String email;
		private String role;
		private int loginId;
		
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
		public int getLoginId() {
			return loginId;
		}
		public void setLoginId(int loginId) {
			this.loginId = loginId;
		}
		@Override
		public String toString() {
			return "AdminDto [adminId=" + adminId + ", fullName=" + fullName + ", contactNo=" + contactNo + ", email="
					+ email + ", role=" + role + ", loginId=" + loginId + "]";
		}
		
		
		
		
}
