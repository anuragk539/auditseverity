package com.project.auditSeverity.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="AuditRequest")
@NoArgsConstructor
public class AuditRequestEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RequestId")
	@Getter private int requestId;
	
	@Column(name="ProjectName")
	@Getter @Setter private String projectName;
	
	@Column(name="ProjectManagerName")
	@Getter @Setter private String projectManagerName;

	@Column(name="ApplicationOwnerName")
	@Getter @Setter private String applicationOwnerName;

	@OneToOne(cascade = CascadeType.ALL)
	@Getter @Setter private AuditDetailEntity auditDetail;

	public AuditRequestEntity(String projectName, String projectManagerName, String applicationOwnerName,
			AuditDetailEntity auditDetail) {
		super();
		this.projectName = projectName;
		this.projectManagerName = projectManagerName;
		this.applicationOwnerName = applicationOwnerName;
		this.auditDetail = auditDetail;
	}

	

}
