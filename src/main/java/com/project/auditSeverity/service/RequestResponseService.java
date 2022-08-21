package com.project.auditSeverity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.auditSeverity.AuditRequest;
import com.project.auditSeverity.AuditResponse;
import com.project.auditSeverity.entity.AuditDetailEntity;
import com.project.auditSeverity.entity.AuditRequestEntity;
import com.project.auditSeverity.entity.AuditResponseEntity;
import com.project.auditSeverity.repository.AuditRequestRepository;
import com.project.auditSeverity.repository.AuditResponseRepository;

@Service
public class RequestResponseService {
	
	@Autowired
	private AuditRequestRepository requestRepository;
	
	@Autowired
	private AuditResponseRepository responseRepository;
	
	public AuditRequestEntity saveRequest(AuditRequest request){
		AuditRequestEntity requestEntity = new AuditRequestEntity();
		AuditDetailEntity auditDetailEntity = new AuditDetailEntity(request.getAuditDetails().getAuditType());
		requestEntity.setAuditDetail(auditDetailEntity);
		requestEntity.setProjectName(request.getProjectName());
		requestEntity.setProjectManagerName(request.getProjectManagerName());
		requestEntity.setApplicationOwnerName(request.getApplicationOwnerName());
		
		return requestRepository.save(requestEntity);
		
	}
	
	public AuditResponseEntity saveResponse(AuditResponse response){
		AuditResponseEntity responseEntity= new AuditResponseEntity(response.getProjectExecutionStatus(),response.getRemedialActionDuration());
		return responseRepository.save(responseEntity);
	}

}
