package com.project.auditSeverity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionsEntity {
	private Integer questionId;
	
	private String auditType;
	
	private String question;
	
	private String response;
	
}
