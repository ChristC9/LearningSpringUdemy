package com.chriscode.employeeproject.dao;

import com.chriscode.employeeproject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


// set up REST API endpoint at /members
@RepositoryRestResource(path = "members") // localhost:8080/api/members
public interface EmployeeRespository extends JpaRepository<Employee, Integer> {

    // no need to write any code
}
