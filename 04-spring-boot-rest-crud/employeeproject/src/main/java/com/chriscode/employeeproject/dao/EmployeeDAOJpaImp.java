package com.chriscode.employeeproject.dao;

import com.chriscode.employeeproject.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOJpaImp implements EmployeeDAO{

    // defince entitymanager

    private EntityManager entityManager;

    // constructor and constructor injection

    @Autowired
    public EmployeeDAOJpaImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> empQuery = entityManager.createQuery("from Employee ", Employee.class);
        List<Employee> emps= empQuery.getResultList();

        return emps;
    }

    @Override
    public Employee save(Employee theEmp) {

        Employee emp = entityManager.merge(theEmp);

        return emp;
    }

    @Override
    public Employee findById(int id) {

        Employee emp = entityManager.find(Employee.class, id);

        return emp;
    }

    @Override
    public void deletebyId(int id) {

        Employee emp = entityManager.find(Employee.class, id);

        entityManager.remove(emp);


    }
}
