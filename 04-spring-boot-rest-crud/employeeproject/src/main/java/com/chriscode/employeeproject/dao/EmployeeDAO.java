package com.chriscode.employeeproject.dao;

import com.chriscode.employeeproject.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
    Employee save(Employee theEmp);
    Employee findById(int id);
    void deletebyId(int id);

}
