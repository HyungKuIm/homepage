package com.oraclejava.homepage.service;


import com.oraclejava.homepage.repository.EmployeeRepository;
import com.oraclejava.homepage.repository.EmployeeSpec;
import com.oraclejava.homepage.repository.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployService{

//    @PersistenceContext
//    private EntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployeeList() {
        //return entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getEmployeeList(Employee employee) {
        return employeeRepository.findAll(Specification.where(
                EmployeeSpec.firstName(employee.getFirstName()))
                .and(EmployeeSpec.lastName(employee.getLastName())));
    }
}
