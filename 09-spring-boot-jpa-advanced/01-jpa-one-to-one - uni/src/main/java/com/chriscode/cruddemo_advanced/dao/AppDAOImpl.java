package com.chriscode.cruddemo_advanced.dao;

import com.chriscode.cruddemo_advanced.entity.Instructor;
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
    @Transactional
    public void save(Instructor theInstructor) {

        entityManager.persist(theInstructor);

    }

    @Override
    public Instructor findInstrutorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorbyId(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.remove(instructor);
    }
}
