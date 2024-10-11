package com.chriscode.cruddemo.dao;

import com.chriscode.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;

@Repository
public class StudentImpl implements StudentDAO{

    // define field for entity manager

    private EntityManager entityManager;

    // set up the entity manager for constructor injection
    // no need to use @Autowired annotation because Spring 5 automatically injects the entity manager
    public StudentImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement the override method
    @Override
    @Transactional
    public void save(Student thestudent) {
        entityManager.persist(thestudent); // save in database
    }

    @Override
    // No need to use @Transactional because we are not modifying the database
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id); // return the student object from the database
    }

    @Override
    public List<Student> findAll() {

        // create a query
//        TypedQuery<Student> stuQuery = entityManager.createQuery("from Student ", Student.class);

        // order the students by descending last name
//        TypedQuery<Student> stuQuery = entityManager.createQuery("from Student order by lastName desc", Student.class);

        // order the students by ascending last name
        TypedQuery<Student> stuQuery = entityManager.createQuery("from Student order by lastName", Student.class);

        // create query results
        return stuQuery.getResultList();
    }

    @Override
    public List<Student> findbyLastName(String theLastName) {

        // create a query
        TypedQuery<Student> studentQuery = entityManager.createQuery("from Student where lastName=:theData", Student.class);

        // set parameter
        studentQuery.setParameter("theData", theLastName);

        // return the query list result
        return studentQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student thestudent) {
        entityManager.merge(thestudent); // update the student object in the database
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student stu = entityManager.find(Student.class,id);
        entityManager.remove(stu);
//        entityManager.createQuery("delete From Student").executeUpdate();
    }
}
