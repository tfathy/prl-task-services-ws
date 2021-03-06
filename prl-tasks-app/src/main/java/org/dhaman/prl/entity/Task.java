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
@Table(name="PRL_TASK")
public class Task implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4274051704511232529L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int Id;
	
	@ManyToOne()
	@JoinColumn(name="tst_id")
	private TaskType taskType;
	
	@ManyToOne()
	@JoinColumn(name="cpy_id")
	private CounterParty counterparty;
	
	@ManyToOne()
	@JoinColumn(name="mbr_id")
	private Member member;
	
	@Column(name="code")
	private String code;
	
	@Column(name="subject")
	private String subject;
	
	@Column(name="SCHEDULE_DATE")
	private Date scheduleDate;
	
	@Column(name="START_DATE")
	private Date startDate;
	
	@Column(name="POSTPONE_DATE")
	private Date postponeDate;
	
	@Column(name="CANCEL_DATE")
	private Date cancelDate;
	
	@Column(name="RESUME_DATE")
	private Date resumeDate;
	
	@Column(name="RESOLVE_DATE")
	private Date resolveDate;
	
	@Column(name="CLOSE_DATE")
	private Date closeDate;
	
	@Column(name="CLOSE_RESULT")
	private String closeResult;
	
	@Column(name="SATISFACTION_RATE")
	private Integer satisfictionRate;
	
	@Column(name="CLOSE_NOTES")
	private String closeNotes;
	
	@Embedded
	private WhoColumns whoColumns;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public TaskType getTaskType() {
		return taskType;
	}

	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}

	public CounterParty getCounterparty() {
		return counterparty;
	}

	public void setCounterparty(CounterParty counterparty) {
		this.counterparty = counterparty;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getPostponeDate() {
		return postponeDate;
	}

	public void setPostponeDate(Date postponeDate) {
		this.postponeDate = postponeDate;
	}

	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	public Date getResumeDate() {
		return resumeDate;
	}

	public void setResumeDate(Date resumeDate) {
		this.resumeDate = resumeDate;
	}

	public Date getResolveDate() {
		return resolveDate;
	}

	public void setResolveDate(Date resolveDate) {
		this.resolveDate = resolveDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public String getCloseResult() {
		return closeResult;
	}

	public void setCloseResult(String closeResult) {
		this.closeResult = closeResult;
	}

	public Integer getSatisfictionRate() {
		return satisfictionRate;
	}

	public void setSatisfictionRate(Integer satisfictionRate) {
		this.satisfictionRate = satisfictionRate;
	}

	public String getCloseNotes() {
		return closeNotes;
	}

	public void setCloseNotes(String closeNotes) {
		this.closeNotes = closeNotes;
	}

	public WhoColumns getWhoColumns() {
		return whoColumns;
	}

	public void setWhoColumns(WhoColumns whoColumns) {
		this.whoColumns = whoColumns;
	}

	@Override
	public String toString() {
		return "Task [Id=" + Id + ", taskType=" + taskType + ", counterparty=" + counterparty + ", member=" + member
				+ ", code=" + code + ", subject=" + subject + ", scheduleDate=" + scheduleDate + ", startDate="
				+ startDate + ", postponeDate=" + postponeDate + ", cancelDate=" + cancelDate + ", resumeDate="
				+ resumeDate + ", resolveDate=" + resolveDate + ", closeDate=" + closeDate + ", closeResult="
				+ closeResult + ", satisfictionRate=" + satisfictionRate + ", closeNotes=" + closeNotes
				+ ", whoColumns=" + whoColumns + "]";
	}
	
	
		
	
}
