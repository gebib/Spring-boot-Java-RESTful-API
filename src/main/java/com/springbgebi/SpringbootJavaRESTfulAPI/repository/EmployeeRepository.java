package com.springbgebi.SpringbootJavaRESTfulAPI.repository;

import com.springbgebi.SpringbootJavaRESTfulAPI.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//                                                      JPA entity, PK type
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
