package org.dhaman.prl.security.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.dhaman.prl.security.entity.lookup.Employee;

@Entity
@Table(name="SMM_USERS")
public class SmmUsers implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4154020556050439855L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="emp_id")
	private Employee employee;
	
	@Column(name="LOGIN_NAME")
	private String loginName;
	
	@Column(name="USER_ID")
	private String userId;
	
	@Column(name="USER_PASSWORD")
	private String userPassword;
	
	@Column(name="ENCRYPT_PW")
	private String encryptPw;
	
	@Column(name="FCM_TOKEN")
	private String fcmToken;
	
	@Column(name="DEFAULT_ROLE")
	private String defaultRole;

	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public String getLoginName() {
		return loginName;
	}


	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	


	public String getEncryptPw() {
		return encryptPw;
	}


	public void setEncryptPw(String encryptPw) {
		this.encryptPw = encryptPw;
	}


	public String getFcmToken() {
		return fcmToken;
	}


	public void setFcmToken(String fcmToken) {
		this.fcmToken = fcmToken;
	}


	public String getDefaultRole() {
		return defaultRole;
	}


	public void setDefaultRole(String defaultRole) {
		this.defaultRole = defaultRole;
	}


	@Override
	public String toString() {
		return "SmmUsers [id=" + id + ", employee=" + employee + ", loginName=" + loginName + ", userId=" + userId
				+ ", userPassword=" + userPassword + ", encryptPw=" + encryptPw + ", fcmToken=" + fcmToken
				+ ", defaultRole=" + defaultRole + "]";
	}


	
}
