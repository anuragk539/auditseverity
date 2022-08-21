package com.project.auditSeverity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuditRequest {


	private String projectName;

	private String projectManagerName;

	private String applicationOwnerName;

	private AuditDetails auditDetails;
	
	
}
