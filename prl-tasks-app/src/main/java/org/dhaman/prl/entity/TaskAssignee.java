package org.dhaman.prl.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.dhaman.prl.entity.lookup.WhoColumns;

@Entity
@Table(name="PRL_TASK_ASSIGNEE")
public class TaskAssignee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7489842085643022038L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int Id;
	
	@Column(name="TSK_ID")
	private Integer tskId;
	
	@ManyToOne()
	@JoinColumn(name="mbr_id")
	private Member member;
	
	@Column(name="ASSIGN_DATE")
	private Date assignDate;
	
	@Column(name="notes")
	private String notes;
	
	
	@Embedded
	private WhoColumns whoColumns;


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public Integer getTskId() {
		return tskId;
	}


	public void setTskId(Integer tskId) {
		this.tskId = tskId;
	}


	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}


	public Date getAssignDate() {
		return assignDate;
	}


	public void setAssignDate(Date assignDate) {
		this.assignDate = assignDate;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public WhoColumns getWhoColumns() {
		return whoColumns;
	}


	public void setWhoColumns(WhoColumns whoColumns) {
		this.whoColumns = whoColumns;
	}


	@Override
	public String toString() {
		return "TaskAssignee [Id=" + Id + ", tskId=" + tskId + ", member=" + member + ", assignDate=" + assignDate
				+ ", notes=" + notes + ", whoColumns=" + whoColumns + "]";
	}

	
}
