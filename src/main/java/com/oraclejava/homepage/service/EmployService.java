package com.oraclejava.homepage.service;



import com.oraclejava.homepage.repository.entity.Employee;

import java.util.List;

public interface EmployService {
    List<Employee> getEmployeeList();

    List<Employee> getEmployeeList(Employee employee);
}
