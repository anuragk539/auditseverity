package com.project.auditSeverity.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="auditdetail")
@NoArgsConstructor
public class AuditDetailEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AuditId")
	private int auditId;
	
	@Column(name="AuditType")
	private String auditType;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="AuditDate")
	private Date auditDate;
	
	@PrePersist
	protected void onCreate(){
		auditDate=new Date();
	}


	public AuditDetailEntity(String auditType) {
		super();
		this.auditType = auditType;
	}


	public String getAuditType() {
		return auditType;
	}


	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}


	public Date getAuditDate() {
		return auditDate;
	}


	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}


	public int getAuditId() {
		return auditId;
	}


	public AuditDetailEntity(int auditId, String auditType, Date auditDate) {
		super();
		this.auditId = auditId;
		this.auditType = auditType;
		this.auditDate = auditDate;
	}
	
	
}
