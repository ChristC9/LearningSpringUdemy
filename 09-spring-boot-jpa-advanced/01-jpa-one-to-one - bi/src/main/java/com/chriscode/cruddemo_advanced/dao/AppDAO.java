package com.chriscode.cruddemo_advanced.dao;

import com.chriscode.cruddemo_advanced.entity.InstructorDetails;

public interface AppDAO {

    InstructorDetails findbyId (int id);
    void deleteInstructorDetails(int id);
}
