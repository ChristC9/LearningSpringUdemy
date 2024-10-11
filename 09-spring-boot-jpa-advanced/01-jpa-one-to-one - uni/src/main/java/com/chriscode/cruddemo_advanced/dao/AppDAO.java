package com.chriscode.cruddemo_advanced.dao;

import com.chriscode.cruddemo_advanced.entity.Instructor;

public interface AppDAO {

    void save (Instructor theInstructor);
    Instructor findInstrutorById(int id);
    void deleteInstructorbyId(int id);
}
