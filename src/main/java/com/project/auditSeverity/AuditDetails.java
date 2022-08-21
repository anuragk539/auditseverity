package com.project.auditSeverity;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuditDetails {

	private String auditType;
	
	private Date auditDate;
	
	private List<QuestionsEntity> QuestionsList;
	
}
