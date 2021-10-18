package org.dhaman.prl.security.model;

import java.io.Serializable;

public class LoginRequestModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1642412364281698716L;
	private String email;
	private String password;
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
	@Override
	public String toString() {
		return "LoginRequestModel [email=" + email + ", password=" + password + "]";
	}
	
	

}
