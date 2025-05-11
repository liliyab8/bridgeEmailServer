package com.example.bridge_email_server.repository;

import com.example.bridge_email_server.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends JpaRepository<EmployeeEntity, Long> {

}
