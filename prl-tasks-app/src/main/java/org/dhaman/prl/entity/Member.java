package org.dhaman.prl.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.dhaman.prl.entity.lookup.Employee;
import org.dhaman.prl.entity.lookup.WhoColumns;

@Entity()
@Table(name="PRL_MEMBER")
public class Member implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5193568712329335949L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int Id;
	
	@ManyToOne()
	@JoinColumn(name="emp_id")
	private Employee employee;
	
	@Column(name="name_ar")
	private String nameAr;
	
	@Column(name="name_en")
	private String nameEn;
	
	@Column(name="active")
	private String active;
	
	@Embedded
	private WhoColumns whoColumns;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getNameAr() {
		return nameAr;
	}

	public void setNameAr(String nameAr) {
		this.nameAr = nameAr;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public WhoColumns getWhoColumns() {
		return whoColumns;
	}

	public void setWhoColumns(WhoColumns whoColumns) {
		this.whoColumns = whoColumns;
	}

	@Override
	public String toString() {
		return "Member [Id=" + Id + ", employee=" + employee + ", nameAr=" + nameAr + ", nameEn=" + nameEn + ", active="
				+ active + ", whoColumns=" + whoColumns + "]";
	}
	
	
	
	
}
