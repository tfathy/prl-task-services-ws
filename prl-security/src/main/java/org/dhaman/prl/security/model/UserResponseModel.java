package org.dhaman.prl.security.model;

import org.dhaman.prl.security.entity.lookup.Employee;

public class UserResponseModel {
	private String fullNameAr;
	private String fullNameEn;
	private String email;
	private String userId;
	private String fcmToken;
	private String defaultRole;
	private Employee employee;
	public String getFullNameAr() {
		return fullNameAr;
	}
	public void setFullNameAr(String fullNameAr) {
		this.fullNameAr = fullNameAr;
	}
	public String getFullNameEn() {
		return fullNameEn;
	}
	public void setFullNameEn(String fullNameEn) {
		this.fullNameEn = fullNameEn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFcmToken() {
		return fcmToken;
	}
	public void setFcmToken(String fcmToken) {
		this.fcmToken = fcmToken;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
		
	public String getDefaultRole() {
		return defaultRole;
	}
	public void setDefaultRole(String defaultRole) {
		this.defaultRole = defaultRole;
	}
	@Override
	public String toString() {
		return "UserResponseModel [fullNameAr=" + fullNameAr + ", fullNameEn=" + fullNameEn + ", email=" + email
				+ ", userId=" + userId + ", fcmToken=" + fcmToken + ", employee=" + employee + "]";
	}
	
	
}
