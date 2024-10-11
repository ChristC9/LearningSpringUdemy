package com.chriscode.employeeproject.service;

import com.chriscode.employeeproject.dao.EmployeeDAO;
import com.chriscode.employeeproject.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO theemployeeDAO) {
        this.employeeDAO = theemployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Transactional
    @Override
    public Employee save(Employee theEmp) {
        return employeeDAO.save(theEmp);
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Transactional
    @Override
    public void deletebyId(int id) {
        employeeDAO.deletebyId(id);
    }
}
