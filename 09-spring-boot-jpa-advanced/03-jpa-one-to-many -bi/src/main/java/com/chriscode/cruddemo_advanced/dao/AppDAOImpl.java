package com.chriscode.cruddemo_advanced.dao;

import com.chriscode.cruddemo_advanced.entity.Course;
import com.chriscode.cruddemo_advanced.entity.Instructor;
import com.chriscode.cruddemo_advanced.entity.InstructorDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{

    // define the entity manager
    private EntityManager entityManager;

    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveInstructor(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    @Transactional
    public void saveCourse(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Instructor findInstructorbyId(int id) {

//        For Lazy Loading (fetch = FetchType.EAGER)
        return entityManager.find(Instructor.class, id);

//        For Lazy Loading (fetch = FetchType.LAZY)
//        TypedQuery <Instructor> query = entityManager.createQuery(
//                "SELECT uniqueId from Instructor uniqueId JOIN FETCH uniqueId.courses where uniqueId.id = :id", Instructor.class
//        );

//        Instructor singleInstructorResult = query.getSingleResult();
//        return singleInstructorResult;
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

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {

        TypedQuery<Course> query = entityManager.createQuery
                ("from Course where instructor.id = :data", Course.class);

        query.setParameter("data",theId);
        List <Course> courses = query.getResultList();

        return courses;

    }

    @Override
    @Transactional
    public void UpdateInstructor(Instructor instructor) {

        entityManager.merge(instructor);

    }

    @Override
    @Transactional
    public void UpdateCourse(Course course) {

        entityManager.merge(course);

    }

    @Override
    public Course findCourseById(int id) {

        Course course = entityManager.find(Course.class, id);
        return course;

    }

    @Override
    @Transactional
    public void deleteInsturctor(Instructor instructor) {
        Instructor attachedInstructor = entityManager.merge(instructor); // Re-attach object
        entityManager.remove(attachedInstructor);
    }
}
