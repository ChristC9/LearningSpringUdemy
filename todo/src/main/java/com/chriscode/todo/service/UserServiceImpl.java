package com.chriscode.todo.service;

import com.chriscode.todo.dao.RoleDao;
import com.chriscode.todo.dao.UserDao;
import com.chriscode.todo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserServiceImpl implements UserDetailsService {

    private UserDao userDao;
    private RoleDao roleDao;

    public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User checkUserExists = userDao.findUserByUsername(username);

        if (checkUserExists == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        return new org.springframework.security.core.userdetails.User(checkUserExists.getUsername(), checkUserExists.getPassword(),
                mapRolesToAuthorities(checkUserExists.getRoles()));
    }
}
