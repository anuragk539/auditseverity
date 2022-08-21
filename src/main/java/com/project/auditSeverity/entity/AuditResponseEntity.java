package com.project.auditSeverity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="auditresponse")
@NoArgsConstructor
public class AuditResponseEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ResponseId")
	@Getter private int responseId;
	
	@Column(name="ProjectExecutionStatus")
	private String projectExecutionStatus;
	
	@Column(name="RemedialActionDuration")
	private String remedialActionDuration;

	public AuditResponseEntity(String projectExecutionStatus, String remedialActionDuration) {
		super();
		this.projectExecutionStatus = projectExecutionStatus;
		this.remedialActionDuration = remedialActionDuration;
	}
	
	
}
