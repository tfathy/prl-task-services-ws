package org.dhaman.prl.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.dhaman.prl.entity.lookup.WhoColumns;

@Entity
@Table(name="PRL_TASK_TYPE")
public class TaskType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5791377394771870786L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int Id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="desc_ar")
	private String descAr;
	
	@Column(name="desc_en")
	private String descEn;
	
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescAr() {
		return descAr;
	}

	public void setDescAr(String descAr) {
		this.descAr = descAr;
	}

	public String getDescEn() {
		return descEn;
	}

	public void setDescEn(String descEn) {
		this.descEn = descEn;
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
		return "TaskType [Id=" + Id + ", code=" + code + ", descAr=" + descAr + ", descEn=" + descEn + ", active="
				+ active + ", whoColumns=" + whoColumns + "]";
	}	
	
	
	

}
