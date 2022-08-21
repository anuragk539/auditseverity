package com.project.auditSeverity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages= {"com.project.auditSeverity.repository"})
//@EntityScan(basePackages= {"com.project.auditSeverity.model"})
@EnableFeignClients//(basePackages={"com.project.auditSeverity.feignclient"})
//@EnableEurekaClient
public class AuditSeverityApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditSeverityApplication.class, args);
	}

}
