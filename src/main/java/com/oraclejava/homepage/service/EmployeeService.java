package com.oraclejava.homepage.service;

import java.util.List;
import java.util.Optional;

import com.oraclejava.homepage.dto.Employee;
import com.oraclejava.homepage.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {
    
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        List<Employee> list = employeeRepository.findAll();

        return list;
    }

    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }



}
