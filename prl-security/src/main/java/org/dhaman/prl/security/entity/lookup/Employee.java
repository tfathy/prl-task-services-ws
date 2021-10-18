package org.dhaman.prl.security.entity.lookup;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HRS_EMPLOYEES")
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7408941836945860796L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int Id;
	
	@Column(name="EMP_NUM")
	private Integer empNum;

	@Column(name="PREFIX_AR")
	private String prefixAr;
	
	@Column(name="AR_NAME_FULL")
	private String arNameFull;
	
	@Column(name="PHONE_EXT")
	private String phoneExt;
	
	@Column(name="IAIGC_EMAIL")
	private String iaigcEmail;
	
	@Column(name="ACTIVE")
	private String active;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Integer getEmpNum() {
		return empNum;
	}

	public void setEmpNum(Integer empNum) {
		this.empNum = empNum;
	}

	public String getPrefixAr() {
		return prefixAr;
	}

	public void setPrefixAr(String prefixAr) {
		this.prefixAr = prefixAr;
	}

	public String getArNameFull() {
		return arNameFull;
	}

	public void setArNameFull(String arNameFull) {
		this.arNameFull = arNameFull;
	}

	public String getPhoneExt() {
		return phoneExt;
	}

	public void setPhoneExt(String phoneExt) {
		this.phoneExt = phoneExt;
	}

	public String getIaigcEmail() {
		return iaigcEmail;
	}

	public void setIaigcEmail(String iaigcEmail) {
		this.iaigcEmail = iaigcEmail;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", empNum=" + empNum + ", prefixAr=" + prefixAr + ", arNameFull=" + arNameFull
				+ ", phoneExt=" + phoneExt + ", iaigcEmail=" + iaigcEmail + ", active=" + active + "]";
	}
	
	
	
	
}
