package com.oraclejava.homepage.repository;

import com.oraclejava.homepage.repository.entity.Employee;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpec {
    public static Specification<Employee> firstName(String firstName) {
        return firstName == null || firstName.isEmpty() ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("firstName"), "%" + firstName + "%");
    }

    public static Specification<Employee> lastName(String lastName) {
        return lastName == null || lastName.isEmpty() ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("lastName"), "%" + lastName + "%");
    }
}
