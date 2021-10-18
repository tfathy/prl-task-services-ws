package org.dhaman.prl.security.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.dhaman.prl.security.entity.lookup.Employee;

public class CreateUserRequestModel {

	private Employee employee;
	private String userId;
	@NotNull(message = "Login name must be entered")
	@Size(min = 2, message = "Login name cannot be less than three charachters")
	private String loginName;
	
	@NotNull(message="password cannot be empty")
	@Size(min=4,message="passowrd cannot be less than 4 charachters")
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
		return "CreateUserRequestModel [employee=" + employee + ", userId=" + userId + ", loginName=" + loginName
				+ ", userPassword=" + userPassword + "]";
	}
	
	
}
