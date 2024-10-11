package com.chriscode.cruddemo.dao;

import com.chriscode.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student thestudent);

    // The reason why we use Integer instead of int is that Integer can be null, but int cannot be null.
    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findbyLastName (String theLastName);

    void update(Student thestudent);

    void delete(Integer id);
}
