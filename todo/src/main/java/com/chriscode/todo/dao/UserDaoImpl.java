package com.chriscode.todo.dao;

import com.chriscode.todo.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{


    EntityManager entityManager;

    @Override
    public User findUserByUsername(String userName) {
        TypedQuery<User> theQuery = entityManager.createQuery("from User where username = :uName", User.class);
        theQuery.setParameter("uName", userName);
        User theUser = null;
        try {
            theUser = theQuery.getSingleResult();
        } catch (Exception e) {
            throw  new RuntimeException("User not found");
        }
        return theUser;
    }
}
