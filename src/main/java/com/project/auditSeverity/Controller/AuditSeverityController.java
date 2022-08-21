package com.project.auditSeverity.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.project.auditSeverity.AuditRequest;
import com.project.auditSeverity.AuditResponse;
import com.project.auditSeverity.QuestionsEntity;
import com.project.auditSeverity.feignclient.AuthClient;
import com.project.auditSeverity.service.RequestResponseService;
import com.project.auditSeverity.service.TokenService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins="*")
@Slf4j
@RestController
public class AuditSeverityController {

	@Autowired
	AuthClient authClient;
	
	@Autowired
	TokenService tokenService;
	
	@Autowired
	Environment env;
	
	@Autowired
	private RequestResponseService service;
	
	
	@PostMapping("/ProjectExecutionStatus")
	public ResponseEntity<?> ProjectExecutionStatus(@RequestHeader(name="Authorization", required=true) String token,@RequestBody AuditRequest auditRequest){
		ResponseEntity<?> responseEntity=null;
		int neededNOAns = 3, actualNOAns=0;
		List<QuestionsEntity> questionsList= null;
		if(tokenService.checkTokenValidity(token)){
			questionsList = auditRequest.getAuditDetails().getQuestionsList();
			for(QuestionsEntity answer: questionsList) {
				if(answer.getResponse().equalsIgnoreCase("No"))
					actualNOAns++;
			}
			System.out.println("22222222222222222222222222222222222222222 "+actualNOAns);
			if(actualNOAns<neededNOAns){
				responseEntity = new ResponseEntity<AuditResponse>(new AuditResponse(env.getProperty("project.status.green"),env.getProperty("remedial.action.no")),HttpStatus.OK);
				AuditResponse response = (AuditResponse) responseEntity.getBody();
				service.saveResponse(response);
			} else {
				responseEntity = new ResponseEntity<AuditResponse>(new AuditResponse(env.getProperty("project.status.red"),env.getProperty("remedial.action.yes")),HttpStatus.OK);
				AuditResponse response = (AuditResponse) responseEntity.getBody();
				service.saveResponse(response);
			}
			service.saveRequest(auditRequest);
			return responseEntity;
		} else {
			log.error(env.getProperty("string.token.exp"));
			log.info(env.getProperty("string.end"));
			responseEntity = new ResponseEntity<String>(env.getProperty("string.token.exp"),HttpStatus.FORBIDDEN);
			return responseEntity;	
		}
	}
}
