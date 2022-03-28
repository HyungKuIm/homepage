package com.oraclejava.homepage.repository;

import com.oraclejava.homepage.dto.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    
}
