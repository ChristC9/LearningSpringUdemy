package com.chriscode.employeeproject.service;

import com.chriscode.employeeproject.dao.EmployeeRespository;
import com.chriscode.employeeproject.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRespository empRepo;

    public EmployeeServiceImpl(EmployeeRespository theempRepo) {
        this.empRepo = theempRepo;
    }

    @Override
    public List<Employee> findAll() {
        return empRepo.findAll();
    }


    @Override
    public Employee save(Employee theEmp) {
        return empRepo.save(theEmp);
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = empRepo.findById(id);
        Employee theEmp = null;
        if (result.isPresent()){
            theEmp = result.get();
        }else {
            throw new RuntimeException("Did not find employee id - " + id);
        }
        return theEmp;
    }

    @Override
    public void deletebyId(int id) {
        empRepo.deleteById(id);
    }
}
