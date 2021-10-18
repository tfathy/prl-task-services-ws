package org.dhaman.prl.security.shared;

import java.io.Serializable;

import org.dhaman.prl.security.entity.lookup.Employee;

public class UserDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3550722256831291917L;

	private Employee employee;
	
	private String userId;
	private String loginName;
	private String encryptPw;
	private String userPassword;
	private String defaultRole;
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getEncryptPw() {
		return encryptPw;
	}
	public void setEncryptPw(String encryptPw) {
		this.encryptPw = encryptPw;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getDefaultRole() {
		return defaultRole;
	}
	public void setDefaultRole(String defaultRole) {
		this.defaultRole = defaultRole;
	}
	@Override
	public String toString() {
		return "UserDto [employee=" + employee + ", userId=" + userId + ", loginName=" + loginName + ", encryptPw="
				+ encryptPw + ", userPassword=" + userPassword + ", defaultRole=" + defaultRole + "]";
	}

	
	
	
}
