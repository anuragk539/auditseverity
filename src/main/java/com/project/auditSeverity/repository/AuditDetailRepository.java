package com.project.auditSeverity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.auditSeverity.entity.AuditDetailEntity;

@Repository
public interface AuditDetailRepository extends JpaRepository<AuditDetailEntity, Integer> {

}
