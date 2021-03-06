package org.dhaman.prl.entity.lookup;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hrs_employees")
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5144824521941516660L;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int Id;
	
	@Column(name="EMP_NUM")
	private Integer empNum;
	
	@Column(name="AR_NAME_FULL")
	private String arNameFull;
	
	@Column(name="EN_NAME_FULL")
	private String enNameFull;
	
	@Column(name="ACTIVE")
	private String active;
	
	@Column(name="IAIGC_EMAIL")
	private String iaigcEmail;
	
	@Column(name="IMAGE_PATH")
	private String imagePath;

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

	public String getArNameFull() {
		return arNameFull;
	}

	public void setArNameFull(String arNameFull) {
		this.arNameFull = arNameFull;
	}

	public String getEnNameFull() {
		return enNameFull;
	}

	public void setEnNameFull(String enNameFull) {
		this.enNameFull = enNameFull;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getIaigcEmail() {
		return iaigcEmail;
	}

	public void setIaigcEmail(String iaigcEmail) {
		this.iaigcEmail = iaigcEmail;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", empNum=" + empNum + ", arNameFull=" + arNameFull + ", enNameFull=" + enNameFull
				+ ", active=" + active + ", iaigcEmail=" + iaigcEmail + ", imagePath=" + imagePath + "]";
	}
	
	
	
	

}
