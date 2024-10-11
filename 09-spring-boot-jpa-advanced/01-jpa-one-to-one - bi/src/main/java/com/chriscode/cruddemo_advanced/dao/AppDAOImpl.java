package com.chriscode.cruddemo_advanced.dao;

import com.chriscode.cruddemo_advanced.entity.InstructorDetails;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImpl implements AppDAO{

    // define the entity manager
    private EntityManager entityManager;

    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public InstructorDetails findbyId(int id) {

        InstructorDetails tempInstructorDetails = entityManager.find(InstructorDetails.class, id);
        return tempInstructorDetails;
    }

    @Override
    @Transactional
    public void deleteInstructorDetails(int id) {

    InstructorDetails tempInstructorDetails = entityManager.find(InstructorDetails.class, id);

    tempInstructorDetails.getInstructor().setInstructorDetails(null);

    entityManager.remove(tempInstructorDetails);

    }
}
