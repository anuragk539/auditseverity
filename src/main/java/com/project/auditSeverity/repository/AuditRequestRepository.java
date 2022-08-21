package com.project.auditSeverity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.auditSeverity.entity.AuditRequestEntity;

@Repository
public interface AuditRequestRepository extends JpaRepository<AuditRequestEntity, Integer> {

}
