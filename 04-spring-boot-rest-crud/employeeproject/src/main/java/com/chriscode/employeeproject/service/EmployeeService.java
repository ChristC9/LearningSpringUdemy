package com.chriscode.employeeproject.service;

import com.chriscode.employeeproject.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee save(Employee theEmp);
    Employee findById(int id);
    void deletebyId(int id);

}
