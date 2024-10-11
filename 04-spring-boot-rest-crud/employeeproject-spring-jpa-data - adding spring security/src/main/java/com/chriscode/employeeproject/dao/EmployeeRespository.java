package com.chriscode.employeeproject.dao;

import com.chriscode.employeeproject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRespository extends JpaRepository<Employee, Integer> {

    // no need to write any code
}
