package com.project.auditSeverity.exception;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.auditSeverity.feignclient.CustomErrorResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends Exception {
	
	@Autowired
	Environment environment;
	@ExceptionHandler(FeignProxyException.class)
	public ResponseEntity<CustomErrorResponse> handleFeignProxyException(FeignProxyException ex) {
		log.info(environment.getProperty("string.start"));
		CustomErrorResponse response = new CustomErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.NOT_FOUND);
		response.setReason(environment.getProperty("feign.null"));
		log.info(environment.getProperty("string.end"));
		return new ResponseEntity<CustomErrorResponse>(response, HttpStatus.NOT_FOUND);
	}

}
